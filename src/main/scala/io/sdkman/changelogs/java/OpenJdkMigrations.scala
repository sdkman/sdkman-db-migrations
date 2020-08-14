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
    order = "070",
    id = "070-update_openjdk_11_0_8",
    author = "andrebrait"
  )
  def migrate070(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "jdk-11.0.8+10/OpenJDK11U-jdk_x64_linux_11.0.8_10.tar.gz",
      Windows -> "jdk-11.0.8+10/OpenJDK11U-jdk_x64_windows_11.0.8_10.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.8-open",
            s"https://github.com/AdoptOpenJDK/openjdk11-upstream-binaries/releases/download/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion(version.candidate, "11.0.7-open", version.platform)
      }

  @ChangeSet(
    order = "071",
    id = "071-add_openjdk_java_15-ea-36",
    author = "eddumelendez"
  )
  def migrate071(implicit db: MongoDatabase): Unit =
    Map(
      LinuxARM64 -> "openjdk-15_linux-aarch64_bin.tar.gz",
      Linux64    -> "openjdk-15_linux-x64_bin.tar.gz",
      MacOSX     -> "openjdk-15_osx-x64_bin.tar.gz",
      Windows    -> "openjdk-15_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.ea.36-open",
            s"https://download.java.net/java/GA/jdk15/779bf45e88a44cbd9ea6621d33e33db1/36/GPL/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "15.ea.35-open", version.platform)
      }

  @ChangeSet(
    order = "072",
    id = "072-add_openjdk_java_16-ea-11",
    author = "eddumelendez"
  )
  def migrate072(implicit db: MongoDatabase): Unit =
    Map(
      LinuxARM64 -> "openjdk-16-ea+11_linux-aarch64_bin.tar.gz",
      Linux64    -> "openjdk-16-ea+11_linux-x64_bin.tar.gz",
      MacOSX     -> "openjdk-16-ea+11_osx-x64_bin.tar.gz",
      Windows    -> "openjdk-16-ea+11_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "16.ea.11-open",
            s"https://download.java.net/java/early_access/jdk16/11/GPL/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "16.ea.9-open", version.platform)
      }
}
