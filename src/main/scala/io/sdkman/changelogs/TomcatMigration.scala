package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import org.bson.Document

@ChangeLog(order = "038")
class TomcatMigration {
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

  @ChangeSet(
    order = "016",
    id = "016-update_tomcat_versions",
    author = "stefanpenndorf"
  )
  def migration016(implicit db: MongoDatabase): Document = {
    removeVersion("tomcat", "11.0.0-M12")

    List(
      "8"  -> "8.5.100",
      "9"  -> "9.0.88",
      "10" -> "10.1.20",
      "11" -> "11.0.0-M19"
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
    order = "017",
    id = "017-update_tomcat_versions",
    author = "stefanpenndorf"
  )
  def migration017(implicit db: MongoDatabase): Document = {
    removeVersion("tomcat", "11.0.0-M19")
    removeVersion("tomcat", "8.5.100") // Tomcat 8.5 EOL on March, 31st 2024

    List(
      "9"  -> "9.0.95",
      "10" -> "10.1.30",
      "11" -> "11.0.0-M26"
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
    setCandidateDefault("tomcat", "10.1.30")
  }

  @ChangeSet(
    order = "018",
    id = "018-update_tomcat_versions",
    author = "kartikvarma"
  )
  def migration018(implicit db: MongoDatabase): Document = {
    removeVersion("tomcat", "11.0.0-M26")

    List(
      "9"  -> "9.0.96",
      "10" -> "10.1.31",
      "11" -> "11.0.0"
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
    setCandidateDefault("tomcat", "11.0.0")
  }

  @ChangeSet(
    order = "019",
    id = "019-update_tomcat_versions",
    author = "stefanpenndorf"
  )
  def migration019(implicit db: MongoDatabase): Document = {
    List(
      "9"  -> "9.0.100",
      "10" -> "10.1.36",
      "11" -> "11.0.4"
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
    setCandidateDefault("tomcat", "11.0.4")
  }

  @ChangeSet(
    order = "020",
    id = "020-update_tomcat_versions",
    author = "stefanpenndorf"
  )
  def migration020(implicit db: MongoDatabase): Document = {
    List(
      "9"  -> "9.0.102",
      "10" -> "10.1.39",
      "11" -> "11.0.5"
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
    setCandidateDefault("tomcat", "11.0.5")
  }

  @ChangeSet(
    order = "021",
    id = "021-update_tomcat_versions",
    author = "stefanpenndorf"
  )
  def migration021(implicit db: MongoDatabase): Document = {
    List(
      "9"  -> "9.0.104",
      "10" -> "10.1.40",
      "11" -> "11.0.6"
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
    setCandidateDefault("tomcat", "11.0.6")
  }

  @ChangeSet(
    order = "022",
    id = "022-update_tomcat_versions",
    author = "stefanpenndorf"
  )
  def migration022(implicit db: MongoDatabase): Document = {
    List(
      "9"  -> "9.0.105",
      "10" -> "10.1.41",
      "11" -> "11.0.7"
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
    setCandidateDefault("tomcat", "11.0.7")
  }

}
