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
}
