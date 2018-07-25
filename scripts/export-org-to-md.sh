#!/bin/sh

find pages/notations/src -iname "*.org" -type f -exec sh -c 'pandoc -f org -t gfm -o "pages/notations/$(basename ${0} .org).md" ${0}' {} \;
find pages/notations -iname "*.md" -type f -exec sh -c 'sed -i "" "1d;8d;" ${0}' {} \;

find pages/_drafts/src -iname "*.org" -type f -exec sh -c 'pandoc -f org -t gfm -o "pages/_drafts/$(basename ${0} .org).md" ${0}' {} \;
find pages/_drafts -iname "*.md" -type f -exec sh -c 'sed -i "" "1d;8d;" ${0}' {} \;
