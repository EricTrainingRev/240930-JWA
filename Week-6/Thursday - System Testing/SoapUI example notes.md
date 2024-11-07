# Soap UI
SoapUI is a testing tool that can perform API, Performance, and Security tests for your web applications. It was designed for SOAP applications, but it can work with RESTful applications as well

To create a basic load test:
1. create a REST project and set your base url
2. create the request methods you will use in your test
3. create a test suite
4. add the methods to be called to your test case
5. add a load test and configure the settings/assertions
6. run your test as needed

## Load Testing Statistics
- min: shortest time to get a response for request across all requests in test in milliseconds
- max: longest time it took to get a response for request across all requests in milliseconds
- avg: average time it took to get a response for request across all requests in milliseconds
- last: how long it took the most recently made http request to return a response in milliseconds
- cnt: number of http requests made over the entire test period
- tps: number of transactions made (requests to server) per second. Calculated by dividing cnt by total time of test
- bytes: total amount of data transferred during test in bytes
- bps: bytes transferred per second during course of test. Calculated by dividing bytes by total time of test
- err: number of requests that ended with an error. This is determined by the assertions you make for the load test specifically
- rat: percentage of requests that failed over the course of the test