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

  @ChangeSet(
    order = "0015",
    id = "0015-remove_corretto_java8_update_272",
    author = "eddumelendez"
  )
  def migrate0015(implicit db: MongoDatabase) =
    Seq(
      LinuxARM64,
      Linux64,
      MacOSX,
      Windows
    ).foreach { platform =>
      removeVersion("java", "8.0.272-amzn", platform)
    }

  @ChangeSet(
    order = "0016",
    id = "0016-add_corretto_java8_update_272",
    author = "eddumelendez"
  )
  def migrate0016(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> ("8.272.10.3", "linux-aarch64.tar.gz"),
      Linux64    -> ("8.272.10.3", "linux-x64.tar.gz"),
      MacOSX     -> ("8.272.10.3", "macosx-x64.tar.gz"),
      Windows    -> ("8.272.10.3", "windows-x64-jdk.zip")
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

  @ChangeSet(
    order = "0017",
    id = "0017-remove_corretto_11.0.9.11.1",
    author = "eddumelendez"
  )
  def migrate0017(implicit db: MongoDatabase) =
    Seq(
      LinuxARM64,
      Linux64
    ).foreach { platform =>
      removeVersion("java", "11.0.9-amzn", platform)
    }

  @ChangeSet(
    order = "0018",
    id = "0018-add_corretto_11.0.9.11.1-1",
    author = "eddumelendez"
  )
  def migrate0018(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> "linux-aarch64.tar.gz",
      Linux64    -> "linux-x64.tar.gz"
    ).map {
        case (platform, suffix) =>
          Version(
            "java",
            "11.0.9-amzn",
            s"https://corretto.aws/downloads/resources/11.0.9.11.1-1/amazon-corretto-11.0.9.11.1-$suffix",
            platform,
            Some(Amazon)
          )
      }
      .toList
      .validate()
      .insert()

}
