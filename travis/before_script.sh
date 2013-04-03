#!/usr/bin/env bash
set -e
PROJECT_ROOT="$( cd "$( dirname "${BASH_SOURCE[0]}" )/.." && pwd )"
cd $PROJECT_ROOT

export DISPLAY=:99.0
sh -e /etc/init.d/xvfb start
sleep 3 # give xvfb some time to start 
emulator -avd emulator -prop persist.sys.language=en -prop persist.sys.country=US -noaudio -no-boot-anim &
sleep 45
