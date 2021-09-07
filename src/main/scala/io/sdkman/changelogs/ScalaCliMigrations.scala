package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "070")
class ScalaCliMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_scala-cli_candidate",
    author = "lwronski"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "scalacli",
      name = "Scala CLI",
      description =
        "Scala CLI is a command-line tool to interact with the Scala language. It lets you compile, run, test, and package your Scala code (and more!)",
      websiteUrl = "https://scala-cli.virtuslab.org"
    ).insert()

  @ChangeSet(
    order = "003",
    id = "003-add_scala-cli_0.1.1_as_default",
    author = "lwronski"
  )
  def migration003(implicit db: MongoDatabase) =
    Map(
      MacOSX  -> "scala-cli-x86_64-apple-darwin-sdk.zip",
      Linux64 -> "scala-cli-x86_64-pc-linux-static-sdk.zip",
      Windows -> "scala-cli-x86_64-pc-win32-sdk.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "scalacli",
            "0.1.1",
            s"https://github.com/VirtuslabRnD/scala-cli/releases/download/v0.1.1/$binary",
            platform
          )
      }
      .toList
      .validate()
      .insert()
}
