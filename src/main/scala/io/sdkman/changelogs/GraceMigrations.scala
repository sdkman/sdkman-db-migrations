package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "084")
class GraceMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_grace_candidate",
    author = "rainboyan"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "grace",
      name = "Grace",
      description =
        "An open-source and powerful One Person web application Framework to help developers quickly build Spring Boot applications written in the Groovy programing language. Grace is a forked of Grails 5.1.x that started development in early 2022.",
      websiteUrl = "https://graceframework.org"
    ).insert()
}
