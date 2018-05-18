package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "009")
class MicronautMigrations {

  @ChangeSet(order = "001", id = "001_add_micronaut_1_0_0_M1", author = "jameskleeh")
  def migration001(implicit db: MongoDatabase) = {
    insertCandidate(
      Candidate(
        candidate = "micronaut",
        name = "Micronaut",
        description = "Micronaut is an open source microservice framework for the JVM",
        default = "1.0.0.M1",
        websiteUrl = "http://micronaut.io/",
        distribution = "UNIVERSAL"))
  }
}
