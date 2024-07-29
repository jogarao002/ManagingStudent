FROM tomcat:8.0.20-jre8
MAINTAINER Jogarao <jogarao.bagathi@gmail.com>
EXPOSE 8080
COPY target/ManagingStudent.war /usr/local/tomcat/webapps/ManagingStudent.war
