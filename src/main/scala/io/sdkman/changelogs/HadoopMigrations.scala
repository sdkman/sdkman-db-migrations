package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "059")
class HadoopMigrations {
  @ChangeSet(
    order = "001",
    id = "001-add_hadoop_candidate",
    author = "ChethanUK"
  )
  def migration001(implicit db: MongoDatabase): Candidate =
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
    order = "005",
    id = "005-add_hadoop_3_4_1",
    author = "noobzik"
  )
  def migration005(implicit db: MongoDatabase) = {
    val hadoopVersions = List(
      "2.10.2",
      "3.2.4",
      "3.3.5",
      "3.3.6",
      "3.4.0",
      "3.4.1"
    )
    hadoopVersions
      .map { version =>
        hadoopVersion(version)
      }
      .validate()
      .insert()
    setCandidateDefault("hadoop", "3.4.1")
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
}
