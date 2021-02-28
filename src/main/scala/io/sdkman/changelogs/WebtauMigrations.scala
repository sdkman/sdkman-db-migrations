package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "044")
class WebtauMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_webtau_candidate",
    author = "MykolaGolubyev"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "webtau",
      name = "webtau",
      description =
        "webtau - web test automation. test across REST-API/Graph QL/Browser/Database/CLI/Business-Logic",
      websiteUrl = "https://github.com/testingisdocumenting/webtau"
    ).insert()

  @ChangeSet(
    order = "002",
    id = "002_register_version",
    author = "MykolaGolubyev"
  )
  def migration002(implicit db: MongoDatabase) =
    Version(
      "webtau",
      "1.38.0",
      "https://repo1.maven.org/maven2/org/testingisdocumenting/webtau/webtau-dist/1.38/webtau-dist-1.38-webtau.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
}
