package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "095")
class KumlMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_kuml",
    author = "betschwa"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "kuml",
      name = "kUML",
      description =
        "kUML is a Kotlin-native DSL for UML 2, SysML 2, and C4 architecture modelling that compiles type-safe Kotlin sources to SVG diagrams through a configurable renderer pipeline.",
      websiteUrl = "https://kuml.dev",
      distribution = "PLATFORM_SPECIFIC"
    ).insert()

  @ChangeSet(order = "002", id = "002_add_kuml_0_20_5", author = "betschwa")
  def migration002(implicit db: MongoDatabase) = {
    List(
      Version(
        "kuml",
        "0.20.5",
        "https://github.com/kuml-dev/kUML/releases/download/v0.20.5/kuml-runtime-0.20.5-darwin-arm64.zip",
        MacARM64
      ),
      Version(
        "kuml",
        "0.20.5",
        "https://github.com/kuml-dev/kUML/releases/download/v0.20.5/kuml-runtime-0.20.5-darwin-x86_64.zip",
        MacOSX
      ),
      Version(
        "kuml",
        "0.20.5",
        "https://github.com/kuml-dev/kUML/releases/download/v0.20.5/kuml-runtime-0.20.5-linux-x86_64.zip",
        Linux64
      ),
      Version(
        "kuml",
        "0.20.5",
        "https://github.com/kuml-dev/kUML/releases/download/v0.20.5/kuml-runtime-0.20.5-linux-aarch64.zip",
        LinuxARM64
      ),
      Version(
        "kuml",
        "0.20.5",
        "https://github.com/kuml-dev/kUML/releases/download/v0.20.5/kuml-runtime-0.20.5-windows-x86_64.zip",
        Windows
      )
    ).validate().insert()
    setCandidateDefault("kuml", "0.20.5")
  }
}
