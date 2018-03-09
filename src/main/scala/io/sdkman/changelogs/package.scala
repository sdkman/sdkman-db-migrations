package io.sdkman

import org.bson.Document

import scala.language.implicitConversions

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
}