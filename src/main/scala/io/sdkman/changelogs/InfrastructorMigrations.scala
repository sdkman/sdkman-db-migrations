package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "010")
class InfrastructorMigrations {

  @ChangeSet(order = "001", id = "001_add_infrastructor_candidate", author = "stanislav.tiurikov")
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "infrastructor",
      name = "Infrastructor",
      description = "Infrastructor is an open source server provisioning tool written in Groovy",
      websiteUrl = "http://infrastructor.io/").insert()
  }

  @ChangeSet(order = "002", id = "002_add_infrastructor_0.1.8", author = "stanislav.tiurikov")
  def migration002(implicit db: MongoDatabase) = {
    Version(
      candidate = "infrastructor",
      version = "0.1.8",
      url = "https://github.com/infrastructor/infrastructor/releases/download/0.1.8/infrastructor-0.1.8.zip")
      .validateUrl()
      .insert()
      .asCandidateDefault()
  }
}

