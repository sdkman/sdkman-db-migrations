package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "002")
class JavaMigrations {

  @ChangeSet(order = "035", id = "035-add_zulu_6_0_113", author = "vpavic")
  def migrate035(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows).foreach(platform => removeVersion(candidate = "java", version = "6.0.107-zulu", platform))
    List(
      Version("java", "6.0.113-zulu", "https://cdn.azul.com/zulu/bin/zulu6.21.0.3-jdk6.0.113-linux_x64.tar.gz", Linux64),
      Version("java", "6.0.113-zulu", "https://cdn.azul.com/zulu/bin/zulu6.21.0.3-jdk6.0.113-win_x64.zip", Windows)
    ).validate().insert()
  }

  @ChangeSet(order = "036", id = "036-add_zulu_7_0_191", author = "vpavic")
  def migrate036(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows).foreach(platform => removeVersion(candidate = "java", version = "7.0.181-zulu", platform))
    List(
      Version("java", "7.0.191-zulu", "https://cdn.azul.com/zulu/bin/zulu7.24.0.1-jdk7.0.191-linux_x64.tar.gz", Linux64),
      Version("java", "7.0.191-zulu", "https://cdn.azul.com/zulu/bin/zulu7.24.0.1-jdk7.0.191-win_x64.zip", Windows)
    ).validate().insert()
  }

  @ChangeSet(order = "037", id = "037-add_zulu_8_0_181", author = "vpavic")
  def migrate037(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "8.0.172-zulu", platform))
    List(
      Version("java", "8.0.181-zulu", "https://cdn.azul.com/zulu/bin/zulu8.31.0.1-jdk8.0.181-linux_x64.tar.gz", Linux64),
      Version("java", "8.0.181-zulu", "https://cdn.azul.com/zulu/bin/zulu8.31.0.1-jdk8.0.181-win_x64.zip", Windows),
      Version("java", "8.0.181-zulu", "https://cdn.azul.com/zulu/bin/zulu8.31.0.1-jdk8.0.181-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
  }

  @ChangeSet(order = "038", id = "038-add_zulu_10_0_2", author = "vpavic")
  def migrate038(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "10.0.1-zulu", platform))
    List(
      Version("java", "10.0.2-zulu", "https://cdn.azul.com/zulu/bin/zulu10.3+5-jdk10.0.2-linux_x64.tar.gz", Linux64),
      Version("java", "10.0.2-zulu", "https://cdn.azul.com/zulu/bin/zulu10.3+5-jdk10.0.2-win_x64.zip", Windows),
      Version("java", "10.0.2-zulu", "https://cdn.azul.com/zulu/bin/zulu10.3+5-jdk10.0.2-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
  }

  @ChangeSet(order = "039", id = "039-update_java_default", author = "vpavic")
  def migrate039(implicit db: MongoDatabase) = setCandidateDefault("java", "8.0.181-zulu")

  @ChangeSet(order = "040", id = "033-add_openjdk_java_11-ea-26", author = "mdeinum")
  def migrate040(implicit db: MongoDatabase) = {
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "11.e.25-openjdk", _))
    List(
      Version("java", "11.e.26-openjdk", "https://download.java.net/java/early_access/jdk11/26/GPL/openjdk-11-ea+26_linux-x64_bin.tar.gz", Linux64),
      Version("java", "11.e.26-openjdk", "https://download.java.net/java/early_access/jdk11/26/GPL/openjdk-11-ea+26_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "11.e.26-openjdk", "https://download.java.net/java/early_access/jdk11/26/GPL/openjdk-11-ea+26_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
  }

  @ChangeSet(order = "041", id = "034-add_openjdk_java_12-ea-06", author = "mdeinum")
  def migrate041(implicit db: MongoDatabase) = {
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "12.e.05-openjdk", _))
    List(
      Version("java", "12.e.06-openjdk", "https://download.java.net/java/early_access/jdk12/6/GPL/openjdk-12-ea+6_linux-x64_bin.tar.gz", Linux64),
      Version("java", "12.e.06-openjdk", "https://download.java.net/java/early_access/jdk12/6/GPL/openjdk-12-ea+6_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "12.e.06-openjdk", "https://download.java.net/java/early_access/jdk12/6/GPL/openjdk-12-ea+6_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
  }

  @ChangeSet(order = "042", id = "042-add_openjdk_java_10.0.2", author = "marc0der")
  def migrate042(implicit db: MongoDatabase) = {
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "10.0.0-open", _))
    List(
      Version("java", "10.0.2-open", "https://download.java.net/java/GA/jdk10/10.0.2/19aef61b38124481863b1413dce1855f/13/openjdk-10.0.2_linux-x64_bin.tar.gz", Linux64),
      Version("java", "10.0.2-open", "https://download.java.net/java/GA/jdk10/10.0.2/19aef61b38124481863b1413dce1855f/13/openjdk-10.0.2_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "10.0.2-open", "https://download.java.net/java/GA/jdk10/10.0.2/19aef61b38124481863b1413dce1855f/13/openjdk-10.0.2_windows-x64_bin.tar.gz", Windows))
      .validate()
      .insert()
    setCandidateDefault("java", "10.0.2-open")
  }
}
