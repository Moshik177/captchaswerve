# Description
A simple wrapper around CAPTCHA solving services.  Only supports deathbycaptcha.com at the moment.

# Install
Signup at deathbycaptcha, then create a properties file:
deathbycaptcha.properties, e.g.:

type=DeathByCaptcha
username=billybobuser
password=password

Install it into the local maven repository with:

	mvn install -DskipTests
