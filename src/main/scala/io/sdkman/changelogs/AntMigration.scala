package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "032")
class AntMigration {
  @ChangeSet(
    order = "015",
    id = "015-add_ant_1.10.10",
    author = "iemejia"
  )
  def migration015(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.10.10",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.10.10-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
