package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "047",
    id = "047-maven-3.9.11",
    author = "albihasani94"
  )
  def migration047(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "3.9.11",
      "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.11/apache-maven-3.9.11-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
}
