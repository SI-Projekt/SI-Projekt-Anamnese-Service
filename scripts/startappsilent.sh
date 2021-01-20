#!/usr/bin/bash

# Check java command exists, discard output
testJava=`which java > /dev/null 2>&1`

# if the last command failed, install java
if [[ $? -eq 1 ]] ; then
  echo 'Java not install, Installing java'
  yum -y install java-1.8.0-openjdk
fi
echo 'Run silently the runapp script'
scriptDir="$(dirname "${BASH_SOURCE[0]}")"
chmod +x "${scriptDir}/runapp.sh"
nohup "${scriptDir}/runapp.sh" > /var/log/si-project.log 2>&1 &
