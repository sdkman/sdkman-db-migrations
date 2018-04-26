package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "002")
class JavaMigrations {

  @ChangeSet(order = "001", id = "001-add_openjdk_10_0_0", author = "MaSven")
  def migrate001(implicit db: MongoDatabase) =
    List(
      Version("java", "10.0.0-openjdk", "https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_windows-x64_bin.tar.gz", Windows),
      Version("java", "10.0.0-openjdk", "https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "10.0.0-openjdk", "https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_linux-x64_bin.tar.gz", Linux)
    ).insert()

  @ChangeSet(order = "002", id = "002-add_openjdk_9_0_4", author = "MaSven")
  def migrate002(implicit db: MongoDatabase) =
    List(
      Version("java", "9.0.4-openjdk", "https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "9.0.4-openjdk", "https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_linux-x64_bin.tar.gz", Linux),
      Version("java", "9.0.4-openjdk", "https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_windows-x64_bin.tar.gz", Windows)
    ).insert()

  @ChangeSet(order = "003", id = "003-add_zulu_10_0_0", author = "marc0der")
  def migrate003(implicit db: MongoDatabase) =
    List(
      Version("java", "10.0.0-zulu", "https://cdn.azul.com/zulu/bin/zulu10.1+11-jdk10-win_x64.zip", Windows),
      Version("java", "10.0.0-zulu", "https://cdn.azul.com/zulu/bin/zulu10.1+11-jdk10-linux_x64.tar.gz", Linux),
      Version("java", "10.0.0-zulu", "https://cdn.azul.com/zulu/bin/zulu10.1+11-jdk10-macosx_x64.zip", MacOSX)
    ).insert()

  @ChangeSet(order = "004", id = "004-add_zulu_8_0_163", author = "marc0der")
  def migrate004(implicit db: MongoDatabase) = {
    Seq(MacOSX, Linux, Windows).foreach(platform => removeVersion(candidate = "java", version = "8u152-zulu", platform))
    List(
      Version("java", "8.0.163-zulu", "https://cdn.azul.com/zulu/bin/zulu8.28.0.1-jdk8.0.163-macosx_x64.zip", MacOSX),
      Version("java", "8.0.163-zulu", "https://cdn.azul.com/zulu/bin/zulu8.28.0.1-jdk8.0.163-linux_x64.tar.gz", Linux),
      Version("java", "8.0.163-zulu", "https://cdn.azul.com/zulu/bin/zulu8.28.0.1-jdk8.0.163-win_x64.zip", Windows)
    ).insert()
  }

  @ChangeSet(order = "005", id = "005-add_oracle_jdk_10_0_0", author = "marc0der")
  def migrate005(implicit db: MongoDatabase) =
    List(
      Version("java", "10.0.0-oracle", "http://download.oracle.com/otn-pub/java/jdk/10+46/76eac37278c24557a3c4199677f19b62/jdk-10_osx-x64_bin.dmg", MacOSX),
      Version("java", "10.0.0-oracle", "http://download.oracle.com/otn-pub/java/jdk/10+46/76eac37278c24557a3c4199677f19b62/jdk-10_linux-x64_bin.tar.gz", Linux),
      Version("java", "10.0.0-oracle", "http://download.oracle.com/otn-pub/java/jdk/10+46/76eac37278c24557a3c4199677f19b62/jdk-10_windows-x64_bin.exe", Windows)
    ).insert()

  @ChangeSet(order = "006", id = "006-restore_openjdk_9_10_osx", author = "marc0der")
  def migrate006(implicit db: MongoDatabase) =
    List(
      Version("java", "9.0.4-openjdk", "https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "10.0.0-openjdk", "https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_osx-x64_bin.tar.gz", MacOSX)
    ).insert()

  @ChangeSet(order = "007", id = "007-add_zulu_6_0_103", author = "vpavic")
  def migrate007(implicit db: MongoDatabase) = {
    Seq(Linux, Windows).foreach(platform => removeVersion(candidate = "java", version = "6.0.93-zulu", platform))
    List(
      Version("java", "6.0.103-zulu", "http://cdn.azul.com/zulu/bin/zulu6.19.0.1-jdk6.0.103-linux_x64.tar.gz", Linux),
      Version("java", "6.0.103-zulu", "http://cdn.azul.com/zulu/bin/zulu6.19.0.1-jdk6.0.103-win_x64.zip", Windows)
    ).insert()
  }

  @ChangeSet(order = "008", id = "008-add_zulu_7_0_171", author = "vpavic")
  def migrate008(implicit db: MongoDatabase) = {
    Seq(Linux, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "7.0.141-zulu", platform))
    List(
      Version("java", "7.0.171-zulu", "https://cdn.azul.com/zulu/bin/zulu7.22.0.3-jdk7.0.171-linux_x64.tar.gz", Linux),
      Version("java", "7.0.171-zulu", "https://cdn.azul.com/zulu/bin/zulu7.22.0.3-jdk7.0.171-win_x64.zip", Windows),
      Version("java", "7.0.171-zulu", "https://cdn.azul.com/zulu/bin/zulu7.22.0.3-jdk7.0.171-macosx_x64.zip", MacOSX)
    ).insert()
  }

  @ChangeSet(order = "009", id = "009-add_oracle_8_0_171", author = "marc0der")
  def migrate009(implicit db: MongoDatabase) = {
    Seq(Linux, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "8.0.161-oracle", platform))
    List(
      Version("java", "8.0.171-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u171-b11/512cd62ec5174c3487ac17c61aaa89e8/jdk-8u171-linux-x64.tar.gz", Linux),
      Version("java", "8.0.171-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u171-b11/512cd62ec5174c3487ac17c61aaa89e8/jdk-8u171-windows-x64.exe", Windows),
      Version("java", "8.0.171-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u171-b11/512cd62ec5174c3487ac17c61aaa89e8/jdk-8u171-macosx-x64.dmg", MacOSX)
    ).insert()
  }

  @ChangeSet(order = "010", id = "010-add_oracle_10_0_1", author = "marc0der")
  def migrate010(implicit db: MongoDatabase) = {
    Seq(Linux, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "10.0.0-oracle", platform))
    List(
      Version("java", "10.0.1-oracle", "http://download.oracle.com/otn-pub/java/jdk/10.0.1+10/fb4372174a714e6b8c52526dc134031e/jdk-10.0.1_linux-x64_bin.tar.gz", Linux),
      Version("java", "10.0.1-oracle", "http://download.oracle.com/otn-pub/java/jdk/10.0.1+10/fb4372174a714e6b8c52526dc134031e/jdk-10.0.1_windows-x64_bin.exe", Windows),
      Version("java", "10.0.1-oracle", "http://download.oracle.com/otn-pub/java/jdk/10.0.1+10/fb4372174a714e6b8c52526dc134031e/jdk-10.0.1_osx-x64_bin.dmg", MacOSX)
    ).insert()
  }

  @ChangeSet(order = "011", id = "011-remove_oracle_9_0_4", author = "marc0der")
  def migrate011(implicit db: MongoDatabase) = {
    Seq(Linux, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "9.0.4-oracle", platform))
  }
}
