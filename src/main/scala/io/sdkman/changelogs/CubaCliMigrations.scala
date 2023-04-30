package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "014")
class CubaCliMigrations {

  @ChangeSet(
    order = "002",
    id = "002_change_versions_urls",
    author = "torquemada163"
  )
  def migration002(implicit db: MongoDatabase): Unit =
    Seq("1.0.1", "1.0.2", "1.0.3", "2.0.1", "2.0.2", "2.0.3", "2.0.4", "2.1.0")
      .foreach { version =>
        removeVersion("cuba", version)
        List(
          Version(
            candidate = "cuba",
            version = version,
            url =
              s"https://cdn.cuba-platform.com/cuba-cli/$version/cuba-cli-$version-linux.zip",
            platform = Linux64
          ),
          Version(
            candidate = "cuba",
            version = version,
            url =
              s"https://cdn.cuba-platform.com/cuba-cli/$version/cuba-cli-$version-macos.zip",
            platform = MacOSX
          )
        ).validate()
          .insert()
      }
}
