package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "027",
    id = "027-add_maven_3.9.1",
    author = "aalmiray"
  )
  def migration028(implicit db: MongoDatabase): Unit =
    List(
      "3.0.4",
      "3.0.5",
      "3.1.0",
      "3.1.1",
      "3.2.1",
      "3.2.2",
      "3.2.3",
      "3.2.5",
      "3.3.1",
      "3.3.3",
      "3.3.9",
      "3.5.0",
      "3.5.2",
      "3.5.3",
      "3.5.4",
      "3.6.0",
      "3.6.1",
      "3.6.2",
      "3.6.3",
      "3.8.1",
      "3.8.2",
      "3.8.3",
      "3.8.4",
      "3.8.5",
      "3.8.6",
      "3.8.7",
      "3.8.8",
      "3.9.0",
      "3.9.1",
      "4.0.0-alpha-4",
      "4.0.0-alpha-5"
    ).foreach { version =>
      removeVersion("maven", version)
      Version(
        "maven",
        "3.9.1",
        s"https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/${version}/apache-maven-${version}-bin.zip"
      ).validate()
        .insert()
    }
}
