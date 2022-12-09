package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "046")
class JarvizMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_jarviz_candidate",
    author = "aalmiray"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "jarviz",
      name = "Jarviz",
      description =
        "Jarviz is a JAR analyzer tool. You can obtaine metadata from a JAR such as its manifest, manifest entries, bytecode versions, declarative services, and more.",
      websiteUrl = "https://github.com/kordamp/jarviz"
    ).insert()
}
