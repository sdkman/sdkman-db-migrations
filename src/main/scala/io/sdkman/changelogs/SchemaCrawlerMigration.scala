package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "071")
class SchemaCrawlerMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_schemacrawler",
    author = "sualeh"
  )
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "schemacrawler",
      name = "SchemaCrawler",
      description =
        "SchemaCrawler is a free database schema discovery and comprehension tool. SchemaCrawler " +
        "has a good mix of useful features for data governance. You can search for database " +
        "schema objects using regular expressions, and output the schema and data in a readable " +
        "text format. The output serves for database documentation, and is designed to be " +
        "diff-ed against other database schemas. SchemaCrawler also generates schema diagrams. " +
        "You can execute scripts in any standard scripting language against your database. You " +
        "can find potential schema design issues with lint.",
      websiteUrl = "https://www.schemacrawler.com"
    ).insert()
  }
}
