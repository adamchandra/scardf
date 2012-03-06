import sbt._
import Keys._

object Build extends sbt.Build {
  import Dependencies._
  
  // lazy val acsCommons = ProjectRef(new java.io.File("../acs-commons-bb-in"), "default-ed5e47")

  lazy val myProject = Project("scardf", file("."))
    .settings(
      organization  := "net.croz.scardf",
      version       := "0.1",
      scalaVersion  := "2.9.1",
      scalacOptions := Seq("-deprecation", "-unchecked", "-encoding", "utf8"),
      resolvers     ++= Dependencies.resolutionRepos,
      libraryDependencies ++= Seq(
        Compile.jena, 
        Compile.arq,    
        Compile.jodatime, 
        Compile.commonslogging,
        Test.specs
      )
    ) 
}

object Dependencies {
  val resolutionRepos = Seq(
    ScalaToolsSnapshots,
    "Typesafe repo" at "http://repo.typesafe.com/typesafe/releases/",
    "spray repo"    at "http://repo.spray.cc/",
    "Apache repo " at "https://repository.apache.org/content/repositories/releases/",
    "IESL rel  repo"    at "http://iesl.cs.umass.edu:8081/nexus/content/repositories/releases/",
    "IESL snap repo"    at "http://iesl.cs.umass.edu:8081/nexus/content/repositories/snapshots/"
  )

  object V {
    val akka      = "1.3"
    val spray     = "0.9.0-RC1"
    val sprayJson = "1.1.0"
    val specs2    = "1.7.1"
    val jetty     = "8.1.0.v20120127"
    val slf4j     = "1.6.4"
    val logback   = "1.0.0"
  }

  object Compile {
    val akkaActor      = "se.scalablesolutions.akka" %  "akka-actor"        % V.akka    % "compile"
    val sprayServer    = "cc.spray"                  %  "spray-server"      % V.spray   % "compile"
    val sprayJson      = "cc.spray"                  %% "spray-json"        % V.sprayJson
    val scalazCore     = "org.scalaz"                %% "scalaz-core"       %  "6.0.4"
    val neo4j          = "org.neo4j"                 %  "neo4j"             %  "1.6"
    val commonsIo      = "commons-io"                %  "commons-io"        %  "2.0.1"
    val jettison       = "org.codehaus.jettison"     %  "jettison"          %  "1.3"
    val jdom           = "org.jdom"                  %  "jdom"              %  "1.1"
    val dispatchHttp   = "net.databinder"            %% "dispatch-http"     %  "0.8.7"
    val dispatchCore   = "net.databinder"            %% "dispatch-core"     %  "0.8.7"
    val boxterBrown    = "cc.acs"                    %% "boxter-brown"      %  "0.1-SNAPSHOT"
    val acsCommons     = "cc.acs"                    %% "acs-commons"       %  "0.1-SNAPSHOT"
    val jena           = "com.hp.hpl.jena"           % "jena"               %  "2.6.4" /* "2.7.0-incubating" "2.6.3" */
    val arq            = "com.hp.hpl.jena"           % "arq"                %  "2.8.8" /* "2.9.0-incubating"  "2.8.7" */
    val jodatime       = "joda-time"                 % "joda-time"          % "1.6"
    val commonslogging = "commons-logging"           % "commons-logging"    % "1.1.1"
  }

  object Test {
    val specs2 = "org.specs2"              %% "specs2"          % V.specs2  % "test"
    val junit  = "junit"                   % "junit"            % "4.7"     % "test"
    val specs  = "org.scala-tools.testing" % "specs_2.8.0"      % "1.6.5"   % "test"
  }

  object Container {
    val jettyWebApp = "org.eclipse.jetty"         %  "jetty-webapp"    % V.jetty   % "container"
    val akkaSlf4j   = "se.scalablesolutions.akka" %  "akka-slf4j"      % V.akka
    val slf4j       = "org.slf4j"                 %  "slf4j-api"       % V.slf4j
    val logback     = "ch.qos.logback"            %  "logback-classic" % V.logback
    val servletApi   = "javax.servlet"            %  "servlet-api"       %  "2.5"    %  "provided"
  }
}
