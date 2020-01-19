package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "011")
class InfrastructorMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_infrastructor_candidate",
    author = "tiurikov"
  )
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "infrastructor",
      name = "Infrastructor",
      description =
        "Infrastructor is an open source server provisioning tool written in Groovy",
      websiteUrl = "http://infrastructor.io/"
    ).insert()
  }
}
