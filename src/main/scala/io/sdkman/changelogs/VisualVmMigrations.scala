package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "009")
class VisualVmMigrations {
  @ChangeSet(
    order = "012",
    id = "012-add_visualvm_2_1_1",
    author = "eddumelendez"
  )
  def migration012(implicit db: MongoDatabase): Unit = {
    Version(
      "visualvm",
      "2.1.1",
      "https://github.com/oracle/visualvm/releases/download/2.1.1/visualvm_211.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
