package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Amazon, Linux64, MacOSX, Version, Windows, _}

@ChangeLog(order = "017")
class AmazonCorrettoMigrations {

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

  @ChangeSet(
    order = "0019",
    id = "0019-add_corretto_15.0.1.9.1",
    author = "eddumelendez"
  )
  def migrate0019(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> "linux-aarch64.tar.gz",
      Linux64    -> "linux-x64.tar.gz",
      MacOSX     -> "macosx-x64.tar.gz",
      Windows    -> "windows-x64-jdk.zip"
    ).map {
        case (platform, suffix) =>
          Version(
            "java",
            "15.0.1-amzn",
            s"https://corretto.aws/downloads/resources/15.0.1.9.1/amazon-corretto-15.0.1.9.1-$suffix",
            platform,
            Some(Amazon)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "15.0.0-amzn", version.platform)
      }

  @ChangeSet(
    order = "0020",
    id = "0020-remove_corretto_11.0.9.11.1",
    author = "eddumelendez"
  )
  def migrate0020(implicit db: MongoDatabase) =
    Seq(
      LinuxARM64,
      Linux64,
      MacOSX,
      Windows
    ).foreach { platform =>
      removeVersion("java", "11.0.9-amzn", platform)
    }

  @ChangeSet(
    order = "0021",
    id = "0021-add_corretto_11.0.9.12.1",
    author = "eddumelendez"
  )
  def migrate0021(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> "linux-aarch64.tar.gz",
      Linux64    -> "linux-x64.tar.gz",
      MacOSX     -> "macosx-x64.tar.gz",
      Windows    -> "windows-x64-jdk.zip"
    ).map {
        case (platform, suffix) =>
          Version(
            "java",
            "11.0.9-amzn",
            s"https://corretto.aws/downloads/resources/11.0.9.12.1/amazon-corretto-11.0.9.12.1-$suffix",
            platform,
            Some(Amazon)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "0022",
    id = "0022-add_corretto_java8_update_275.01.1",
    author = "eddumelendez"
  )
  def migrate0022(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> "amazon-corretto-8.275.01.1-linux-aarch64.tar.gz",
      Linux64    -> "amazon-corretto-8.275.01.1-linux-x64.tar.gz",
      MacOSX     -> "amazon-corretto-8.275.01.1-macosx-x64.tar.gz",
      Windows    -> "amazon-corretto-8.275.01.1-windows-x64-jdk.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.275-amzn",
            s"https://corretto.aws/downloads/resources/8.275.01.1/$binary",
            platform,
            Some(Amazon)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8.0.272-amzn", version.platform)
      }

  @ChangeSet(
    order = "023",
    id = "023-hide-java-versions",
    author = "eddumelendez"
  )
  def migrate023(implicit db: MongoDatabase): Unit =
    Seq("8.0.275-amzn", "11.0.9-amzn")
      .foreach(version => hideVersion("java", version))
}
