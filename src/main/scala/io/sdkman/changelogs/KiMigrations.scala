package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "066")
class KiMigrations {
  @ChangeSet(order = "001", id = "001-add_ki_candidate", author = "asm0dey")
  def migrate001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "ki",
      name = "ki",
      description =
        "An extensible implementation of the Kotlin REPL with a rich set of features including autocomplete, syntax highlighting, type inference and maven dependencies.",
      websiteUrl = "https://github.com/Kotlin/kotlin-interactive-shell"
    ).insert()
  }
}
