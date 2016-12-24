[![Build Status](https://travis-ci.org/hanneskaeufler/java-ee-rest-api-playground.svg?branch=master)](https://travis-ci.org/hanneskaeufler/java-ee-rest-api-playground)

# Java ee rest api playground

* java ee 7.0
* jersey
* arquillian
* etc.

## Deployment

For now I dont have automatic deployment set up. Run

`mvn -f BooksApi/pom.xml package`

This will generate a `BooksApi-ear/target/booksapi.ear` which you can manually deploy to payara.
If the tests fail but you still want to deploy for some crazy reason 😈, you can skip the tests with

`mvn -f BooksApi/pom.xml -DskipTests package`

## Testing

Run tests with `mvn -f BooksApi/pom.xml  test`. This will run the default profile `remote-server` which requires a glassfish/payara server to be started.
This is why there is also `mvn -f BooksApi/pom.xml test -Pembedded-server` which will boot a payara-embedded instance for each test.

## "Uummm What"s

The were loads of moments where I was conf

* Entities must have setters, otherwise serialization doesn't work. [Boo](http://softwareengineering.stackexchange.com/questions/21802/when-are-getters-and-setters-justified)
* The booksapi-web-integration-tests.war did not expose the endpoint that I expected. I forgot the class with @ApplicationPath annotation in the deployment. [fix](https://github.com/hanneskaeufler/java-ee-rest-api-playground/commit/fc86221d63ee58cfb64f0ea17841375afcd23638)

## References

Getting this to work requires reading of the entire internet. Here are some links that helped:

* https://github.com/payara/Payara-Examples/tree/master/rest-examples
* https://github.com/payara/Payara-Examples/tree/master/Java-EE/arquillian-example with http://blog.payara.fish/using-payara-embedded-as-an-arquillian-container-inside-intellij-idea
* https://github.com/javaee-samples/javaee7-samples/tree/master/jaxrs/jaxrs-endpoint

### Exception to Response Mapping

* https://jersey.java.net/documentation/latest/representations.html#d0e6754

### Validation

* https://github.com/jersey/jersey/tree/master/examples/bean-validation-webapp
