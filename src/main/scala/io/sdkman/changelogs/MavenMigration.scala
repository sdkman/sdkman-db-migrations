package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "023",
    id = "023-add_maven_4.0.0_alpha_4",
    author = "aalmiray"
  )
  def migration023(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "4.0.0-alpha-4",
      "https://dlcdn.apache.org/maven/maven-4/4.0.0-alpha-4/binaries/apache-maven-4.0.0-alpha-4-bin.zip"
    ).validate()
      .insert()
  }
}
