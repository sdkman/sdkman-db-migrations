package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "025")
class KarafMigrations {

  @ChangeSet(order = "001", id = "001_add_karaf_candidate", author = "tonit")
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = "karaf",
      name = "Karaf",
      description =
        "Apache Karaf is a polymorphic, lightweight, powerful, and enterprise ready applications runtime. It provides all the ecosystem and bootstrapping options you need for your applications. It runs on premise or on cloud. By polymorphic, it means that Karaf can host any kind of applications: WAR, OSGi, Spring, and much more.",
      websiteUrl = "https://karaf.apache.org/"
    ).insert()
  }
}
