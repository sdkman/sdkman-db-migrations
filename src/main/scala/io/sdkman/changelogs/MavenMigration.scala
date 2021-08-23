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

  @ChangeSet(order = "006", id = "006-add_maven_3.8.1", author = "aalmiray")
  def migration006(implicit db: MongoDatabase) = {
    Version(
      "maven",
      "3.8.1",
      "https://archive.apache.org/dist/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }  

  @ChangeSet(order = "007", id = "007-add_maven_3.8.2", author = "clemstoquart")
  def migration007(implicit db: MongoDatabase) = {
    Version(
      "maven",
      "3.8.2",
      "https://archive.apache.org/dist/maven/maven-3/3.8.2/binaries/apache-maven-3.8.2-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
    
  @ChangeSet(order = "008", id = "008-add_checksums", author = "hgeraldino")
  def migration008(implicit db: MongoDatabase) = {
    updateChecksum(
      "maven",
      "3.5.4",
      Universal,
      SHA512,
      "4d2763e1b73dfcde5c955f586bd754443833f63e20dd9ce4ce4405a2010bfc48324aa3b6bd5b6ac71a614112734b0bc652aa2ac05f492ed28a66de8116c3ef6e"
    )
    updateChecksum(
      "maven",
      "3.6.0",
      Universal,
      SHA512,
      "7d14ab2b713880538974aa361b987231473fbbed20e83586d542c691ace1139026f232bd46fdcce5e8887f528ab1c3fbfc1b2adec90518b6941235952d3868e9"
    )
    updateChecksum(
      "maven",
      "3.6.1",
      Universal,
      SHA512,
      "51169366d7269ed316bad013d9cbfebe3a4ef1fda393ac4982d6dbc9af2d5cc359ee12838b8041cb998f236486e988b9c05372f4fdb29a96c1139f63c991e90e"
    )
    updateChecksum(
      "maven",
      "3.6.2",
      Universal,
      SHA512,
      "4bb0e0bb1fb74f1b990ba9a6493cc6345873d9188fc7613df16ab0d5bd2017de5a3917af4502792f0bad1fcc95785dcc6660f7add53548e0ec4bfb30ce4b1da7"
    )
    updateChecksum(
      "maven",
      "3.6.3",
      Universal,
      SHA512,
      "1c095ed556eda06c6d82fdf52200bc4f3437a1bab42387e801d6f4c56e833fb82b16e8bf0aab95c9708de7bfb55ec27f653a7cf0f491acebc541af234eded94d"
    )
    updateChecksum(
      "maven",
      "3.8.1",
      Universal,
      SHA512,
      "c585847bfbcf8647aeabfd3e8bf0ac3f67a037bd345545e274766f144c2b978b3457cbc3e31545e62c21ad69e732695de01ec96ea2580e5da67bd85df095c0f4"
    )    
  }

}
