package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "009")
class VisualVmMigrations {
  @ChangeSet(
    order = "013",
    id = "013-add_visualvm_2_1_2",
    author = "eddumelendez"
  )
  def migration(implicit db: MongoDatabase): Unit = {
    Version(
      "visualvm",
      "2.1.2",
      "https://github.com/oracle/visualvm/releases/download/2.1.2/visualvm_212.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
