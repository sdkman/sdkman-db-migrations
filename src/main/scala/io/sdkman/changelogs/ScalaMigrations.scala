package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "003")
class ScalaMigrations {
  @ChangeSet(
    order = "027",
    id = "027_add_scala_2.13.7",
    author = "helpermethod"
  )
  def migration027(implicit db: MongoDatabase): Unit =
    Version(
      candidate = "scala",
      version = "2.13.7",
      url = "https://downloads.lightbend.com/scala/2.13.7/scala-2.13.7.zip"
    ).validate()
      .insert()
}
