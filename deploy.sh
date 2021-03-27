#!/bin/bash

echo "Deploying the application to WildFly 16 at /otc/wildfly"

mvn package

FILE=/opt/wildfly/standalone/deployments/ServletAPI.war

if test -f "$FILE"; then
  rm /opt/wildfly/standalone/deployments/ServletAPI.war
fi

cp ./target/ServletAPI.war /opt/wildfly/standalone/deployments/
echo "File Copied Successfully!"