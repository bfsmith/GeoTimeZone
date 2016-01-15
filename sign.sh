#!/usr/bin/env bash

rm -rf sign/
mkdir sign
cp target/*.jar sign/.
cp pom.xml sign/.

cd sign
for f in $( ls ); do
  gpg -ab $f
done

jar -cvf bundle.jar *

