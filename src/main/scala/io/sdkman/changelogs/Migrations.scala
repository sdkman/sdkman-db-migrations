package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import org.bson.Document

import scala.collection.JavaConverters._

@deprecated(message = "This class has been superceded by candidate specific migration classes", since = "#24")
@ChangeLog(order = "001")
class Migrations {

  @ChangeSet(order = "001", id = "001-add_java_904_zulu", author = "marc0der")
  def migrate001(db: MongoDatabase) = db.getCollection("versions").insertMany(List[Document](
    Version("java", "9.0.4-zulu", Some("MAC_OSX"), "https://cdn.azul.com/zulu/bin/zulu9.0.4.1-jdk9.0.4-macosx_x64.zip"),
    Version("java", "9.0.4-zulu", Some("WINDOWS_64"), "https://cdn.azul.com/zulu/bin/zulu9.0.4.1-jdk9.0.4-win_x64.zip")).asJava)

  @ChangeSet(order = "002", id = "002-add_java_904_zulu", author = "marc0der")
  def migrate002(db: MongoDatabase) = db.getCollection("versions").insertOne(
    Version("java", "9.0.4-zulu", Some("LINUX_64"), "https://cdn.azul.com/zulu/bin/zulu9.0.4.1-jdk9.0.4-linux_x64.tar.gz"))

  @ChangeSet(order = "003", id = "003-add_openjdk_latest", author = "MaSven")
  def migrate003(implicit db: MongoDatabase) = insertVersions(
    Version("java", "9u181-openjdk", Some("LINUX_64"), "https://github.com/AdoptOpenJDK/openjdk9-releases/releases/download/jdk-9%2B181/OpenJDK9_x64_Linux_jdk-9.181.tar.gz"),
    Version("java", "9u181-openjdk", Some("MAC_OSX"), "https://github.com/AdoptOpenJDK/openjdk9-releases/releases/download/jdk-9%2B181/OpenJDK9_x64_Mac_jdk-9.181.tar.gz"),
    Version("java", "9u181-openjdk", Some("WINDOWS_64"), "https://github.com/AdoptOpenJDK/openjdk9-releases/releases/download/jdk-9%2B181/OpenJDK9_x64_Win_jdk-9.181.zip"),
    Version("java", "8u144-openjdk", Some("LINUX_64"), "https://github.com/AdoptOpenJDK/openjdk8-releases/releases/download/jdk8u144-b01/OpenJDK8_x64_Linux_jdk8u144-b01.tar.gz"),
    Version("java", "8u144-openjdk", Some("MAC_OSX"), "https://github.com/AdoptOpenJDK/openjdk8-releases/releases/download/jdk8u144-b01/OpenJDK8_x64_Mac_jdk8u144-b01.tar.gz"),
    Version("java", "8u144-openjdk", Some("WINDOWS_64"), "https://github.com/AdoptOpenJDK/openjdk8-releases/releases/download/jdk8u144-b01/OpenJDK8_x64_Win_jdk8u144-b01.zip"),
    Version("java", "10u23-openjdk", Some("LINUX_64"), "https://github.com/AdoptOpenJDK/openjdk10-releases/releases/download/jdk-10%2B23/OpenJDK10_x64_Linux_jdk-10.23.tar.gz"),
    Version("java", "10u23-openjdk", Some("MAC_OSX"), "https://github.com/AdoptOpenJDK/openjdk10-releases/releases/download/jdk-10%2B23/OpenJDK10_x64_Mac_jdk-10.23.tar.gz"))

  @ChangeSet(order = "004", id = "004-change_java_default", author = "MaSven")
  def migrate004(implicit db: MongoDatabase) = setCandidateDefault("java", "8u144-openjdk")

  @ChangeSet(order = "005", id = "005-change_java_default_8u152_zulu", author = "MaSven")
  def migrate005(implicit db: MongoDatabase) = setCandidateDefault("java", "8u152-zulu")


  @ChangeSet(order = "006", id = "003-add_maven_353", author = "hho")
  def migrate006(implicit db: MongoDatabase) = {
    insertVersions(Version("maven", "3.5.3", Some("UNIVERSAL"), "https://archive.apache.org/dist/maven/maven-3/3.5.3/binaries/apache-maven-3.5.3-bin.zip"))
    setCandidateDefault("maven", "3.5.3")
  }

  @ChangeSet(order = "007", id = "007-add_scala_2_12_5", author = "marc0der")
  def migrate007(implicit db: MongoDatabase) = {
    insertVersions(Version("scala", "2.12.5", Some("UNIVERSAL"), "https://downloads.lightbend.com/scala/2.12.5/scala-2.12.5.zip"))
    setCandidateDefault("scala", "2.12.5")
  }
  
  
}
