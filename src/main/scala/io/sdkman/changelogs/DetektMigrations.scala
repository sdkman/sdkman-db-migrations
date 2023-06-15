package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "080")
class DetektMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_detect_1_22_0",
    author = "helpermethod"
  )
  def migration001(implicit db: MongoDatabase): Version = {
    Candidate(
      candidate = "detekt",
      name = "Detekt",
      description =
        "A static code analysis tool for the Kotlin programming language",
      default = Some("1.22.0"),
      websiteUrl = "https://detekt.dev/"
    ).insert()

    Version(
      candidate = "detekt",
      version = "1.22.0",
      url =
        "https://github.com/detekt/detekt/releases/download/v1.22.0/detekt-cli-1.22.0.zip"
    ).insert()
  }

  @ChangeSet(
    order = "002",
    id = "001_add_detect_1_23_0",
    author = "helpermethod"
  )
  def migration002(implicit db: MongoDatabase): Unit = {
    Version(
      candidate = "detekt",
      version = "1.23.0",
      url =
        "https://github.com/detekt/detekt/releases/download/v1.23.0/detekt-cli-1.22.0.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
