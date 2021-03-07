package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "045")
class FlinkMigrations {
  @ChangeSet(
    order = "001",
    id = "001-add_flink_candidate",
    author = "ChethanUK"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "flink",
      name = "flink",
      description =
        "Apache Flink is an open-source, unified stream-processing and batch-processing framework." +
          "It's a distributed processing engine for stateful computations over unbounded and bounded data streams." +
          "It has been designed to run in all common cluster environments, perform computations at in-memory speed" +
          " and at any scale.",
      websiteUrl = "https://flink.apache.org/"
    ).insert()

  @ChangeSet(
    order = "002",
    id = "002-add_flink_1.9.3_2.12",
    author = "ChethanUK"
  )
  def migration002(implicit db: MongoDatabase) = {
    flinkVersion("1.9.3", "2.12")
      .insert()
  }

  @ChangeSet(
    order = "003",
    id = "002-add_flink_1.10.3_2.12",
    author = "ChethanUK"
  )
  def migration003(implicit db: MongoDatabase) = {
    flinkVersion("1.10.3", "2.12")
      .insert()
  }

  @ChangeSet(
    order = "004",
    id = "004-add_flink_1.11.3_2.12",
    author = "ChethanUK"
  )
  def migration004(implicit db: MongoDatabase) = {
    flinkVersion("1.11.3", "2.12")
      .insert()
  }

  @ChangeSet(
    order = "005",
    id = "004-add_flink_1.12.2_2.12",
    author = "ChethanUK"
  )
  def migration005(implicit db: MongoDatabase) = {
    flinkVersion("1.12.2", "2.12")
      .insert()
      .asCandidateDefault()
  }

  private def url(version: String, scala: String) =
    s"https://archive.apache.org/dist/flink/flink-$version/flink-$version-bin-scala_$scala.tgz"

  private def flinkVersion(
      flinkVersion: String,
      scalaVersion: String,
      candidate: String = "flink"
  ) =
    Version(
      candidate = candidate,
      version = flinkVersion,
      url = url(flinkVersion, scalaVersion)
    ).validate()
}
