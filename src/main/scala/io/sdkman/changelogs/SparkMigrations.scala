package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import org.bson.Document

@ChangeLog(order = "007")
class SparkMigrations {

  @ChangeSet(
    order = "030",
    id = "030-latest-spark-versions",
    author = "noobzik"
  )
  def migration030(implicit db: MongoDatabase): Document = {
    Map(
      "2.2.2"          -> "hadoop2.7",
      "2.2.3"          -> "hadoop2.7",
      "2.3.4"          -> "hadoop2.7",
      "2.4.8"          -> "hadoop2.7",
      "3.0.3"          -> "hadoop3.2",
      "3.1.3"          -> "hadoop3.2",
      "3.2.4"          -> "hadoop3.2",
      "3.3.3"          -> "hadoop3",
      "3.3.4"          -> "hadoop3",
      "3.4.2"          -> "hadoop3",
      "3.4.3"          -> "hadoop3",
      "3.5.1"          -> "hadoop3",
      "3.5.2"          -> "hadoop3",
      "3.5.3"          -> "hadoop3",
      "4.0.0-preview1" -> "hadoop3",
      "4.0.0-preview2" -> "hadoop3"
    ).foreach {
      case (version, distribution) =>
        Version(
          candidate = "spark",
          version = version,
          url =
            s"https://archive.apache.org/dist/spark/spark-$version/spark-$version-bin-$distribution.tgz"
        ).validate().insert()
    }
    setCandidateDefault("spark", "3.5.3")
  }
}
