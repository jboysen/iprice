name := "iprice.jboysen.dk"

version := "1.0"

scalaVersion := "2.10.3"

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  //"org.sorm-framework" % "sorm" % "0.3.11",
  //"mysql" % "mysql-connector-java" % "5.1.27",
  "org.mongodb" %% "casbah" % "2.6.3",
  "io.spray" % "spray-http" % "1.2.0",
  "com.typesafe.akka" %% "akka-actor" % "2.2.3",
  "org.scalatest" % "scalatest_2.10" % "2.0" % "test",
  "org.json4s" %% "json4s-native" % "3.2.6",
  "com.typesafe" %% "scalalogging-log4j" % "1.0.1",
  "org.apache.logging.log4j" % "log4j-core" % "2.0-beta9"
)

