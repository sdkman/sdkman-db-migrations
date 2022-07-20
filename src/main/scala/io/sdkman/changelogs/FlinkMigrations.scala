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
  def migration001(implicit db: MongoDatabase): Candidate =
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
    order = "008",
    id = "008-add_flink_1_15",
    author = "ChethanUK"
  )
  def migration008(implicit db: MongoDatabase) = {
    val flinkVersions = List(
      "1.14.4",
      "1.15.0"
    )
    List("2.12")
      .flatMap { scalaVersion =>
        flinkVersions.map { version =>
          flinkVersion(version, scalaVersion)
        }
      }
      .validate()
      .insert()
  }

  @ChangeSet(
    order = "009",
    id = "009-add_flink_1.15.1",
    author = "ChethanUK"
  )
  def migration009(implicit db: MongoDatabase) = {
    flinkVersion("1.15.1", "2.12")
      .validate()
      .insert()
  }
}
