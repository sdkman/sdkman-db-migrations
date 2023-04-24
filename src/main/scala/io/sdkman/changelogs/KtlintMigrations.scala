package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "079")
class KtlintMigrations {
  @ChangeSet(order = "001", id = "001_add_ktlint_candidate", author = "paul-dingemans")
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "ktlint",
      name = "ktlint",
      description = "An anti-bikeshedding Kotlin linter with built-in formatter",
      websiteUrl = "https://github.com/pinterest/ktlint"
    ).insert()
}
