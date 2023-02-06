package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(order = "022", id = "022-add_maven_3.9.0", author = "yeikel")
  def migration020(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.9.0",
      "https://dlcdn.apache.org/maven/maven-3/3.9.0/binaries/apache-maven-3.9.0-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
