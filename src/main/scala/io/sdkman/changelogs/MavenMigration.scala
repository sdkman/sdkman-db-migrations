package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "036",
    id = "036-maven-3.9.6",
    author = "aalmiray"
  )
  def migration036(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "3.9.6",
      "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.6/apache-maven-3.9.6-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
}
