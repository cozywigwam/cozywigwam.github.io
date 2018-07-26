#!/bin/sh

find pages/_drafts/src -iname "*.org" -type f -exec sh -c 'pandoc --verbose -f org -t gfm -o "pages/_drafts/$(basename ${0} .org).md" ${0}' {} \;
find pages/_drafts -iname "*.md" -type f -exec sh -c 'sed -i "" "1d;8d;" ${0}' {} \;
