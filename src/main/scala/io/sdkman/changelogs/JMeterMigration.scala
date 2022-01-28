package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import org.bson.Document

@ChangeLog(order = "051")
class JMeterMigration {
  val CandidateName  = "jmeter"
  val DefaultVersion = "5.4.3"

  @ChangeSet(
    order = "003",
    id = "003-add_latest_jmeter_candidate_urls",
    author = "xshyamx"
  )
  def migration003(implicit db: MongoDatabase): List[Version] = {
    List(
      DefaultVersion,
      "5.4.2"
    ).map(
        version =>
          Version(
            candidate = CandidateName,
            version = version,
            url =
              s"https://archive.apache.org/dist/jmeter/binaries/apache-jmeter-$version.zip"
          )
      )
      .validate()
      .insert()
  }
  @ChangeSet(
    order = "004",
    id = "004-update-default-jmeter-version",
    author = "xshyamx"
  )
  def migration004(implicit db: MongoDatabase): Document = {
    setCandidateDefault(CandidateName, DefaultVersion)
  }

}
