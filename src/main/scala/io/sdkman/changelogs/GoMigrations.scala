package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "080")
class GoMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_go_candidate",
    author = "ehlui"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "go",
      name = "Go",
      description =
        "An open-source programming language supported by Google." +
          "Easy to learn and great for teams. Built-in concurrency and a robust standard library." +
          "Large ecosystem ... ",
      websiteUrl = "https://go.dev/"
    ).insert()

  @ChangeSet(
    order = "002",
    id = "002_add_go_1_x_y",
    author = "ehlui"
  )
  def migration002(implicit db: MongoDatabase): Unit =
    Seq("1.21.5", "1.20.12", "1.19.13", "1.19")
      .foreach { version =>
        removeVersion("go", version)
        List(
          Version(
            candidate = "go",
            version = version,
            url = s"https://go.dev/dl/go$version.linux-amd64.tar.gz",
            platform = Linux64
          ),
          Version(
            candidate = "go",
            version = version,
            url = s"https://go.dev/dl/go$version.linux-arm64.tar.gz",
            platform = LinuxARM64
          ),
          Version(
            candidate = "go",
            version = version,
            url = s"https://go.dev/dl/go$version.linux-amd64.tar.gz",
            platform = MacOSX
          ),
          Version(
            candidate = "go",
            version = version,
            url = s"https://go.dev/dl/go$version.darwin-arm64.tar.gz",
            platform = MacARM64
          ),
          Version(
            candidate = "go",
            version = version,
            url = s"https://go.dev/dl/go$version.windows-amd64.zip",
            platform = Windows
          )
        ).validate()
          .insert()
      }
}
