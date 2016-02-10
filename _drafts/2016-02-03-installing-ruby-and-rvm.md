---
layout: post
title: "Installing RVM"
date:   2016-02-03
categories: ruby gist
---
sudo apt-get install curl
\curl -L https://get.rvm.io | bash -s stable
source ~/.rvm/scripts/rvm
rvm requirements
rvm install ruby
rvm use ruby --default
