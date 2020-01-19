package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "006")
class CxfMigrations {

  @ChangeSet(order = "001", id = "001_add_cxf_3_2_4", author = "r0b0")
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "cxf",
      name = "CXF",
      description =
        "Apache CXF is an open source services framework. CXF helps you build and develop services using frontend programming APIs, like JAX-WS and JAX-RS. These services can speak a variety of protocols such as SOAP, XML/HTTP, RESTful HTTP, or CORBA and work over a variety of transports such as HTTP, JMS or JBI.",
      default = Some("3.2.4"),
      websiteUrl = "https://cxf.apache.org/"
    ).insert()

    Version(
      candidate = "cxf",
      version = "3.2.4",
      url = "http://apache.mirror.anlx.net/cxf/3.2.4/apache-cxf-3.2.4.zip"
    ).insert()
  }

  @ChangeSet(order = "002", id = "002_add_cxf_3_2_4-3_2_5", author = "marc0der")
  def migration002(implicit db: MongoDatabase) = {
    removeVersion("cxf", "3.2.4")
    Version(
      "cxf",
      "3.2.4",
      "https://archive.apache.org/dist/cxf/3.2.4/apache-cxf-3.2.4.zip"
    ).validate()
      .insert()
    Version(
      "cxf",
      "3.2.5",
      "https://archive.apache.org/dist/cxf/3.2.5/apache-cxf-3.2.5.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(order = "003", id = "003_make_3_2_5_default", author = "marc0der")
  def migration003(implicit db: MongoDatabase) = {
    setCandidateDefault("cxf", "3.2.5")
  }
}
