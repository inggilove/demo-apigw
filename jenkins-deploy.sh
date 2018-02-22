#!/bin/bash
# bash Call
# sudo bash {PATH}/deploy.sh Build-demo-apigw-0.0.1-SNAPSHOT.war
 
# Field
 
# Service Name
# Ex) Build-demo-apigw
PROJECT_NAME=$1
 
PROJECT_PATH=/var/lib/jenkins/workspace/$PROJECT_NAME/build/libs
WAR_FILE=$PROJECT_PATH/$PROJECT_NAME
 
# Function
function stop(){
    echo " "
    echo "Stoping process on port: $WAR_FILE"
    echo " "
}
 
function start(){
    echo " "
    nohup java -jar $WAR_FILE /tmp 2>> /dev/null >> /dev/null &
    echo "java -jar $WAR_FILE /tmp 2>> /dev/null >> /dev/null &"
    echo " "
}
 
# Function Call
stop
 
start
