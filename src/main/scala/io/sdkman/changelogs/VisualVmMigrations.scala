package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "009")
class VisualVmMigrations {
  @ChangeSet(
    order = "020",
    id = "020-add_visualvm_2_1_9",
    author = "helpermethod"
  )
  def migration020(implicit db: MongoDatabase): Unit = {
    Version(
      "visualvm",
      "2.1.9",
      "https://github.com/oracle/visualvm/releases/download/2.1.9/visualvm_219.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
