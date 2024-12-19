package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "088")
class MicronautMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_jeka_candidate",
    author = "djeang"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = "jeka",
      name = "Jeka",
      description =
        "Jeka is a build tool for Java focusing on simplicity.",
      websiteUrl = "http://jeka.dev"
    ).insert()
  }
}
