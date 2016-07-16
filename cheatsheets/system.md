---
layout: post
title: "Cheatsheet"
categories: cheatsheet
subtitle: Because brainspace is limited - cheatsheet for installations
---

### Examine the system

    # know thyself (env)
    printenv
    whoami; pwd
    history

### observe disk

    mount
    df -h

### io (Mac OS X)
    iostat -c 2
    iotop [-pid]

### view all USB (Mac OS X)

`system_profiler SPUSBDataType`

- open Audio MIDI Setup application
- cmd + 1 - Audio Devices (input/output, built-in microphone)
- cmd + 2 - MIDI Studio - see USB, Bluetooth, and Network-connected devices... test MIDI




### Package managers

    # bower
    bower list
    bower search
    bower install
    bower uninstall
    bower prune

    # brew
    brew list
    brew list postgres
    brew search TERM
    
    # composer
    
    
    # dpkg / apt-get
    dpkg --get-selections | grep -v deinstall
    dpkg --get-selections | grep -i php
    
    # n
    n // arrow keys and select
    n --help
    n list
    n stable // use/install stable
    n latest // use/install latest
    n rm 0.9.4 v0.10.0 // remove
    
    # npm
    npm help
    npm help <cmd>
    npm list -g --depth=0
    npm outdated
    sudo npm update -g npm
    
    # ~ is minor: ~1.2.3 matches 1.2.x, not 1.3.0
    # ^ is major: ^1.2.3 matches 1.x.x, not 2.0.0
    
