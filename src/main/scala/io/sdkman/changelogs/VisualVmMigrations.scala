package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "009")
class VisualVmMigrations {
  @ChangeSet(
    order = "023",
    id = "023-add_visualvm_2_2_1",
    author = "vpavic"
  )
  def migration023(implicit db: MongoDatabase): Unit = {
    Version(
      "visualvm",
      "2.2.1",
      "https://github.com/oracle/visualvm/releases/download/2.2.1/visualvm_221.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
