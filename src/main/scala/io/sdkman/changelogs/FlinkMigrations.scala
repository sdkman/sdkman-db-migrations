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
    val flinkVersions = List(
      "1.7.0",
      "1.7.1",
      "1.7.2",
      "1.8.0",
      "1.8.1",
      "1.8.2",
      "1.8.3",
      "1.9.0",
      "1.9.1",
      "1.9.2",
      "1.9.3",
      "1.10.0",
      "1.10.1",
      "1.10.2",
      "1.10.3",
      "1.11.0",
      "1.11.1",
      "1.11.2",
      "1.11.3",
      "1.12.0",
      "1.12.1",
      "1.12.2",
      "1.12.3",
      "1.12.4",
      "1.13.0",
      "1.13.1"
    )
    List("2.11", "2.12")
      .flatMap { scalaVersion =>
        flinkVersions.map { version =>
          flinkVersion(version, scalaVersion)
        }
      }
      .validate()
      .insert()
  }

  private def flinkVersion(
      flinkVersion: String,
      scalaVersion: String
  ) =
    Version(
      candidate = "flink",
      version = flinkVersion,
      url = url(flinkVersion, scalaVersion)
    )

  private def url(version: String, scala: String) =
    s"https://archive.apache.org/dist/flink/flink-$version/flink-$version-bin-scala_$scala.tgz"

  @ChangeSet(
    order = "003",
    id = "003-set_default_version_1_12_2",
    author = "marc0der"
  )
  def migration003(implicit db: MongoDatabase) =
    setCandidateDefault("flink", "1.12.2")

  @ChangeSet(
    order = "004",
    id = "004-set_default_version_1_13_1",
    author = "ChethanUK"
  )
  def migration004(implicit db: MongoDatabase) =
    setCandidateDefault("flink", "1.13.1")
}
