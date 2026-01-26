package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "048")
class JdkMissionControlMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_mission_control",
    author = "marc0der"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "jmc",
      name = "JDK Mission Control",
      description =
        "Java Flight Recorder and JDK Mission Control together create a complete tool chain to continuously collect " +
          "low level and detailed runtime information enabling after-the-fact incident analysis. JDK Mission Control " +
          "is an advanced set of tools that enables efficient and detailed analysis of the extensive of data " +
          "collected by Java Flight Recorder. The tool chain enables developers and administrators to collect and " +
          "analyze data from Java applications running locally or deployed in production environments.",
      websiteUrl =
        "https://www.oracle.com/java/technologies/jdk-mission-control.html"
    ).insert()

  @ChangeSet(
    order = "002",
    id = "002-add-corretto-8.0.0.1",
    author = "eddumelendez"
  )
  def migrate002(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "amazon-corretto-jmc-8.0.0.1-linux-x64.tar.gz",
      MacOSX  -> "amazon-corretto-jmc-8.0.0.1-mac-x64.tar.gz"
    ).map {
        case (platform, binary) =>
          Version(
            "jmc",
            "8.0.0.1-amzn",
            s"https://corretto.aws/downloads/resources/jmc/8.0.0.1/$binary",
            platform,
            Some(Amazon)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "003",
    id = "003-add-latest-version-of-each-distribution",
    author = "sciencesakura"
  )
  def migrate003(implicit db: MongoDatabase): Unit = {
    List(
      ("adpt", Linux64, "org.openjdk.jmc-9.1.1-linux.gtk.x86_64.tar.gz"),
      ("adpt", LinuxARM64, "org.openjdk.jmc-9.1.1-linux.gtk.aarch64.tar.gz"),
      ("adpt", MacOSX, "org.openjdk.jmc-9.1.1-macosx.cocoa.x86_64.tar.gz"),
      ("adpt", MacARM64, "org.openjdk.jmc-9.1.1-macosx.cocoa.aarch64.tar.gz"),
      ("adpt", Windows, "org.openjdk.jmc-9.1.1-win32.win32.x86_64.zip"),
      ("amzn", Linux64, "amazon-corretto-jmc-8.1.1.1-linux-x64.tar.gz"),
      ("amzn", MacOSX, "amazon-corretto-jmc-8.1.1.1-mac-x64.tar.gz"),
      ("amzn", Windows, "amazon-corretto-jmc-8.1.1.1-windows-x64.zip"),
      ("librca", Linux64, "bellsoft-lmc8.3.0-linux-amd64.tar.gz"),
      ("librca", MacOSX, "bellsoft-lmc8.3.0-macos-amd64.tar.gz"),
      ("librca", MacARM64, "bellsoft-lmc8.3.0-macos-aarch64.tar.gz"),
      ("librca", Windows, "bellsoft-lmc8.3.0-windows-amd64.zip"),
      ("zulu", Linux64, "zmc9.1.1.35-ca-linux_x64.tar.gz"),
      ("zulu", LinuxARM64, "zmc9.1.1.35-ca-linux_aarch64.tar.gz"),
      ("zulu", MacOSX, "zmc9.1.1.35-ca-macos_x64.tar.gz"),
      ("zulu", MacARM64, "zmc9.1.1.35-ca-macos_aarch64.tar.gz"),
      ("zulu", Windows, "zmc9.1.1.35-ca-win_x64.zip")
    ).map {
        case ("adpt", platform, binary) =>
          Version(
            "jmc",
            "9.1.1-adpt",
            s"https://github.com/adoptium/jmc-build/releases/download/9.1.1/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
        case ("amzn", platform, binary) =>
          Version(
            "jmc",
            "8.1.1.1-amzn",
            s"https://corretto.aws/downloads/resources/jmc/8.1.1.1/$binary",
            platform,
            Some(Amazon)
          )
        case ("librca", platform, binary) =>
          Version(
            "jmc",
            "8.3.0-librca",
            s"https://download.bell-sw.com/lmc/8.3.0/$binary",
            platform,
            Some(Liberica)
          )
        case ("zulu", platform, binary) =>
          Version(
            "jmc",
            "9.1.1-zulu",
            s"https://cdn.azul.com/zmc/bin/$binary",
            platform,
            Some(Zulu)
          )
        case _ => throw new IllegalArgumentException("Invalid version format")
      }
      .validate()
      .insert()
    setCandidateDefault("jmc", "9.1.1-zulu")
  }

  @ChangeSet(
    order = "004",
    id = "004-add-9.1.1.1-zulu",
    author = "sciencesakura"
  )
  def migrate004(implicit db: MongoDatabase): Unit = {
    List(
      (Linux64, "zmc9.1.1.1.41-ca-linux_x64.tar.gz"),
      (LinuxARM64, "zmc9.1.1.1.41-ca-linux_aarch64.tar.gz"),
      (MacOSX, "zmc9.1.1.1.41-ca-macos_x64.tar.gz"),
      (MacARM64, "zmc9.1.1.1.41-ca-macos_aarch64.tar.gz"),
      (Windows, "zmc9.1.1.1.41-ca-win_x64.zip")
    ).map(
        it =>
          Version(
            "jmc",
            "9.1.1.1-zulu",
            s"https://cdn.azul.com/zmc/bin/${it._2}",
            it._1,
            Some(Zulu)
          )
      )
      .validate()
      .insert()
    setCandidateDefault("jmc", "9.1.1.1-zulu")
  }
}
