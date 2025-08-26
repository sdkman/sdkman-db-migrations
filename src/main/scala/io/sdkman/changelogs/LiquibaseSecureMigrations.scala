package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "090")
class LiquibaseMigrations {
  @ChangeSet(order = "001", id = "001_add_liquibase_secure", author = "jandroav")
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "liquibase-secure",
      name = "Liquibase Secure",
      description =
        "Liquibase Secure is a database-independent library for tracking, managing and applying database schema changes.",
      websiteUrl = "https://liquibase.com/",
      distribution = "UNIVERSAL"
    ).insert()
  }
}
