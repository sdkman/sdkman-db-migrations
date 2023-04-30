package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "069")
class TaxiMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_taxi_candidate",
    author = "martypitt"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "taxi",
      name = "Taxi",
      description =
        "Taxi is a language for documenting data - such as data models - and the contracts of APIs. It describes " +
          "data semantically, allowing powerful tooling to discover and map data based on it's meaning, rather " +
          "than the name of a field.",
      websiteUrl = "https://taxilang.org"
    ).insert()
}
