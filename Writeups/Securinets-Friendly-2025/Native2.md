## **Challenge Name :** Native2
### **Category :** Mobile

### **𝐀𝐮𝐭𝐡𝐨𝐫 : [𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫](https://github.com/Blackkader/)**
---

### **Files Given :** _'Native2.apk , output.dat'_

---

### Solution

This is the common flag-decryption challenge , we have the apk that was used to encrypt the flag , and we were handed the **output.dat** which contains the encrypted flag , we can know that by launching the apk : 

![alt text](Ressources/18.png)

Now time for the **MainActivity** :

```java
public class MainActivity extends AppCompatActivity {

    /* renamed from: hf */
    heavynativeflag f191hf = new heavynativeflag();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(C0794R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(C0794R.id.rootLayout), new OnApplyWindowInsetsListener() { // from class: io.securinets.level13.MainActivity$$ExternalSyntheticLambda0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 0 */
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return MainActivity.lambda$onCreate$0(view, windowInsetsCompat);
            }
        });
        AppCompatButton encButton = (AppCompatButton) findViewById(C0794R.id.encButton);
        encButton.setOnClickListener(new View.OnClickListener() { // from class: io.securinets.level13.MainActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                TextView payload = (TextView) MainActivity.this.findViewById(C0794R.id.ciphertext);
                String payloadVal = payload.getText().toString();
                byte[] encryptedData = MainActivity.this.f191hf.magic(payloadVal);
                File desktopDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File outputFile = new File(desktopDir, "output.dat");
                try {
                    FileOutputStream fos = new FileOutputStream(outputFile);
                    try {
                        fos.write(encryptedData);
                        Toast.makeText(MainActivity.this, "File saved to Downloads/output.dat", 1).show();
                        fos.close();
                    } finally {
                    }
                } catch (IOException e) {
                    Log.e("SaveFile", "Error writing file", e);
                    Toast.makeText(MainActivity.this, "Error saving file", 0).show();
                }
            }
        });
    }
```
The activity instanciates a **heavynativeflag** class , then simply encrypts the **ciphertext** then saves it in **output.dat** , but again , its a native lib used here to do the encryption , so we take our .so file out and this time it shouldn't have a static flag xd , so we throw it in ida and after that we simply search for the package name ( cause native libs are usually in the same package as the apk ) "I'll just search for securinets" and we find our **magic** function that was used to encrypt : 

![alt text](Ressources/19.png)

Let's see what the function does :

```C++
int __cdecl Java_io_securinets_level13_heavynativeflag_magic(_JNIEnv *a1, int a2, int a3)
{
  int v3; // eax
  int v4; // esi
  int v5; // eax
  int v7; // [esp+20h] [ebp-4Ch]
  _BYTE v8[20]; // [esp+38h] [ebp-34h] BYREF
  _BYTE v9[12]; // [esp+4Ch] [ebp-20h] BYREF
  int StringUTFChars; // [esp+58h] [ebp-14h]

  StringUTFChars = _JNIEnv::GetStringUTFChars(a1, a3, 0);
  std::string::basic_string[abi:ne180000]<0>(v9, StringUTFChars);
  _JNIEnv::ReleaseStringUTFChars(a1, a3, StringUTFChars);
  encrypt_flag_bytes(v8);
  v3 = std::vector<unsigned char>::size[abi:ne180000](v8);
  v7 = _JNIEnv::NewByteArray(a1, v3);
  v4 = std::vector<unsigned char>::size[abi:ne180000](v8);
  v5 = std::vector<unsigned char>::data[abi:ne180000](v8);
  _JNIEnv::SetByteArrayRegion(a1, v7, 0, v4, v5);
  std::vector<unsigned char>::~vector[abi:ne180000](v8);
  std::string::~string(v9);
  return v7;
}
```
ahh looks hard to read , let's rename few variables , according to program flow and what the functions do ( just search up function names and u'll find them in the c++ docs)
```C++
  inputChars = _JNIEnv::GetStringUTFChars(jniEnv, input, 0);
  std::string::basic_string[abi:ne180000]<0>(v9, inputChars);
  _JNIEnv::ReleaseStringUTFChars(jniEnv, input, inputChars);
  encrypt_flag_bytes(v8);
  encryptedPayloadSize = std::vector<unsigned char>::size[abi:ne180000](v8);
  ByteArray = _JNIEnv::NewByteArray(jniEnv, encryptedPayloadSize);
  v4 = std::vector<unsigned char>::size[abi:ne180000](v8);
  v5 = std::vector<unsigned char>::data[abi:ne180000](v8);
  _JNIEnv::SetByteArrayRegion(jniEnv, ByteArray, 0, v4, v5);
  std::vector<unsigned char>::~vector[abi:ne180000](v8);
  std::string::~string(v9);
  return ByteArray;

```
What interests us is the **encrypt_flag_bytes** function , let's find out what it does :
```C++
  __int64 __fastcall encrypt_flag_bytes(__int64 a1, __int64 input)
{
  __int64 iterEnd; // [rsp+18h] [rbp-D8h]
  __int64 iterBegin; // [rsp+20h] [rbp-D0h]
  _BYTE encryptedBytes[24]; // [rsp+28h] [rbp-C8h] BYREF
  _BYTE substr3[24]; // [rsp+40h] [rbp-B0h] BYREF
  _BYTE desLayer2[24]; // [rsp+58h] [rbp-98h] BYREF
  _BYTE substr2[24]; // [rsp+70h] [rbp-80h] BYREF
  _BYTE desLayer1[28]; // [rsp+88h] [rbp-68h] BYREF
  _BYTE substr1[24]; // [rsp+B0h] [rbp-40h] BYREF
  _BYTE rot13String[24]; // [rsp+C8h] [rbp-28h] BYREF
  __int64 input2; // [rsp+E0h] [rbp-10h]
  __int64 v13; // [rsp+E8h] [rbp-8h]

  v13 = a1;
  input2 = input;
  rot13(rot13String, input);
  std::string::substr[abi:ne180000](substr1, input2, 0, 8);
  std::string::resize(substr1, 8, 88);
  des_encrypt(desLayer1, rot13String, substr1);
  std::string::substr[abi:ne180000](substr2, input2, 6, 4);
  std::string::resize(substr2, 8, 88);
  des_encrypt(desLayer2, desLayer1, substr2);
  std::string::substr[abi:ne180000](substr3, input2, 2, 4);
  std::string::resize(substr3, 8, 88);
  des_encrypt(encryptedBytes, desLayer2, substr3);
  iterBegin = std::string::begin[abi:ne180000]();
  iterEnd = std::string::end[abi:ne180000](encryptedBytes);
  _ZNSt6__ndk16vectorIhNS_9allocatorIhEEEC2INS_11__wrap_iterIPcEETnNS_9enable_ifIXaasr31__has_forward_iterator_categoryIT_EE5valuesr16is_constructibleIhNS_15iterator_traitsIS9_E9referenceEEE5valueEiE4typeELi0EEES9_S9_(
    a1,
    iterBegin,
    iterEnd);
  std::string::~string(encryptedBytes);
  std::string::~string(substr3);
  std::string::~string(desLayer2);
  std::string::~string(substr2);
  std::string::~string(desLayer1);
  std::string::~string(substr1);
  std::string::~string(rot13String);
  return a1;
}
```
This function basically takes a string, obfuscates it with ROT13, then runs three successive DES encryptions on different slices of the string, and finally packs the encrypted result into a byte vector to return.
```C++

```
That part is just taking the processed/encrypted bytes (between beginIter and endIter) and stuffing them into the output vector so they can be returned to the caller that's why we can ignore it lol , so now we have our flow we just need to write our solver which will do the decryption process and it starts with 3 des_decrypt then rot13 , here is the flow :

Encrypted bytes (outputVector from encrypt_flag_bytes)

→ DES decrypt using key3(substr3 = input[2:6], padded to 8 bytes with 'X')

→ DES decrypt using key2 (substr2 = input[6:10], padded to 8 bytes with 'X')

→ DES decrypt using key1 (substr1 = input[0:8], padded to 8 bytes with 'X')

→ Recombine decrypted layers to reconstruct ROT13 version of original input
→ Apply ROT13 to recover the original plaintext ciphertext/flag

NOTEE : as we know the flag format is "Securinets{flag}", the substrs (keys) are already known : 
- key1 = "Securine"
- key2 = "nets"
- key3 = "curi"

We have all we need to craft our solver  :
```python
from Crypto.Cipher import DES

def rot13(text: str) -> str:
    result = []
    for c in text:
        if 'a' <= c <= 'z':
            result.append(chr((ord(c) - ord('a') + 13) % 26 + ord('a')))
        elif 'A' <= c <= 'Z':
            result.append(chr((ord(c) - ord('A') + 13) % 26 + ord('A')))
        else:
            result.append(c)
    return ''.join(result)
def des_decrypt(ciphertext: bytes, key: bytes) -> bytes:
    key = key.ljust(8, b'X')[:8]
    cipher = DES.new(key, DES.MODE_ECB)
    decrypted = cipher.decrypt(ciphertext)
    return decrypted.rstrip(b'\0')

def decrypt_flag_bytes(encrypted_bytes: bytes) -> str:
    key3 = "Securinets{test}"[2:6].encode('utf-8')
    layer3 = des_decrypt(encrypted_bytes, key3)
    key2 = "Securinets{test}"[6:10].encode('utf-8')
    layer2 = des_decrypt(layer3, key2)
    key1 = "Securinets{test}"[:8].encode('utf-8')
    layer1_bytes = des_decrypt(layer2, key1)
    layer1_str = layer1_bytes.decode('utf-8', errors='ignore')
    return rot13(layer1_str)



with open("output.dat", "rb") as f:
    encrypted = f.read()
decrypted = decrypt_flag_bytes(encrypted)
print(f"Decrypted: {decrypted}")
```
Result :

```
Decrypted: Securinets{n4T1v3_L1bS_h4V3_L0T5_0f_53cR3t5!!}
```
---