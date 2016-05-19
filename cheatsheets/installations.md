---
layout: post
title: "Cheatsheet"
categories: cheatsheet
subtitle: Because brainspace is limited - cheatsheet for installations
---

### git
{% highlight bash %}
git submodule add git@github.com:url_to/awesome_submodule.git path_to_awesome_submodule
git submodule update --init
{% endhighlight %}

### Examine the system
{% highlight bash %}
mount
df -h
{% endhighlight %}

## Setup

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



## Server Setup

### set up first user after installation
{% highlight bash %}
# [ if you need ssh-copy-id on Mac...
brew install ssh-copy-id
# ]

ssh-copy-id example_user@203.0.113.10
{% endhighlight %}


### HTTPS SSL cert with Let's Encrypt [(ref.)](https://www.digitalocean.com/community/tutorials/how-to-secure-nginx-with-let-s-encrypt-on-ubuntu-14-04)

Install Let's Encrypt. [DO Tutorial](https://www.digitalocean.com/community/tutorials/how-to-secure-nginx-with-let-s-encrypt-on-ubuntu-14-04)

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

Generate Diffie-Hellman Group

{% highlight bash %}
sudo openssl dhparam -out /etc/ssl/certs/dhparam_YOUR_DOMAIN_NAME.pem 2048
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
    ssl_dhparam /etc/ssl/certs/dhparam_YOUR_DOMAIN_NAME.pem;
    ssl_ciphers 'ECDHE-RSA-AES128-GCM-SHA256:ECDHE-ECDSA-AES128-GCM-SHA256:ECDHE-RSA-AES256-GCM-SHA384:ECDHE-ECDSA-AES256-GCM-SHA384:DHE-RSA-AES128-GCM-SHA256:DHE-DSS-AES128-GCM-SHA256:kEDH+AESGCM:ECDHE-RSA-AES128-SHA256:ECDHE-ECDSA-AES128-SHA256:ECDHE-RSA-AES128-SHA:ECDHE-ECDSA-AES128-SHA:ECDHE-RSA-AES256-SHA384:ECDHE-ECDSA-AES256-SHA384:ECDHE-RSA-AES256-SHA:ECDHE-ECDSA-AES256-SHA:DHE-RSA-AES128-SHA256:DHE-RSA-AES128-SHA:DHE-DSS-AES128-SHA256:DHE-RSA-AES256-SHA256:DHE-DSS-AES256-SHA:DHE-RSA-AES256-SHA:AES128-GCM-SHA256:AES256-GCM-SHA384:AES128-SHA256:AES256-SHA256:AES128-SHA:AES256-SHA:AES:CAMELLIA:DES-CBC3-SHA:!aNULL:!eNULL:!EXPORT:!DES:!RC4:!MD5:!PSK:!aECDH:!EDH-DSS-DES-CBC3-SHA:!EDH-RSA-DES-CBC3-SHA:!KRB5-DES-CBC3-SHA';
    ssl_session_timeout 1d;
    ssl_session_cache shared:SSL:50m;
    ssl_stapling on;
    ssl_stapling_verify on;
    add_header Strict-Transport-Security max-age=15768000;
    # location, etc. ...
}
server {
    listen 80;
    server_name example.com;
    return 301 https://$host$request_uri;
}
{% endhighlight %} 


