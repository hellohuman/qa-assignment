# QA Take-Home Assignment

A small take-home assignment for you to demonstrate working knowledge of web user interface and API testing along with helping safe guard quality.

## User interface testing

Use the publicly available [Conduit](https://demo.realworld.io/) sample to create a suite of manual and automated tests that show some of:
* Sign up of a new user
* User login
* *Global Feed* loading progress and final state
* Navigation to an article
* Creation of a new article

Note that whatever password you use on this site should be considered insecure, and you should not rely on existing records or accounts as they may be removed at any time.

The choice of what is automated vs. manual and how many tests to create is up to you. It should be guided by the idea that this is to showcase that you can:
* Create automated tests that run against the user interface and report their results
* Store the automated tests in a Github repository
* Document the automated tests with sufficient detail for others to be able to run them
* Create manual tests with sufficient documentation for others to replicate them and achieve the same results

## API testing

Use the publicly available [Conduit](duit.productionready.io/api/) API to create a set of automated API tests. This is the same API used by the site in the *User interface testing* section, and the scenarios you cover there should guide the scenarios you cover with the API tests. There is additionally an [API spec](https://github.com/gothinkster/realworld/tree/master/api) which describes some of the calls, though you will also need to use experimentation to learn how they function.

## Suggestions for quality

This last section is about applying a QA mindset to the API and user interface to suggest improvements to the application and explain why the suggestion is being made. This task is deliberately open ended and 5-10 suggestions is sufficient.
We recommend focusing on things like handling/responses to error cases, consistency/quality of user experience, relevance of API request results and thoughts on security/risk.
Good luck :v:
