package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "086")
class JettyMigrations {

  @ChangeSet(
    order = "005",
    id = "005-update_jetty_versions",
    author = "olamy"
  )
  def migration005(implicit db: MongoDatabase) = {
    List(
      "10" -> "10.0.24",
      "11" -> "11.0.24",
      "12" -> "12.0.14"
    ).map {
        case (series: String, version: String) =>
          Version(
            candidate = "jetty",
            version = version,
            url =
              s"https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-home/$version/jetty-home-$version.zip"
          )
      }
      .validate()
      .insert()
    setCandidateDefault("jetty", "12.0.14")

  }
}
