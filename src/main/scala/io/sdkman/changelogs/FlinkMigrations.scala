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
    id = "002-add_flink_1.8_2.12",
    author = "ChethanUK"
  )
  def migration002(implicit db: MongoDatabase) = {
    flinkListVersion(majorVersion = "1.7", minorVersions = (0 to 2).toList)
    flinkListVersion(majorVersion = "1.8", minorVersions = (0 to 3).toList)
      .insert()
  }

  @ChangeSet(
    order = "003",
    id = "003-add_flink_1.9_2.12",
    author = "ChethanUK"
  )
  def migration003(implicit db: MongoDatabase) = {
    flinkListVersion(majorVersion = "1.9", minorVersions = (0 to 3).toList)
      .insert()
  }

  @ChangeSet(
    order = "004",
    id = "004-add_flink_1.10_2.12",
    author = "ChethanUK"
  )
  def migration004(implicit db: MongoDatabase) = {
    flinkListVersion(majorVersion = "1.10", minorVersions = (0 to 3).toList)
      .insert()
  }

  @ChangeSet(
    order = "005",
    id = "005-add_flink_1.11_2.12",
    author = "ChethanUK"
  )
  def migration005(implicit db: MongoDatabase) = {
    flinkListVersion(majorVersion = "1.11", minorVersions = (0 to 3).toList)
      .insert()
  }

  @ChangeSet(
    order = "006",
    id = "006-add_flink_1.12_2.12",
    author = "ChethanUK"
  )
  def migration006(implicit db: MongoDatabase) = {
    flinkListVersion(majorVersion = "1.12", minorVersions = (0 to 1).toList)
      .insert()
  }

  @ChangeSet(
    order = "007",
    id = "007-add_flink_1.12.2_2.12_as_default",
    author = "ChethanUK"
  )
  def migration007(implicit db: MongoDatabase) = {
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
    )

  private def flinkListVersion(
      majorVersion: String,
      minorVersions: List[Int],
      scalaVersion: String = "2.12"
  ) = {
    ((minorVersions map { s"$majorVersion." + _ }) map { v =>
      flinkVersion(v, scalaVersion)
    }).validate()
  }

}
