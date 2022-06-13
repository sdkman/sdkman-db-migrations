package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(order = "020", id = "020-add_maven_3.8.6", author = "aalmiray")
  def migration020(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.8.6",
      "https://archive.apache.org/dist/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
