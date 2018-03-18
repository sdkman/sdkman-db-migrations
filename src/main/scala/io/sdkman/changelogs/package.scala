package io.sdkman

import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.{Filters, Updates}
import org.bson.Document

import scala.language.implicitConversions

import scala.collection.JavaConverters._

package object changelogs {

  case class Candidate(candidate: String,
                       name: String,
                       description: String,
                       default: String,
                       websiteUrl: String,
                       distribution: String)

  case class CandidateVersion(candidate: String,
                              version: String,
                              platform: Option[String],
                              url: String)

  implicit def candidateToDocument(c: Candidate): Document =
    new Document("candidate", c.candidate)
      .append("name", c.name)
      .append("description", c.description)
      .append("default", c.default)
      .append("website", c.websiteUrl)
      .append("distribution", c.distribution)

  implicit def candidateVersionToDocument(cv: CandidateVersion): Document =
    new Document("candidate", cv.candidate)
      .append("version", cv.version)
      .append("platform", cv.platform.getOrElse("UNIVERSAL"))
      .append("url", cv.url)

  def insertVersions(vs: Document*)(implicit db: MongoDatabase): Unit = db.getCollection("versions").insertMany(vs.asJava)

  def updateCandidateDefault(c: String, d: String)(implicit db: MongoDatabase): Document =
    db.getCollection("candidates").findOneAndUpdate(Filters.eq("candidate", c), Updates.set("default", d))
}