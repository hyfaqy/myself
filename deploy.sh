#!/bin/sh

mkdir -p $CATALINA_HOME/webapps/myself

cp -r src/main/webapp/* $CATALINA_HOME/webapps/myself
cp -r target/classes/ $CATALINA_HOME/webapps/myself/WEB-INF/
cp -r lib $CATALINA_HOME/webapps/myself/WEB-INF/
