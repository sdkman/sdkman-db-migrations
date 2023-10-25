package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "035",
    id = "035-maven-4.0.0-alpha-8",
    author = "aalmiray"
  )
  def migration035(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "4.0.0-alpha-8",
      "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/4.0.0-alpha-8/apache-maven-4.0.0-alpha-8-bin.zip"
    ).validate()
      .insert()
}
