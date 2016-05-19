---
layout: post
title: "Cheatsheet"
categories: cheatsheet
subtitle: Because brainspace is limited - cheatsheet for installations
---

### Examine the system

{% highlight bash %}
# know thyself (env)
printenv
whoami; pwd
history

# observe disk
mount
df -h

# io (Mac OS X)
iostat -c 2
iotop [-pid]

# view all USB (Mac OS X)
system_profiler SPUSBDataType
open Audio MIDI Setup application
cmd + 1 - Audio Devices (input/output, built-in microphone)
cmd + 2 - MIDI Studio - see USB, Bluetooth, and Network-connected devices... test MIDI

{% endhighlight %}

