package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "033",
    id = "033-maven-3.9.4",
    author = "aalmiray"
  )
  def migration033(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "3.9.4",
      "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.4/apache-maven-3.9.4-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
}
