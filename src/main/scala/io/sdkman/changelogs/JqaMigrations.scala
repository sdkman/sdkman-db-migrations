package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "089")
class JqaMigrations {
  @ChangeSet(order = "001", id = "001_add_jqa_2_6_0", author = "ascheman")
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = "jqassistant",
      name = "jQAssistant",
      description =
        "jQAssistant is an open-source tool for software analytics, enabling you to gain insights into your systems, verify design implementation, and create living documentation. By scanning code and configurations into a Neo4j graph database, it helps maintain software quality and bridge the gap between documentation and implementation.",
      websiteUrl = "https://jqassistant.org"
    ).insert()
  }
}
