package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{
  Linux64,
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
    order = "065",
    id = "065-add_openjdk_java_15-ea-34",
    author = "eddumelendez"
  )
  def migrate065(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "openjdk-15-ea+34_linux-x64_bin.tar.gz",
      MacOSX  -> "openjdk-15-ea+34_osx-x64_bin.tar.gz",
      Windows -> "openjdk-15-ea+34_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.ea.34-open",
            s"https://download.java.net/java/early_access/jdk15/34/GPL/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "15.ea.33-open", version.platform)
      }

  @ChangeSet(
    order = "066",
    id = "066-add_openjdk_java_16-ea-8",
    author = "eddumelendez"
  )
  def migrate066(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "openjdk-16-ea+8_linux-x64_bin.tar.gz",
      MacOSX  -> "openjdk-16-ea+8_osx-x64_bin.tar.gz",
      Windows -> "openjdk-16-ea+8_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "16.ea.8-open",
            s"https://download.java.net/java/early_access/jdk16/8/GPL/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "16.ea.7-open", version.platform)
      }
}
