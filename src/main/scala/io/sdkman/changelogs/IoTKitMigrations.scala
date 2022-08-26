package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
@ChangeLog(order = "074")
class IoTKitMigrations {

  val CandidateName = "iotkit"

  @ChangeSet(
    order = "001",
    id = "001-add_iotkit_migrations_candidate",
    author = "sanshengshui"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = CandidateName,
      name = "IoTKit Migrations",
      description =
        "Toolkit is a client command line tool that supports multiple IoT protocols (or IoTKit Migrations for short). for example, MQTT and COAP protocols" +
          "Provide a user optimized client tool for IoT developers and learners",
      websiteUrl = "https://github.com/IoT-Technology/IoT-Toolkit"
    ).insert()
  }

  @ChangeSet(
    order = "002",
    id = "002-add_iotkit_0_4_5",
    author = "sanshengshui"
  )
  def migration002(implicit db: MongoDatabase) = {
    List(
      Version(
        "iotkit",
        "0.4.5",
        "https://github.com/IoT-Technology/IoT-Toolkit/releases/download/0.4.5/toolkit-0.4.5-osx-x86_64.zip",
        MacOSX
      ),
      Version(
        "iotkit",
        "0.4.5",
        "https://github.com/IoT-Technology/IoT-Toolkit/releases/download/0.4.5/toolkit-0.4.5-linux-x86_64.zip",
        Linux64
      ),
      Version(
        "iotkit",
        "0.4.5",
        "https://github.com/IoT-Technology/IoT-Toolkit/releases/download/0.4.5/toolkit-0.4.5-windows-x86_64.zip",
        Windows
      )
    ).validate().insert()
    setCandidateDefault("iotkit", "0.4.5")
  }

}
