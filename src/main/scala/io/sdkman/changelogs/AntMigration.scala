package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "032")
class AntMigration {
  @ChangeSet(
    order = "016",
    id = "016-add_ant_1.10.11",
    author = "aalmiray"
  )
  def migration016(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.10.11",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.10.11-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(
    order = "017",
    id = "017-add_ant_1.10.12",
    author = "aalmiray"
  )
  def migration017(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.10.12",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.10.12-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
