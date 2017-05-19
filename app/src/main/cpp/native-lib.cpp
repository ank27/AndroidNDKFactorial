#include <jni.h>
#include <string>
#include <android/log.h>
#define  LOG_TAG    "NativeC"
#define  LOGD(...)  __android_log_prjint(ANDROID_LOG_DEBUG,LOG_TAG,__VA_ARGS__)

long factorial_cal(int value1);

//extern "C"
//jint Java_com_factorialappndk_MainActivity_factorialValue(JNIEnv* env,jobject obj,jint value){
//    int fact = factorial(value);
//    __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, "Value from activity: %d",value);
//    return fact;
//}


extern "C"
jlong Java_com_factorialappndk_MainActivity_calculateFactorialValue(JNIEnv* env,jobject obj,jint value){
    long fact = factorial_cal(value);
    return fact;
}

//int factorial(int value1) {
//    if (value1 == 0) {
//        return 0;
//    } else {
//        int fact = 1;
//        for (int counter = 1; counter <= value1; counter++) {
//            fact = fact * counter;
//        }
//        return fact;
//    }
//}


long factorial_cal(int value1) {
    if(value1 == 0){
        return 0;
    } else {
        long fact = 1;
        for (int counter = 1; counter <= value1; counter++) {
            fact = fact * counter;
        }
        return fact;
    }
}
