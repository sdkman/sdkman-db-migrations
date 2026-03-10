package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "032")
class AntMigration {
  @ChangeSet(
    order = "019",
    id = "019-add_ant_1.10.15",
    author = "helpermethod"
  )
  def migration019(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.10.15",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.10.15-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
