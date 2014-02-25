iPrice
=======
This project consists of a fetcher, parser and data-cruncher that in combination can be used to retrieve prices of used
iPhones from DBA and calculating the current average prices.

## Configuration
To get this up and running, you need a MongoDB server and an API key to DBA's API (retrieve this by e.g. eavesdrop
the traffic from and to the DBA app on the iPhone, see [this link](http://www.tuaw.com/2011/02/21/how-to-inspect-ioss-http-traffic-without-spending-a-dime/)).
Rename the file [`src/main/resources/application.default.conf`](src/main/resources/application.default.conf) and set the parameters to their appropriate values.

### MongoDB

Database tests can only succeed if there exists a MongoDB database called `test-database` with the user `test-user` and
password `password` - alternatively the test-database credentials can be changed in the file [`src/test/resources/application.conf`](src/test/resources/application.conf).

## Dependencies

* JSON parsing: http://json4s.org/
* Testing: http://www.scalatest.org/
* http://spray.io/
* ORM: http://sorm-framework.org/
* Logging: https://github.com/typesafehub/scalalogging