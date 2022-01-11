package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "065")
class KiMigrations {
  @ChangeSet(order = "001", id = "001-add_ki_candidate", author = "asm0dey")
  def migrate001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "ki",
      name = "ki",
      description =
        "The shell is an extensible implementation of Kotlin REPL with reach set of features",
      websiteUrl = "https://github.com/Kotlin/kotlin-interactive-shell"
    ).insert()
  }
}
