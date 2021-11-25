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
      "7"  -> "7.0.109",
      "8"  -> "8.5.73",
      "9"  -> "9.0.55",
      "10" -> "10.0.13"
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
    setCandidateDefault("tomcat", "10.0.13")
  }
}
