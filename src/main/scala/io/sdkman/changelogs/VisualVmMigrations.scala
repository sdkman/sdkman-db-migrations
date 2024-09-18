package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "009")
class VisualVmMigrations {
  @ChangeSet(
    order = "021",
    id = "021-add_visualvm_2_1_10",
    author = "linghengqian"
  )
  def migration021(implicit db: MongoDatabase): Unit = {
    Version(
      "visualvm",
      "2.1.10",
      "https://github.com/oracle/visualvm/releases/download/2.1.10/visualvm_2110.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
