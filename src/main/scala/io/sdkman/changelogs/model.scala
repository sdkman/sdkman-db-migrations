package io.sdkman.changelogs

import org.bson.Document

case class CandidateVersion(candidate: String, version: String, platform: Option[String], url: String)

trait MigrationDsl {

  implicit def candidateVersionToDocument(cv: CandidateVersion): Document =
    new Document("candidate", cv.candidate)
      .append("version", cv.version)
      .append("platform", cv.platform.getOrElse("UNIVERSAL"))
      .append("url", cv.url)
}