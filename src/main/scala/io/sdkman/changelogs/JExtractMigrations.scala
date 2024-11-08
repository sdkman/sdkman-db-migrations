package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "087")
class JExtractMigrations {
  @ChangeSet(
    order = "006",
    id = "006_add-jextract-22.6",
    author = "helpermethod"
  )
  def migration005(implicit db: MongoDatabase): Unit = {
    List(
      (LinuxARM64, "linux-aarch64"),
      (Linux64, "linux-x64"),
      (MacARM64, "macos-aarch64"),
      (MacOSX, "macos-x64"),
      (Windows, "windows-x64")
    ).foreach {
      case (platform, platformIdentifier) =>
        Version(
          candidate = "jextract",
          version = "22.ea.6",
          url =
            s"https://download.java.net/java/early_access/jextract/22/6/openjdk-22-jextract+6-47_${platformIdentifier}_bin.tar.gz",
          platform = platform
        ).validate()
          .insert()
    }

    setCandidateDefault("jextract", "22.ea.6")
  }
}
