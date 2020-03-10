package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "012")
class BpipeMigrations {

  @ChangeSet(order = "001", id = "001_add_bpipe_0_9_9_5", author = "ssadedin")
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "bpipe",
      name = "Bpipe",
      description =
        "Bpipe is a framework for running computational pipelines and workflows",
      websiteUrl = "http://bpipe.org"
    ).insert()
  }
}
