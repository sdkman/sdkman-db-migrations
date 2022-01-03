package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(order = "008", id = "008-add_maven_3.8.3", author = "aalmiray")
  def migration008(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.8.3",
      "https://archive.apache.org/dist/maven/maven-3/3.8.3/binaries/apache-maven-3.8.3-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(order = "009", id = "009-add_maven_4.0.0-alpha-1", author = "helpermethod")
  def migration009(implicit db: MongoDatabase) = {
    Version(
      "maven",
      "4.0.0-alpha-1",
      "https://repository.apache.org/content/repositories/snapshots/org/apache/maven/apache-maven/4.0.0-alpha-1-SNAPSHOT/apache-maven-4.0.0-alpha-1-20211230.155705-237-bin.zip"
    ).validate()
      .insert()
  }

}
