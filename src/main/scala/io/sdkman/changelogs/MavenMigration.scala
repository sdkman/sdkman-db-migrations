package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(order = "021", id = "021-add_maven_3.8.7", author = "aalmiray")
  def migration020(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.8.7",
      "https://dlcdn.apache.org/maven/maven-3/3.8.7/binaries/apache-maven-3.8.7-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
