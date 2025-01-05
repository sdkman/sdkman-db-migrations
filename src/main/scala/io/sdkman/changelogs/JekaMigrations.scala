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
      name = "JeKa",
      description =
        "JeKa is a modern build tool for Java, designed to simplify and streamline your development experience. It reshapes Java application building for a generation of developers seeking lightweight, accessible, yet powerful solutions."
      websiteUrl = "https://jeka.dev"
    ).insert()
  }
}
