package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "030",
    id = "030-maven-3.9.2",
    author = "aalmiray"
  )
  def migration030(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "3.9.2",
      "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.2/apache-maven-3.9.2-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
}
