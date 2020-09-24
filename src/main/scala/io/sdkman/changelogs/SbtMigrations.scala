package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "037")
class SbtMigrations {

  @ChangeSet(order = "001", id = "001-remove-all", author = "eed3si9n")
  def migration001(implicit db: MongoDatabase) =
    removeAllVersions(candidate = "sbt")

  @ChangeSet(
    order = "002",
    id = "002-add_sbt_historic_verions",
    author = "eed3si9n"
  )
  def migration002(implicit db: MongoDatabase) =
    (((17 to 18).toList map { "0.13." + _ }) :::
      ((0 to 4).toList map { "1.0." + _ }) :::
      ((0 to 6).toList diff List(3) map { "1.1." + _ }) :::
      ((0 to 8).toList diff List(2) map { "1.2." + _ }) :::
      ((0 to 12).toList diff List(2) map { "1.3." + _ }) map { v =>
      Version(
        candidate = "sbt",
        version = v,
        url = s"https://github.com/sbt/sbt/releases/download/v$v/sbt-$v.zip"
      )
    }).validate()
      .insert()

  @ChangeSet(
    order = "003",
    id = "003-add_sbt_1_3_13_as_default",
    author = "eed3si9n"
  )
  def migration003(implicit db: MongoDatabase) =
    Version(
      candidate = "sbt",
      version = "1.3.13",
      url =
        "https://github.com/sbt/sbt/releases/download/v1.3.13/sbt-1.3.13.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
}
