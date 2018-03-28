package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "005")
class CleanupMigrations {

  @ChangeSet(order = "001", id = "001_remove_griffon_and_kobalt", author = "marc0der")
  def migration001(implicit db: MongoDatabase) = {
    List("griffon", "kobalt").foreach { candidate =>
      removeCandidate(candidate)
      removeAllVersions(candidate)
    }
  }

  @ChangeSet(order = "002", id = "002_remove_vertx_orphans", author = "marc0der")
  def migration002(implicit db: MongoDatabase) = {
    List("1.1.0.final", "1.2.0.final", "1.2.1.final", "1.2.2.final").foreach { version =>
      removeVersion("vertx", version)
    }
  }

  @ChangeSet(order = "003", id = "003-clean_up_openjdk_variants", author = "marc0der")
  def migrate003(implicit db: MongoDatabase) = {
    List("9u181-openjdk", "9.0.1-zulu", "9.0.0-zulu", "8u144-zulu", "8u144-openjdk", "8u131-zulu", "10u23-openjdk").foreach { version =>
      List(MacOSX, Windows, Linux).foreach { platform =>
        removeVersion("java", version, platform)
      }
    }
  }
}
