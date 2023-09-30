package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "082")
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
    id = "002_add_jextract_candidate",
    author = "helpermethod"
  )
  def migration002(implicit db: MongoDatabase): Unit = {
    List(
      ("19-jextract+2-3", 2),
      ("20-jextract+1-2", 1),
      ("21-jextract+1-2", 1)
    ).map {
      case (version, patchNumber) =>
        List(
          (Linux64, "linux"),
          (MacOSX, "macos"),
          (Windows, "windows")
        ).map {
          case (platform, platformIdentifier) =>
            Version(
              "jextract",
              version,
              s"https://download.java.net/java/early_access/jextract/$patchNumber/openjdk-${version}_${platformIdentifier}-x64_bin.tar.gz",
              platform
            ).validate()
              .insert()
        }
    }
  }
}
