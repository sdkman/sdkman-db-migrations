package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "079")
class DetektMigrations {
  @ChangeSet(
    order = "005",
    id = "005_add_detect_1_23_5",
    author = "helpermethod"
  )
  def migration004(implicit db: MongoDatabase): Unit = {
    val version = "1.23.5"
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
