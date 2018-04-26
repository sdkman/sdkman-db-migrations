package io.sdkman

import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.{Filters, Updates}
import org.bson.Document

import scala.language.implicitConversions

package object changelogs {

  val CandidatesCollection = "candidates"

  val VersionsCollection = "versions"

  trait Migratable[A] {
    def insert(a: A)(implicit db: MongoDatabase): Unit
  }

  implicit val candidateMigration = new Migratable[Candidate] {
    override def insert(c: Candidate)(implicit db: MongoDatabase): Unit =
      db.getCollection(CandidatesCollection)
        .insertOne(candidateToDocument(c))
  }

  implicit val versionMigration = new Migratable[Version] {
    override def insert(v: Version)(implicit db: MongoDatabase): Unit =
      db.getCollection(VersionsCollection)
        .insertOne(versionToDocument(v))
  }

  implicit def listMigration[A](implicit migratable: Migratable[A]): Migratable[List[A]] = new Migratable[List[A]] {
    override def insert(xs: List[A])(implicit db: MongoDatabase): Unit = xs.foreach(migratable.insert)
  }

  implicit class MigrationOps[A](a: A) {
    def insert()(implicit migratable: Migratable[A], db: MongoDatabase) = migratable.insert(a)
  }

  trait Platform {
    def id: String
  }

  case object UniversalBinary extends Platform {
    override val id = "UNIVERSAL"
  }

  case object MacOSX extends Platform {
    override val id = "MAC_OSX"
  }

  case object Windows extends Platform {
    override val id = "WINDOWS_64"
  }

  case object Linux extends Platform {
    override val id = "LINUX_64"
  }

  case class Candidate(candidate: String,
                       name: String,
                       description: String,
                       default: String,
                       websiteUrl: String,
                       distribution: String = "UNIVERSAL")

  case class Version(candidate: String,
                     version: String,
                     url: String,
                     platform: Platform = UniversalBinary)

  def candidateToDocument(c: Candidate): Document =
    new Document("candidate", c.candidate)
      .append("name", c.name)
      .append("description", c.description)
      .append("default", c.default)
      .append("websiteUrl", c.websiteUrl)
      .append("distribution", c.distribution)

  def versionToDocument(cv: Version): Document =
    new Document("candidate", cv.candidate)
      .append("version", cv.version)
      .append("platform", cv.platform.id)
      .append("url", cv.url)


  def removeCandidate(candidate: String)(implicit db: MongoDatabase): Unit =
    db.getCollection(CandidatesCollection).deleteOne(new Document("candidate", candidate))

  def removeVersion(candidate: String, version: String, platform: Platform = UniversalBinary)(implicit db: MongoDatabase): Unit =
    db.getCollection(VersionsCollection).deleteOne(new Document("candidate", candidate).append("version", version).append("platform", platform.id))

  def removeAllVersions(candidate: String)(implicit db: MongoDatabase): Unit =
    db.getCollection(VersionsCollection).deleteMany(new Document("candidate", candidate))

  def setCandidateDefault(candidate: String, version: String)(implicit db: MongoDatabase): Document =
    db.getCollection(CandidatesCollection).findOneAndUpdate(Filters.eq("candidate", candidate), Updates.set("default", version))
}