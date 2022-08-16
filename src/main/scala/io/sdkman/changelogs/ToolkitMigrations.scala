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
        "Toolkit is a client command line tool that supports multiple IoT protocols. for example, MQTT and COAP protocols" +
          "Provide a user optimized client tool for IoT developers and learners",
      websiteUrl = "https://github.com/IoT-Technology/IoT-Toolkit"
    ).insert()
  }

  @ChangeSet(
    order = "002",
    id = "002-add_toolkit_0.4.0_as_default",
    author = "iot-technology"
  )
  def migration002(implicit db: MongoDatabase) =
    Map(
      MacOSX  -> "toolkit-0.4.0-osx-x86_64.zip",
      Linux64 -> "toolkit-0.4.0-linux-x86_64.zip",
      Windows -> "toolkit-0.4.0-windows-x86_64.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "toolkit",
            "0.4.0",
            s"https://github.com/IoT-Technology/IoT-Toolkit/releases/download/0.4.0/$binary",
            platform
          )
      }
      .toList
      .validate()
      .insert()
      .asCandidateDefault()

}
