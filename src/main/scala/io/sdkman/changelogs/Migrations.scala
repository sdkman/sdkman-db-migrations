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

  
  @ChangeSet(order="004", id= "oo4-add_openjdk_version",author="MaSven")
  def migrate004(db: MongoDatabase) = db.getCollection("versions").insertMany(List[Document](
      CandidateVersion("java", "jdk9j9-latest-openjdk", Some("LINUX_64"), "https://api.adoptopenjdk.net/openjdk-opnj9/releases/x64_linux/latest/binary"),
      CandidateVersion("java","jdk9-latest-opendjk",Some("LINUX_64"),"https://api.adoptopenjdk.net/openjdk9/releases/x64_linux/latest/binary"),
      CandidateVersion("java","jdk9-latest-opendjk",Some("MAC_OSX"),"https://api.adoptopenjdk.net/openjdk9/releases/x64_mac/latest/binary"),
      CandidateVersion("java","jdk9-latest-opendjk",Some("WINDOWS_64"),"https://api.adoptopenjdk.net/openjdk9/releases/x64_win/latest/binary"),
      CandidateVersion("java","jdk8-latest-opendjk",Some("LINUX_64"),"https://api.adoptopenjdk.net/openjdk8/releases/x64_linux/latest/binary"),
      CandidateVersion("java","jdk8-latest-opendjk",Some("MAC_OSX"),"https://api.adoptopenjdk.net/openjdk8/releases/x64_mac/latest/binary"),
      CandidateVersion("java","jdk8-latest-opendjk",Some("WINDOWS_64"),"https://api.adoptopenjdk.net/openjdk8/releases/x64_win/latest/binary"),
      CandidateVersion("java","jdk8j9-latest-opendjk",Some("LINUX_64"),"https://api.adoptopenjdk.net/openjdk8-opnj9/releases/x64_linux/latest/binary"),
      CandidateVersion("java","jdk10-latest-opendjk",Some("LINUX_64"),"https://api.adoptopenjdk.net/openjdk10/releases/x64_linux/latest/binary"),
      CandidateVersion("java","jdk10-latest-opendjk",Some("MAC_OSX"),"https://api.adoptopenjdk.net/openjdk10/releases/x64_mac/latest/binary")
      ).asJava)
  
}
