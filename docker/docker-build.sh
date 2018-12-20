#!/bin/bash
cp ../target/transactions.war .
docker build -t wildfly-springboot-app .
read -rsp $'Press enter to continue...\n'
