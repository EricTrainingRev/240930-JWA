# API Testing
API testing is simply validating that users are sending data and receiving data correctly. Typically this is done via HTTP protocol, so when doing API testing on your HTTP requests you are typically looking for the following:
- Requests
    - Method types
    - POST requests should not be used for solely retrieving information
    - Request Headers
    - URL is correct
    - request body is correct
- Responses
    - response body is correct
    - response headers
    - response status code
        - 200s status codes for successful actions
        - 400s status codes for user error
        - 500s status codes NOT present
            - 500 status codes happen when the server does not know how to handle a request/an exception is thrown in the server, you never want 500 status codes