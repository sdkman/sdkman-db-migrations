package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "046",
    id = "046-maven-4.0.0-rc-4",
    author = "hho"
  )
  def migration046(implicit db: MongoDatabase): Unit =
    Version(
      "maven",
      "4.0.0-rc-4",
      "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/4.0.0-rc-4/apache-maven-4.0.0-rc-4-bin.zip"
    ).validate()
      .insert()
}
