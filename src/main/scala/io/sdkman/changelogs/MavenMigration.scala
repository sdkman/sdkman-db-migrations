package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "041",
    id = "041-maven-3.9.7",
    author = "aalmiray"
  )
  def migration041(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "3.9.7",
      "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.7/apache-maven-3.9.7-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
}
