recheck-web-spring-showcases
============================

In this project you will find one or more showcases for [recheck-web](https://github.com/retest/recheck-web) for demo purposes. These showcases show the interaction between recheck-web and Spring.

## Usage

Import this project to find out how recheck-web interacts with spring, especially for the usage of both javax.xml.bind and jakarta.xml.bind.

In order to run the demo it is required to run `mvn clean install` once. Following this make sure that the file called *mvnw* in the main directory is marked as executable.

To actually execute the test you must run `./mvnw test` in a terminal inside the main directory of the project or run a test in your IDE.

Further resources
=================

To apply changes to your golden masters, you need to install either the [review GUI](https://assets.retest.org/releases/review.html) or the [recheck CLI](https://github.com/retest/recheck.cli/releases). Help to setup the CLI can be found [in the docs](https://docs.retest.de/recheck.cli/setup/).
