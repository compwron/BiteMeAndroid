#!/usr/bin/env bash
set -e

PROJECT_ROOT="$( cd "$( dirname "${BASH_SOURCE[0]}/.." )" && pwd )"

cd $PROJECT_ROOT

sudo apt-get update -qq
if [ `uname -m` = x86_64 ]; then sudo apt-get install -qq --force-yes libgd2-xpm ia32-libs ia32-libs-multiarch; fi
wget http://dl.google.com/android/android-sdk_r21.0.1-linux.tgz
tar -xzf android-sdk_r21.0.1-linux.tgz
export ANDROID_HOME=$PROJECT_ROOT/android-sdk-linux
echo "ANDROID_HOME is $ANDROID_HOME"
export PATH=${PATH}:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools
echo "PATH is $PATH"
android update sdk --filter platform-tools,android-16,extra-android-support,android-17,sysimg-17,extra-google-google_play_services --no-ui --force
cp vendor/GmsMvn/gms-mvn-install.sh android-sdk-linux/extras/google/google_play_services/libproject/google-play-services_lib/ 
(cd android-sdk-linux/extras/google/google_play_services/libproject/google-play-services_lib/ && ./gms-mvn-install.sh)
echo no | android create avd -n emulator -t android-17 --skin WVGA800 --force --abi armeabi-v7a
gem install calabash-android
