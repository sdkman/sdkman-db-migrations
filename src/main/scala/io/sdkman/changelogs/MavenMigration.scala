package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "025",
    id = "025-add_maven_3.9.1",
    author = "aalmiray"
  )
  def migration025(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.9.1",
      "https://dlcdn.apache.org/maven/maven-3/3.9.1/binaries/apache-maven-3.9.1-bin.zip"
    ).validate()
      .insert()
  }
}
