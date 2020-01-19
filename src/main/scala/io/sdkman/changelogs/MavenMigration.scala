package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(
    order = "001",
    id = "001-add_maven_3.5.4",
    author = "philiplourandos"
  )
  def migration001(implicit db: MongoDatabase) = {
    Version(
      "maven",
      "3.5.4",
      "https://archive.apache.org/dist/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(order = "002", id = "002-add_maven_3.6.0", author = "hho")
  def migration002(implicit db: MongoDatabase) = {
    Version(
      "maven",
      "3.6.0",
      "https://archive.apache.org/dist/maven/maven-3/3.6.0/binaries/apache-maven-3.6.0-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(
    order = "003",
    id = "003-add_maven_3.6.1",
    author = "philiplourandos"
  )
  def migration003(implicit db: MongoDatabase) = {
    Version(
      "maven",
      "3.6.1",
      "https://archive.apache.org/dist/maven/maven-3/3.6.1/binaries/apache-maven-3.6.1-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(
    order = "004",
    id = "004-add_maven_3.6.2",
    author = "philiplourandos"
  )
  def migration004(implicit db: MongoDatabase) = {
    Version(
      "maven",
      "3.6.2",
      "https://archive.apache.org/dist/maven/maven-3/3.6.2/binaries/apache-maven-3.6.2-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(order = "005", id = "005-add_maven_3.6.3", author = "eddumelendez")
  def migration005(implicit db: MongoDatabase) = {
    Version(
      "maven",
      "3.6.3",
      "https://archive.apache.org/dist/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

}
