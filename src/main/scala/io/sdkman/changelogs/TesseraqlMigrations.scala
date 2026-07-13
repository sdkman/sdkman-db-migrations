package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "096")
class TesseraqlMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_tesseraql_candidate",
    author = "n-ichimura"
  )
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "tesseraql",
      name = "TesseraQL",
      description =
        "TesseraQL is a SQL-first framework for hypermedia business applications: YAML routes, 2-way SQL files, and server-rendered HTML on Apache Camel.",
      websiteUrl = "https://ingcreators.com/tesseraql",
      distribution = "UNIVERSAL"
    ).insert()
  }
}
