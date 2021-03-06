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
        "Webtau (short for web test automation) is a testing API, command line tool and a framework to write " +
          "unit, integration and end-to-end tests. " +
          "Tests can span multiple application layers like REST-API, Graph QL, Browser, Database and CLI. " +
          "Consistent set of matchers and testing concepts work across all testing layers. " +
          "Use REPL mode to speed-up tests development. " +
          "Leverage rich reporting to significantly cut down failure investigation time.",
      websiteUrl = "https://github.com/testingisdocumenting/webtau"
    ).insert()
}
