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
    order = "059",
    id = "059-add_openjdk_java_15-ea-32",
    author = "eddumelendez"
  )
  def migrate059(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "openjdk-15-ea+32_linux-x64_bin.tar.gz",
      MacOSX  -> "openjdk-15-ea+32_osx-x64_bin.tar.gz",
      Windows -> "openjdk-15-ea+32_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.ea.32-open",
            s"https://download.java.net/java/early_access/jdk15/32/GPL/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "15.ea.31-open", version.platform)
      }

  @ChangeSet(
    order = "060",
    id = "060-add_openjdk_java_16-ea-6",
    author = "eddumelendez"
  )
  def migrate060(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "openjdk-16-ea+6_linux-x64_bin.tar.gz",
      MacOSX  -> "openjdk-16-ea+6_osx-x64_bin.tar.gz",
      Windows -> "openjdk-16-ea+6_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "16.ea.6-open",
            s"https://download.java.net/java/early_access/jdk16/6/GPL/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "16.ea.5-open", version.platform)
      }
}
