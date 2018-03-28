package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "002")
class JavaMigrations {

  @ChangeSet(order = "001", id = "001-add_openjdk_10_0_0", author = "MaSven")
  def migrate001(implicit db: MongoDatabase) = insertVersions(
    Version("java", "10.0.0-openjdk", Some("WINDOWS_64"), "https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_windows-x64_bin.tar.gz"),
    Version("java", "10.0.0-openjdk", Some("MAC_OSX"), "https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_osx-x64_bin.tar.gz"),
    Version("java", "10.0.0-openjdk", Some("LINUX_64"), "https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_linux-x64_bin.tar.gz"))

  @ChangeSet(order = "002", id = "002-add_openjdk_9_0_4", author = "MaSven")
  def migrate002(implicit db: MongoDatabase) = insertVersions(
    Version("java", "9.0.4-openjdk", Some("MAC_OSX"), "https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_osx-x64_bin.tar.gz"),
    Version("java", "9.0.4-openjdk", Some("LINUX_64"), "https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_linux-x64_bin.tar.gz"),
    Version("java", "9.0.4-openjdk", Some("WINDOWS_64"), "https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_windows-x64_bin.tar.gz"))
}
