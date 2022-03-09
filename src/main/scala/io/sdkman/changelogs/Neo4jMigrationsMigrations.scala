package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "072")
class Neo4jMigrationsMigrations {

  val candidate = "neo4jmigrations"

  @ChangeSet(
    order = "001",
    id = "001_add_neo4j-migrations_candidate",
    author = "michael-simons"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = candidate,
      name = "Neo4j-Migrations",
      description =
        "Neo4j-Migrations is a database migration and refactoring tool that allows running Cypher scripts and programmatic refactorings in a controlled and repeatable fashion against one or more Neo4j database.",
      websiteUrl = "https://neo4j.com/labs/neo4j-migrations/"
    ).insert()
}
