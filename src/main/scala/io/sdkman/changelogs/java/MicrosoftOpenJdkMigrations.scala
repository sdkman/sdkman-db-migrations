package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{
  Linux64,
  MacOSX,
  Microsoft,
  Version,
  Windows
}

@ChangeLog(order = "047")
class MicrosoftOpenJdkMigrations {

  @ChangeSet(
    order = "001",
    id = "001-add-microsoft-11.0.10.9",
    author = "eddumelendez"
  )
  def migrate084(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "microsoft-jdk-11.0.10.9-linux-x64.tar.gz",
      MacOSX  -> "microsoft-jdk-11.0.10.9-macos-x64.tar.gz",
      Windows -> "microsoft-jdk-11.0.10.9-windows-x64.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.10.9-ms",
            s"https://aka.ms/download-jdk/$binary",
            platform,
            Some(Microsoft)
          )
      }
      .toList
      .validate()
      .insert()

}
