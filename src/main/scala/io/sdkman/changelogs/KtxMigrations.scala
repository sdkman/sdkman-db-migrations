package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "075")
class KtxMigrations {
  @ChangeSet(order = "001", id = "001_add_ktx_candidate", author = "mpetuska")
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "ktx",
      name = "ktx",
      description =
        """npx for kotlin and the JVM!
          |Install and execute jars or kotlin scripts just like any other command line utility.""".stripMargin,
      websiteUrl = "https://github.com/mpetuska/ktx"
    ).insert()
}
