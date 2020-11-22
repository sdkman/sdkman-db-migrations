package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "038")
class TomcatMigration {
  @ChangeSet(
    order = "001",
    id = "001-add_tomcat_candidate",
    author = "larsmoil"
  )
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "tomcat",
      name = "Apache Tomcat",
      description =
        "The Apache Tomcat® software is an open source implementation of the Java Servlet, JavaServer Pages, Java Expression Language and Java WebSocket technologies.",
      websiteUrl = "https://tomcat.apache.org/"
    ).insert()

  }

  @ChangeSet(
    order = "007",
    id = "007-add_correct_tomcat_urls",
    author = "marc0der"
  )
  def migration007(implicit db: MongoDatabase) = {
    removeAllVersions("tomcat")
    List(
      "7"  -> "7.0.106",
      "8"  -> "8.5.60",
      "9"  -> "9.0.40",
      "10" -> "10.0.0-M10"
    ).map {
        case (series: String, version: String) =>
          Version(
            candidate = "tomcat",
            version = version,
            url =
              s"https://archive.apache.org/dist/tomcat/tomcat-$series/v$version/bin/apache-tomcat-$version.zip"
          )
      }
      .validate()
      .insert()
    setCandidateDefault("tomcat", "9.0.40")
  }

  @ChangeSet(
    order = "007",
    id = "007-add_tomcat_8.5.60",
    author = "eddumelendez"
  )
  def migration008(implicit db: MongoDatabase) = {
    Version(
      "tomcat",
      "8.5.60",
      "https://downloads.apache.org/tomcat/tomcat-8/v8.5.60/bin/apache-tomcat-8.5.60.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "008",
    id = "008-add_tomcat_9.0.40",
    author = "eddumelendez"
  )
  def migration009(implicit db: MongoDatabase) = {
    Version(
      "tomcat",
      "9.0.40",
      "https://downloads.apache.org/tomcat/tomcat-9/v9.0.40/bin/apache-tomcat-9.0.40.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

}
