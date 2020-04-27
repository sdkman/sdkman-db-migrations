package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Linux64, MacOSX, Version, Windows, _}

@ChangeLog(order = "023")
class SapMachineMigrations {
  @ChangeSet(order = "0001", id = "0001-add_sapmchn_11_0_6", author = "poad")
  def migrate0001(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.6-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-11.0.6/sapmachine-jdk-11.0.6_linux-x64_bin.tar.gz",
        Linux64,
        Some(SAP)
      ),
      Version(
        "java",
        "11.0.6-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-11.0.6/sapmachine-jdk-11.0.6_windows-x64_bin.zip",
        Windows,
        Some(SAP)
      ),
      Version(
        "java",
        "11.0.6-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-11.0.6/sapmachine-jdk-11.0.6_osx-x64_bin.tar.gz",
        MacOSX,
        Some(SAP)
      )
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "11.0.4-sapmchn", platform)
    )
  }

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

  @ChangeSet(order = "0003", id = "0003-add_sapmchn_14_0_0", author = "poad")
  def migrate0003(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "14.0.0-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-14/sapmachine-jdk-14_linux-x64_bin.tar.gz",
        Linux64,
        Some(SAP)
      ),
      Version(
        "java",
        "14.0.0-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-14/sapmachine-jdk-14_windows-x64_bin.zip",
        Windows,
        Some(SAP)
      ),
      Version(
        "java",
        "14.0.0-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-14/sapmachine-jdk-14_osx-x64_bin.tar.gz",
        MacOSX,
        Some(SAP)
      )
    ).validate().insert()
  }

  @ChangeSet(order = "0004", id = "0004-add_sapmchn_11_0_7", author = "poad")
  def migrate0004(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.7-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-11.0.7/sapmachine-jdk-11.0.7_linux-x64_bin.tar.gz",
        Linux64,
        Some(SAP)
      ),
      Version(
        "java",
        "11.0.7-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-11.0.7/sapmachine-jdk-11.0.7_windows-x64_bin.zip",
        Windows,
        Some(SAP)
      ),
      Version(
        "java",
        "11.0.7-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-11.0.7/sapmachine-jre-11.0.7_osx-x64_bin.tar.gz",
        MacOSX,
        Some(SAP)
      )
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "11.0.6-sapmchn", platform)
    )
  }

  @ChangeSet(order = "0005", id = "0005-add_sapmchn_14_0_1", author = "poad")
  def migrate0005(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "14.0.1-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-14.0.1/sapmachine-jdk-14.0.1_linux-x64_bin.tar.gz",
        Linux64,
        Some(SAP)
      ),
      Version(
        "java",
        "14.0.1-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-14.0.1/sapmachine-jdk-14.0.1_windows-x64_bin.zip",
        Windows,
        Some(SAP)
      ),
      Version(
        "java",
        "14.0.1-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-14.0.1/sapmachine-jre-14.0.1_osx-x64_bin.tar.gz",
        MacOSX,
        Some(SAP)
      )
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "14.0.0-sapmchn", platform)
    )
  }

  @ChangeSet(
    order = "0006",
    id = "0006-remove_sapmchn_jre_14_0_1",
    author = "poad"
  )
  def migrate0006(implicit db: MongoDatabase) = {
    Seq(MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "14.0.1-sapmchn", platform)
    )
  }

  @ChangeSet(order = "0007", id = "0007-re-add_sapmchn_14_0_1", author = "poad")
  def migrate0007(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "14.0.1-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-14.0.1/sapmachine-jdk-14.0.1_osx-x64_bin.tar.gz",
        MacOSX,
        Some(SAP)
      )
    ).validate().insert()
  }

  @ChangeSet(
    order = "0008",
    id = "0008-remove_sapmchn_jre_11_0_7",
    author = "poad"
  )
  def migrate0008(implicit db: MongoDatabase) = {
    Seq(MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "11.0.7-sapmchn", platform)
    )
  }

  @ChangeSet(order = "0009", id = "0009-re-add_sapmchn_11.0.7", author = "poad")
  def migrate0009(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.7-sapmchn",
        "https://github.com/SAP/SapMachine/releases/download/sapmachine-11.0.7/sapmachine-jdk-11.0.7_osx-x64_bin.tar.gz",
        MacOSX,
        Some(SAP)
      )
    ).validate().insert()
  }
}
