package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "016")
class KobaltMigrations {

  @ChangeSet(order = "001", id = "001_add_kobalt_1_0_122", author = "rvprasad")
  def migration001(implicit db: MongoDatabase) = {
    Version("kobalt", "1.0.122", "https://github.com/cbeust/kobalt/releases/download/1.0.122/kobalt-1.0.122.zip")
      .validate()
      .insert()
      .asCandidateDefault()
  }
}

