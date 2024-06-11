package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "007")
class SparkMigrations {

  @ChangeSet(
    order = "028",
    id = "028-add_spark_3.5.1",
    author = "cphbrt"
  )
  def migration028(implicit db: MongoDatabase) = {
    Version(
      "spark",
      "2.2.2",
      "https://archive.apache.org/dist/spark/spark-2.2.2/spark-2.2.2-bin-hadoop2.7.tgz"
    ).validate().insert()
    Version(
      "spark",
      "2.2.3",
      "https://archive.apache.org/dist/spark/spark-2.2.3/spark-2.2.3-bin-hadoop2.7.tgz"
    ).validate().insert()
    Version(
      "spark",
      "2.3.4",
      "https://archive.apache.org/dist/spark/spark-2.3.4/spark-2.3.4-bin-hadoop2.7.tgz"
    ).validate().insert()
    Version(
      "spark",
      "2.4.8",
      "https://archive.apache.org/dist/spark/spark-2.4.8/spark-2.4.8-bin-hadoop2.7.tgz"
    ).validate().insert()
    Version(
      "spark",
      "3.0.3",
      "https://archive.apache.org/dist/spark/spark-3.0.3/spark-3.0.3-bin-hadoop3.2.tgz"
    ).validate().insert()
    Version(
      "spark",
      "3.1.3",
      "https://archive.apache.org/dist/spark/spark-3.1.3/spark-3.1.3-bin-hadoop3.2.tgz"
    ).validate().insert()
    Version(
      "spark",
      "3.2.4",
      "https://archive.apache.org/dist/spark/spark-3.2.4/spark-3.2.4-bin-hadoop3.2.tgz"
    ).validate().insert()
    Version(
      "spark",
      "3.3.3",
      "https://archive.apache.org/dist/spark/spark-3.3.3/spark-3.3.3-bin-hadoop3.tgz"
    ).validate().insert()
    Version(
      "spark",
      "3.3.4",
      "https://archive.apache.org/dist/spark/spark-3.3.4/spark-3.3.4-bin-hadoop3.tgz"
    ).validate().insert()
    Version(
      "spark",
      "3.4.2",
      "https://archive.apache.org/dist/spark/spark-3.4.2/spark-3.4.2-bin-hadoop3.tgz"
    ).validate().insert()
    Version(
      "spark",
      "3.4.3",
      "https://archive.apache.org/dist/spark/spark-3.4.3/spark-3.4.3-bin-hadoop3.tgz"
    ).validate().insert()
    Version(
      "spark",
      "3.5.1",
      "https://archive.apache.org/dist/spark/spark-3.5.1/spark-3.5.1-bin-hadoop3.tgz"
    ).validate().insert().asCandidateDefault()
  }
}
