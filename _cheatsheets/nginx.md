---
layout: post
title: "nginx"
categories: cheatsheet
subtitle: Misc snippets
---

### Random

``` bash
sudo nginx -t && sudo nginx -s reload # !nginxreload
```

### force no-www & https

``` bash
server {
    listen 80;
    listen 443 ssl;
    server_name www.DOMAIN;
    
    ssl_certificate /etc/letsencrypt/live/DOMAIN/fullchain.pem;
    ssl_certificate_key /etc/letsencrypt/live/DOMAIN/privkey.pem;
    
    return 301 https://DOMAIN$request_uri;
}

server {
    # [default] listen 80;
    server_name DOMAIN;
    return 301 https://$host$request_uri;
}
```

## SSL

### Let's Encrypt SSL
[DO Let's Encrypt Ubuntu/nginx Tutorial](https://www.digitalocean.com/community/tutorials/how-to-secure-nginx-with-let-s-encrypt-on-ubuntu-14-04)

``` bash
# install let's encrypt
sudo apt-get -y install bc # auto 'yes' to prompts
sudo git clone https://github.com/letsencrypt/letsencrypt /opt/letsencrypt

# get certs
sudo service nginx stop
netstat -na | grep ':80.*LISTEN' # sanity check

/opt/letsencrypt/letsencrypt-auto certonly --standalone # launch GUI
sudo ls /etc/letsencrypt/live/YOUR_DOMAIN_NAME # verify

# renew everything
/opt/letsencrypt/letsencrypt-auto renew

# generate Diffie-Hellman Group
sudo openssl dhparam -out /etc/ssl/certs/dhparam_DOMAIN.pem 2048 # !diffie
```

### server block config for SSL

``` bash
ssl_certificate /etc/letsencrypt/live/DOMAIN_NAME/fullchain.pem;
ssl_certificate_key /etc/letsencrypt/live/DOMAIN_NAME/privkey.pem;

ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
ssl_prefer_server_ciphers on;
ssl_dhparam /etc/ssl/certs/dhparam_DOMAIN_NAME.pem;

ssl_ciphers 'ECDHE-RSA-AES128-GCM-SHA256:ECDHE-ECDSA-AES128-GCM-SHA256:ECDHE-RSA-AES256-GCM-SHA384:ECDHE-ECDSA-AES256-GCM-SHA384:DHE-RSA-AES128-GCM-SHA256:DHE-DSS-AES128-GCM-SHA256:kEDH+AESGCM:ECDHE-RSA-AES128-SHA256:ECDHE-ECDSA-AES128-SHA256:ECDHE-RSA-AES128-SHA:ECDHE-ECDSA-AES128-SHA:ECDHE-RSA-AES256-SHA384:ECDHE-ECDSA-AES256-SHA384:ECDHE-RSA-AES256-SHA:ECDHE-ECDSA-AES256-SHA:DHE-RSA-AES128-SHA256:DHE-RSA-AES128-SHA:DHE-DSS-AES128-SHA256:DHE-RSA-AES256-SHA256:DHE-DSS-AES256-SHA:DHE-RSA-AES256-SHA:AES128-GCM-SHA256:AES256-GCM-SHA384:AES128-SHA256:AES256-SHA256:AES128-SHA:AES256-SHA:AES:CAMELLIA:DES-CBC3-SHA:!aNULL:!eNULL:!EXPORT:!DES:!RC4:!MD5:!PSK:!aECDH:!EDH-DSS-DES-CBC3-SHA:!EDH-RSA-DES-CBC3-SHA:!KRB5-DES-CBC3-SHA';
ssl_session_timeout 1d;
ssl_session_cache shared:SSL:50m;
ssl_stapling on;
ssl_stapling_verify on;
add_header Strict-Transport-Security max-age=15768000;
```