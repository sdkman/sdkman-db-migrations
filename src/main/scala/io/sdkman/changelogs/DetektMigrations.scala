package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "079")
class DetektMigrations {
  @ChangeSet(
    order = "003",
    id = "003_add_detect_1_23_3",
    author = "helpermethod"
  )
  def migration003(implicit db: MongoDatabase): Unit = {
    val version = "1.23.3"
    Version(
      candidate = "detekt",
      version = version,
      url =
        f"https://github.com/detekt/detekt/releases/download/v$version/detekt-cli-$version.zip"
    ).validate()
      .insert()
  }
}
