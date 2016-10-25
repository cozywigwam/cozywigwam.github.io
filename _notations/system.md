---
layout: post
title: "System"
categories: notation
subtitle: Examination, package managers
---

### Know thyself

```bash
printenv
history
id
w
uname a
who -a
last -a
getent passwd
whoami
pwd
cat /etc/issue
cat /etc/*release*
cat /proc/version
dpkg -get-selections
mount
df -h
iostat -c 2
```
    

### Observe USB (Mac OS X)

```bash
system_profiler SPUSBDataType
```

- open Audio MIDI Setup application
- cmd + 1 - Audio Devices (input/output, built-in microphone)
- cmd + 2 - MIDI Studio - see USB, Bluetooth, and Network-connected devices... test MIDI



### Package managers

```bash
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
composer # see commands
composer show # because list would be too easy

# dpkg / apt-get
dpkg --get-selections | grep -v deinstall
dpkg --get-selections | grep -i php

# n
n # arrow keys and select
n --help
n list
n stable # use/install stable
n latest # use/install latest
n rm 0.9.4 v0.10.0 # remove

# npm
npm help
npm help <cmd>
npm list -g --depth=0
npm outdated -g --depth=0
sudo npm update -g npm

# ~ is minor: ~1.2.3 matches 1.2.x, not 1.3.0
# ^ is major: ^1.2.3 matches 1.x.x, not 2.0.0
```


### Misc

```bash
history -c

# Mac OS - routing table
netstat -rn # like Linux `route -n`
```
