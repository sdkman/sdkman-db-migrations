package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "096")
class JarCartMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_jarcart_candidate",
    author = "Sudhanshu-Ambastha"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "jarcart",
      name = "jarcart",
      description =
        "An instant, no-build dependency manager and CLI task runner designed to bring pnpm-style simplicity, lockfile security, and lightweight scripting to Java projects.",
      websiteUrl = "https://github.com/Sudhanshu-Ambastha/jar-cart",
      distribution = "PLATFORM_SPECIFIC"
    ).insert()
}
