package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "009")
class VisualVmMigrations {
  @ChangeSet(
    order = "017",
    id = "017-add_visualvm_2_1_6",
    author = "eddumelendez"
  )
  def migration(implicit db: MongoDatabase): Unit = {
    Version(
      "visualvm",
      "2.1.6",
      "https://github.com/oracle/visualvm/releases/download/2.1.6/visualvm_216.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
