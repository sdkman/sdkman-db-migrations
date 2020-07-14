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
    order = "054",
    id = "054-add_openjdk_java_15-ea-30",
    author = "eddumelendez"
  )
  def migrate054(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.30-open",
        "https://download.java.net/java/early_access/jdk15/30/GPL/openjdk-15-ea+30_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.30-open",
        "https://download.java.net/java/early_access/jdk15/30/GPL/openjdk-15-ea+30_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.30-open",
        "https://download.java.net/java/early_access/jdk15/30/GPL/openjdk-15-ea+30_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.29-open", _)
    )
  }

  @ChangeSet(
    order = "055",
    id = "055-add_openjdk_java_16-ea-4",
    author = "eddumelendez"
  )
  def migrate055(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "16.ea.4-open",
        "https://download.java.net/java/early_access/jdk16/4/GPL/openjdk-16-ea+4_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "16.ea.4-open",
        "https://download.java.net/java/early_access/jdk16/4/GPL/openjdk-16-ea+4_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "16.ea.4-open",
        "https://download.java.net/java/early_access/jdk16/4/GPL/openjdk-16-ea+4_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "16.ea.3-open", _)
    )
  }

  @ChangeSet(
    order = "056",
    id = "056-add_openjdk_java_14.0.2",
    author = "eddumelendez"
  )
  def migrate056(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "openjdk-14.0.2_linux-x64_bin.tar.gz",
      MacOSX  -> "openjdk-14.0.2_osx-x64_bin.tar.gz",
      Windows -> "openjdk-14.0.2_windows-x64_bin.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "14.0.2-open",
            s"https://download.java.net/java/GA/jdk14.0.2/205943a0976c4ed48cb16f1043c5c647/11/GPL/$binary",
            platform,
            Some(OpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "14.0.1-open", version.platform)
      }

  @ChangeSet(
    order = "057",
    id = "057-add_openjdk_java_15-ea-31",
    author = "eddumelendez"
  )
  def migrate057(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.31-open",
        "https://download.java.net/java/early_access/jdk15/31/GPL/openjdk-15-ea+31_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.31-open",
        "https://download.java.net/java/early_access/jdk15/31/GPL/openjdk-15-ea+31_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.31-open",
        "https://download.java.net/java/early_access/jdk15/31/GPL/openjdk-15-ea+31_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.30-open", _)
    )
  }
}
