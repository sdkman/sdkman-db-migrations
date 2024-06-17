package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "043",
    id = "043-maven-3.9.8",
    author = "aalmiray"
  )
  def migration042(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "3.9.8",
      "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.8/apache-maven-3.9.8-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
}
