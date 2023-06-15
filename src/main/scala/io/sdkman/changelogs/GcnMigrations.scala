package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "081")
class GcnMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_gcn_candidate",
    author = "ezzarghili"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = "gcn",
      name = "Graal Cloud Native",
      description =
        "Graal Cloud Native (GCN) is a curated set of Micronaut(tm) framework modules designed from the ground up to be compiled ahead-of-time with GraalVM Native image resulting in native executables ideal for microservices." +
          "With GCN, You can build portable cloud-native Java microservices that start instantly and use fewer resources to reduce compute costs.",
      websiteUrl = "https://www.graal.cloud/gcn/"
    ).insert()
  }

  @ChangeSet(
    order = "002",
    id = "002_add_gcn_candidate_3.8.5",
    author = "ezzarghili"
  )
  def migrate002(implicit db: MongoDatabase): Unit = {
    val platforms = List(
      (MacOSX, "macos-amd64", "tar.gz"),
      (MacARM64, "macos-aarch64", "tar.gz"),
      (Linux64, "linux-amd64", "tar.gz"),
      (LinuxARM64, "linux-aarch64", "tar.gz"),
      (Windows, "windows-amd64", "zip")
    )
    val version = "3.8.5"

    platforms
      .map {
        case (platform, gcnPlatform, extension) =>
          Version(
            candidate = "gcn",
            version = version,
            url =
              s"https://github.com/oracle/gcn/releases/download/$version/gcn-cli-$version-$gcnPlatform.$extension",
            platform = platform
          )
      }
      .validate()
      .insert()

    setCandidateDefault("gcn", "3.8.5")
  }
}
