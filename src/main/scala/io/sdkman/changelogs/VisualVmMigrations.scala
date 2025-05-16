package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "009")
class VisualVmMigrations {
  @ChangeSet(
    order = "022",
    id = "022-add_visualvm_2_2",
    author = "arixmkii"
  )
  def migration022(implicit db: MongoDatabase): Unit = {
    Version(
      "visualvm",
      "2.2",
      "https://github.com/oracle/visualvm/releases/download/2.2/visualvm_22.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
