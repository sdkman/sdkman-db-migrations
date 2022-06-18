package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "062")
class MyBatisMigrations {

  val CandidateName = "mybatis"

  @ChangeSet(
    order = "001",
    id = "001-add_mybatis_migrations_candidate",
    author = "xshyamx"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = CandidateName,
      name = "MyBatis Migrations",
      description =
        "The MyBatis Schema Migration System (or MyBatis Migrations for short) seeks to provide database migrations for any database (new or existing) and make the current status of the database easily accessible and comprehensible. Installing this candidate provides the migrate command for managing database migrations",
      websiteUrl = "https://mybatis.org/migrations/"
    ).insert()
  }
  @ChangeSet(
    order = "004",
    id = "004-add_latest_mybatis_migrations",
    author = "xshyamx"
  )
  def migration004(implicit db: MongoDatabase): Unit = {
    val version = "3.3.10"
    Version(
      candidate = CandidateName,
      version = version,
      url =
        s"https://github.com/mybatis/migrations/releases/download/mybatis-migrations-$version/mybatis-migrations-$version-bundle.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

}
