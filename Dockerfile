FROM tomcat:9.0-jre8

COPY  target/Marriage_App.war           /usr/local/tomcat/webapps/Marriage_App.war