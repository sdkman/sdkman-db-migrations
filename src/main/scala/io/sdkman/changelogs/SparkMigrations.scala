package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "007")
class SparkMigrations {
  @ChangeSet(
    order = "017",
    id = "016-add_spark_3.2.0",
    author = "ChethanUK"
  )
  def migration017(implicit db: MongoDatabase): Unit = {
    Version(
      "spark",
      "3.2.0",
      "https://archive.apache.org/dist/spark/spark-3.2.0/spark-3.2.0-bin-hadoop3.2.tgz"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(
    order = "018",
    id = "018-add_spark_3.0.3",
    author = "ChethanUK"
  )
  def migration018(implicit db: MongoDatabase) = {
    Version(
      "spark",
      "3.1.1",
      "https://archive.apache.org/dist/spark/spark-3.0.3/spark-3.0.3-bin-hadoop3.2.tgz"
    ).validate()
      .insert()
  }
}
