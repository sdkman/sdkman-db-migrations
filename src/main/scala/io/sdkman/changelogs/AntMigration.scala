package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "032")
class AntMigration {
  @ChangeSet(
    order = "001",
    id = "001-add_ant_1.9.10",
    author = "andrebrait"
  )
  def migration001(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.9.10",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.9.10-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "002",
    id = "002-add_ant_1.9.11",
    author = "andrebrait"
  )
  def migration002(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.9.11",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.9.11-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "003",
    id = "003-add_ant_1.9.12",
    author = "andrebrait"
  )
  def migration003(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.9.12",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.9.12-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "004",
    id = "004-add_ant_1.9.13",
    author = "andrebrait"
  )
  def migration004(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.9.13",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.9.13-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "005",
    id = "005-add_ant_1.9.14",
    author = "andrebrait"
  )
  def migration005(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.9.14",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.9.14-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "006",
    id = "006-add_ant_1.9.15",
    author = "andrebrait"
  )
  def migration006(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.9.15",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.9.15-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "007",
    id = "007-add_ant_1.10.2",
    author = "andrebrait"
  )
  def migration007(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.10.2",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.10.2-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "008",
    id = "008-add_ant_1.10.3",
    author = "andrebrait"
  )
  def migration008(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.10.3",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.10.3-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "009",
    id = "009-add_ant_1.10.4",
    author = "andrebrait"
  )
  def migration009(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.10.4",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.10.4-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "010",
    id = "010-add_ant_1.10.5",
    author = "andrebrait"
  )
  def migration010(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.10.5",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.10.5-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "011",
    id = "011-add_ant_1.10.6",
    author = "andrebrait"
  )
  def migration011(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.10.6",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.10.6-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "012",
    id = "012-add_ant_1.10.7",
    author = "andrebrait"
  )
  def migration012(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.10.7",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.10.7-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "013",
    id = "013-add_ant_1.10.8",
    author = "andrebrait"
  )
  def migration013(implicit db: MongoDatabase): Unit = {
    Version(
      "ant",
      "1.10.8",
      "https://archive.apache.org/dist/ant/binaries/apache-ant-1.10.8-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

}
