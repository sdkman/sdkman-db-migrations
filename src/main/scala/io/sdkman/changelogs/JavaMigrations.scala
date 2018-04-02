package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "002")
class JavaMigrations {

  @ChangeSet(order = "001", id = "001-add_openjdk_10_0_0", author = "MaSven")
  def migrate001(implicit db: MongoDatabase) = insertVersions(
    Version("java", "10.0.0-openjdk", "https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_windows-x64_bin.tar.gz", Windows),
    Version("java", "10.0.0-openjdk", "https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_osx-x64_bin.tar.gz", MacOSX),
    Version("java", "10.0.0-openjdk", "https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_linux-x64_bin.tar.gz", Linux))

  @ChangeSet(order = "002", id = "002-add_openjdk_9_0_4", author = "MaSven")
  def migrate002(implicit db: MongoDatabase) = insertVersions(
    Version("java", "9.0.4-openjdk", "https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_osx-x64_bin.tar.gz", MacOSX),
    Version("java", "9.0.4-openjdk", "https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_linux-x64_bin.tar.gz", Linux),
    Version("java", "9.0.4-openjdk", "https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_windows-x64_bin.tar.gz", Windows))

  @ChangeSet(order = "003", id = "003-add_zulu_10_0_0", author = "marc0der")
  def migrate003(implicit db: MongoDatabase) = insertVersions(
    Version("java", "10.0.0-zulu", "https://cdn.azul.com/zulu/bin/zulu10.1+11-jdk10-win_x64.zip", Windows),
    Version("java", "10.0.0-zulu", "https://cdn.azul.com/zulu/bin/zulu10.1+11-jdk10-linux_x64.tar.gz", Linux),
    Version("java", "10.0.0-zulu", "https://cdn.azul.com/zulu/bin/zulu10.1+11-jdk10-macosx_x64.zip", MacOSX))

  @ChangeSet(order = "004", id = "004-add_zulu_8_0_163", author = "marc0der")
  def migrate004(implicit db: MongoDatabase) = {
    Seq(MacOSX, Linux, Windows).foreach(platform => removeVersion(candidate = "java", version = "8u152-zulu", platform))
    insertVersions(
      Version("java", "8.0.163-zulu", "https://cdn.azul.com/zulu/bin/zulu8.28.0.1-jdk8.0.163-macosx_x64.zip", MacOSX),
      Version("java", "8.0.163-zulu", "https://cdn.azul.com/zulu/bin/zulu8.28.0.1-jdk8.0.163-linux_x64.tar.gz", Linux),
      Version("java", "8.0.163-zulu", "https://cdn.azul.com/zulu/bin/zulu8.28.0.1-jdk8.0.163-win_x64.zip", Windows))
  }

  @ChangeSet(order = "005", id = "005-add_oracle_jdk_10_0_0", author = "marc0der")
  def migrate005(implicit db: MongoDatabase) = {
    insertVersions(
      Version("java", "10.0.0-oracle", "http://download.oracle.com/otn-pub/java/jdk/10+46/76eac37278c24557a3c4199677f19b62/jdk-10_osx-x64_bin.dmg", MacOSX),
      Version("java", "10.0.0-oracle", "http://download.oracle.com/otn-pub/java/jdk/10+46/76eac37278c24557a3c4199677f19b62/jdk-10_linux-x64_bin.tar.gz", Linux),
      Version("java", "10.0.0-oracle", "http://download.oracle.com/otn-pub/java/jdk/10+46/76eac37278c24557a3c4199677f19b62/jdk-10_windows-x64_bin.exe", Windows))
  }

  @ChangeSet(order = "006", id = "006-restore_openjdk_9_10_osx", author = "marc0der")
  def migrate006(implicit db: MongoDatabase) = {
    insertVersions(
      Version("java", "9.0.4-openjdk", "https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "10.0.0-openjdk", "https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_osx-x64_bin.tar.gz", MacOSX))
  }
}
