#!/usr/bin/env bash

PROJECT_ROOT="$(cd $(dirname "${BASH_SOURCE[0]}") && pwd)"
VENDOR_DIRECTORY=$PROJECT_ROOT/vendor
ANDROID_SDK_DIRECTORY=$VENDOR_DIRECTORY/android-sdk-macosx

export ANDROID_HOME=$ANDROID_SDK_DIRECTORY
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools

emulator -avd emulator -prop persist.sys.language=en -prop persist.sys.country=US -noaudio -no-boot-anim &

echo "Sleeping while emulator initialises..."
sleep 45

mvn install

adb kill-server
adb start-server
adb devices
adb install -r target/bitemoi-1.0-SNAPSHOT.apk

calabash-android run target/bitemoi-1.0-SNAPSHOT.apk