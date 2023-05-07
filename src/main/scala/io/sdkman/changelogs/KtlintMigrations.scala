package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "079")
class KtlintMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_ktlint_candidate",
    author = "eygraber"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "ktlint",
      name = "ktlint",
      description =
        "Ktlint is an anti-bikeshedding Kotlin linter with built-in formatter.",
      websiteUrl = "https://github.com/pinterest/ktlint"
    ).insert()
}
