package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "046")
class JReleaserMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_jreleaser_candidate",
    author = "aalmiray"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "jreleaser",
      name = "JReleaser",
      description =
        "JReleaser is a release automation tool for Java projects. Its goal is to simplify creating releases and publishing artifacts to multiple package managers while providing customizable options.",
      websiteUrl = "https://jreleaser.org"
    ).insert()
}
