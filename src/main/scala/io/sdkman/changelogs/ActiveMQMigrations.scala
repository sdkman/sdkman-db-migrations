package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import org.bson.Document

@ChangeLog(order = "060")
class ActiveMQMigrations {

  val CandidateName = "activemq"

  @ChangeSet(
    order = "001",
    id = "001-add_activemq_candidate",
    author = "xshyamx"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = CandidateName,
      name = "Apache ActiveMQ (Classic)",
      description =
        "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.",
      websiteUrl = "https://activemq.apache.org/"
    ).insert()
  }
  @ChangeSet(
    order = "003",
    id = "003-add_new_activemq_versions_and_update_default",
    author = "xshyamx"
  )
  def migration003(implicit db: MongoDatabase): Document = {
    List(
      "5.17.1",
      "5.17.0",
      "5.16.5",
      "5.16.4",
      "5.16.3"
    ).map(
        version =>
          Version(
            candidate = CandidateName,
            version = version,
            url =
              s"https://archive.apache.org/dist/activemq/$version/apache-activemq-$version-bin.zip"
          )
      )
      .validate()
      .insert()
    setCandidateDefault(CandidateName, "5.17.1")
  }

}
