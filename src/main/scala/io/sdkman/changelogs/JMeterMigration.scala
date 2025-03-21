package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "051")
class JMeterMigration {
  val candidate = "jmeter"

  @ChangeSet(
    order = "001",
    id = "001-add_jmeter_candidate",
    author = "xshyamx"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = candidate,
      name = "Apache JMeter",
      description =
        "The Apache JMeter™ application is open source software, a 100% pure Java application designed to load test functional behavior and measure performance. It was originally designed for testing Web Applications but has since expanded to other test functions.",
      websiteUrl = "https://jmeter.apache.org/"
    ).insert()
  }

  @ChangeSet(
    order = "007",
    id = "007-add_5.6.x_jmeter_candidate",
    author = "jbriantais"
  )
  def migration007(implicit db: MongoDatabase): Unit = {
    List(
      "5.6.1",
      "5.6.2",
      "5.6.3"
    ).map(
        version =>
          Version(
            candidate = candidate,
            version = version,
            url =
              s"https://archive.apache.org/dist/jmeter/binaries/apache-jmeter-$version.zip"
          )
      )
      .validate()
      .insert()
    setCandidateDefault(candidate, "5.6.3")
  }
}
