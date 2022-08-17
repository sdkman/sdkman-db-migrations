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
    id = "002-add_toolkit_0_4_5",
    author = "sanshengshui"
  )
  def migration002(implicit db: MongoDatabase) = {
    List(
      Version(
        "toolkit",
        "0.4.5",
        "https://github.com/IoT-Technology/IoT-Toolkit/releases/download/0.4.5/toolkit-0.4.5-osx-x86_64.zip",
        MacOSX
      ),
      Version(
        "toolkit",
        "0.4.5",
        "https://github.com/IoT-Technology/IoT-Toolkit/releases/download/0.4.5/toolkit-0.4.5-linux-x86_64.zip",
        Linux64
      ),
      Version(
        "toolkit",
        "0.4.5",
        "https://github.com/IoT-Technology/IoT-Toolkit/releases/download/0.4.5/toolkit-0.4.5-windows-x86_64.zip",
        Windows
      )
    ).validate().insert()
    setCandidateDefault("toolkit", "0.4.5")
  }

}
