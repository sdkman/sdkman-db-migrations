package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "051")
class JMeterMigration {
  @ChangeSet(
    order = "001",
    id = "001-add_jmeter_candidate",
    author = "xshyamx"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = "jmeter",
      name = "Apache JMeter",
      description =
        " The Apache JMeter™ application is open source software, a 100% pure Java application designed to load test functional behavior and measure performance. It was originally designed for testing Web Applications but has since expanded to other test functions.",
      websiteUrl = "https://jmeter.apache.org/"
    ).insert()
  }
}
