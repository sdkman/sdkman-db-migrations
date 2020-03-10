package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "005")
class CleanupMigrations {

  @ChangeSet(
    order = "001",
    id = "001_remove_griffon_and_kobalt",
    author = "marc0der"
  )
  def migration001(implicit db: MongoDatabase) = {
    List("griffon", "kobalt").foreach { candidate =>
      removeCandidate(candidate)
      removeAllVersions(candidate)
    }
  }

  @ChangeSet(
    order = "002",
    id = "002_remove_vertx_orphans",
    author = "marc0der"
  )
  def migration002(implicit db: MongoDatabase) = {
    List("1.1.0.final", "1.2.0.final", "1.2.1.final", "1.2.2.final").foreach {
      version =>
        removeVersion("vertx", version)
    }
  }

  @ChangeSet(
    order = "006",
    id = "006-clean_up_openjdk_variants",
    author = "marc0der"
  )
  def migrate006(implicit db: MongoDatabase) = {
    List(
      "9u181-openjdk",
      "9.0.1-zulu",
      "9.0.0-zulu",
      "8u144-zulu",
      "8u144-openjdk",
      "8u131-zulu",
      "10u23-openjdk"
    ).foreach { version =>
      List(MacOSX, Windows, Linux64).foreach { platform =>
        removeVersion("java", version, platform)
      }
    }
  }

  @ChangeSet(
    order = "007",
    id = "007-temporary_remove_openjdk_10_osx",
    author = "marc0der"
  )
  def migrate007(implicit db: MongoDatabase) = {
    List("9.0.4-openjdk", "10.0.0-openjdk").foreach { version =>
      removeVersion("java", version, MacOSX)
    }
  }

  @ChangeSet(
    order = "008",
    id = "008-remove-broken-kscript-2_7_0",
    author = "hho"
  )
  def migrate008(implicit db: MongoDatabase) = {
    removeVersion("kscript", "2.7.0")
  }

  @ChangeSet(order = "009", id = "009-remove-oracle-java", author = "marc0der")
  def migrate009(implicit db: MongoDatabase) =
    Seq(Linux32, Linux64, MacOSX, Windows)
      .foreach(platform => removeVersion("java", "8.0.201-oracle", platform))
}
