# telecom-demo
For demo purpose
spring boot application that exposes and api that has gzip compression - Added configuration in application.preoperties
 On the get of api …..  read a URL from property file and return the value of GET of that url. - http://localhost:8080/getURL
 Implemented Basic auth to the api that takes admin/admin as username/password.
 
 curl statement for testing the api is 
 curl -i --user admin:password http://localhost:8080/getURL
