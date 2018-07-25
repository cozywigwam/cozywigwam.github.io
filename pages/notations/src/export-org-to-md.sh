#! /bin/bash

find ./ -iname "*.org" -type f -exec sh -c 'pandoc "${0}" -o "../$(basename ${0%.html}.md)"' {} \;
