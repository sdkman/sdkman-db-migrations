package io.sdkman

case class Candidate(candidate: String,
                     default: String,
                     description: String,
                     websiteUrl: String,
                     name: String,
                     distribution: Option[String])
