package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "034")
class MavenDaemon {
  @ChangeSet(
    order = "001",
    id = "001_add_mvnd_candidate",
    author = "helpermethod"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "mvnd",
      name = "Maven Daemon",
      description =
        "The mvnd project aims to provide a daemon infrastructure for maven based builds. It borrows techniques from Gradle and Takari to provide a simple and efficient system.",
      websiteUrl = "https://github.com/mvndaemon/mvnd/"
    ).insert()

  @ChangeSet(
    order = "002",
    id = "002-add_mavend_0_4_0",
    author = "helpermethod"
  )
  def migration002(implicit db: MongoDatabase) = {
    List(
      Version(
        "mvnd",
        "0.4.0",
        "https://github.com/mvndaemon/mvnd/releases/download/0.0.4/mvnd-0.0.4-darwin-amd64.zip",
        MacOSX
      ),
      Version(
        "mvnd",
        "0.4.0",
        "https://github.com/mvndaemon/mvnd/releases/download/0.0.4/mvnd-0.0.4-linux-amd64.zip",
        Linux64
      ),
      Version(
        "mvnd",
        "0.4.0",
        "https://github.com/mvndaemon/mvnd/releases/download/0.0.4/mvnd-0.0.4-windows-amd64.zip",
        Windows
      )
    ).validate().insert()
    setCandidateDefault("mvnd", "0.4.0")
  }
}
