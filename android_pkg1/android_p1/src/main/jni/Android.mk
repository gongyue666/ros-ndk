LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE    := chatter_jni
LOCAL_SRC_FILES := src/chatter_jni.cpp
LOCAL_C_INCLUDES := $(LOCAL_PATH)/include
LOCAL_LDLIBS := -landroid -llog
LOCAL_STATIC_LIBRARIES := roscpp_android_ndk
include $(BUILD_SHARED_LIBRARY)

$(call import-add-path,  /home/gy/ros-android-ndk/roscpp_android/output/)
$(call import-module, roscpp_android_ndk)