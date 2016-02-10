---
layout: post
title: "Cheatsheet: Linux Installations"
date:   2016-02-10
categories: cheatsheet linux
subtitle: Because brainspace is limited
---

## Basics

### curl & git are dpkg
{% highlight bash %}
sudo apt-get install curl git
{% endhighlight %}


### RVM & Ruby
{% highlight bash %}
curl -L https://get.rvm.io | bash -s stable
source ~/.rvm/scripts/rvm
rvm requirements
rvm install ruby
rvm use ruby --default
rvm rubygems current
rvm list # see 'em
{% endhighlight %}


### node is dpkg...
{% highlight bash %}
#sudo apt-get install nodejs
#sudo apt-get install npm
{% endhighlight %}


### ... but use n instead
{% highlight bash %}
curl -L http://git.io/n-install | bash
n list # see 'em
{% endhighlight %}


### jekyll is a gem
{% highlight bash %}
gem install jekyll
{% endhighlight %}


## HTTPS

### HTTPS SSL cert with Let's Encrypt [(ref.)](https://www.digitalocean.com/community/tutorials/how-to-secure-nginx-with-let-s-encrypt-on-ubuntu-14-04)

Install Let's Encrypt.

{% highlight bash %}
sudo apt-get -y install bc # auto 'yes' to prompts
sudo git clone https://github.com/letsencrypt/letsencrypt /opt/letsencrypt
{% endhighlight %} 

Register the domain with Let's Encrypt.

{% highlight bash %}
sudo service nginx stop
netstat -na | grep ':80.*LISTEN' # sanity check
cd /opt/letsencrypt
./letsencrypt-auto certonly --standalone # launches instructions-led GUI
sudo ls /etc/letsencrypt/live/YOUR_DOMAIN_NAME # verify
{% endhighlight %} 

Update the nginx vhost config by changing the main server block to `listen 443 ssl` with ssl-related directives, then 301 port 80 to https.

{% highlight bash %}
server {
    # listen 80 ...
    listen 443 ssl;

    # server_name, etc. ...

    ssl_certificate /etc/letsencrypt/live/example.com/fullchain.pem;
    ssl_certificate_key /etc/letsencrypt/live/example.com/privkey.pem;

    ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
    ssl_prefer_server_ciphers on;
    ssl_ciphers 'EECDH+AESGCM:EDH+AESGCM:AES256+EECDH:AES256+EDH';

    # location, etc. ...
}
server {
    listen 80;
    server_name example.com;
    return 301 https://$host$request_uri;
}
{% endhighlight %} 


