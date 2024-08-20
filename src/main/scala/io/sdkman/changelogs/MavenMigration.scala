package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "044",
    id = "044-maven-3.9.9",
    author = "aalmiray"
  )
  def migration042(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "3.9.9",
      "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.9/apache-maven-3.9.9-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
}
