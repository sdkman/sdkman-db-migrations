package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "079")
class DetektMigrations {
  @ChangeSet(
    order = "006",
    id = "006_add_detect_1_23_6",
    author = "helpermethod"
  )
  def migration004(implicit db: MongoDatabase): Unit = {
    val version = "1.23.6"
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
