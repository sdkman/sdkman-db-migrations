package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "026")
class DottyMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_dotty_candidate",
    author = "mingchuno"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = "dotty",
      name = "Dotty",
      description =
        "Research compiler that will become Scala 3. Dotty is the project name for technologies that are considered for " +
          "inclusion in Scala 3. Scala has pioneered the fusion of object-oriented and functional programming in a typed " +
          "setting. Scala 3 will be a big step towards realizing the full potential of these ideas.",
      websiteUrl = "https://dotty.epfl.ch/"
    ).insert()
  }

  @ChangeSet(
    order = "002",
    id = "002_add_dotty_0_20_0_and_0_22_0",
    author = "mingchuno"
  )
  def migration002(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        candidate = "dotty",
        version = "0.20.0",
        url = url("0.20.0")
      ),
      Version(
        candidate = "dotty",
        version = "0.22.0",
        url = url("0.22.0")
      )
    ).validate()
      .insert()
    setCandidateDefault("dotty", "0.22.0")
  }

  @ChangeSet(
    order = "003",
    id = "003_add_dotty_0_24_0",
    author = "steinybot"
  )
  def migration003(implicit db: MongoDatabase): Unit = {
    val version = "0.24.0"
    Version(
      candidate = "dotty",
      version = version,
      url = url(version)
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  private def url(version: String) =
    s"https://github.com/lampepfl/dotty/releases/download/$version/dotty-$version.zip"
}
