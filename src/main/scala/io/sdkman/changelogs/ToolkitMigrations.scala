package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "073")
class ToolkitMigrations {

  val CandidateName = "toolkit"

  @ChangeSet(
    order = "001",
    id = "001-add_toolkit_migrations_candidate",
    author = "sanshengshui"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = CandidateName,
      name = "Toolkit Migrations",
      description =
        "Toolkit is a client command line tool that supports multiple IoT protocols like MQTT and COAP. It provides a command line client tool for IoT development.",
      websiteUrl = "https://github.com/IoT-Technology/IoT-Toolkit"
    ).insert()
  }
}
