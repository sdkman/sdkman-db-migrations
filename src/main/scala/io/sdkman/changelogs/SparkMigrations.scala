package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "007")
class SparkMigrations {
  @ChangeSet(
    order = "023",
    id = "023-add_spark_3.2.3",
    author = "sekikn"
  )
  def migration023(implicit db: MongoDatabase) = {
    Version(
      "spark",
      "3.2.3",
      "https://archive.apache.org/dist/spark/spark-3.2.3/spark-3.2.3-bin-hadoop3.2.tgz"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "024",
    id = "024-add_spark_3.3.2",
    author = "sekikn"
  )
  def migration024(implicit db: MongoDatabase) = {
    Version(
      "spark",
      "3.3.2",
      "https://archive.apache.org/dist/spark/spark-3.3.2/spark-3.3.2-bin-hadoop3.tgz"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
  
  @ChangeSet(
    order = "025",
    id = "025-add_spark_3.4.0",
    author = "sekikn"
  )
  def migration025(implicit db: MongoDatabase) = {
    Version(
      "spark",
      "3.4.0",
      "https://archive.apache.org/dist/spark/spark-3.4.0/spark-3.4.0-bin-hadoop3.tgz"
    ).validate()
      .insert()
      .asCandidateDefault()
  }  
}
