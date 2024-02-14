package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import org.bson.Document

@ChangeLog(order = "084")
class GraceMigrations {

  val CandidateName = "grace"

  @ChangeSet(
    order = "001",
    id = "001_add_grace_candidate",
    author = "rainboyan"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = CandidateName,
      name = "Grace Framework",
      description =
        "Grace is a powerful open-source, One-Person web application Framework to help developers build Spring Boot applications rapidly using the Groovy programming language. Grace is a fork of Grails 5 that started development in early 2022.",
      websiteUrl = "https://graceframework.org"
    ).insert()
  }

  @ChangeSet(
    order = "002",
    id = "002_add_new_grace_versions_and_update_default",
    author = "rainboyan"
  )
  def migration002(implicit db: MongoDatabase): Document = {
    List(
      "2022.0.0",
      "2022.0.1",
      "2022.0.2",
      "2022.0.3",
      "2022.0.4",
      "2022.0.5",
      "2022.1.0"
    ).map(
        version =>
          Version(
            candidate = CandidateName,
            version = version,
            url =
              s"https://github.com/graceframework/grace-framework/releases/download/v$version/grace-$version.zip"
          )
      )
      .validate()
      .insert()
    setCandidateDefault(CandidateName, "2022.1.0")
  }

}
