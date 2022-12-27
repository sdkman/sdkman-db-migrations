package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "074")
class SkeletalMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_skeletal_candidate",
    author = "cbmarcum"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "skeletal",
      name = "Skeletal",
      description =
        "Skeletal is a tool that allows you to create a new project structure for any framework or library for which the tool has a template.",
      websiteUrl = "https://github.com/cbmarcum/skeletal"
    ).insert()
}
