#include <jni.h>

extern "C" {

// This is the constant flag stored in the native library
static const char secret[] = "VTJWamRYSnBibVYwYzN0T05IUXhWak5mYkRGQ2MxOXNWWEpMWHpGT1gzUklNMTl6U0RSa01GYzFmUT09";

// Exported JNI function
JNIEXPORT jstring JNICALL
Java_io_securinets_level12_nativeflag_getFlag(JNIEnv* env, jobject /* this */) {
    return env->NewStringUTF(secret);
}

}
