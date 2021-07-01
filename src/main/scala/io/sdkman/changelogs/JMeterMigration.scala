package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "049")
class JMeterMigration {
  @ChangeSet(
    order = "001",
    id = "001-add_jmeter_candidate",
    author = "xshyamx"
  )
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "jmeter",
      name = "Apache JMeter",
      description =
        " The Apache JMeter™ application is open source software, a 100% pure Java application designed to load test functional behavior and measure performance. It was originally designed for testing Web Applications but has since expanded to other test functions.",
      websiteUrl = "https://jmeter.apache.org/",
      distribution = "UNIVERSAL"
    ).insert()
  }

  @ChangeSet(
    order = "002",
    id = "002-add_correct_jmeter_candidate_urls",
    author = "xshyamx"
  )
  def migration002(implicit db: MongoDatabase) = {
    removeAllVersions("jmeter")
    List(
      "5.4.1",
      "5.4",
      "5.3",
      "5.2",
      "5.2.1",
      "5.1",
      "5.1.1",
      "5.0",
      "4.0",
      "3.3",
      "3.2",
      "3.1",
      "3.0",
      "2.13",
      "2.12",
      "2.11",
      "2.10",
      "2.9",
      "2.8",
      "2.7",
      "2.6"
    ).map {
        case (version: String) =>
          Version(
            candidate = "jmeter",
            version = version,
            url =
              s"https://archive.apache.org/dist/jmeter/binaries/apache-jmeter-$version.zip"
          )
      }
      .validate()
      .insert()
    setCandidateDefault("jmeter", "5.4.1")
  }
}
