name := "egofunding"

organization  := "org.egooyiry"

version       := "0.1"

scalaVersion  := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies += "junit" % "junit" % "4.10" % "test"

libraryDependencies ++= {
  val akkaV    = "2.1.4"
  val sprayV   = "1.2.0"
  val logbackV = "1.0.13"
  val specs2V  = "2.2.3"
  Seq(
    "io.spray"            %   "spray-can"        % sprayV,
    "io.spray"            %   "spray-routing"    % sprayV,
    "io.spray"            %   "spray-caching"    % sprayV,
    "io.spray"            %   "spray-testkit"    % sprayV,
    "com.typesafe.akka"   %%  "akka-actor"       % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"     % akkaV,
    "com.typesafe.akka"   %%  "akka-slf4j"       % akkaV,
    "ch.qos.logback"      %   "logback-classic"  % logbackV,
    "org.specs2"          %%  "specs2"           % specs2V       % "test"
  )
}

seq(Revolver.settings: _*)
