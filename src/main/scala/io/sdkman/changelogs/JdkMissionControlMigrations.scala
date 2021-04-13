package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "048")
class JdkMissionControlMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_mission_control",
    author = "marc0der"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "jmc",
      name = "JDK Mission Control",
      description =
        "Java Flight Recorder and JDK Mission Control together create a complete tool chain to continuously collect " +
          "low level and detailed runtime information enabling after-the-fact incident analysis. JDK Mission Control " +
          "is an advanced set of tools that enables efficient and detailed analysis of the extensive of data " +
          "collected by Java Flight Recorder. The tool chain enables developers and administrators to collect and " +
          "analyze data from Java applications running locally or deployed in production environments.",
      websiteUrl =
        "https://www.oracle.com/java/technologies/jdk-mission-control.html"
    ).insert()
}
