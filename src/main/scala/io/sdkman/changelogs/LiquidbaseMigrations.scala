package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "040")
class LiquidbaseMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_liquidbase_candidate",
    author = "rfigueroa"
  )
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "liquidbase",
      name = "Liquidbase",
      description =
        "Liquibase helps millions of teams track, version, and deploy database schema changes.",
      websiteUrl = "https://www.liquibase.org/"
    ).insert()

    Version(
      candidate = "liquidbase",
      version = "3.10.3",
      url =
        "https://github.com/liquibase/liquibase/releases/download/v3.10.3/liquibase-3.10.3.tar.gz"
    ).validate()
      .insert()

    Version(
      candidate = "liquidbase",
      version = "4.1.1",
      url =
        "https://github.com/liquibase/liquibase/releases/download/v4.1.1/liquibase-4.1.1.tar.gz"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

}
