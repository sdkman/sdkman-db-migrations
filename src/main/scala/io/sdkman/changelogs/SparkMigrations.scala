package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "007")
class SparkMigrations {
  @ChangeSet(
    order = "020",
    id = "020-add_spark_3.2.2",
    author = "cphbrt"
  )
  def migration020(implicit db: MongoDatabase) = {
    Version(
      "spark",
      "3.2.2",
      "https://archive.apache.org/dist/spark/spark-3.2.2/spark-3.2.2-bin-hadoop3.2.tgz"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "021",
    id = "021-add_spark_3.3.0",
    author = "cphbrt"
  )
  def migration021(implicit db: MongoDatabase) = {
    Version(
      "spark",
      "3.3.0",
      "https://archive.apache.org/dist/spark/spark-3.3.0/spark-3.3.0-bin-hadoop3.tgz"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "022",
    id = "022-add_spark_3.3.1",
    author = "cphbrt"
  )
  def migration022(implicit db: MongoDatabase) = {
    Version(
      "spark",
      "3.3.1",
      "https://archive.apache.org/dist/spark/spark-3.3.1/spark-3.3.1-bin-hadoop3.tgz"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
