package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "003")
class ScalaMigrations {
  @ChangeSet(
    order = "030",
    id = "030_add_scala_3.2.2",
    author = "lwronski"
  )
  def migration030(implicit db: MongoDatabase): Unit =
    Version(
      candidate = "scala",
      version = "3.2.2",
      url =
        "https://github.com/lampepfl/dotty/releases/download/3.2.2/scala3-3.2.2.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
}
