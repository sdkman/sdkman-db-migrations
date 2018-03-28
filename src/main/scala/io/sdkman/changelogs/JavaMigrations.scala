package io.sdkman.changelogs

import com.github.mongobee.changeset.ChangeLog
import com.github.mongobee.changeset.ChangeSet
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

  @ChangeSet(order = "003", id = "003-clean_up_openjdk_variants", author = "marc0der")
  def migrate003(implicit db: MongoDatabase) =
    removeVersions("9u181-openjdk", "9.0.1-zulu", "9.0.0-zulu", "8u144-zulu", "8u144-openjdk", "8u131-zulu", "10u23-openjdk")
}
