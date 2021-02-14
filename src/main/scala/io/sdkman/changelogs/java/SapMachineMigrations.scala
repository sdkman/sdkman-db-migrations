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
    order = "0021",
    id = "0021-add_sapmchn_jdk_15.0.1",
    author = "eddumelendez"
  )
  def migrate0021(implicit db: MongoDatabase) =
    Map(
      Linux64 -> "linux-x64_bin.tar.gz",
      MacOSX  -> "osx-x64_bin.tar.gz",
      Windows -> "windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          toVersion(platform, binary, "15.0.1")
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "0022",
    id = "0022-remove_sapmchn_jdk_11.0.9.0",
    author = "poad"
  )
  def migrate0022(implicit db: MongoDatabase) =
    Set(Linux64, Windows, MacOSX)
      .foreach { platform =>
        removeVersion("java", "11.0.9-sapmchn", platform)
      }

  @ChangeSet(
    order = "0023",
    id = "0023-add_sapmchn_jdk_11.0.9_1",
    author = "poad"
  )
  def migrate0023(implicit db: MongoDatabase) =
    Map(
      Linux64 -> "linux-x64_bin.tar.gz",
      MacOSX  -> "osx-x64_bin.tar.gz",
      Windows -> "windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.9-sapmchn",
            s"https://github.com/SAP/SapMachine/releases/download/sapmachine-11.0.9.1/sapmachine-jdk-11.0.9.1_$binary",
            platform,
            Some(SAP)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "024",
    id = "024-hide-java-versions",
    author = "eddumelendez"
  )
  def migrate024(implicit db: MongoDatabase): Unit =
    hideVersion("java", "11.0.9-sapmchn")

  @ChangeSet(
    order = "025",
    id = "025-hide-old-java-versions",
    author = "eddumelendez"
  )
  def migrate025(implicit db: MongoDatabase): Unit =
    Seq(
      "11.0.9.1-sapmchn",
      "12.0.2-sapmchn",
      "13.0.2-sapmchn",
      "14.0.2-sapmchn",
      "15.0.1-sapmchn"
    ).foreach(version => hideVersion("java", version))
}
