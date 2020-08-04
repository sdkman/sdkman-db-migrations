package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Amazon, Linux64, MacOSX, Version, Windows, _}

@ChangeLog(order = "017")
class AmazonCorrettoMigrations {
  @ChangeSet(
    order = "0001",
    id = "0001-add_corretto_java8_update_242",
    author = "poad"
  )
  def migrate0001(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.242-amzn",
        "https://corretto.aws/downloads/resources/8.242.07.1/amazon-corretto-8.242.07.1-linux-x64.tar.gz",
        Linux64,
        Some(Amazon)
      ),
      Version(
        "java",
        "8.0.242-amzn",
        "https://corretto.aws/downloads/resources/8.242.07.1/amazon-corretto-8.242.07.1-macosx-x64.tar.gz",
        MacOSX,
        Some(Amazon)
      ),
      Version(
        "java",
        "8.0.242-amzn",
        "https://corretto.aws/downloads/resources/8.242.07.1/amazon-corretto-8.242.07.1-windows-x64-jdk.zip",
        Windows,
        Some(Amazon)
      )
    ).validate().insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      platform =>
        removeVersion(candidate = "java", version = "8.0.232-amzn", platform)
    )
  }

  @ChangeSet(
    order = "0002",
    id = "0002-add_corretto_java11_update_6",
    author = "poad"
  )
  def migrate0002(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.6-amzn",
        "https://corretto.aws/downloads/resources/11.0.6.10.1/amazon-corretto-11.0.6.10.1-linux-x64.tar.gz",
        Linux64,
        Some(Amazon)
      ),
      Version(
        "java",
        "11.0.6-amzn",
        "https://corretto.aws/downloads/resources/11.0.6.10.1/amazon-corretto-11.0.6.10.1-macosx-x64.tar.gz",
        MacOSX,
        Some(Amazon)
      ),
      Version(
        "java",
        "11.0.6-amzn",
        "https://corretto.aws/downloads/resources/11.0.6.10.1/amazon-corretto-11.0.6.10.1-windows-x64-jdk.zip",
        Windows,
        Some(Amazon)
      )
    ).validate().insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      platform =>
        removeVersion(candidate = "java", version = "11.0.5-amzn", platform)
    )
  }

  @ChangeSet(
    order = "0003",
    id = "0003-add_corretto_java11_update_6_hotfix",
    author = "dr29bart"
  )
  def migrate0003(implicit db: MongoDatabase) = {
    Seq(MacOSX, Windows).foreach(
      platform =>
        removeVersion(candidate = "java", version = "11.0.6-amzn", platform)
    )
    List(
      Version(
        "java",
        "11.0.6-amzn",
        "https://corretto.aws/downloads/resources/11.0.6.10.1/amazon-corretto-11.0.6.10.1-2-macosx-x64.tar.gz",
        MacOSX,
        Some(Amazon)
      ),
      Version(
        "java",
        "11.0.6-amzn",
        "https://corretto.aws/downloads/resources/11.0.6.10.1/amazon-corretto-11.0.6.10.1-1-windows-x64-jdk.zip",
        Windows,
        Some(Amazon)
      )
    ).validate().insert()
  }

  @ChangeSet(
    order = "0004",
    id = "0004-add_corretto_java8_update_252",
    author = "poad"
  )
  def migrate0004(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.252-amzn",
        "https://corretto.aws/downloads/resources/8.252.09.1/amazon-corretto-8.252.09.1-linux-x64.tar.gz",
        Linux64,
        Some(Amazon)
      ),
      Version(
        "java",
        "8.0.252-amzn",
        "https://corretto.aws/downloads/resources/8.252.09.1/amazon-corretto-8.252.09.1-macosx-x64.tar.gz",
        MacOSX,
        Some(Amazon)
      ),
      Version(
        "java",
        "8.0.252-amzn",
        "https://corretto.aws/downloads/resources/8.252.09.1/amazon-corretto-8.252.09.1-windows-x64-jdk.zip",
        Windows,
        Some(Amazon)
      )
    ).validate().insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      platform =>
        removeVersion(candidate = "java", version = "8.0.242-amzn", platform)
    )
  }

  @ChangeSet(
    order = "0005",
    id = "0005-add_corretto_java11_update_7",
    author = "poad"
  )
  def migrate0005(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.7-amzn",
        "https://corretto.aws/downloads/resources/11.0.7.10.1/amazon-corretto-11.0.7.10.1-linux-x64.tar.gz",
        Linux64,
        Some(Amazon)
      ),
      Version(
        "java",
        "11.0.7-amzn",
        "https://corretto.aws/downloads/resources/11.0.7.10.1/amazon-corretto-11.0.7.10.1-macosx-x64.tar.gz",
        MacOSX,
        Some(Amazon)
      ),
      Version(
        "java",
        "11.0.7-amzn",
        "https://corretto.aws/downloads/resources/11.0.7.10.1/amazon-corretto-11.0.7.10.1-windows-x64-jdk.zip",
        Windows,
        Some(Amazon)
      )
    ).validate().insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      platform =>
        removeVersion(candidate = "java", version = "11.0.6-amzn", platform)
    )
  }

  @ChangeSet(
    order = "0006",
    id = "0006-add_corretto_java8_update_262",
    author = "poad"
  )
  def migrate0006(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("8.262.10.1", "linux-x64.tar.gz"),
      MacOSX  -> ("8.262.10.1", "macosx-x64.tar.gz"),
      Windows -> ("8.262.10.1", "windows-x64-jdk.zip")
    ).map {
        case (platform, (version, suffix)) =>
          Version(
            "java",
            "8.0.262-amzn",
            s"https://corretto.aws/downloads/resources/$version/amazon-corretto-$version-$suffix",
            platform,
            Some(Amazon)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8.0.252-amzn", version.platform)
      }

  @ChangeSet(
    order = "0007",
    id = "0007-add_corretto_java11_update_8",
    author = "poad"
  )
  def migrate0007(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("11.0.8.10.1", "linux-x64.tar.gz"),
      MacOSX  -> ("11.0.8.10.1", "macosx-x64.tar.gz"),
      Windows -> ("11.0.8.10.1", "windows-x64-jdk.zip")
    ).map {
        case (platform, (version, suffix)) =>
          Version(
            "java",
            "11.0.8-amzn",
            s"https://corretto.aws/downloads/resources/$version/amazon-corretto-$version-$suffix",
            platform,
            Some(Amazon)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "11.0.7-amzn", version.platform)
      }

  @ChangeSet(
    order = "0008",
    id = "0008-add_corretto_java8_update_265",
    author = "eddumelendez"
  )
  def migrate0008(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("8.265.01.1", "linux-x64.tar.gz"),
      MacOSX  -> ("8.265.01.1", "macosx-x64.tar.gz"),
      Windows -> ("8.265.01.1", "windows-x64-jdk.zip")
    ).map {
        case (platform, (version, suffix)) =>
          Version(
            "java",
            "8.0.265-amzn",
            s"https://corretto.aws/downloads/resources/$version/amazon-corretto-$version-$suffix",
            platform,
            Some(Amazon)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8.0.262-amzn", version.platform)
      }

  @ChangeSet(
    order = "0009",
    id = "0009-add_corretto-8-11-linuxarm64",
    author = "pnavais"
  )
  def migrate0009(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.262-amzn",
        "https://corretto.aws/downloads/resources/8.262.10.1/amazon-corretto-8.262.10.1-linux-aarch64.tar.gz",
        LinuxARM64,
        Some(Amazon)
      ),
      Version(
        "java",
        "11.0.8-amzn",
        "https://corretto.aws/downloads/resources/11.0.8.10.1/amazon-corretto-11.0.8.10.1-linux-aarch64.tar.gz",
        LinuxARM64,
        Some(Amazon)
      )
    ).validate()
      .insert()
  }

}
