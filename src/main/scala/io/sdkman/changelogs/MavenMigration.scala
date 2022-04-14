package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "013")
class MavenMigration {
  @ChangeSet(order = "009", id = "009-add_maven_3.8.5", author = "aalmiray")
  def migration008(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.8.5",
      "https://archive.apache.org/dist/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }

  @ChangeSet(
    order = "010",
    id = "010-add_maven_3.3.3",
    author = "JohnLBergqvist"
  )
  def migration010(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.3.3",
      "https://archive.apache.org/dist/maven/maven-3/3.3.3/binaries/apache-maven-3.3.3-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "011",
    id = "011-add_maven_3.3.1",
    author = "JohnLBergqvist"
  )
  def migration011(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.3.1",
      "https://archive.apache.org/dist/maven/maven-3/3.3.1/binaries/apache-maven-3.3.1-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "012",
    id = "012-add_maven_3.2.5",
    author = "JohnLBergqvist"
  )
  def migration012(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.2.5",
      "https://archive.apache.org/dist/maven/maven-3/3.2.5/binaries/apache-maven-3.2.5-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "013",
    id = "013-add_maven_3.2.3",
    author = "JohnLBergqvist"
  )
  def migration013(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.2.3",
      "https://archive.apache.org/dist/maven/maven-3/3.2.3/binaries/apache-maven-3.2.3-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "014",
    id = "014-add_maven_3.2.2",
    author = "JohnLBergqvist"
  )
  def migration014(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.2.2",
      "https://archive.apache.org/dist/maven/maven-3/3.2.2/binaries/apache-maven-3.2.2-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "015",
    id = "015-add_maven_3.2.1",
    author = "JohnLBergqvist"
  )
  def migration015(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.2.1",
      "https://archive.apache.org/dist/maven/maven-3/3.2.1/binaries/apache-maven-3.2.1-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "016",
    id = "016-add_maven_3.1.1",
    author = "JohnLBergqvist"
  )
  def migration016(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.1.1",
      "https://archive.apache.org/dist/maven/maven-3/3.1.1/binaries/apache-maven-3.1.1-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "017",
    id = "017-add_maven_3.1.0",
    author = "JohnLBergqvist"
  )
  def migration017(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.1.0",
      "https://archive.apache.org/dist/maven/maven-3/3.1.0/binaries/apache-maven-3.1.0-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "018",
    id = "018-add_maven_3.0.5",
    author = "JohnLBergqvist"
  )
  def migration018(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.0.5",
      "https://archive.apache.org/dist/maven/maven-3/3.0.5/binaries/apache-maven-3.0.5-bin.zip"
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "019",
    id = "019-add_maven_3.0.4",
    author = "JohnLBergqvist"
  )
  def migration019(implicit db: MongoDatabase): Unit = {
    Version(
      "maven",
      "3.0.4",
      "https://archive.apache.org/dist/maven/maven-3/3.0.4/binaries/apache-maven-3.0.4-bin.zip"
    ).validate()
      .insert()
  }

}
