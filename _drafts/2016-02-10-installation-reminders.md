---
layout: post
title: "INSTALLATION REMINDERS: where to get things"
date:   2016-02-10
categories: ruby gist
---
# curl
```bash
sudo apt-get install curl
```

# RVM & Ruby
```bash
\curl -L https://get.rvm.io | bash -s stable
source ~/.rvm/scripts/rvm
rvm requirements
rvm install ruby
rvm use ruby --default
rvm rubygems current
rvm list # see 'em
```

# Node.js
```bash
#sudo apt-get install nodejs
#sudo apt-get install npm
```

# Better... n
```bash
curl -L http://git.io/n-install | bash
n list # see 'em
```

# git
```bash
sudo apt-get install git
```

# jekyll
```bash
gem install jekyll
```

# HTTPS SSL cert with Let's Encrypt
```bash
sudo service nginx stop
cd /opt/letsencrypt
./letsencrypt-auto certonly --standalone
sudo ls /etc/letsencrypt/live/YOUR_DOMAIN_NAME
change /etc/nginx/sites-available/sitename:
```

## Update /etc/nginx/sites-available/sitename.com
Replace listen 80 with (and add ssl...):
```bash
    listen 443 ssl;

    server_name example.com www.example.com;

    ssl_certificate /etc/letsencrypt/live/example.com/fullchain.pem;
    ssl_certificate_key /etc/letsencrypt/live/example.com/privkey.pem;

    ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
    ssl_prefer_server_ciphers on;
    ssl_ciphers 'EECDH+AESGCM:EDH+AESGCM:AES256+EECDH:AES256+EDH';

server {
    listen 80;
	server_name example.com;
	return 301 https://$host$request_uri;
}
```

```bash
sudo service nginx restart
```


# Examine the system
mount
df -h






