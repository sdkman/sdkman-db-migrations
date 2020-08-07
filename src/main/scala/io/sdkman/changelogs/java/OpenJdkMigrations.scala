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
    order = "067",
    id = "067-add_openjdk_java_15-ea-35",
    author = "eddumelendez"
  )
  def migrate067(implicit db: MongoDatabase): Unit =
    Map(
      LinuxARM64 -> "openjdk-15_linux-aarch64_bin.tar.gz",
      Linux64    -> "openjdk-15_linux-x64_bin.tar.gz",
      MacOSX     -> "openjdk-15_osx-x64_bin.tar.gz",
      Windows    -> "openjdk-15_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.ea.35-open",
            s"https://download.java.net/java/GA/jdk15/779bf45e88a44cbd9ea6621d33e33db1/35/GPL/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "15.ea.34-open", version.platform)
      }

  @ChangeSet(
    order = "068",
    id = "068-add_openjdk_java_16-ea-9",
    author = "eddumelendez"
  )
  def migrate068(implicit db: MongoDatabase): Unit =
    Map(
      LinuxARM64 -> "openjdk-16-ea+9_linux-aarch64_bin.tar.gz",
      Linux64    -> "openjdk-16-ea+9_linux-x64_bin.tar.gz",
      MacOSX     -> "openjdk-16-ea+9_osx-x64_bin.tar.gz",
      Windows    -> "openjdk-16-ea+9_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "16.ea.9-open",
            s"https://download.java.net/java/early_access/jdk16/9/GPL/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "16.ea.8-open", version.platform)
      }
}
