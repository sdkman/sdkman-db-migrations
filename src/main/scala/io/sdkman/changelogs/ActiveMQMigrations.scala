package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import org.bson.Document

@ChangeLog(order = "060")
class ActiveMQMigrations {
  @ChangeSet(
    order = "001",
    id = "001-add_activemq_candidate",
    author = "xshyamx"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = "activemq",
      name = "Apache ActiveMQ (Classic)",
      description =
        "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.",
      websiteUrl = "https://activemq.apache.org/"
    ).insert()
  }

  @ChangeSet(
    order = "002",
    id = "002-add_correct_activemq_candidate_urls",
    author = "xshyamx"
  )
  def migration002(implicit db: MongoDatabase): Document = {
    List(
      "5.16.2",
      "5.16.1",
      "5.16.0",
      "5.15.15",
      "5.15.14",
      "5.15.13",
      "5.15.12",
      "5.15.11",
      "5.15.10",
      "5.15.9",
      "5.15.8",
      "5.15.7",
      "5.15.6",
      "5.15.5",
      "5.15.4",
      "5.15.3",
      "5.15.2",
      "5.15.1",
      "5.15.0",
      "5.14.5",
      "5.14.4",
      "5.14.3",
      "5.14.2",
      "5.14.1",
      "5.14.0",
      "5.13.4",
      "5.13.3",
      "5.13.2",
      "5.13.1",
      "5.13.0",
      "5.12.2",
      "5.12.1",
      "5.12.0",
      "5.11.3",
      "5.11.2",
      "5.11.1",
      "5.11.0",
      "5.10.2",
      "5.10.1",
      "5.10.0",
      "5.9.1"
    ).map(
        version =>
          Version(
            candidate = "activemq",
            version = version,
            url =
              s"https://archive.apache.org/dist/activemq/$version/apache-activemq-$version-bin.zip"
          )
      )
      .insert()
    setCandidateDefault("activemq", "5.16.2")
  }
}
