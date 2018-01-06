#! /bin/bash

FILE=$1

while read -ru 3 LINE; do
    pandoc "$LINE" -o "$LINE".org
done 3< "$FILE"
