Feature: create post and get method validate respone 



Scenario: Create post request and validate the response 
Given: create post prerequest script 
When: execute post api
Then: validate the 201 response code
And: validate the response id is matching with expected result 
And: retrieve the ID values
And: print the value id value using log4j2
And: print the log response in report


Scenario: Create get method and validate the response
Given:create get pre request script
When: pass the id in path parameter and execute get api
Then: validate the 200 response code


Scenario: Create unknown get method and validate the response
Given:create unknown get pre request script
When: execute get api
Then: validate the 200 response code
And: get the response data from the year 2000 color