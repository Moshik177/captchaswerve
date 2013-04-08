# Description
A simple wrapper around CAPTCHA solving services.  Only supports captchbuster at the moment.

# Install
Signup at captchabuster, then create a properties file:
captchabuster.properties with properties for "login" and "api", e.g.:

login=myusername
api=theKeyTheyAssignToMe

Install it into the local maven repository with:

	mvn install -DskipTests