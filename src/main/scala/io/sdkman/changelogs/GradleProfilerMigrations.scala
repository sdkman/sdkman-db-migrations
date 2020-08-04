package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "033")
class GradleProfilerMigrations {
  @ChangeSet(
    order = "001",
    id = "001-add_gradleprofiler_0.12.0",
    author = "wolfs"
  )
  def migration001(implicit db: MongoDatabase): Unit = {
    Candidate(
      candidate = "gradleprofiler",
      name = "Gradle profiler",
      description =
        "A tool for gathering profiling and benchmarking information for Gradle builds",
      websiteUrl = "https://github.com/gradle/gradle-profiler"
    ).insert()

    Version(
      "gradleprofiler",
      "0.12.0",
      "https://repo.gradle.org/gradle/ext-releases-local/org/gradle/profiler/gradle-profiler/0.12.0/gradle-profiler-0.12.0.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
