# Java Quotes
This is an application that reaches out to the [Ron Swanson Quotes API](http://ron-swanson-quotes.herokuapp.com/v2/quotes) and prints a random quote provided by the API. In the event that reaching the API fails it reads in the json file from the [assets folder](assets/recentquotes.json) and parses the contents into an array of [Quote](src/main/java/Quote.java) objects. It will then print a random quote from that array to the console.

# Install
After cloning the repo, cd into it and run `./gradlew build` from the terminal to install the dependencies for this project.

# Running and Testing
The app can be run using `./gradlew run` in the terminal, it will output a random quote in the console. To run the tests for this app, run `./gradlew test` in the terminal to run all the included test suites.