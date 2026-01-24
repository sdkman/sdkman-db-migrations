package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "085")
class NaftahMigrations {

  val CandidateName = "naftah"

  @ChangeSet(
    order = "001",
    id = "001_add_naftah_candidate",
    author = "chakib-daii"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = CandidateName,
      name = "Naftah Programming Language",
      description =
        """
          |Write programs in Tunisian and Arabic naturally—just like living in Naftah.
          |
          |Naftah is a modern programming language built on top of the JVM, with first-class support for Arabic and Tunisian scripts.
          |It brings the Arabic language into modern programming, aiming to make code more natural, readable, and expressive for Arabic-speaking developers.
          |
          |It is both educational and practical, making it suitable for beginners learning to program as well as experienced developers building real-world applications.
          |""".stripMargin,
      websiteUrl = "https://naftah.daiitech.org"
    ).insert()
  }

  @ChangeSet(
    order = "002",
    id = "002_add_naftah_first_version_as_default_candidate",
    author = "chakib-daii"
  )
  def migration002(implicit db: MongoDatabase): Unit = {
    Version(
      candidate = CandidateName,
      version = "0.1.0",
      url =
        s"https://github.com/Chakib-DAII/Naftah/releases/download/0.1.0/naftah-lang-0.1.0-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
