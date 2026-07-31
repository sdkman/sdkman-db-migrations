package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "096")
class DmigrateMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_dmigrate",
    author = "pt9912"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = "dmigrate",
      name = "d-migrate",
      description =
        "d-migrate is a database-agnostic tool for schema migration and data management, usable as a CLI and as an MCP server. You define a schema once in a neutral YAML format and then validate, compare, generate DDL, and run live diff-based migrations against PostgreSQL, MySQL, and SQLite. It also covers reverse engineering of existing databases, streaming data export/import/transfer between databases, and export to existing migration toolchains such as Flyway, Liquibase, Django, and Knex.",
      websiteUrl = "https://github.com/pt9912/d-migrate",
      distribution = "UNIVERSAL"
    ).insert()
  }
}
