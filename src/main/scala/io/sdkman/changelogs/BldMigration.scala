package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "078")
class BldMigration {
  @ChangeSet(
    order = "001",
    id = "001-add_bld_candidate",
    author = "gbevin"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "bld",
      name = "Bld",
      description =
        "bld is a build system that allows you to write your build logic in pure Java. bld was created because we're not really interested in build tools. We use them because we have to, but we'd rather just get on with coding the real stuff.",
      websiteUrl = "https://rife2.com/bld",
      distribution = "UNIVERSAL"
    ).insert()
}
