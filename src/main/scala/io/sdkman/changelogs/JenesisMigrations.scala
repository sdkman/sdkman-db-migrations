package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "094")
class JenesisMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_jenesis_candidate",
    author = "raphw"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "jenesis",
      name = "Jenesis",
      description = """A Java-native, Java-module-focused build tool.
          |Builds are incremental and cache-friendly,
          |configured in plain Java.""".stripMargin,
      websiteUrl = "https://jenesis.build",
      distribution = "UNIVERSAL"
    ).insert()
}
