package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "003")
class ScalaMigrations {
  @ChangeSet(
    order = "029",
    id = "029_add_scala_3.1.1",
    author = "helpermethod"
  )
  def migration029(implicit db: MongoDatabase): Unit =
    Version(
      candidate = "scala",
      version = "3.1.1",
      url =
        "https://github.com/lampepfl/dotty/releases/download/3.1.1/scala3-3.1.1.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
}
