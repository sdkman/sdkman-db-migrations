package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "079")
class DetektMigrations {
  @ChangeSet(
    order = "002",
    id = "002_add_detect_1_23_x",
    author = "helpermethod"
  )
  def migration002(implicit db: MongoDatabase): Unit = {
    List(
      "1.23.0",
      "1.23.1"
    ).foreach { version =>
      Version(
        candidate = "detekt",
        version = version,
        url =
          f"https://github.com/detekt/detekt/releases/download/v$version/detekt-cli-$version.zip"
      ).validate()
        .insert()
    }
  }
}
