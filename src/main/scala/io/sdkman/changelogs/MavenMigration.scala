package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "037",
    id = "037-maven-4.0.0-alpha-9",
    author = "aalmiray"
  )
  def migration037(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "4.0.0-alpha-9",
      "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/4.0.0-alpha-9/apache-maven-4.0.0-alpha-9-bin.zip"
    ).validate()
      .insert()
}
