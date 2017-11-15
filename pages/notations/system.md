---
title: "System"
layout: notation
description: Self-discovery
path: "/system/"
---

# Know thyself

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

# macOS
dscacheutil -q user | grep -A 3 -B 2 -e uid:\ 5'[0-9][0-9]'
dscl . list /Users | grep -v '_'
```


# Examination

## Bower

```sh
bower list
bower search
bower install
bower uninstall
bower prune
```

## Brew

```sh
man brew
brew list
brew list postgres
brew search TERM
brew leaves # "Show installed formulae that are not dependencies of another installed formula."
```

## composer

```sh
composer # see commands
composer show # because list would be too easy
```

## dpkg / apt-get

```sh
dpkg --get-selections | grep -v deinstall
dpkg --get-selections | grep -i php
```

## elasticsearch

[docs](https://www.elastic.co/guide/en/elasticsearch/reference/current/_cluster_health.html)

```sh
curl 'localhost:9200/_cat/health?v'
curl 'localhost:9200/_cat/nodes?v'
curl 'localhost:9200/_cat/indices?v'

# deletion
curl -XDELETE localhost:9200/app_name/resource/123
curl -XDELETE localhost:9200/app_name
curl -XDELETE localhost:9200/_all
```

## gems

```sh
gem env
```

## n (instead of nvm)

```sh
n # arrow keys and select
n --help
n list
n stable # use/install stable
n latest # use/install latest
n rm 0.9.4 v0.10.0 # remove
```

## npm

```sh
npm help
npm help <cmd>
npm list -g --depth=0
npm outdated -g --depth=0
sudo npm update -g npm
```

### Change global path

Originally, the global path is `/usr/local/lib/node_modules/`. Change it with:

```sh
npm config set prefix '~/.npm-global' # updates ~/.npmrc
```

Then add `~/.npm-global/bin` to path.

## pm2

```sh
pm2 list
pm2 restart [name]
```

## rbenv

```sh
rbenv # quick help
rbenv install -l # list
rbenv install 2.3.1
rbenv version # see current version
rbenv versions # like `ls ~/.rbenv/versions/`

rbenv shell # just a helper for RBENV_VERSION
rbenv local # adds .ruby-version project file
rbenv global
```

## rvm

```sh
ruby -v
rvm list
gem list
```

## semver

Range specifiers:

|||||
|-|-|-|-|
~ | minor | `~1.2.3 ≈ 1.2.x` | `~1.2.3 ≉ 1.3.0`
^ | major | `^1.2.3 ≈ 1.x.x` | `^1.2.3 ≉ 2.0.0`

## ssh

```sh
eval `ssh-agent`
ssh-add ~/.ssh/my_id_rsa
ssh-add -l
kill [ssh-agent pid]
```



# docker

Docker's changing IP address on macOS is `docker.for.mac.localhost` ([reference](https://docs.docker.com/docker-for-mac/networking/#known-limitations-use-cases-and-workarounds)).

## Reference

[common mistakes](https://runnable.com/blog/9-common-dockerfile-mistakes)


# macOS

settings/options defaults from [Mathias Bynens](https://github.com/mathiasbynens/dotfiles/blob/master/.macos) 

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

# hide/show directories in Finder
chflags hidden Pictures
chflags nohidden Pictures

# safely remove a volume
diskutil list
diskutil eject disk2 # disk2 is [device]
```

## Daemons & Agents

`brew services list`

`brew services run|start|stop|restart formula|-all`

Daemons: `launchd` and `launchctl`. `brew` plugs into `launchctl` via `brew services`.

Launched at boot: `/Library/LaunchDaemons`

Launched at login: `~/Library/LaunchAgents`

## Misc

|||
|-|-|
`cmd + shift + V` | paste with stripped formatting (might need alt sometimes, not sure here)
`~/Library/Services/` | Location of AppleScript services (.workflow files)


# Misc

```sh
history -c

identify -format '%w %h' img.png ## measure/get img pixel dims

scp -r <local_spec> <remote_spec>

# vagrant
vagrant ssh-config # see hostname, port, SSH Key location

```

Vagrant insecure key: `~/.vagrant.d/insecure_private_key`

