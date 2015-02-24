#!/bin/bash

rm -rf deploy/
mkdir deploy
cp pom.xml deploy/
cp target/*.jar deploy/
cd deploy/

for f in `ls`; do 
gpg2 -ab $f
done
jar -cvf geotimezone.jar *
