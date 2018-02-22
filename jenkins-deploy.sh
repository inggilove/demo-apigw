#!/bin/bash
# bash Call
# bash {PATH}/jenkins-deploy.sh Build-demo-apigw 0.0.1-SNAPSHOT
 
# Field
 
# Jenkins Project Name
# Ex) Build-demo-apigw
PROJECT_NAME=$1

# Version Number
# Ex) 0.0.1-SNAPSHOT
VERSION_NO=$2
 
WAR_FILE=./build/libs/$PROJECT_NAME-$VERSION_NO.war
 
# Function
function stop(){
    echo " "
    echo "Stoping process on port: $WAR_FILE"
    echo " "
}
 
function start(){
    echo " "
    nohup java -jar $WAR_FILE 1> /dev/null 2>&1
    echo "java -jar $WAR_FILE 1> /dev/null 2>&1"
    echo " "
}
 
# Function Call
stop
 
start
