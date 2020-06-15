package io.sdkman.changelogs.jmc

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Linux64, MacOSX, Version, Windows, _}

@ChangeLog(order = "029")
class OpenJDKJmcMigrations {

  @ChangeSet(order = "001", id = "001_add_jmc_candidate", author = "den1ska")
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "jmc",
      name = "JDK Mission Control",
      description =
        "JDK Mission Control 7 (JMC) is an advanced set of tools that enables efficient and detailed data analysis, and delivers advanced, unobtrusive Java monitoring and management. JMC provides sections for common analysis areas such as code performance, memory, and latency.",
      websiteUrl = "https://jdk.java.net/jmc/",
      distribution = "UNIVERSAL"
    ).insert()
  }

  @ChangeSet(order = "002", id = "002-add_jmc_7.0.1-ga", author = "den1ska")
  def migration002(implicit db: MongoDatabase) = {
    List(
      Version(
        "jmc",
        "7.0.1-open",
        "https://download.java.net/java/GA/jmc7.0.1/01/UPL/jmc-7.0.1+01_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "jmc",
        "7.0.1-open",
        "https://download.java.net/java/GA/jmc7.0.1/01/UPL/jmc-7.0.1+01_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "jmc",
        "7.0.1-open",
        "https://download.java.net/java/GA/jmc7.0.1/01/UPL/jmc-7.0.1+01_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).insert()

    setCandidateDefault("jmc", "7.0.1-open")
  }
}
