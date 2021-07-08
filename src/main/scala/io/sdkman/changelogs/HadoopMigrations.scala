package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "052")
class HadoopMigrations {
  @ChangeSet(
    order = "001",
    id = "001-add_hadoop_candidate",
    author = "ChethanUK"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "hadoop",
      name = "hadoop",
      description =
        "Apache™ Hadoop® project develops open-source software for reliable, scalable, distributed computing." +
          "It's a framework that allows for the distributed processing of large data sets across clusters of computers" +
          "using simple programming models." +
          "It is designed to scale up from single servers to thousands of machines, each offering local computation and storage.",
      websiteUrl = "https://hadoop.apache.org/"
    ).insert()

  @ChangeSet(
    order = "002",
    id = "002-add_hadoop_3_3_0",
    author = "ChethanUK"
  )
  def migration002(implicit db: MongoDatabase) = {
    val hadoopVersions = List(
      "2.6.5",
      "2.7.7",
      "2.8.5",
      "2.9.2",
      "3.0.3",
      "3.1.4",
      "3.2.0",
      "3.2.1",
      "3.2.2",
      "3.3.0",
      "3.3.1"
    )
    hadoopVersions
      .map { version =>
        hadoopVersion(version)
      }
      .validate()
      .insert()
  }

  private def hadoopVersion(
      hadoopVersion: String
  ) =
    Version(
      candidate = "hadoop",
      version = hadoopVersion,
      url = url(hadoopVersion)
    )

  private def url(version: String) =
    s"https://archive.apache.org/dist/hadoop/common/hadoop-$version/hadoop-$version.tar.gz"

  @ChangeSet(
    order = "003",
    id = "003-set_default_version_3_3_1",
    author = "ChethanUK"
  )
  def migration003(implicit db: MongoDatabase) =
    setCandidateDefault("hadoop", "3.3.1")
}
