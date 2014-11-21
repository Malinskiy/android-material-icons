#!/bin/bash

iconDefinitions=($(tr -d '\n ' < $1 | egrep -o "md-[^: ]+[^}]+}"))

echo "Found ${#iconDefinitions[@]} icons"

rm -f enum.txt

for i in "${iconDefinitions[@]}"
do
   :
   name=$(echo $i | egrep -o "md-[^:]+" | tr '-' '_')
   value=$(echo $i | egrep -o "content[^;]+" | egrep -o "[0-9a-f]{4}")

   echo "$name('\u$value')," >> enum.txt
done