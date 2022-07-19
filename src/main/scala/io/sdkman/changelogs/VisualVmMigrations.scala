package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "009")
class VisualVmMigrations {
  @ChangeSet(
    order = "015",
    id = "015-add_visualvm_2_1_4",
    author = "eddumelendez"
  )
  def migration(implicit db: MongoDatabase): Unit = {
    Version(
      "visualvm",
      "2.1.4",
      "https://github.com/oracle/visualvm/releases/download/2.1.4/visualvm_214.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
