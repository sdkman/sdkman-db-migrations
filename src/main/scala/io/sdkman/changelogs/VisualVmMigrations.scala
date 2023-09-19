package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "009")
class VisualVmMigrations {
  @ChangeSet(
    order = "018",
    id = "018-add_visualvm_2_1_7",
    author = "eddumelendez"
  )
  def migration(implicit db: MongoDatabase): Unit = {
    Version(
      "visualvm",
      "2.1.7",
      "https://github.com/oracle/visualvm/releases/download/2.1.7/visualvm_217.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
