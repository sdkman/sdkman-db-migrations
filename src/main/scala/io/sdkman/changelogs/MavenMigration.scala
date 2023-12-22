package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "038",
    id = "038-maven-4.0.0-alpha-10",
    author = "aalmiray"
  )
  def migration038(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "4.0.0-alpha-10",
      "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/4.0.0-alpha-10/apache-maven-4.0.0-alpha-10-bin.zip"
    ).validate()
      .insert()
}
