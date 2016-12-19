[![Build Status](https://travis-ci.org/hanneskaeufler/java-ee-rest-api-playground.svg?branch=master)](https://travis-ci.org/hanneskaeufler/java-ee-rest-api-playground)

# Java ee rest api playground

* java ee 7.0
* jersey
* arquillian
* etc.

## Testing

Run tests with `mvn test`. This will run the default profile `remote-server` which requires a glassfish/payara server to be started.
This is why there is also `mvn test -Pembedded-server` which will boot a payara-embedded instance for each test.
