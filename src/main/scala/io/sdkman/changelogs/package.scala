package io.sdkman

import org.bson.Document

import scala.language.implicitConversions

package object changelogs {

  implicit def candidateToDocument(c: Candidate): Document =
    new Document("candidate", c.candidate)
      .append("default", c.default)
      .append("description", c.description)
      .append("websiteUrl", c.websiteUrl)
      .append("name", c.name)
      .append("distribution", c.distribution.getOrElse("UNIVERSAL"))

  implicit def candidateVersionToDocument(cv: CandidateVersion): Document =
    new Document("candidate", cv.candidate)
      .append("version", cv.version)
      .append("platform", cv.platform.getOrElse("UNIVERSAL"))
      .append("url", cv.url)
}