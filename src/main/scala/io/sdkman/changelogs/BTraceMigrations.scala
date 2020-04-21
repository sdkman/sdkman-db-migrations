package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "027")
class BTraceMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_btrace_candidate",
    author = "bachorikj"
  )
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "btrace",
      name = "BTrace",
      description =
        "BTrace - a safe, dynamic tracing tool for the Java platform",
      websiteUrl = "https://github.com/btraceio/btrace"
    ).insert()
  }
}
