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
      Version("java", "10.0.0-openjdk", "https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_linux-x64_bin.tar.gz", Linux64)
    ).insert()

  @ChangeSet(order = "002", id = "002-add_openjdk_9_0_4", author = "MaSven")
  def migrate002(implicit db: MongoDatabase) =
    List(
      Version("java", "9.0.4-openjdk", "https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "9.0.4-openjdk", "https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_linux-x64_bin.tar.gz", Linux64),
      Version("java", "9.0.4-openjdk", "https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_windows-x64_bin.tar.gz", Windows)
    ).insert()

  @ChangeSet(order = "003", id = "003-add_zulu_10_0_0", author = "marc0der")
  def migrate003(implicit db: MongoDatabase) =
    List(
      Version("java", "10.0.0-zulu", "https://cdn.azul.com/zulu/bin/zulu10.1+11-jdk10-win_x64.zip", Windows),
      Version("java", "10.0.0-zulu", "https://cdn.azul.com/zulu/bin/zulu10.1+11-jdk10-linux_x64.tar.gz", Linux64),
      Version("java", "10.0.0-zulu", "https://cdn.azul.com/zulu/bin/zulu10.1+11-jdk10-macosx_x64.zip", MacOSX)
    ).insert()

  @ChangeSet(order = "004", id = "004-add_zulu_8_0_163", author = "marc0der")
  def migrate004(implicit db: MongoDatabase) = {
    Seq(MacOSX, Linux64, Windows).foreach(platform => removeVersion(candidate = "java", version = "8u152-zulu", platform))
    List(
      Version("java", "8.0.163-zulu", "https://cdn.azul.com/zulu/bin/zulu8.28.0.1-jdk8.0.163-macosx_x64.zip", MacOSX),
      Version("java", "8.0.163-zulu", "https://cdn.azul.com/zulu/bin/zulu8.28.0.1-jdk8.0.163-linux_x64.tar.gz", Linux64),
      Version("java", "8.0.163-zulu", "https://cdn.azul.com/zulu/bin/zulu8.28.0.1-jdk8.0.163-win_x64.zip", Windows)
    ).insert()
  }

  @ChangeSet(order = "005", id = "005-add_oracle_jdk_10_0_0", author = "marc0der")
  def migrate005(implicit db: MongoDatabase) =
    List(
      Version("java", "10.0.0-oracle", "http://download.oracle.com/otn-pub/java/jdk/10+46/76eac37278c24557a3c4199677f19b62/jdk-10_osx-x64_bin.dmg", MacOSX),
      Version("java", "10.0.0-oracle", "http://download.oracle.com/otn-pub/java/jdk/10+46/76eac37278c24557a3c4199677f19b62/jdk-10_linux-x64_bin.tar.gz", Linux64),
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
    Seq(Linux64, Windows).foreach(platform => removeVersion(candidate = "java", version = "6.0.93-zulu", platform))
    List(
      Version("java", "6.0.103-zulu", "http://cdn.azul.com/zulu/bin/zulu6.19.0.1-jdk6.0.103-linux_x64.tar.gz", Linux64),
      Version("java", "6.0.103-zulu", "http://cdn.azul.com/zulu/bin/zulu6.19.0.1-jdk6.0.103-win_x64.zip", Windows)
    ).insert()
  }

  @ChangeSet(order = "008", id = "008-add_zulu_7_0_171", author = "vpavic")
  def migrate008(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "7.0.141-zulu", platform))
    List(
      Version("java", "7.0.171-zulu", "https://cdn.azul.com/zulu/bin/zulu7.22.0.3-jdk7.0.171-linux_x64.tar.gz", Linux64),
      Version("java", "7.0.171-zulu", "https://cdn.azul.com/zulu/bin/zulu7.22.0.3-jdk7.0.171-win_x64.zip", Windows),
      Version("java", "7.0.171-zulu", "https://cdn.azul.com/zulu/bin/zulu7.22.0.3-jdk7.0.171-macosx_x64.zip", MacOSX)
    ).insert()
  }

  @ChangeSet(order = "009", id = "009-add_oracle_8_0_171", author = "marc0der")
  def migrate009(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "8.0.161-oracle", platform))
    List(
      Version("java", "8.0.171-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u171-b11/512cd62ec5174c3487ac17c61aaa89e8/jdk-8u171-linux-x64.tar.gz", Linux64),
      Version("java", "8.0.171-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u171-b11/512cd62ec5174c3487ac17c61aaa89e8/jdk-8u171-windows-x64.exe", Windows),
      Version("java", "8.0.171-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u171-b11/512cd62ec5174c3487ac17c61aaa89e8/jdk-8u171-macosx-x64.dmg", MacOSX)
    ).insert()
  }

  @ChangeSet(order = "010", id = "010-add_oracle_10_0_1", author = "marc0der")
  def migrate010(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "10.0.0-oracle", platform))
    List(
      Version("java", "10.0.1-oracle", "http://download.oracle.com/otn-pub/java/jdk/10.0.1+10/fb4372174a714e6b8c52526dc134031e/jdk-10.0.1_linux-x64_bin.tar.gz", Linux64),
      Version("java", "10.0.1-oracle", "http://download.oracle.com/otn-pub/java/jdk/10.0.1+10/fb4372174a714e6b8c52526dc134031e/jdk-10.0.1_windows-x64_bin.exe", Windows),
      Version("java", "10.0.1-oracle", "http://download.oracle.com/otn-pub/java/jdk/10.0.1+10/fb4372174a714e6b8c52526dc134031e/jdk-10.0.1_osx-x64_bin.dmg", MacOSX)
    ).insert()
  }

  @ChangeSet(order = "011", id = "011-remove_oracle_9_0_4", author = "marc0der")
  def migrate011(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "9.0.4-oracle", platform))
  }

  @ChangeSet(order = "012", id = "012-add_zulu_6_0_107", author = "vpavic")
  def migrate012(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows).foreach(platform => removeVersion(candidate = "java", version = "6.0.103-zulu", platform))
    List(
      Version("java", "6.0.107-zulu", "https://cdn.azul.com/zulu/bin/zulu6.20.0.1-jdk6.0.107-linux_x64.tar.gz", Linux64),
      Version("java", "6.0.107-zulu", "https://cdn.azul.com/zulu/bin/zulu6.20.0.1-jdk6.0.107-win_x64.zip", Windows)
    ).insert()
  }

  @ChangeSet(order = "013", id = "013-add_zulu_7_0_181", author = "vpavic")
  def migrate013(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "7.0.171-zulu", platform))
    List(
      Version("java", "7.0.181-zulu", "https://cdn.azul.com/zulu/bin/zulu7.23.0.1-jdk7.0.181-linux_x64.tar.gz", Linux64),
      Version("java", "7.0.181-zulu", "https://cdn.azul.com/zulu/bin/zulu7.23.0.1-jdk7.0.181-win_x64.zip", Windows),
      Version("java", "7.0.181-zulu", "https://cdn.azul.com/zulu/bin/zulu7.23.0.1-jdk7.0.181-macosx_x64.tar.gz", MacOSX)
    ).insert()
  }

  @ChangeSet(order = "014", id = "014-add_zulu_8_0_172", author = "vpavic")
  def migrate014(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "8.0.163-zulu", platform))
    List(
      Version("java", "8.0.172-zulu", "https://cdn.azul.com/zulu/bin/zulu8.30.0.1-jdk8.0.172-linux_x64.tar.gz", Linux64),
      Version("java", "8.0.172-zulu", "https://cdn.azul.com/zulu/bin/zulu8.30.0.1-jdk8.0.172-win_x64.zip", Windows),
      Version("java", "8.0.172-zulu", "https://cdn.azul.com/zulu/bin/zulu8.30.0.1-jdk8.0.172-macosx_x64.tar.gz", MacOSX)
    ).insert()
  }

  @ChangeSet(order = "015", id = "015-add_zulu_9_0_7", author = "vpavic")
  def migrate015(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "9.0.4-zulu", platform))
    List(
      Version("java", "9.0.7-zulu", "https://cdn.azul.com/zulu/bin/zulu9.0.7.1-jdk9.0.7-linux_x64.tar.gz", Linux64),
      Version("java", "9.0.7-zulu", "https://cdn.azul.com/zulu/bin/zulu9.0.7.1-jdk9.0.7-win_x64.zip", Windows),
      Version("java", "9.0.7-zulu", "https://cdn.azul.com/zulu/bin/zulu9.0.7.1-jdk9.0.7-macosx_x64.tar.gz", MacOSX)
    ).insert()
  }

  @ChangeSet(order = "016", id = "016-add_zulu_10_0_1", author = "vpavic")
  def migrate016(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "10.0.0-zulu", platform))
    List(
      Version("java", "10.0.1-zulu", "https://cdn.azul.com/zulu/bin/zulu10.2+3-jdk10.0.1-linux_x64.tar.gz", Linux64),
      Version("java", "10.0.1-zulu", "https://cdn.azul.com/zulu/bin/zulu10.2+3-jdk10.0.1-win_x64.zip", Windows),
      Version("java", "10.0.1-zulu", "https://cdn.azul.com/zulu/bin/zulu10.2+3-jdk10.0.1-macosx_x64.tar.gz", MacOSX)
    ).insert()
  }

  @ChangeSet(order = "017", id = "017-update_java_default", author = "vpavic")
  def migrate017(implicit db: MongoDatabase) = setCandidateDefault("java", "8.0.172-zulu")

  @ChangeSet(order = "018", id = "018-lemove_broken_zulu_jdks", author = "marc0der")
  def migrate018(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows).foreach { platform =>
      removeVersion("java", "6.0.107-zulu", platform)
      removeVersion("java", "7.0.181-zulu", platform)
      removeVersion("java", "9.0.7-zulu", platform)
    }
    removeVersion("java", "9.0.7-zulu", MacOSX)
  }

  @ChangeSet(order = "019", id = "019-add_zulu_6_0_103", author = "marc0der")
  def migrate019(implicit db: MongoDatabase) = {
    List(
      Version("java", "6.0.103-zulu", "http://cdn.azul.com/zulu/bin/zulu6.19.0.1-jdk6.0.103-linux_x64.tar.gz", Linux64),
      Version("java", "6.0.103-zulu", "http://cdn.azul.com/zulu/bin/zulu6.19.0.1-jdk6.0.103-win_x64.zip", Windows)
    ).insert()
  }

  @ChangeSet(order = "020", id = "020-add_zulu_7_0_171", author = "marc0der")
  def migrate020(implicit db: MongoDatabase) = {
    List(
      Version("java", "7.0.171-zulu", "https://cdn.azul.com/zulu/bin/zulu7.22.0.3-jdk7.0.171-linux_x64.tar.gz", Linux64),
      Version("java", "7.0.171-zulu", "https://cdn.azul.com/zulu/bin/zulu7.22.0.3-jdk7.0.171-win_x64.zip", Windows),
      Version("java", "7.0.171-zulu", "https://cdn.azul.com/zulu/bin/zulu7.22.0.3-jdk7.0.171-macosx_x64.zip", MacOSX)
    ).insert()
  }

  @ChangeSet(order = "021", id = "021-add_openjdk_9_0_4", author = "marc0der")
  def migrate021(implicit db: MongoDatabase) = {
    List(
      Version("java", "9.0.4-zulu", "https://cdn.azul.com/zulu/bin/zulu9.0.4.1-jdk9.0.4-macosx_x64.tar.gz", Linux64),
      Version("java", "9.0.4-zulu", "https://cdn.azul.com/zulu/bin/zulu9.0.4.1-jdk9.0.4-win_x64.zip", Windows),
      Version("java", "9.0.4-zulu", "https://cdn.azul.com/zulu/bin/zulu9.0.4.1-jdk9.0.4-macosx_x64.tar.gz", MacOSX)
    ).insert()
  }

  @ChangeSet(order = "022", id = "022-add_zulu_6_0_107", author = "vpavic")
  def migrate022(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows).foreach(platform => removeVersion(candidate = "java", version = "6.0.103-zulu", platform))
    List(
      Version("java", "6.0.107-zulu", "https://cdn.azul.com/zulu/bin/zulu6.20.0.1-jdk6.0.107-linux_x64.tar.gz", Linux64),
      Version("java", "6.0.107-zulu", "https://cdn.azul.com/zulu/bin/zulu6.20.0.1-jdk6.0.107-win_x64.zip", Windows)
    ).validate().insert()
  }

  @ChangeSet(order = "023", id = "023-add_zulu_7_0_181", author = "vpavic")
  def migrate023(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "7.0.171-zulu", platform))
    List(
      Version("java", "7.0.181-zulu", "https://cdn.azul.com/zulu/bin/zulu7.23.0.1-jdk7.0.181-linux_x64.tar.gz", Linux64),
      Version("java", "7.0.181-zulu", "https://cdn.azul.com/zulu/bin/zulu7.23.0.1-jdk7.0.181-win_x64.zip", Windows),
      Version("java", "7.0.181-zulu", "https://cdn.azul.com/zulu/bin/zulu7.23.0.1-jdk7.0.181-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
  }

  @ChangeSet(order = "024", id = "024-add_zulu_9_0_7", author = "vpavic")
  def migrate024(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "9.0.4-zulu", platform))
    List(
      Version("java", "9.0.7-zulu", "https://cdn.azul.com/zulu/bin/zulu9.0.7.1-jdk9.0.7-linux_x64.tar.gz", Linux64),
      Version("java", "9.0.7-zulu", "https://cdn.azul.com/zulu/bin/zulu9.0.7.1-jdk9.0.7-win_x64.zip", Windows),
      Version("java", "9.0.7-zulu", "https://cdn.azul.com/zulu/bin/zulu9.0.7.1-jdk9.0.7-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
  }

  @ChangeSet(order = "025", id = "025-add_graalvm_1_0_0_rc_1", author = "marc0der")
  def migrate025(implicit db: MongoDatabase) =
    Version(
      candidate = "java",
      version = "1.0.0-rc1-graal",
      url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc1/graalvm-ce-1.0.0-rc1-linux-amd64.tar.gz",
      platform = Linux64)
      .validate()
      .insert()

  @ChangeSet(order = "026", id = "026-update_linux_32_oracle_java", author = "marc0der")
  def migrate026(implicit db: MongoDatabase) = {
    removeVersion("java", "8.0.151-oracle", Linux32)
    Version(
      candidate = "java",
      version = "8.0.171-oracle",
      url = "http://download.oracle.com/otn-pub/java/jdk/8u171-b11/512cd62ec5174c3487ac17c61aaa89e8/jdk-8u171-linux-i586.tar.gz",
      platform = Linux32)
      .validate()
      .insert()
  }

  @ChangeSet(order = "027", id = "027-add_graalvm_1_0_0_rc_3", author = "wololock")
  def migrate027(implicit db: MongoDatabase) = {
    removeVersion("java", "1.0.0-rc1-graal", Linux64)
    Version(
      candidate = "java",
      version = "1.0.0-rc3-graal",
      url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc3/graalvm-ce-1.0.0-rc3-linux-amd64.tar.gz",
      platform = Linux64)
      .validate()
      .insert()
  }

  @ChangeSet(order = "028", id = "028-release_oracle_java_8_0_181", author = "marc0der")
  def migrate028(implicit db: MongoDatabase) = {
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "8.0.171-oracle", _))
    List(
      Version("java", "8.0.181-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u181-b13/96a7b8442fe848ef90c96a2fad6ed6d1/jdk-8u181-linux-x64.tar.gz", Linux64),
      Version("java", "8.0.181-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u181-b13/96a7b8442fe848ef90c96a2fad6ed6d1/jdk-8u181-macosx-x64.dmg", MacOSX),
      Version("java", "8.0.181-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u181-b13/96a7b8442fe848ef90c96a2fad6ed6d1/jdk-8u181-windows-x64.exe", Windows))
      .validate()
      .insert()
  }

  @ChangeSet(order = "029", id = "029-release_oracle_java_10_0_2", author = "marc0der")
  def migrate029(implicit db: MongoDatabase) = {
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "10.0.1-oracle", _))
    List(
      Version("java", "10.0.2-oracle", "http://download.oracle.com/otn-pub/java/jdk/10.0.2+13/19aef61b38124481863b1413dce1855f/jdk-10.0.2_linux-x64_bin.tar.gz", Linux64),
      Version("java", "10.0.2-oracle", "http://download.oracle.com/otn-pub/java/jdk/10.0.2+13/19aef61b38124481863b1413dce1855f/jdk-10.0.2_osx-x64_bin.dmg", MacOSX),
      Version("java", "10.0.2-oracle", "http://download.oracle.com/otn-pub/java/jdk/10.0.2+13/19aef61b38124481863b1413dce1855f/jdk-10.0.2_windows-x64_bin.exe", Windows))
      .validate()
      .insert()
  }

  @ChangeSet(order = "030", id = "030-release_oracle_java_8_0_181_linux32", author = "marc0der")
  def migrate030(implicit db: MongoDatabase) = {
    removeVersion("java", "8.0.171-oracle", Linux32)
      Version("java", "8.0.181-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u181-b13/96a7b8442fe848ef90c96a2fad6ed6d1/jdk-8u181-linux-i586.tar.gz", Linux32)
      .validate()
      .insert()
  }

  @ChangeSet(order = "031", id = "031-add_graalvm_1_0_0_rc_4", author = "wololock")
  def migrate031(implicit db: MongoDatabase) = {
    removeVersion("java", "1.0.0-rc3-graal", Linux64)
    Version(
      candidate = "java",
      version = "1.0.0-rc4-graal",
      url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc4/graalvm-ce-1.0.0-rc4-linux-amd64.tar.gz",
      platform = Linux64)
      .validate()
      .insert()
  }
}
