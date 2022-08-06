package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "073")
class ToolkitMigrations {

  val CandidateName = "toolkit"

  @ChangeSet(
    order = "001",
    id = "001-add_toolkit_migrations_candidate",
    author = "iot-technology"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = CandidateName,
      name = "Toolkit Migrations",
      description =
        "Toolkit is a client command line tool that supports multiple IoT protocols. for example, MQTT and COAP protocols" +
          "Provide a user optimized client tool for IoT developers and learners",
      websiteUrl = "https://github.com/IoT-Technology/IoT-Toolkit"
    ).insert()
  }

}
