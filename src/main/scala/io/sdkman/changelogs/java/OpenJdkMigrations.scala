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
  hideVersion,
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
    order = "093",
    id = "093-add_openjdk_java_16-loom-9",
    author = "eddumelendez"
  )
  def migrate093(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "openjdk-16-loom+9-316_linux-x64_bin.tar.gz",
      MacOSX  -> "openjdk-16-loom+9-316_osx-x64_bin.tar.gz",
      Windows -> "openjdk-16-loom+9-316_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "16.ea.9.lm-open",
            s"https://download.java.net/java/early_access/loom/9/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "16.ea.7.lm-open", version.platform)
      }

  @ChangeSet(
    order = "096",
    id = "096-add_openjdk_java_16-ea+28",
    author = "eddumelendez"
  )
  def migrate096(implicit db: MongoDatabase): Unit =
    Map(
      LinuxARM64 -> "openjdk-16-ea+28_linux-aarch64_bin.tar.gz",
      Linux64    -> "openjdk-16-ea+28_linux-x64_bin.tar.gz",
      MacOSX     -> "openjdk-16-ea+28_osx-x64_bin.tar.gz",
      Windows    -> "openjdk-16-ea+28_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "16.ea.28-open",
            s"https://download.java.net/java/early_access/jdk16/28/GPL/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "16.ea.27-open", version.platform)
      }

  @ChangeSet(
    order = "097",
    id = "097-add_openjdk_java_17-ea+1",
    author = "mdeinum"
  )
  def migrate097(implicit db: MongoDatabase): Unit =
    Map(
      LinuxARM64 -> "openjdk-17-ea+1_linux-aarch64_bin.tar.gz",
      Linux64    -> "openjdk-17-ea+1_linux-x64_bin.tar.gz",
      MacOSX     -> "openjdk-17-ea+1_osx-x64_bin.tar.gz",
      Windows    -> "openjdk-17-ea+1_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "17.ea.1-open",
            s"https://download.java.net/java/early_access/jdk17/1/GPL/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "101",
    id = "101-hide-java-versions",
    author = "eddumelendez"
  )
  def migrate100(implicit db: MongoDatabase): Unit =
    Seq("16.ea.31-open", "17.ea.4-open")
      .foreach(version => hideVersion("java", version))

  @ChangeSet(
    order = "102",
    id = "102-hide-java-versions",
    author = "eddumelendez"
  )
  def migrate102(implicit db: MongoDatabase): Unit =
    hideVersion("java", "16.ea.9.lm-open")

  @ChangeSet(
    order = "103",
    id = "103-hide-java-versions",
    author = "eddumelendez"
  )
  def migrate103(implicit db: MongoDatabase): Unit =
    hideVersion("java", "15.0.1-open")

  @ChangeSet(
    order = "104",
    id = "104-hide-non-lts-java-versions",
    author = "eddumelendez"
  )
  def migrate104(implicit db: MongoDatabase): Unit =
    Seq(
      "9.0.4-open",
      "10.0.2-open",
      "12.0.2-open",
      "13.0.2-open",
      "14.0.2-open"
    ).foreach(version => hideVersion("java", version))

  @ChangeSet(
    order = "105",
    id = "105-hide-ea-java-versions",
    author = "eddumelendez"
  )
  def migrate105(implicit db: MongoDatabase): Unit =
    Seq(
      "17.ea.5-open",
      "17.ea.6-open",
      "17.ea.7-open",
      "17.ea.8-open",
      "16.ea.32-open",
      "16.ea.33-open",
      "16.ea.34-open",
      "16.ea.35-open"
    ).foreach(version => hideVersion("java", version))

  @ChangeSet(
    order = "106",
    id = "106-hide-ea-java-versions",
    author = "eddumelendez"
  )
  def migrate106(implicit db: MongoDatabase): Unit =
    Seq(
      "17.ea.9-open",
      "17.ea.10-open",
      "17.ea.11-open",
      "17.ea.12-open"
    ).foreach(version => hideVersion("java", version))

}
