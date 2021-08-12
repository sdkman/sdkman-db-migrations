package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "061")
class ConnorMigration {
  @ChangeSet(
    order = "001",
    id = "001_add_connor_candidate",
    author = "helpermethod"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "connor",
      name = "Connor",
      description =
        "Connor (short for: ConnectOffsetReset) is a commandline tool for resetting Kafka Connect source connector offsets.",
      websiteUrl = "https://github.com/helpermethod/connor"
    ).insert()
}
