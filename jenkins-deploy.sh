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
    sudo echo " "
    sudo echo "Stoping process on port: $WAR_FILE"
    sudo echo " "
}
 
function start(){
    sudo echo " "
    sudo nohup java -jar $WAR_FILE /tmp 2>> /dev/null >> /dev/null &
    sudo echo "java -jar $WAR_FILE /tmp 2>> /dev/null >> /dev/null &"
    sudo echo " "
}
 
# Function Call
stop
 
start
