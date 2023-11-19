package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import org.bson.Document

@ChangeLog(order = "038")
class TomcatMigration {

  @ChangeSet(
    order = "014",
    id = "014-update_tomcat_versions",
    author = "stefanpenndorf"
  )
  def migration014(implicit db: MongoDatabase): Document = {
    removeVersion("tomcat", "11.0.0-M7")

    List(
      "8"  -> "8.5.91",
      "8"  -> "8.5.92",
      "9"  -> "9.0.78",
      "9"  -> "9.0.79",
      "10" -> "10.1.11",
      "10" -> "10.1.12",
      "11" -> "11.0.0-M10"
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
    setCandidateDefault("tomcat", "10.1.12")
  }

  @ChangeSet(
    order = "015",
    id = "015-update_tomcat_versions",
    author = "stefanpenndorf"
  )
  def migration015(implicit db: MongoDatabase): Document = {
    removeVersion("tomcat", "11.0.0-M10")

    List(
      "8"  -> "8.5.94",
      "9"  -> "9.0.81",
      "10" -> "10.1.14",
      "11" -> "11.0.0-M12"
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
    setCandidateDefault("tomcat", "10.1.14")
  }

  @ChangeSet(
    order = "016",
    id = "016-update_tomcat_versions",
    author = "stefanpenndorf"
  )
  def migration016(implicit db: MongoDatabase): Document = {
    removeVersion("tomcat", "11.0.0-M12")

    List(
      "8"  -> "8.5.96",
      "9"  -> "9.0.83",
      "10" -> "10.1.16",
      "11" -> "11.0.0-M14"
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
    setCandidateDefault("tomcat", "10.1.16")
  }

}
