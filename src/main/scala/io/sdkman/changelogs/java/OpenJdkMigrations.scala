package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{
  Linux64,
  LinuxARM64,
  MacOSX,
  OpenJDK,
  Version,
  Windows,
  removeVersion
}

@ChangeLog(order = "022")
class OpenJdkMigrations {

  @ChangeSet(
    order = "061",
    id = "061-remove_openjdk_java_14.0.2-b11",
    author = "poad"
  )
  def migrate061(implicit db: MongoDatabase): Unit =
    Seq(
      Linux64,
      MacOSX,
      Windows
    ).foreach { platform =>
      removeVersion("java", "14.0.2-open", platform)
    }

  @ChangeSet(
    order = "062",
    id = "062-readd_openjdk_java_14.0.2",
    author = "poad"
  )
  def migrate062(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "openjdk-14.0.2_linux-x64_bin.tar.gz",
      MacOSX  -> "openjdk-14.0.2_osx-x64_bin.tar.gz",
      Windows -> "openjdk-14.0.2_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "14.0.2-open",
            s"https://download.java.net/java/GA/jdk14.0.2/205943a0976c4ed48cb16f1043c5c647/12/GPL/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "069",
    id = "069-update_openjdk_8_0_265",
    author = "andrebrait"
  )
  def migrate069(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "jdk8u265-b01/OpenJDK8U-jdk_x64_linux_8u265b01.tar.gz",
      Windows -> "jdk8u265-b01/OpenJDK8U-jdk_x64_windows_8u265b01.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.265-open",
            s"https://github.com/AdoptOpenJDK/openjdk8-upstream-binaries/releases/download/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion(version.candidate, "8.0.252-open", version.platform)
      }

  @ChangeSet(
    order = "078",
    id = "078-add_openjdk_java_16-loom-6",
    author = "soberich"
  )
  def migrate078(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "openjdk-16-loom+6-105_linux-x64_bin.tar.gz",
      MacOSX  -> "openjdk-16-loom+6-105_osx-x64_bin.tar.gz",
      Windows -> "openjdk-16-loom+6-105_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "16.ea.6.lm-open",
            s"https://download.java.net/java/early_access/loom/6/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "081",
    id = "081-add_openjdk_java_16-pma-6",
    author = "eddumelendez"
  )
  def migrate081(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "openjdk-16-panama+2-193_linux-x64_bin.tar.gz",
      MacOSX  -> "openjdk-16-panama+2-193_osx-x64_bin.tar.gz",
      Windows -> "openjdk-16-panama+2-193_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "16.ea.2.pma-open",
            s"https://download.java.net/java/early_access/panama/2/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "083",
    id = "083-add_openjdk_java_11_linux_windows",
    author = "eddumelendez"
  )
  def migrate083(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "openjdk-11.0.2_linux-x64_bin.tar.gz",
      Windows -> "openjdk-11.0.2_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.2-open",
            s"https://download.java.net/java/GA/jdk11/9/GPL/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "11.0.8-open", version.platform)
      }
  @ChangeSet(
    order = "084",
    id = "084-add_openjdk_java_15.0.1",
    author = "poad"
  )
  def migrate084(implicit db: MongoDatabase): Unit =
    Map(
      LinuxARM64 -> "openjdk-15.0.1_linux-aarch64_bin.tar.gz",
      Linux64    -> "openjdk-15.0.1_linux-x64_bin.tar.gz",
      MacOSX     -> "openjdk-15.0.1_osx-x64_bin.tar.gz",
      Windows    -> "openjdk-15.0.1_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.0.1-open",
            s"https://download.java.net/java/GA/jdk15.0.1/51f4f36ad4ef43e39d0dfdbaf6549e32/9/GPL/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "15-open", version.platform)
      }

  @ChangeSet(
    order = "087",
    id = "087-add_openjdk_java_16-ea+23",
    author = "eddumelendez"
  )
  def migrate087(implicit db: MongoDatabase): Unit =
    Map(
      LinuxARM64 -> "openjdk-16-ea+23_linux-aarch64_bin.tar.gz",
      Linux64    -> "openjdk-16-ea+23_linux-x64_bin.tar.gz",
      MacOSX     -> "openjdk-16-ea+23_osx-x64_bin.tar.gz",
      Windows    -> "openjdk-16-ea+23_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "16.ea.23-open",
            s"https://download.java.net/java/early_access/jdk16/23/GPL/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "16.ea.22-open", version.platform)
      }

}
