package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "071")
class JoernMigrations {

  @ChangeSet(order = "001", id = "001_add_joern_1_1_524", author = "ursachec")
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "io.joern",
      name = "joern-cli",
      description =
        "Joern is a platform for analyzing source code, bytecode, and binary executables. It generates code property graphs (CPGs), a graph representation of code for cross-language code analysis. Code property graphs are stored in a custom graph database. This allows code to be mined using search queries formulated in a Scala-based domain-specific query language. Joern is developed with the goal of providing a useful tool for vulnerability discovery and research in static program analysis.",
      default = Some("1.1.524"),
      websiteUrl = "https://joern.io/"
    ).insert()

    Version(
      candidate = "joern",
      version = "1.1.524",
      url = "https://joern.io/"
    ).insert()
  }
}
