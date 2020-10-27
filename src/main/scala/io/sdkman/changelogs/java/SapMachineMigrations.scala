package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Linux64, MacOSX, Version, Windows, _}

@ChangeLog(order = "023")
class SapMachineMigrations {

  @ChangeSet(order = "0002", id = "0002-add_sapmchn_13_0_2", author = "poad")
  def migrate0002(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "13.0.2-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-13.0.2/sapmachine-jdk-13.0.2_linux-x64_bin.tar.gz",
        Linux64,
        Some(SAP)
      ),
      Version(
        "java",
        "13.0.2-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-13.0.2/sapmachine-jdk-13.0.2_windows-x64_bin.zip",
        Windows,
        Some(SAP)
      ),
      Version(
        "java",
        "13.0.2-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-13.0.2/sapmachine-jdk-13.0.2_osx-x64_bin.tar.gz",
        MacOSX,
        Some(SAP)
      )
    ).validate().insert()
  }

  @ChangeSet(
    order = "0011",
    id = "0011-add_sapmchn_jdk_14.0.2",
    author = "poad"
  )
  def migrate0011(implicit db: MongoDatabase) =
    Map(
      Linux64 -> "linux-x64_bin.tar.gz",
      MacOSX  -> "osx-x64_bin.tar.gz",
      Windows -> "windows-x64_bin.zip"
    ).map {
        case (platform, suffix) =>
          toVersion(platform, suffix, "14.0.2")
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "14.0.1-sapmchn", version.platform)
      }

  private def toVersion(platform: Platform, suffix: String, version: String) =
    Version(
      "java",
      s"$version-sapmchn",
      s"https://github.com/SAP/SapMachine/releases/download/sapmachine-$version/sapmachine-jdk-${version}_$suffix",
      platform,
      Some(SAP)
    )

  @ChangeSet(
    order = "0017",
    id = "0017-add_sapmchn_jdk_11.0.9",
    author = "poad"
  )
  def migrate0017(implicit db: MongoDatabase) =
    Map(
      Linux64 -> "linux-x64_bin.tar.gz",
      Windows -> "windows-x64_bin.zip"
    ).map {
        case (platform, suffix) =>
          toVersion(platform, suffix, "11.0.9")
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "11.0.8-sapmchn", version.platform)
      }

  @ChangeSet(
    order = "0018",
    id = "0018-add_sapmchn_jdk_15.0.1",
    author = "poad"
  )
  def migrate0018(implicit db: MongoDatabase) =
    Map(
      Linux64 -> "linux-x64_bin.tar.gz",
      Windows -> "windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          toVersion(platform, binary, "11.0.9")
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "15.0.0-sapmchn", version.platform)
      }
}
