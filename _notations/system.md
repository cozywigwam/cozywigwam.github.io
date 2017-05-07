---
layout: post
title: "System"
categories: notation
subtitle: Examination, Package Managers
---

# Know thyself

Noah Hoffman's [notes](http://web.labmed.washington.edu/nhoffman/notes/linux)

```sh
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
dscacheutil -q user | grep -A 3 -B 2 -e uid:\ 5'[0-9][0-9]' # macOS
```


# Package managers

```sh
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

# n (instead of nvm)
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

# original global path
/usr/local/lib/node_modules/

# change global path
npm config set prefix '~/.npm-global' # updates ~/.npmrc
# add ~/.npm-global/bin to path

# ~ is minor: ~1.2.3 matches 1.2.x, not 1.3.0
# ^ is major: ^1.2.3 matches 1.x.x, not 2.0.0

# rvm
ruby -v
rvm list
gem list

# rbenv
rbenv # quick help
rbenv install -l # list
rbenv install 2.3.1
rbenv version # see current version
rbenv versions # like `ls ~/.rbenv/versions/`

rbenv shell # just a helper for RBENV_VERSION
rbenv local # adds .ruby-version project file
rbenv global

# gems
gem env
```


# macOS

settings/options defaults: https://github.com/mathiasbynens/dotfiles/blob/master/.macos

`<S-v>` | paste with stripped formatting (might need alt sometimes, not sure here)

## Location of AppleScript services (.workflow files):
local/ref | in use
--- | ---
~/script-and-helpers/Automator/ | ~/Library/Services/

## Observe USB in the GUI:
- open Audio MIDI Setup application
- cmd + 1 - Audio Devices (input/output, built-in microphone)
- cmd + 2 - MIDI Studio - see USB, Bluetooth, and Network-connected devices... test MIDI

```sh
# observe USB
system_profiler SPUSBDataType

# routing table
netstat -rn # like Linux `route -n`

# when camera stops working
ps -ax | grep i vdcassistant
kill [pid]

# users with uid 5xx
dscacheutil -q user | grep -A 3 -B 2 -e uid:\ 5'[0-9][0-9]'
dscl # then `cd Contact`, `cd Users`, `read [username]`
```


# Misc

```sh
history -c

# vagrant
vagrant ssh-config # see hostname, port, SSH Key location
```
