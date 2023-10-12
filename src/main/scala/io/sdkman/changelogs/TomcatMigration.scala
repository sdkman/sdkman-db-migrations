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

  @ChangeSet(
    order = "008",
    id = "008-update_tomcat_versions",
    author = "ahmadshalabi"
  )
  def migration008(implicit db: MongoDatabase): Document = {
    List(
      "7"  -> "7.0.109",
      "8"  -> "8.5.73",
      "9"  -> "9.0.56",
      "10" -> "10.0.14",
      "10" -> "10.1.0-M8"
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
    setCandidateDefault("tomcat", "10.0.14")
  }

  @ChangeSet(
    order = "009",
    id = "009-add_tomcat_10.0.22",
    author = "helpermethod"
  )
  def migration009(implicit db: MongoDatabase) =
    Version(
      candidate = "tomcat",
      version = "10.0.22",
      url =
        "https://archive.apache.org/dist/tomcat/tomcat-10/v10.0.22/bin/apache-tomcat-10.0.22.zip"
    ).validate()
      .insert()
      .asCandidateDefault()

  @ChangeSet(
    order = "010",
    id = "010-update_tomcat_versions",
    author = "stefanpenndorf"
  )
  def migration010(implicit db: MongoDatabase): Document = {
    removeVersion("tomcat", "10.0.0-M10")
    removeVersion("tomcat", "10.1.0-M8")

    List(
      "8"  -> "8.5.86",
      "8"  -> "8.5.87",
      "9"  -> "9.0.65",
      "9"  -> "9.0.72",
      "9"  -> "9.0.73",
      "10" -> "10.1.6",
      "10" -> "10.1.7",
      "11" -> "11.0.0-M3"
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
    setCandidateDefault("tomcat", "10.1.7")
  }

  @ChangeSet(
    order = "011",
    id = "011-update_tomcat_versions",
    author = "stefanpenndorf"
  )
  def migration011(implicit db: MongoDatabase): Document = {
    removeVersion("tomcat", "11.0.0-M3")

    List(
      "8"  -> "8.5.88",
      "9"  -> "9.0.74",
      "10" -> "10.1.8",
      "11" -> "11.0.0-M5"
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
    setCandidateDefault("tomcat", "10.1.8")
  }
  @ChangeSet(
    order = "012",
    id = "012-update_tomcat_versions",
    author = "stefanpenndorf"
  )
  def migration012(implicit db: MongoDatabase): Document = {
    removeVersion("tomcat", "11.0.0-M5")

    List(
      "8"  -> "8.5.89",
      "9"  -> "9.0.75",
      "10" -> "10.1.9",
      "11" -> "11.0.0-M6"
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
    setCandidateDefault("tomcat", "10.1.9")
  }

  @ChangeSet(
    order = "013",
    id = "013-update_tomcat_versions",
    author = "stefanpenndorf"
  )
  def migration013(implicit db: MongoDatabase): Document = {
    removeVersion("tomcat", "11.0.0-M6")

    List(
      "8"  -> "8.5.90",
      "9"  -> "9.0.76",
      "10" -> "10.1.10",
      "11" -> "11.0.0-M7"
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
    setCandidateDefault("tomcat", "10.1.10")
  }

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

}
