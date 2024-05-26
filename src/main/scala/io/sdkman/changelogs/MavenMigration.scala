package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "042",
    id = "042-maven-4.0.0-beta-3",
    author = "aalmiray"
  )
  def migration042(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "4.0.0-beta-3",
      "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/4.0.0-beta-3/apache-maven-4.0.0-beta-3-bin.zip"
    ).validate()
      .insert()
}
