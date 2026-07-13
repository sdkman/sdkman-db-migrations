package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "090")
class JRubyMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_jruby",
    author = "headius"
  )
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "jruby",
      name = "JRuby",
      description = "JRuby: Ruby for the JVM.",
      websiteUrl = "https://jruby.org/",
      distribution = "UNIVERSAL"
    ).insert()
  }
}
