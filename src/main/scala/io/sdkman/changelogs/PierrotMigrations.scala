package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "063")
class PierrotMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_pierrot_candidate",
    author = "musketyr"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "pierrot",
      name = "Pierrot",
      description =
        "Pierrot helps you to manage many GitHub repositories with a single command.",
      websiteUrl = "https://agorapulse.github.io/pierrot/",
      distribution = "PLATFORM_SPECIFIC"
    ).insert()

  @ChangeSet(
    order = "002",
    id = "002-add_pierrot_0_9_8",
    author = "musketyr"
  )
  def migration002(implicit db: MongoDatabase) = {
    List(
      Version(
        "pierrot",
        "0.9.8",
        "https://github.com/agorapulse/pierrot/releases/download/0.9.8/pierrot-darwin-amd64-v0.9.8.zip",
        MacOSX
      ),
      Version(
        "pierrot",
        "0.9.8",
        "https://github.com/agorapulse/pierrot/releases/download/0.9.8/pierrot-linux-amd64-v0.9.8.zip",
        Linux64
      ),
      Version(
        "pierrot",
        "0.9.8",
        "https://github.com/agorapulse/pierrot/releases/download/0.9.8/pierrot-windows-amd64-v0.9.8.zip",
        Windows
      )
    ).validate().insert()
    setCandidateDefault("pierrot", "0.9.8")
  }
}
