package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import org.bson.Document

@ChangeLog(order = "038")
class TomcatMigration {
  @ChangeSet(
    order = "007",
    id = "007-add_correct_tomcat_urls",
    author = "marc0der"
  )
  def migration007(implicit db: MongoDatabase): Document = {
    removeAllVersions("tomcat")
    List(
      "7"  -> "7.0.106",
      "8"  -> "8.5.60",
      "9"  -> "9.0.40",
      "10" -> "10.0.0-M10"
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
    setCandidateDefault("tomcat", "9.0.40")
  }
}
