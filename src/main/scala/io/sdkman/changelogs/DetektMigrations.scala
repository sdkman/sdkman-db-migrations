package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "079")
class DetektMigrations {
  @ChangeSet(
    order = "007",
    id = "007_add_detect_1_23_7",
    author = "helpermethod"
  )
  def migration007(implicit db: MongoDatabase): Unit = {
    val version = "1.23.7"
    Version(
      candidate = "detekt",
      version = version,
      url =
        f"https://github.com/detekt/detekt/releases/download/v$version/detekt-cli-$version.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
