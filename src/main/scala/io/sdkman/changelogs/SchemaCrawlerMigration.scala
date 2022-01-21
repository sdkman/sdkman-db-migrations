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
        "SchemaCrawler is a free database schema discovery and comprehension tool",
      websiteUrl = "https://www.schemacrawler.com"
    ).insert()
  }
}
