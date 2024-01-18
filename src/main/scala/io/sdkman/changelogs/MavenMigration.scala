package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "039",
    id = "039-maven-4.0.0-alpha-12",
    author = "aalmiray"
  )
  def migration039(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "4.0.0-alpha-12",
      "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/4.0.0-alpha-12/apache-maven-4.0.0-alpha-12-bin.zip"
    ).validate()
      .insert()
}
