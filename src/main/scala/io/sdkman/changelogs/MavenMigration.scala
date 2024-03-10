package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "040",
    id = "040-maven-4.0.0-alpha-13",
    author = "aalmiray"
  )
  def migration040(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "4.0.0-alpha-13",
      "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/4.0.0-alpha-13/apache-maven-4.0.0-alpha-13-bin.zip"
    ).validate()
      .insert()
}
