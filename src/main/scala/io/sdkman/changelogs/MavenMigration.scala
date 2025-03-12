package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "045",
    id = "045-maven-4.0.0-rc-3",
    author = "ascheman"
  )
  def migration045(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "4.0.0-rc-3",
      "https://dlcdn.apache.org/maven/maven-4/4.0.0-rc-3/binaries/apache-maven-4.0.0-rc-3-bin.zip"
    ).validate()
      .insert()
}
