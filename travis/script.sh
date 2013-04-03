#!/usr/bin/env bash
set -e

PROJECT_ROOT="$( cd "$( dirname "${BASH_SOURCE[0]}" )/.." && pwd )"

cd $PROJECT_ROOT

export ANDROID_HOME=$PROJECT_ROOT/android-sdk-linux
export PATH=${PATH}:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools

mvn install
adb kill-server
adb start-server
adb devices
adb install -r target/bitemoi-1.0-SNAPSHOT.apk
calabash-android run target/bitemoi-1.0-SNAPSHOT.apk
