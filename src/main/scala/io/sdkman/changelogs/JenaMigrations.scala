package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import org.bson.Document

@ChangeLog(order = "100")
class JenaMigrations {

  val CandidateName = "jena"

  @ChangeSet(
    order = "001",
    id = "001-add_jena_candidate",
    author = "berezovskyi"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = CandidateName,
      name = "Apache Jena",
      description =
        "Apache Jena (or Jena in short) is a free and open source Java framework for building semantic web and Linked Data applications. The framework is composed of different APIs and CLI tools interacting together to process RDF data.",
      websiteUrl = "https://jena.apache.org/"
    ).insert()
  }
  @ChangeSet(
    order = "003",
    id = "003-add_jena_versions",
    author = "berezovskyi"
  )
  def migration003(implicit db: MongoDatabase): Document = {
    List(
      "2.12.1",
      "2.13.0",
      "3.0.1",
      "3.1.1",
      "3.2.0",
      "3.3.0",
      "3.4.0",
      "3.5.0",
      "3.6.0",
      "3.7.0",
      "3.8.0",
      "3.9.0",
      "3.10.0",
      "3.11.0",
      "3.12.0",
      "3.13.1",
      "3.14.0",
      "3.15.0",
      "3.16.0",
      "3.17.0",
      "4.0.0",
      "4.1.0",
      "4.2.0",
      "4.3.0",
      "4.3.1",
      "4.3.2",
      "4.4.0",
      "4.5.0",
      "4.6.0",
      "4.6.1"
    ).map(
        version =>
          Version(
            candidate = CandidateName,
            version = version,
            url =
              s"http://archive.apache.org/dist/jena/binaries/apache-jena-$version.zip"
          )
      )
      .validate()
      .insert()
    setCandidateDefault(CandidateName, "4.6.1")
  }

}
