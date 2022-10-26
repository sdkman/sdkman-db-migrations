package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "009")
class VisualVmMigrations {
  @ChangeSet(
    order = "016",
    id = "016-add_visualvm_2_1_5",
    author = "eddumelendez"
  )
  def migration(implicit db: MongoDatabase): Unit = {
    Version(
      "visualvm",
      "2.1.5",
      "https://github.com/oracle/visualvm/releases/download/2.1.5/visualvm_215.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
