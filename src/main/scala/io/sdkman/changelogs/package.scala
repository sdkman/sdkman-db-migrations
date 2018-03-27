package io.sdkman

import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.{Filters, Updates}
import org.bson.Document

import scala.language.implicitConversions

import scala.collection.JavaConverters._

package object changelogs {

  val CandidatesCollection = "candidates"

  val VersionsCollection = "versions"

  case class Candidate(candidate: String,
                       name: String,
                       description: String,
                       default: String,
                       websiteUrl: String,
                       distribution: String)

  case class Version(candidate: String,
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

  implicit def versionToDocument(cv: Version): Document =
    new Document("candidate", cv.candidate)
      .append("version", cv.version)
      .append("platform", cv.platform.getOrElse("UNIVERSAL"))
      .append("url", cv.url)

  def insertVersion(version: Document)(implicit db: MongoDatabase): Unit =
    db.getCollection(VersionsCollection).insertOne(version)

  def insertVersions(versions: Document*)(implicit db: MongoDatabase): Unit =
    db.getCollection(VersionsCollection).insertMany(versions.asJava)

  def insertCandidate(candidate: Document)(implicit db: MongoDatabase): Unit =
    db.getCollection(CandidatesCollection).insertOne(candidate)

  def removeCandidate(candidate: String)(implicit db: MongoDatabase): Unit =
    db.getCollection(CandidatesCollection).deleteOne(new Document("candidate", candidate))

  def removeVersion(candidate: String, version: String)(implicit db: MongoDatabase): Unit =
    db.getCollection(VersionsCollection).deleteOne(new Document("candidate", candidate).append("version", version))

  def removeAllVersions(candidate: String)(implicit db: MongoDatabase): Unit =
    db.getCollection(VersionsCollection).deleteMany(new Document("candidate", candidate))

  def setCandidateDefault(candidate: String, version: String)(implicit db: MongoDatabase): Document =
    db.getCollection(CandidatesCollection).findOneAndUpdate(Filters.eq("candidate", candidate), Updates.set("default", version))
}