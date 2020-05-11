package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "010")
class MicronautMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_micronaut_candidate",
    author = "jameskleeh"
  )
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "micronaut",
      name = "Micronaut",
      description =
        "Micronaut is an open source microservice framework for the JVM",
      websiteUrl = "http://micronaut.io/"
    ).insert()
  }

  @ChangeSet(
    order = "002",
    id = "002_replace_2_0_0_M3_with_platform_binaries",
    author = "marc0der"
  )
  def migration002(implicit db: MongoDatabase) = {
    removeVersion("micronaut", "2.0.0.M3", Universal)
    List(
      Version(
        "micronaut",
        "2.0.0.M3",
        "https://github.com/micronaut-projects/micronaut-starter/releases/download/v2.0.0.M3/mn-darwin-amd64-v2.0.0.M3.tar.gz",
        MacOSX
      ),
      Version(
        "micronaut",
        "2.0.0.M3",
        "https://github.com/micronaut-projects/micronaut-starter/releases/download/v2.0.0.M3/mn-linux-amd64-v2.0.0.M3.tar.gz",
        Linux64
      ),
      Version(
        "micronaut",
        "2.0.0.M3",
        "https://github.com/micronaut-projects/micronaut-starter/releases/download/v2.0.0.M3/mn-win-amd64-v2.0.0.M3.zip",
        Windows
      )
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "003",
    id = "002_replace_2_0_0_M3_with_platform_zip_binaries",
    author = "marc0der"
  )
  def migration003(implicit db: MongoDatabase) = {
    Seq(Linux64, MacOSX).foreach(removeVersion("micronaut", "2.0.0.M3", _))
    List(
      Version(
        "micronaut",
        "2.0.0.M3",
        "https://github.com/micronaut-projects/micronaut-starter/releases/download/v2.0.0.M3/mn-darwin-amd64-v2.0.0.M3.zip",
        MacOSX
      ),
      Version(
        "micronaut",
        "2.0.0.M3",
        "https://github.com/micronaut-projects/micronaut-starter/releases/download/v2.0.0.M3/mn-linux-amd64-v2.0.0.M3.zip",
        Linux64
      )
    ).validate()
      .insert()
  }
}
