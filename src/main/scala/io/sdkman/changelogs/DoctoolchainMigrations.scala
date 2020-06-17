package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "030")
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
}
