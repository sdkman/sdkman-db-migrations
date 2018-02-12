package io.sdkman

case class CandidateVersion(candidate: String,
                            version: String,
                            platform: Option[String],
                            url: String)