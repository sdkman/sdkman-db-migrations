package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "007")
class SparkMigrations {
  @ChangeSet(order = "001", id = "001-add_spark_2.3.0", author = "marc0der")
  def migration001(implicit db: MongoDatabase) = {
    Version("spark", "2.3.0", "https://archive.apache.org/dist/spark/spark-2.3.0/spark-2.3.0-bin-hadoop2.7.tgz")
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(order = "002", id = "002-add_spark_2.3.1", author = "marc0der")
  def migration002(implicit db: MongoDatabase) = {
    Version("spark", "2.3.1", "https://archive.apache.org/dist/spark/spark-2.3.1/spark-2.3.1-bin-hadoop2.7.tgz")
      .validateUrl()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(order = "003", id = "003-fix_broken_urls", author = "marc0der")
  def migration003(implicit db: MongoDatabase) = Seq("2.0.2", "2.1.1", "2.1.2", "2.2.0", "2.2.1").foreach { version =>
    removeVersion("spark", version)
    Version("spark", version, s"https://archive.apache.org/dist/spark/spark-$version/spark-$version-bin-hadoop2.7.tgz")
      .validateUrl()
      .insert()
  }
}
