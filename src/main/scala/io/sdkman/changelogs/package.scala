package io.sdkman

import org.bson.Document

import scala.language.implicitConversions

package object changelogs {

  implicit def candidateVersionToDocument(cv: CandidateVersion): Document =
    new Document("candidate", cv.candidate)
      .append("version", cv.version)
      .append("platform", cv.platform.getOrElse("UNIVERSAL"))
      .append("url", cv.url)
}