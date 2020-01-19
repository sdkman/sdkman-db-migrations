package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "024")
class JBangMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_jbang_candidate",
    author = "maxandersen"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "jbang",
      name = "J'Bang",
      description =
        "J'Bang makes it easy to use Java for scripting. It lets you use a single file for code and dependency management and allows you to run it directly.",
      websiteUrl = "http://github.com/maxandersen/jbang/"
    ).insert()
}
