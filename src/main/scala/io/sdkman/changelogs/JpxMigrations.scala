package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "096")
class JpxMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_jpx_candidate",
    author = "raphw"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "jpx",
      name = "JPX",
      description = """A Java-native, Java-module-focused application runner.
          |Name a module (or Maven coordinate) and it fetches,
          |caches and runs the implied application. """.stripMargin,
      websiteUrl = "https://jenesis.build",
      distribution = "UNIVERSAL"
    ).insert()
}
