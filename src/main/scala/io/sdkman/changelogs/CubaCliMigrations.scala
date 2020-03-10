package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "014")
class CubaCliMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_cubacli_candidate",
    author = "jreznot"
  )
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "cuba-cli",
      name = "CUBA CLI",
      description =
        "CUBA CLI is an open source command line utility that enables you to easily create projects based on CUBA Platform",
      websiteUrl = "https://cuba-platform.com",
      distribution = "PLATFORM_SPECIFIC"
    ).insert()

    List(
      Version(
        candidate = "cuba-cli",
        version = "1.0.1",
        url =
          "https://cuba-platform.bintray.com/tools/cuba-cli/1.0.1/cuba-cli-1.0.1-linux.zip",
        platform = Linux64
      ),
      Version(
        candidate = "cuba-cli",
        version = "1.0.1",
        url =
          "https://cuba-platform.bintray.com/tools/cuba-cli/1.0.1/cuba-cli-1.0.1-macos.zip",
        platform = MacOSX
      ),
      Version(
        candidate = "cuba-cli",
        version = "1.0.1",
        url =
          "https://cuba-platform.bintray.com/tools/cuba-cli/1.0.1/cuba-cli-1.0.1-windows.zip",
        platform = Windows
      )
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "002",
    id = "002_change_versions_urls",
    author = "torquemada163"
  )
  def migration002(implicit db: MongoDatabase) =
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
