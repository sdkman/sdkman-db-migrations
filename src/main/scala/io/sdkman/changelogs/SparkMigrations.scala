package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "007")
class SparkMigrations {
  @ChangeSet(order = "001", id = "001-add_spark_2.3.0", author = "marc0der")
  def migration001(implicit db: MongoDatabase) = {
    Version(
      "spark",
      "2.3.0",
      "https://archive.apache.org/dist/spark/spark-2.3.0/spark-2.3.0-bin-hadoop2.7.tgz"
    ).insert()
      .asCandidateDefault()
  }

  @ChangeSet(order = "002", id = "002-add_spark_2.3.1", author = "marc0der")
  def migration002(implicit db: MongoDatabase) = {
    Version(
      "spark",
      "2.3.1",
      "https://archive.apache.org/dist/spark/spark-2.3.1/spark-2.3.1-bin-hadoop2.7.tgz"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(order = "003", id = "003-fix_broken_urls", author = "marc0der")
  def migration003(implicit db: MongoDatabase) =
    Seq("2.0.2", "2.1.1", "2.1.2", "2.2.0", "2.2.1").foreach { version =>
      removeVersion("spark", version)
      Version(
        "spark",
        version,
        s"https://archive.apache.org/dist/spark/spark-$version/spark-$version-bin-hadoop2.7.tgz"
      ).validate()
        .insert()
    }

  @ChangeSet(
    order = "004",
    id = "004-add_spark_2.3.2_and_2.4.0",
    author = "marc0der"
  )
  def migration004(implicit db: MongoDatabase) = {
    Seq("2.3.2", "2.4.0").foreach { version =>
      Version(
        "spark",
        version,
        s"https://archive.apache.org/dist/spark/spark-$version/spark-$version-bin-hadoop2.7.tgz"
      ).validate()
        .insert()
    }
    setCandidateDefault("spark", "2.4.0")
  }

  @ChangeSet(order = "005", id = "005-add_spark_2.1.3", author = "machielg")
  def migration005(implicit db: MongoDatabase) = {
    Seq("2.1.3").foreach { version =>
      Version(
        "spark",
        version,
        s"https://archive.apache.org/dist/spark/spark-$version/spark-$version-bin-hadoop2.7.tgz"
      ).validate()
        .insert()
    }
  }

  @ChangeSet(order = "006", id = "006-add_spark_2.3.3", author = "marc0der")
  def migration006(implicit db: MongoDatabase) =
    Version(
      "spark",
      "2.3.3",
      "https://archive.apache.org/dist/spark/spark-2.3.3/spark-2.3.3-bin-hadoop2.7.tgz"
    ).validate()
      .insert()

  @ChangeSet(order = "007", id = "007-add_spark_2.4.x", author = "marc0der")
  def migration007(implicit db: MongoDatabase) = {
    Seq("2.4.1", "2.4.2", "2.4.3").foreach { version =>
      Version(
        "spark",
        version,
        s"https://archive.apache.org/dist/spark/spark-$version/spark-$version-bin-hadoop2.7.tgz"
      ).validate()
        .insert()
    }
    setCandidateDefault("spark", "2.4.3")
  }

  @ChangeSet(
    order = "008",
    id = "008-add_spark_2.4.4",
    author = "rnarasimhan88"
  )
  def migration008(implicit db: MongoDatabase) = {
    Version(
      "spark",
      "2.4.4",
      "https://archive.apache.org/dist/spark/spark-2.4.4/spark-2.4.4-bin-hadoop2.7.tgz"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "009",
    id = "009-add_spark_2.4.5",
    author = "flvndh"
  )
  def migration009(implicit db: MongoDatabase) = {
    Version(
      "spark",
      "2.4.5",
      "https://archive.apache.org/dist/spark/spark-2.4.5/spark-2.4.5-bin-hadoop2.7.tgz"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "010",
    id = "010-add_spark_2.4.6",
    author = "flvndh"
  )
  def migration010(implicit db: MongoDatabase) = {
    Version(
      "spark",
      "2.4.6",
      "https://archive.apache.org/dist/spark/spark-2.4.6/spark-2.4.6-bin-hadoop2.7.tgz"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
