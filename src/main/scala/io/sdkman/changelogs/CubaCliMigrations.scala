package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "014")
class CubaCliMigrations {

  @ChangeSet(order = "001", id = "001_add_cubacli_candidate", author = "jreznot")
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "cubacli",
      name = "CUBA CLI",
      description = "CUBA CLI is an open source command line utility that enables you to easily create projects based on CUBA Platform",
      websiteUrl = "https://cuba-platform.com",
      distribution = "PLATFORM_SPECIFIC"
    ).insert()

    Version(
      candidate = "cubacli",
      version = "1.0.1",
      url = "https://bintray.com/cuba-platform/tools/download_file?file_path=cuba-cli%2F1.0.1%2Fcuba-cli-1.0.1-linux.zip",
      platform = Linux64
    ).insert()

    Version(
      candidate = "cubacli",
      version = "1.0.1",
      url = "https://bintray.com/cuba-platform/tools/download_file?file_path=cuba-cli%2F1.0.1%2Fcuba-cli-1.0.1-macos.zip",
      platform = MacOSX
    ).insert()

    Version(
      candidate = "cubacli",
      version = "1.0.1",
      url = "https://bintray.com/cuba-platform/tools/download_file?file_path=cuba-cli%2F1.0.1%2Fcuba-cli-1.0.1-windows.zip",
      platform = Windows
    ).insert()
  }
}