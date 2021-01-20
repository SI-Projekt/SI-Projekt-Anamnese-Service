#!/usr/bin/bash

#Starts app and saves the process id in a file to kill it later
echo 'Starting Spring Boot app'
cd '/home/ec2-user/app'
java -jar si-projekt-anamnese-service-0.0.1-SNAPSHOT.jar &
