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
    id = "003-add-zulu-9.1.1",
    author = "sciencesakura"
  )
  def migrate003(implicit db: MongoDatabase): Unit =
    Map(
      Linux64    -> "zmc9.1.1.35-ca-linux_x64.tar.gz",
      LinuxARM64 -> "zmc9.1.1.35-ca-linux_aarch64.tar.gz",
      MacOSX     -> "zmc9.1.1.35-ca-macos_x64.tar.gz",
      MacARM64   -> "zmc9.1.1.35-ca-macos_aarch64.tar.gz",
      Windows    -> "zmc9.1.1.35-ca-win_x64.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "jmc",
            "9.1.1-zulu",
            s"https://cdn.azul.com/zmc/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()

}
