package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "010")
class MicronautMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_micronaut_candidate",
    author = "jameskleeh"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = "micronaut",
      name = "Micronaut",
      description =
        "Micronaut is an open source microservice framework for the JVM",
      websiteUrl = "http://micronaut.io/"
    ).insert()
  }
}
