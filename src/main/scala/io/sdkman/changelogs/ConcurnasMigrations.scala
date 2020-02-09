package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "025")
class ConcurnasMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_concurnas_candidate",
    author = "jasontatton"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "concurnas",
      name = "Concurnas",
      description =
        "Concurnas is an open source JVM programming language designed for building reliable, scalable, high performance concurrent, distributed and parallel systems.",
      websiteUrl = "https://concurnas.com/"
    ).insert()
}
