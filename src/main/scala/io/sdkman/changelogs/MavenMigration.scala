package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "024",
    id = "024-add_maven_3.8.8",
    author = "aalmiray"
  )
  def migration024(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.8.8",
      "https://dlcdn.apache.org/maven/maven-3/3.8.8/binaries/apache-maven-3.8.8-bin.zip"
    ).validate()
      .insert()
  }
}
