package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "026",
    id = "026-add_maven_4.0.0-alpha-5",
    author = "aalmiray"
  )
  def migration026(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "4.0.0-alpha-5",
      "https://dlcdn.apache.org/maven/maven-4/4.0.0-alpha-5/binaries/apache-maven-4.0.0-alpha-5-bin.zip"
    ).validate()
      .insert()
  }
}
