package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "032")
class AntMigration {
  @ChangeSet(
    order = "018",
    id = "018-add_ant_1.10.13",
    author = "aalmiray"
  )
  def migration017(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.10.13",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.10.13-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
