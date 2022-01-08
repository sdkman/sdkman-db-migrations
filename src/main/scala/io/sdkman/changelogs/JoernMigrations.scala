package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "066")
class JoernMigrations {

  @ChangeSet(order = "001", id = "001_add_joern_1_1_428", author = "ursachec")
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "joern",
      name = "Joern",
      description =
        "Joern is a platform for analyzing source code, bytecode, and binary executables. It generates code property graphs (CPGs), a graph representation of code for cross-language code analysis. Code property graphs are stored in a custom graph database. This allows code to be mined using search queries formulated in a Scala-based domain-specific query language. Joern is developed with the goal of providing a useful tool for vulnerability discovery and research in static program analysis.",
      default = Some("1.1.428"),
      websiteUrl = "http://joern.io"
    ).insert()

    Version(
        candidate = "joern",
        version = "1.1.428",
        url = "https://github.com/joernio/joern/releases/download/v1.1.428/joern-cli.zip"
      ).insert()
  }
}
