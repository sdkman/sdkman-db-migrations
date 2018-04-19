package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "007")
class SparkMigrations {
  @ChangeSet(order = "001", id = "001-add_spark_2.3.0", author = "marc0der")
  def migration001(implicit db: MongoDatabase) = {
    insertVersion(Version("spark", "2.3.0", "https://archive.apache.org/dist/spark/spark-2.3.0/spark-2.3.0-bin-hadoop2.7.tgz"))
    setCandidateDefault("spark", "2.3.0")
  }
}
