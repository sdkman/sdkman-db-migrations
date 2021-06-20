package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Linux64, MacOSX, Microsoft, Version, Windows}

@ChangeLog(order = "047")
class MicrosoftOpenJdkMigrations {

  @ChangeSet(
    order = "003",
    id = "002-add-microsoft-16.0.1.9.1",
    author = "eddumelendez"
  )
  def migrate003(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "microsoft-jdk-16.0.1.9.1-linux-x64.tar.gz",
      MacOSX  -> "microsoft-jdk-16.0.1.9.1-macOS-x64.tar.gz",
      Windows -> "microsoft-jdk-16.0.1.9.1-windows-x64.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "16.0.1.9.1-ms",
            s"https://aka.ms/download-jdk/$binary",
            platform,
            Some(Microsoft)
          )
      }
      .toList
      .validate()
      .insert()

}
