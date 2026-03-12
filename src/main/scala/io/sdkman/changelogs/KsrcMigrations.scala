package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "092")
class KsrcMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_ksrc_candidate",
    author = "respawn-app"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "ksrc",
      name = "ksrc",
      description = "Let your AI agents search and read 3rd-party Kotlin dependency sources",
      websiteUrl = "https://github.com/respawn-app/ksrc",
      distribution = "PLATFORM_SPECIFIC"
    ).insert()
}
