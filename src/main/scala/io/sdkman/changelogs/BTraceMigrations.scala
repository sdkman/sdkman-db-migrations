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
        "BTrace is a safe, dynamic tracing tool for the Java platform. BTrace can be used to dynamically trace a " +
          "running Java program (similar to DTrace for OpenSolaris applications and OS). BTrace dynamically " +
          "instruments the classes of the target application to inject bytecode tracing code.",
      websiteUrl = "https://github.com/btraceio/btrace"
    ).insert()
  }
}
