package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "036")
class BallerinaMigrations {

  private val CandidateName = "ballerina"

  @ChangeSet(
    order = "001",
    id = "001_add_ballerina_candidate",
    author = "bassmake"
  )
  def migration001(implicit db: MongoDatabase): Unit = {
    Candidate(
      candidate = CandidateName,
      name = "Ballerina",
      description =
        "Open source programming language and platform for cloud-era application programmers to easily write software that just works.",
      websiteUrl = "https://ballerina.io/"
    ).insert()
  }

  @ChangeSet(
    order = "002",
    id = "002_add_ballerina_swan_lake_p3",
    author = "bassmake"
  )
  def migration002(implicit db: MongoDatabase): Unit = {
    Version(
      CandidateName,
      "swan-lake-p3",
      "https://dist.ballerina.io/downloads/swan-lake-preview3/ballerina-swan-lake-preview3.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

}
