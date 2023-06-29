package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "032",
    id = "032-maven-4.0.0-alpha-7",
    author = "aalmiray"
  )
  def migration032(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "4.0.0-alpha-7",
      "https://dlcdn.apache.org/maven/maven-4/4.0.0-alpha-7/binaries/apache-maven-4.0.0-alpha-7-bin.zip"
    ).validate()
      .insert()
}
