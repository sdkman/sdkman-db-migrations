package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "009")
class VisualVmMigrations {
  @ChangeSet(
    order = "014",
    id = "014-add_visualvm_2_1_3",
    author = "eddumelendez"
  )
  def migration(implicit db: MongoDatabase): Unit = {
    Version(
      "visualvm",
      "2.1.3",
      "https://github.com/oracle/visualvm/releases/download/2.1.3/visualvm_213.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
