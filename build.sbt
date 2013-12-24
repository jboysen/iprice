name := "iprice.jboysen.dk"

version := "1.0"

scalaVersion := "2.10.3"

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "org.sorm-framework" % "sorm" % "0.3.11",
  "mysql" % "mysql-connector-java" % "5.1.27",
  "io.spray" % "spray-http" % "1.2.0",
  "com.typesafe.akka" %% "akka-actor" % "2.2.3",
  "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
)

