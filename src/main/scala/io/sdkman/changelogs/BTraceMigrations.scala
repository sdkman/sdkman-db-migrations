package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "027")
class BTraceMigrations {

  @ChangeSet(order = "001", id = "001-add_btrace_2_0_1", author = "bachorikj")
  def migration001(implicit db: MongoDatabase) = {
    List(
      Version(
        "btrace",
        "2.0.1",
        "https://github.com/btraceio/btrace/releases/download/v2.0.1/btrace-bin.tar.gz",
        Universal
      ),
      Version(
        "btrace",
        "2.0.1",
        "https://github.com/btraceio/btrace/releases/download/v2.0.1/btrace-bin.zip",
        Windows
      )
    ).validate()
      .insert()

    setCandidateDefault("btrace", "2.0.1")
  }

  @ChangeSet(order = "002", id = "002-add_btrace_1_3_11_3", author = "bachorik")
  def migration002(implicit db: MongoDatabase) = {
    List(
      Version(
        "btrace",
        "1.3.11.3",
        "https://github.com/btraceio/btrace/releases/download/v1.3.11.3/btrace-bin-1.3.11.3.tgz",
        Universal
      ),
      Version(
        "btrace",
        "1.3.11.3",
        "https://github.com/btraceio/btrace/releases/download/v1.3.11.3/btrace-bin-1.3.11.3.zip",
        Windows
      )
    ).validate()
      .insert()
  }
}
