package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "087")
class JExtractMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_jextract_candidate",
    author = "helpermethod"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "jextract",
      name = "Jextract",
      description =
        "jextract is a tool which mechanically generates Java bindings from a native library headers.",
      websiteUrl = "https://jdk.java.net/jextract/"
    ).insert()

  @ChangeSet(
    order = "002",
    id = "002_add_jextract_22-jextract+5-33",
    author = "helpermethod"
  )
  def migration002(implicit db: MongoDatabase): Unit = {
    List(
      (Linux64, "linux-x64"),
      (MacARM64, "macos-aarch64"),
      (MacOSX, "macos-x64"),
      (Windows, "windows-x64")
    ).map {
      case (platform, platformIdentifier) =>
        Version(
          candidate = "jextract",
          version = "22-jextract+5-33",
          url =
            s"https://download.java.net/java/early_access/jextract/22/5/openjdk-22-jextract+5-33_${platformIdentifier}_bin.tar.gz",
          platform = platform
        ).validate()
          .insert()
    }
  }
}
