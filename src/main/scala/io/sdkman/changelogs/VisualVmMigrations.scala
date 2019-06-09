package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "009")
class VisualVmMigrations {

  @ChangeSet(order = "001", id = "001-add_visualvm_1_4_1", author = "vpavic")
  def migration001(implicit db: MongoDatabase) = {
    Version("visualvm", "1.4.1", "https://github.com/visualvm/visualvm.src/releases/download/1.4.1/visualvm_141.zip")
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(order = "002", id = "002-add_visualvm_1_4_2", author = "vpavic")
  def migration002(implicit db: MongoDatabase) = {
    Version("visualvm", "1.4.2", "https://github.com/visualvm/visualvm.src/releases/download/1.4.2/visualvm_142.zip")
      .validate().insert().asCandidateDefault()
  }

  @ChangeSet(order = "003", id = "003-add_visualvm_1_4_3", author = "jorsol")
  def migration003(implicit db: MongoDatabase) = {
    Version("visualvm", "1.4.3", "https://github.com/visualvm/visualvm.src/releases/download/1.4.3/visualvm_143.zip")
      .validate().insert().asCandidateDefault()
  }

}
