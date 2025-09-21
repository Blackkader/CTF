#include <jni.h>
#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
#include <random>
#include <cstring>    
#include <openssl/des.h>


// Layer 1: XOR with a rolling key
std::string xor_encrypt(const std::string &input, const std::string &key) {
    std::string output = input;
    for (size_t i = 0; i < input.size(); ++i) {
        output[i] = input[i] ^ key[i % key.size()];
    }
    return output;
}

// Layer 2: Base64 encoding (custom implementation)
const std::string base64_chars = 
    "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    "abcdefghijklmnopqrstuvwxyz"
    "0123456789+/";

std::string base64_encode(const std::string &input) {
    std::string output;
    int val = 0, valb = -6;
    for (unsigned char c : input) {
        val = (val << 8) + c;
        valb += 8;
        while (valb >= 0) {
            output.push_back(base64_chars[(val >> valb) & 0x3F]);
            valb -= 6;
        }
    }
    if (valb > -6) output.push_back(base64_chars[((val << 8) >> (valb + 8)) & 0x3F]);
    while (output.size() % 4) output.push_back('=');
    return output;
}

std::string base64_decode(const std::string &input) {
    std::string output;
    std::vector<int> T(256, -1);
    for (int i = 0; i < 64; i++) T[base64_chars[i]] = i;
    
    int val = 0, valb = -8;
    for (unsigned char c : input) {
        if (T[c] == -1) break;
        val = (val << 6) + T[c];
        valb += 6;
        if (valb >= 0) {
            output.push_back(char((val >> valb) & 0xFF));
            valb -= 8;
        }
    }
    return output;
}

// Layer 3: Character shifting with prime number pattern
std::string prime_shift_encrypt(const std::string &input) {
    std::string output = input;
    std::vector<int> primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71};
    
    for (size_t i = 0; i < input.size(); ++i) {
        int prime = primes[i % primes.size()];
        output[i] = input[i] + prime;
    }
    return output;
}

std::string rot13(const std::string& input) {
    std::string out = input;
    for (char& c : out) {
        if ('a' <= c && c <= 'z') c = ((c - 'a' + 13) % 26) + 'a';
        else if ('A' <= c && c <= 'Z') c = ((c - 'A' + 13) % 26) + 'A';
    }
    return out;
}

std::string des_encrypt(const std::string& plaintext, const std::string& key) {
    DES_cblock key_block;
    memcpy(key_block, key.c_str(), 8);
    DES_key_schedule schedule;
    DES_set_key_unchecked(&key_block, &schedule);

    // Pad plaintext to 8-byte multiple
    size_t len = plaintext.size();
    size_t padded_len = ((len / 8) + 1) * 8;
    std::vector<unsigned char> input(padded_len, 0);
    memcpy(input.data(), plaintext.data(), len);

    std::vector<unsigned char> output(padded_len, 0);
    for (size_t i = 0; i < padded_len; i += 8) {
        DES_ecb_encrypt(
            (DES_cblock*)(input.data() + i),
            (DES_cblock*)(output.data() + i),
            &schedule,
            DES_ENCRYPT
        );
    }

    return std::string(reinterpret_cast<char*>(output.data()), padded_len);
}



std::vector<uint8_t> encrypt_flag_bytes(const std::string& input) {
    std::string layer1 = rot13(input);
    std::string key2=input.substr(0,8);
    key2.resize(8,'X');
    std::string layer2 = des_encrypt(layer1, key2);
    std::string key3=input.substr(6,4);
    key3.resize(8,'X'); 
    std::string layer3 = des_encrypt(layer2,key3 ); 
    std::string key4=input.substr(2,4);
    key4.resize(8,'X'); 

    std::string layer4 = des_encrypt(layer3, key4);       


    return std::vector<uint8_t>(layer4.begin(), layer4.end());
}



// Magic function that will be called from Java
extern "C" JNIEXPORT jbyteArray JNICALL
Java_io_securinets_level13_heavynativeflag_magic(JNIEnv* env, jobject, jstring input) {
    const char* nativeString = env->GetStringUTFChars(input, nullptr);
    std::string str(nativeString);
    env->ReleaseStringUTFChars(input, nativeString);

    std::vector<uint8_t> encrypted_bytes = encrypt_flag_bytes(str);

    jbyteArray output = env->NewByteArray(encrypted_bytes.size());
    env->SetByteArrayRegion(output, 0, encrypted_bytes.size(),
                            reinterpret_cast<jbyte*>(encrypted_bytes.data()));
    return output;
}

// ================= DECOY FUNCTIONS =================

extern "C" JNIEXPORT jint JNICALL
Java_io_securinets_level13_heavynativeflag_decoy1(JNIEnv*, jobject, jint a, jint b) {
    return a + b;
}

extern "C" JNIEXPORT jstring JNICALL
Java_io_securinets_level13_heavynativeflag_decoy2(JNIEnv* env, jobject, jstring str) {
    const char *nativeString = env->GetStringUTFChars(str, 0);
    std::string result = "Processed: " + std::string(nativeString);
    env->ReleaseStringUTFChars(str, nativeString);
    return env->NewStringUTF(result.c_str());
}

extern "C" JNIEXPORT jdouble JNICALL
Java_io_securinets_level13_heavynativeflag_decoy3(JNIEnv*, jobject, jdouble x) {
    return std::sin(x) * std::cos(x);
}

extern "C" JNIEXPORT jintArray JNICALL
Java_io_securinets_level13_heavynativeflag_decoy4(JNIEnv* env, jobject, jintArray arr) {
    jsize length = env->GetArrayLength(arr);
    jint *elements = env->GetIntArrayElements(arr, 0);
    
    for (jsize i = 0; i < length; i++) {
        elements[i] = elements[i] * 2;
    }
    
    env->ReleaseIntArrayElements(arr, elements, 0);
    return arr;
}

extern "C" JNIEXPORT jlong JNICALL
Java_io_securinets_level13_heavynativeflag_decoy5(JNIEnv*, jobject, jint n) {
    if (n <= 1) return 1;
    return n * Java_io_securinets_level13_heavynativeflag_decoy5(nullptr, nullptr, n - 1);
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_securinets_level13_heavynativeflag_decoy6(JNIEnv*, jobject, jstring str) {
    return JNI_TRUE;
}

extern "C" JNIEXPORT jint JNICALL
Java_io_securinets_level13_heavynativeflag_decoy7(JNIEnv*, jobject, jint a, jint b, jint c) {
    return a * b + c;
}

extern "C" JNIEXPORT jstring JNICALL
Java_io_securinets_level13_heavynativeflag_decoy8(JNIEnv* env, jobject, jstring a, jstring b) {
    const char *strA = env->GetStringUTFChars(a, 0);
    const char *strB = env->GetStringUTFChars(b, 0);
    std::string result = std::string(strA) + "|" + std::string(strB);
    env->ReleaseStringUTFChars(a, strA);
    env->ReleaseStringUTFChars(b, strB);
    return env->NewStringUTF(result.c_str());
}

extern "C" JNIEXPORT jdouble JNICALL
Java_io_securinets_level13_heavynativeflag_decoy9(JNIEnv*, jobject, jdouble a, jdouble b) {
    return std::pow(a, b);
}

extern "C" JNIEXPORT jint JNICALL
Java_io_securinets_level13_heavynativeflag_decoy10(JNIEnv*, jobject, jintArray arr) {
    return 42;
}

extern "C" JNIEXPORT jstring JNICALL
Java_io_securinets_level13_heavynativeflag_decoy11(JNIEnv* env, jobject, jint num) {
    std::string result = "Number: " + std::to_string(num);
    return env->NewStringUTF(result.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_io_securinets_level13_heavynativeflag_decoy12(JNIEnv*, jobject, jint a, jint b) {
    return a % b;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_io_securinets_level13_heavynativeflag_decoy13(JNIEnv*, jobject, jdouble x) {
    return std::log(x);
}

extern "C" JNIEXPORT jint JNICALL
Java_io_securinets_level13_heavynativeflag_decoy14(JNIEnv*, jobject, jint n) {
    if (n <= 1) return n;
    return Java_io_securinets_level13_heavynativeflag_decoy14(nullptr, nullptr, n - 1) + 
           Java_io_securinets_level13_heavynativeflag_decoy14(nullptr, nullptr, n - 2);
}

extern "C" JNIEXPORT jstring JNICALL
Java_io_securinets_level13_heavynativeflag_decoy15(JNIEnv* env, jobject, jstring str) {
    const char *nativeString = env->GetStringUTFChars(str, 0);
    std::string result = std::string(nativeString);
    std::reverse(result.begin(), result.end());
    env->ReleaseStringUTFChars(str, nativeString);
    return env->NewStringUTF(result.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_io_securinets_level13_heavynativeflag_decoy16(JNIEnv*, jobject, jint a, jint b, jint c, jint d) {
    return (a + b) * (c - d);
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_securinets_level13_heavynativeflag_decoy17(JNIEnv*, jobject, jint num) {
    if (num < 2) return JNI_FALSE;
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) return JNI_FALSE;
    }
    return JNI_TRUE;
}

extern "C" JNIEXPORT jint JNICALL
Java_io_securinets_level13_heavynativeflag_decoy18(JNIEnv*, jobject, jintArray arr) {
    return 0;
}

extern "C" JNIEXPORT jstring JNICALL
Java_io_securinets_level13_heavynativeflag_decoy19(JNIEnv* env, jobject, jstring str, jint times) {
    const char *nativeString = env->GetStringUTFChars(str, 0);
    std::string result;
    for (int i = 0; i < times; i++) {
        result += nativeString;
    }
    env->ReleaseStringUTFChars(str, nativeString);
    return env->NewStringUTF(result.c_str());
}

extern "C" JNIEXPORT jdouble JNICALL
Java_io_securinets_level13_heavynativeflag_decoy20(JNIEnv*, jobject, jdouble x, jdouble y) {
    return std::sqrt(x * x + y * y);
}

extern "C" JNIEXPORT jint JNICALL
Java_io_securinets_level13_heavynativeflag_decoy21(JNIEnv*, jobject, jint a, jint b) {
    return a & b;
}

extern "C" JNIEXPORT jstring JNICALL
Java_io_securinets_level13_heavynativeflag_decoy22(JNIEnv* env, jobject, jstring str) {
    const char *nativeString = env->GetStringUTFChars(str, 0);
    std::string result = "ENC_" + std::string(nativeString) + "_DEC";
    env->ReleaseStringUTFChars(str, nativeString);
    return env->NewStringUTF(result.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_io_securinets_level13_heavynativeflag_decoy23(JNIEnv*, jobject, jint a, jint b) {
    return a | b;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_io_securinets_level13_heavynativeflag_decoy24(JNIEnv*, jobject, jdouble x) {
    return std::exp(x);
}

extern "C" JNIEXPORT jint JNICALL
Java_io_securinets_level13_heavynativeflag_decoy25(JNIEnv*, jobject, jint n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
        sum += i;
    }
    return sum;
}

extern "C" JNIEXPORT jstring JNICALL
Java_io_securinets_level13_heavynativeflag_decoy26(JNIEnv* env, jobject, jstring a, jstring b, jstring c) {
    const char *strA = env->GetStringUTFChars(a, 0);
    const char *strB = env->GetStringUTFChars(b, 0);
    const char *strC = env->GetStringUTFChars(c, 0);
    std::string result = std::string(strA) + "-" + std::string(strB) + "-" + std::string(strC);
    env->ReleaseStringUTFChars(a, strA);
    env->ReleaseStringUTFChars(b, strB);
    env->ReleaseStringUTFChars(c, strC);
    return env->NewStringUTF(result.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_io_securinets_level13_heavynativeflag_decoy27(JNIEnv*, jobject, jint a, jint b) {
    return a ^ b;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_io_securinets_level13_heavynativeflag_decoy28(JNIEnv*, jobject, jdouble a, jdouble b, jdouble c) {
    return a * b + c;
}

extern "C" JNIEXPORT jint JNICALL
Java_io_securinets_level13_heavynativeflag_decoy29(JNIEnv*, jobject, jint n) {
    return n * n;
}

extern "C" JNIEXPORT jstring JNICALL
Java_io_securinets_level13_heavynativeflag_decoy30(JNIEnv* env, jobject, jstring str) {
    const char *nativeString = env->GetStringUTFChars(str, 0);
    std::string result;
    for (char c : std::string(nativeString)) {
        result += std::to_string((int)c) + ".";
    }
    env->ReleaseStringUTFChars(str, nativeString);
    return env->NewStringUTF(result.c_str());
}