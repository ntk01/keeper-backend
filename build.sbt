import sbt._

name := "keeper-backend"
version := "0.1"
scalaVersion := "2.13.7"

val AkkaVersion = "2.6.18"
val AkkaHttpVersion = "10.2.7"
val Slf4jNopVersion = "1.7.32"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "org.slf4j" % "slf4j-nop" % Slf4jNopVersion
)
