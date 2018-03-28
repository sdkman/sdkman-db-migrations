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
}
