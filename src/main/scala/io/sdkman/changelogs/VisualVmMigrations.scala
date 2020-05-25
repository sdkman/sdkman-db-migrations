package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "009")
class VisualVmMigrations {

  @ChangeSet(order = "001", id = "001-add_visualvm_1_4_1", author = "vpavic")
  def migration001(implicit db: MongoDatabase) = {
    Version(
      "visualvm",
      "1.4.1",
      "https://github.com/visualvm/visualvm.src/releases/download/1.4.1/visualvm_141.zip"
    ).insert()
      .asCandidateDefault()
  }

  @ChangeSet(order = "002", id = "002-add_visualvm_1_4_2", author = "vpavic")
  def migration002(implicit db: MongoDatabase) = {
    Version(
      "visualvm",
      "1.4.2",
      "https://github.com/visualvm/visualvm.src/releases/download/1.4.2/visualvm_142.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(order = "003", id = "003-add_visualvm_1_4_3", author = "jorsol")
  def migration003(implicit db: MongoDatabase) = {
    Version(
      "visualvm",
      "1.4.3",
      "https://github.com/visualvm/visualvm.src/releases/download/1.4.3/visualvm_143.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(order = "004", id = "004-add_visualvm_1_4_4", author = "Markitox")
  def migration004(implicit db: MongoDatabase) = {
    Version(
      "visualvm",
      "1.4.4",
      "https://github.com/oracle/visualvm/releases/download/1.4.4/visualvm_144.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(order = "005", id = "005-add_visualvm_2_0", author = "ramonPires")
  def migration005(implicit db: MongoDatabase) = {
    Version(
      "visualvm",
      "2.0",
      "https://github.com/oracle/visualvm/releases/download/2.0/visualvm_20.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(
    order = "006",
    id = "006-add_visualvm_2_0_2",
    author = "eddumelendez"
  )
  def migration006(implicit db: MongoDatabase) = {
    Version(
      "visualvm",
      "2.0.2",
      "https://github.com/oracle/visualvm/releases/download/2.0.2/visualvm_202.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

}
