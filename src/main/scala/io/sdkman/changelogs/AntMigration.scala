package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "032")
class AntMigration {
  @ChangeSet(
    order = "020",
    id = "020-add_ant_1.10.16",
    author = "theit"
  )
  def migration020(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.10.16",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.10.16-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(
    order = "021",
    id = "021-add_ant_1.10.17",
    author = "theit"
  )
  def migration021(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.10.17",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.10.17-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
