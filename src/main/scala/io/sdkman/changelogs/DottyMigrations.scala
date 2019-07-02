package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "016")
class DottyMigrations {

  @ChangeSet(order = "001", id = "001-add_dotty_0_13_0-RC1_to_0_16_0-RC2", author = "Miuler")
  def migration001(implicit db: MongoDatabase): Unit = {
    List(
      Version(candidate = "dotty", version = "0.13.0-RC1", url = url("0.13.0-RC1")),
      Version(candidate = "dotty", version = "0.14.0-RC1", url = url("0.14.0-RC1")),
      Version(candidate = "dotty", version = "0.15.0-RC1", url = url("0.15.0-RC1")),
      Version(candidate = "dotty", version = "0.16.0-RC1", url = url("0.16.0-RC1")),
      Version(candidate = "dotty", version = "0.16.0-RC2", url = url("0.16.0-RC2"))
    )
      .validate()
      .insert()
    setCandidateDefault("dotty", "0.16.0-RC2")
  }

  @ChangeSet(order = "002", id = "002-add_dotty_0_16_0-RC3", author = "Miuler")
  def migration002(implicit db: MongoDatabase): Unit = {
    Version(candidate = "dotty", version = "0.16.0-RC3", url = url("0.16.0-RC3"))
      .validate()
      .insert()
      .asCandidateDefault()
  }


  private def url(version: String) = s"https://github.com/lampepfl/dotty/releases/download/$version/dotty-$version.tar.gz"
}
