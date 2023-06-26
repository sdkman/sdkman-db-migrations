package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "031",
    id = "031-maven-3.9.3",
    author = "aalmiray"
  )
  def migration031(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "3.9.3",
      "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.3/apache-maven-3.9.3-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
}
