#!/usr/bin/env bash
set -e

mvn install
adb kill-server
adb start-server
adb devices
adb install -r target/bitemoi-1.0-SNAPSHOT.apk
calabash-android run target/bitemoi-1.0-SNAPSHOT.apk
