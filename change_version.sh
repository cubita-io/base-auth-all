#!/bin/bash
## 替换 auth-parent 为对应的项目的名称
## 替换 base.auth.version 为对应的项目的名称
shopt -s expand_aliases
if [ ! -n "$1" ] ;then
	echo "Please input a version as first argument, e.g., 3.2.2"
 	exit 1
else
  	echo "Version to update is $1"
fi

currentVersion=`sed -n '/<project /,/<packaging/p' pom.xml | grep version | cut -d '>' -f2 | cut -d '<' -f1`
echo "Current version is $currentVersion"

if [ `uname` == "Darwin" ] ;then
 	alias sed='sed -i ""'
else
 	alias sed='sed -i'
fi

echo "Change version in root pom.xml ===>"
sed "/<project /,/<packaging/ s/<version>.*<\/version>/<version>$1<\/version>/" pom.xml

echo "Change version in subproject pom ===>"
for filename in $(find ./ ! -path '*/auth-parent/*' -name "pom.xml"); do
    echo "Dealing with ${filename:2}"
    sed "/<parent>/,/<\/parent>/ s/<version>$currentVersion<\/version>/<version>$1<\/version>/" $filename
done
sed "/<packaging>/,/<properties>/ s/<version>$currentVersion<\/version>/<version>$1<\/version>/" \
    ./auth-parent/pom.xml
sed "/<properties>/,/<\/properties>/ s/<base.auth.version>$currentVersion<\/base.auth.version>/<base.auth.version>$1<\/base.auth.version>/" \
    ./auth-parent/pom.xml

echo "Change version in build.gradle"
for filename in $(find . -name "build.gradle" -mindepth 3); do
    echo "Dealing with $filename"
    sed "s/^version '$currentVersion'$/version '$1'/g" $filename
done