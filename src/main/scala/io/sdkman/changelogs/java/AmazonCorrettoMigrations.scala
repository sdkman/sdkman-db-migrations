package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Amazon, Linux64, MacOSX, Version, Windows, _}

@ChangeLog(order = "017")
class AmazonCorrettoMigrations {

  @ChangeSet(
    order = "0011",
    id = "0011-add_corretto_java15.0.0",
    author = "poad"
  )
  def migrate0011(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> ("15.0.0.36.1", "linux-aarch64.tar.gz"),
      Linux64    -> ("15.0.0.36.1", "linux-x64.tar.gz"),
      MacOSX     -> ("15.0.0.36.1", "macosx-x64.tar.gz"),
      Windows    -> ("15.0.0.36.1", "windows-x64-jdk.zip")
    ).map {
        case (platform, (version, suffix)) =>
          Version(
            "java",
            "15.0.0-amzn",
            s"https://corretto.aws/downloads/resources/$version/amazon-corretto-$version-$suffix",
            platform,
            Some(Amazon)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "0012",
    id = "0012-add_corretto_java11_update_9",
    author = "eddumelendez"
  )
  def migrate0012(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> ("11.0.9.11.1", "linux-aarch64.tar.gz"),
      Linux64    -> ("11.0.9.11.1", "linux-x64.tar.gz"),
      MacOSX     -> ("11.0.9.11.1", "macosx-x64.tar.gz"),
      Windows    -> ("11.0.9.11.1", "windows-x64-jdk.zip")
    ).map {
        case (platform, (version, suffix)) =>
          Version(
            "java",
            "11.0.9-amzn",
            s"https://corretto.aws/downloads/resources/$version/amazon-corretto-$version-$suffix",
            platform,
            Some(Amazon)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "11.0.8-amzn", version.platform)
      }

  @ChangeSet(
    order = "0013",
    id = "0013-add_corretto_java8_update_272",
    author = "eddumelendez"
  )
  def migrate0013(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> ("8.272.10.1", "linux-aarch64.tar.gz"),
      Linux64    -> ("8.272.10.1", "linux-x64.tar.gz"),
      MacOSX     -> ("8.272.10.1", "macosx-x64.tar.gz"),
      Windows    -> ("8.272.10.1", "windows-x64-jdk.zip")
    ).map {
        case (platform, (version, suffix)) =>
          Version(
            "java",
            "8.0.272-amzn",
            s"https://corretto.aws/downloads/resources/$version/amazon-corretto-$version-$suffix",
            platform,
            Some(Amazon)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8.0.265-amzn", version.platform)
      }
  @ChangeSet(
    order = "0014",
    id = "0014-add_corretto_java11_update_9",
    author = "eddumelendez"
  )
  def migrate0014(implicit db: MongoDatabase) =
    Map(
      Windows -> ("11.0.9.11.2", "windows-x64-jdk.zip")
    ).map {
        case (platform, (version, suffix)) =>
          Version(
            "java",
            "11.0.9-amzn",
            s"https://corretto.aws/downloads/resources/$version/amazon-corretto-$version-$suffix",
            platform,
            Some(Amazon)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "11.0.9-amzn", version.platform)
      }
}
