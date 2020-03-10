package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "004")
class JBakeMigrations {

  @ChangeSet(
    order = "001",
    id = "001_clear_out_orphaned_links",
    author = "marc0der"
  )
  def migration001(implicit db: MongoDatabase) = removeAllVersions("jbake")
}
