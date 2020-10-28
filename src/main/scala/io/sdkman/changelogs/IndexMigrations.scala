package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Indexes.{ascending, compoundIndex}

@ChangeLog(order = "038")
class IndexMigrations {
  @ChangeSet(
    order = "001",
    id = "001-create-compound-index",
    author = "helpermethod"
  )
  def migration001(implicit db: MongoDatabase) =
    db.getCollection("versions")
      .createIndex(
        compoundIndex(
          ascending("candidate"),
          ascending("platform")
        )
      )
}
