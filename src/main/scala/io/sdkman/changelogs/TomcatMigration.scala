package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import org.bson.Document

@ChangeLog(order = "038")
class TomcatMigration {

  @ChangeSet(
    order = "015",
    id = "015-update_tomcat_versions",
    author = "stefanpenndorf"
  )
  def migration015(implicit db: MongoDatabase): Document = {
    removeVersion("tomcat", "11.0.0-M10")

    List(
      "8"  -> "8.5.93",
      "9"  -> "9.0.80",
      "10" -> "10.1.13",
      "11" -> "11.0.0-M11"
    ).map {
        case (series: String, version: String) =>
          Version(
            candidate = "tomcat",
            version = version,
            url =
              s"https://archive.apache.org/dist/tomcat/tomcat-$series/v$version/bin/apache-tomcat-$version.zip"
          )
      }
      .validate()
      .insert()
    setCandidateDefault("tomcat", "10.1.13")
  }

}
