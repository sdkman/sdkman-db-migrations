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
        "Taxi is a language for semantically describing data and services.  Taxi allows describing any data format (XML, CSV, JSON etc), and any data service (OpenAPI, Kafka, CSV files).  Taxi goes beyond simple scalar types (Int,String,Date) to support rich semantic types (FirstName, LastName, EmailAddress), which enables smart automated integration tools like Vyne.  The SDK provides command line tooling to create and manage your taxi project. ",
      websiteUrl = "https://taxilang.org",
      distribution = "UNIVERSAL"
    ).insert()
}
