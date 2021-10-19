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
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = CandidateName,
      name = "MyBatis Migrations",
      description =
        "The MyBatis Schema Migration System (or MyBatis Migrations for short) seeks to provide database migrations for any database (new or existing) and make the current status of the database easily accessible and comprehensible. Installing this candidate provides the migrate command for managing database migrations",
      websiteUrl = "https://mybatis.org/migrations/",
      distribution = "UNIVERSAL"
    ).insert()
  }

  @ChangeSet(
    order = "002",
    id = "002-add_correct_mybatis_migrations_bundle_urls",
    author = "xshyamx"
  )
  def migration002(implicit db: MongoDatabase) = {
    List(
      "3.3.9",
      "3.3.8",
      "3.3.7",
      "3.3.6",
      "3.3.5",
      "3.3.4",
      "3.3.3",
      "3.3.2",
      "3.3.1",
      "3.3.0",
      "3.1.1"
    ).map(
        version =>
          Version(
            candidate = CandidateName,
            version = version,
            url =
              s"https://github.com/mybatis/migrations/releases/download/mybatis-migrations-$version/mybatis-migrations-$version-bundle.zip"
          )
      )
      .validate()
      .insert()
    setCandidateDefault("migrate", "3.3.9")
  }

  @ChangeSet(
    order = "003",
    id = "003-add_non_bundle_mybatis_migrations",
    author = "xshyamx"
  )
  def migration003(implicit db: MongoDatabase) = {
    List(
      "3.2.1",
      "3.2.0",
      "3.1.0"
    ).map(
        version =>
          Version(
            candidate = CandidateName,
            version = version,
            url =
              s"https://github.com/mybatis/migrations/releases/download/mybatis-migrations-$version/mybatis-migrations-$version.zip"
          )
      )
      .validate()
      .insert()
  }
}
