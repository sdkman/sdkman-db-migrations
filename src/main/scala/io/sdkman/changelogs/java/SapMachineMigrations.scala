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
}
