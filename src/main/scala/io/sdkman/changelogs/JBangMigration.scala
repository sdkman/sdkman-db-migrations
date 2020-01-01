package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "010")
class JBangMigrations {

  @ChangeSet(order = "001", id = "001_add_jbang_candidate", author = "maxandersen")
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "jbang",
      name = "J'Bang",
      description = "J'Bang makes it easy to use Java for scripting. `jbang` lets you use a single file for code and dependency management and let you run directly.",
      websiteUrl = "http://github.com/maxandersen/jbang/").insert()
  }
}
