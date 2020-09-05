package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Mandrel, Linux64, Version}

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
}
