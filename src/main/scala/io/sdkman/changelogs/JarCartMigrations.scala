package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "096")
class JarCartMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_jar_cart_candidate",
    author = "Sudhanshu-Ambastha"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "jar-cart",
      name = "Jar-Cart",
      description = "A lightweight, no-build package manager and CLI tool designed for Java.",
      websiteUrl = "https://github.com/Sudhanshu-Ambastha/jar-cart"
    ).insert()
}