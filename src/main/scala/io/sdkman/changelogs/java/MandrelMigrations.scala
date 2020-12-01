package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Linux64, Mandrel, Version}

@ChangeLog(order = "035")
class MandrelMigrations {

  @ChangeSet(
    order = "001",
    id = "001-add_mandrel_20_1_0_1",
    author = "AlexKovynev"
  )
  def migrate001(implicit db: MongoDatabase): Unit =
    List(
      Version(
        candidate = "java",
        version = "20.1.0.1-mandrel",
        url =
          "https://github.com/graalvm/mandrel/releases/download/mandrel-20.1.0.1.Final/mandrel-java11-linux-amd64-20.1.0.1.Final.tar.gz",
        platform = Linux64,
        vendor = Some(Mandrel)
      )
    ).validate()
      .insert()

  @ChangeSet(
    order = "002",
    id = "002-add_mandrel_20_2_0_0",
    author = "poad"
  )
  def migrate002(implicit db: MongoDatabase): Unit =
    List(
      Version(
        candidate = "java",
        version = "20.2.0.0-mandrel",
        url =
          "https://github.com/graalvm/mandrel/releases/download/mandrel-20.2.0.0.Final/mandrel-java11-linux-amd64-20.2.0.0.Final.tar.gz",
        platform = Linux64,
        vendor = Some(Mandrel)
      )
    ).validate()
      .insert()

  @ChangeSet(
    order = "003",
    id = "003-add_mandrel_20_1_0_3",
    author = "zakkak"
  )
  def migrate003(implicit db: MongoDatabase): Unit =
    List(
      Version(
        candidate = "java",
        version = "20.1.0.3-mandrel",
        url =
          "https://github.com/graalvm/mandrel/releases/download/mandrel-20.1.0.3.Final/mandrel-java11-linux-amd64-20.1.0.3.Final.tar.gz",
        platform = Linux64,
        vendor = Some(Mandrel)
      )
    ).validate()
      .insert()
}
