package io.sdkman.changelogs

import com.github.mongobee.changeset.{ ChangeLog, ChangeSet }
import com.mongodb.client.MongoDatabase
import org.bson.Document

import scala.collection.JavaConverters._

@ChangeLog(order = "001")
class VersionsMigration {

  @ChangeSet(order = "001", id = "001-add_java_904_zulu", author = "marc0der")
  def migrate001(db: MongoDatabase) = db.getCollection("versions").insertMany(List[Document](
    CandidateVersion("java", "9.0.4-zulu", Some("MAC_OSX"), "https://cdn.azul.com/zulu/bin/zulu9.0.4.1-jdk9.0.4-macosx_x64.zip"),
    CandidateVersion("java", "9.0.4-zulu", Some("WINDOWS_64"), "https://cdn.azul.com/zulu/bin/zulu9.0.4.1-jdk9.0.4-win_x64.zip")).asJava)

  @ChangeSet(order = "002", id = "002-add_java_904_zulu", author = "marc0der")
  def migrate002(db: MongoDatabase) = db.getCollection("versions").insertOne(
    CandidateVersion("java", "9.0.4-zulu", Some("LINUX_64"), "https://cdn.azul.com/zulu/bin/zulu9.0.4.1-jdk9.0.4-linux_x64.tar.gz"))

  
  @ChangeSet(order="003", id= "004-add_openjdk_latest",author="MaSven")
  def migrate003(db: MongoDatabase) = db.getCollection("versions").insertMany(List[Document](
      CandidateVersion("java", "jdk9j9-9+181-openjdk", Some("LINUX_64"), "https://github.com/AdoptOpenJDK/openjdk9-openj9-releases/releases/download/jdk-9%2B181/OpenJDK9-OPENJ9_x64_Linux_jdk-9.181.tar.gz"),
      CandidateVersion("java","jdk9-9+181-opendjk",Some("LINUX_64"),"https://github.com/AdoptOpenJDK/openjdk9-releases/releases/download/jdk-9%2B181/OpenJDK9_x64_Linux_jdk-9.181.tar.gz"),
      CandidateVersion("java","jdk9-9+181-opendjk",Some("MAC_OSX"),"https://github.com/AdoptOpenJDK/openjdk9-releases/releases/download/jdk-9%2B181/OpenJDK9_x64_Mac_jdk-9.181.tar.gz"),
      CandidateVersion("java","jdk9-9+181-opendjk",Some("WINDOWS_64"),"https://github.com/AdoptOpenJDK/openjdk9-releases/releases/download/jdk-9%2B181/OpenJDK9_x64_Win_jdk-9.181.zip"),
      CandidateVersion("java","jdk8-144-b01-opendjk",Some("LINUX_64"),"https://github.com/AdoptOpenJDK/openjdk8-releases/releases/download/jdk8u144-b01/OpenJDK8_x64_Linux_jdk8u144-b01.tar.gz"),
      CandidateVersion("java","jdk8-144-b01-opendjk",Some("MAC_OSX"),"https://github.com/AdoptOpenJDK/openjdk8-releases/releases/download/jdk8u144-b01/OpenJDK8_x64_Mac_jdk8u144-b01.tar.gz"),
      CandidateVersion("java","jdk8-144-b01-opendjk",Some("WINDOWS_64"),"https://github.com/AdoptOpenJDK/openjdk8-releases/releases/download/jdk8u144-b01/OpenJDK8_x64_Win_jdk8u144-b01.zip"),
      CandidateVersion("java","jdk8j9-162-b12-opendjk",Some("LINUX_64"),"https://github.com/AdoptOpenJDK/openjdk8-openj9-releases/releases/download/jdk8u162-b12_openj9-0.8.0/OpenJDK8-OPENJ9_x64_Linux_jdk8u162-b12_openj9-0.8.0.tar.gz"),
      CandidateVersion("java","jdk10-+23-opendjk",Some("LINUX_64"),"https://github.com/AdoptOpenJDK/openjdk10-releases/releases/download/jdk-10%2B23/OpenJDK10_x64_Linux_jdk-10.23.tar.gz"),
      CandidateVersion("java","jdk10-+23-opendjk",Some("MAC_OSX"),"https://github.com/AdoptOpenJDK/openjdk10-releases/releases/download/jdk-10%2B23/OpenJDK10_x64_Mac_jdk-10.23.tar.gz")
      ).asJava)
   
  
}
