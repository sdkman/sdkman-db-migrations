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
    order = "002",
    id = "002-add_tomcat_7.0.106",
    author = "larsmoil"
  )
  def migration002(implicit db: MongoDatabase) = {
    Version(
      "tomcat",
      "7.0.106",
      "https://downloads.apache.org/tomcat/tomcat-7/v7.0.106/bin/apache-tomcat-7.0.106.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "003",
    id = "003-add_tomcat_8.5.59",
    author = "larsmoil"
  )
  def migration003(implicit db: MongoDatabase) = {
    Version(
      "tomcat",
      "8.5.59",
      "https://apache.uib.no/tomcat/tomcat-8/v8.5.59/bin/apache-tomcat-8.5.59.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "004",
    id = "004-add_tomcat_9.0.39",
    author = "larsmoil"
  )
  def migration004(implicit db: MongoDatabase) = {
    Version(
      "tomcat",
      "9.0.39",
      "https://apache.uib.no/tomcat/tomcat-9/v9.0.39/bin/apache-tomcat-9.0.39.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(
    order = "005",
    id = "005-add_tomcat_10.0.0-M9",
    author = "larsmoil"
  )
  def migration005(implicit db: MongoDatabase) = {
    Version(
      "tomcat",
      "10.0.0-M9",
      "https://downloads.apache.org/tomcat/tomcat-10/v10.0.0-M9/bin/apache-tomcat-10.0.0-M9.zip"
    ).validate()
      .insert()
  }
}
