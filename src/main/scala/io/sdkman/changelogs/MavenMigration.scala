package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(order = "001", id = "001-add_maven_3.5.4", author = "philiplourandos")
  def migration001(implicit db: MongoDatabase) = {
    Version("maven", "3.5.4", "https://archive.apache.org/dist/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.zip")
      .validate()
      .insert()
      .asCandidateDefault()
  }
}
