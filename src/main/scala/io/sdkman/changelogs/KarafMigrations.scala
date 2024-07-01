package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import org.bson.Document

@ChangeLog(order = "025")
class KarafMigrations {

  val CandidateName = "karaf"

  @ChangeSet(
    order = "003",
    id = "003-add_new_karaf_versions_and_update_default",
    author = "fcolinet"
  )
  def migration003(implicit db: MongoDatabase): Document = {
    List(
      "4.4.3",
      "4.4.2",
      "4.4.1",
      "4.4.0",
      "4.3.9",
      "4.3.8",
      "4.3.7",
      "4.3.6",
      "4.3.5",
      "4.3.4",
      "4.3.3",
      "4.3.2",
      "4.3.1",
      "4.3.0",
      "4.2.16",
      "4.2.15",
      "4.2.14",
      "4.2.13",
      "4.2.12",
      "4.2.11",
      "4.2.10",
      "4.2.9"
    ).map(
        version =>
          Version(
            candidate = CandidateName,
            version = version,
            url =
              s"https://archive.apache.org/dist/karaf/$version/apache-karaf-$version.tar.gz"
          )
      )
      .validate()
      .insert()
    setCandidateDefault(CandidateName, "4.4.3")
  }
}
