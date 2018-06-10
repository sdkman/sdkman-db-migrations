package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "012")
class BpipeMigrations {

  @ChangeSet(order = "001", id = "001_add_bpipe_0_9_9_5", author = "ssadedin")
  def migration001(implicit db: MongoDatabase) = {
    Candidate(candidate = "bpipe",
      name = "Bpipe",
      description = "Bpipe is a framework for running computational pipelines and workflows",
      default = Some("0.9.9.5"),
      websiteUrl = "http://bpipe.org"
    ).insert()

    Version(
      candidate = "bpipe",
      version = "0.9.9.5",
      url = "http://github.com/ssadedin/bpipe/releases/download/0.9.9.5/bpipe-0.9.9.5.zip"
    ).insert()
  }
}
