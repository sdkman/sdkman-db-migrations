package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "029")
class TestMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_test_candidate",
    author = "marc0der"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = "test",
      name = "Test",
      description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
      websiteUrl = "https://example.org"
    ).insert()
  }
}
