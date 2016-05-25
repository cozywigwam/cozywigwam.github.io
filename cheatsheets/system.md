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




### Examine installed packages & versions

    # bower

    # brew
    brew list
    brew list postgres
    brew search TERM
    
    # composer
    
    
    # dpkg / apt-get
    dpkg --get-selections | grep -v deinstall
    dpkg --get-selections | grep -i php
    
    # npm
    
