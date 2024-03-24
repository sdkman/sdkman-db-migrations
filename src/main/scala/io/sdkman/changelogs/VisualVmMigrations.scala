package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "009")
class VisualVmMigrations {
  @ChangeSet(
    order = "019",
    id = "019-add_visualvm_2_1_8",
    author = "eddumelendez"
  )
  def migration(implicit db: MongoDatabase): Unit = {
    Version(
      "visualvm",
      "2.1.8",
      "https://github.com/oracle/visualvm/releases/download/2.1.8/visualvm_218.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
