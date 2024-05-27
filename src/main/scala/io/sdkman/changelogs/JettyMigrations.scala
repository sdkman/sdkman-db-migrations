package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "086")
class JettyMigrations {
  @ChangeSet(
    order = "001",
    id = "001-add_jetty_candidate",
    author = "olamy"
  )
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "jetty",
      name = "Eclipse Jetty",
      description =
        "Eclipse Jetty provides a highly scalable and memory-efficient web server and servlet container, supporting many protocols such as HTTP/3,2,1 and WebSocket",
      websiteUrl = "https://jetty.org/"
    ).insert()

  }

  @ChangeSet(
    order = "002",
    id = "002-add_jetty_10.0.21",
    author = "olamy"
  )
  def migration002(implicit db: MongoDatabase) = {
    Version(
      "jetty",
      "10.0.21",
      "https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-home/10.0.21/jetty-home-10.0.21.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "003",
    id = "003-add_jetty_11.0.21",
    author = "olamy"
  )
  def migration003(implicit db: MongoDatabase) = {
    Version(
      "jetty",
      "11.0.21",
      "https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-home/11.0.21/jetty-home-11.0.21.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "004",
    id = "004-add_jetty_12.0.9",
    author = "olamy"
  )
  def migration004(implicit db: MongoDatabase) = {
    Version(
      "jetty",
      "12.0.9",
      "https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-home/12.0.9/jetty-home-12.0.9.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
