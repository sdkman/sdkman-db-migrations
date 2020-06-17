package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "015")
class DoctoolchainMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_docToolchain",
    author = "rdmueller"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = "doctoolchain",
      name = "docToolchain",
      description =
        "docToolchain is an implementation of the docs-as-code approach for software architecture plus some additional automation. The basis of docToolchain is the philosophy that software documentation should be treated in the same way as code together with the arc42 template for software architecture.",
      websiteUrl = "https://doctoolchain.github.io/docToolchain/",
      distribution = "UNIVERSAL"
    ).insert()
  }
  @ChangeSet(
    order = "002",
    id = "002_add_docToolchain_1_2_0",
    author = "rdmueller"
  )
  def migration002(implicit db: MongoDatabase) = {
    Version(
      candidate = "doctoolchain",
      version = "1.2.0",
      url = "https://github.com/docToolchain/docToolchain/archive/v1.2.0.zip"
    ).validate()
      .insert()
    setCandidateDefault("doctoolchain", "1.2.0")
  }
}
