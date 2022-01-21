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

  @ChangeSet(
    order = "028",
    id = "028_add_scala_2.13.8",
    author = "helpermethod"
  )
  def migration028(implicit db: MongoDatabase): Unit =
    Version(
      candidate = "scala",
      version = "2.13.8",
      url = "https://downloads.lightbend.com/scala/2.13.8/scala-2.13.8.zip"
    ).validate()
      .insert()

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
