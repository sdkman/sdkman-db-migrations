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

  @ChangeSet(order = "043", id = "043-add_openjdk_java_11-ea-28", author = "mdeinum")
  def migrate043(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.ea.28-open", "https://download.java.net/java/early_access/jdk11/28/GPL/openjdk-11+28_linux-x64_bin.tar.gz", Linux64),
      Version("java", "11.ea.28-open", "https://download.java.net/java/early_access/jdk11/28/GPL/openjdk-11+28_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "11.ea.28-open", "https://download.java.net/java/early_access/jdk11/28/GPL/openjdk-11+28_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "11.ea.26-open", _))
  }

  @ChangeSet(order = "044", id = "044-add_openjdk_java_12-ea-08", author = "mdeinum")
  def migrate044(implicit db: MongoDatabase) = {
    List(
      Version("java", "12.ea.08-open", "https://download.java.net/java/early_access/jdk12/8/GPL/openjdk-12-ea+8_linux-x64_bin.tar.gz", Linux64),
      Version("java", "12.ea.08-open", "https://download.java.net/java/early_access/jdk12/8/GPL/openjdk-12-ea+8_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "12.ea.08-open", "https://download.java.net/java/early_access/jdk12/8/GPL/openjdk-12-ea+8_windows-x64_bin.zip", Windows))
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "12.ea.06-open", _))
  }

  @ChangeSet(order = "045", id = "045-add_graalvm_1_0_0_rc_6", author = "graemerocher")
  def migrate045(implicit db: MongoDatabase) = {
    Seq(Linux64, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "1.0.0-rc5-graal", platform))
    List(
      Version(
        candidate = "java",
        version = "1.0.0-rc6-graal",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc6/graalvm-ce-1.0.0-rc6-linux-amd64.tar.gz",
        platform = Linux64),
      Version(
        candidate = "java",
        version = "1.0.0-rc6-graal",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc6/graalvm-ce-1.0.0-rc6-macos-amd64.tar.gz",
        platform = MacOSX))
      .validate()
      .insert()
  }

  @ChangeSet(order = "046", id = "046-add_openjdk_java_12-ea-12", author = "marc0der")
  def migrate046(implicit db: MongoDatabase) = {
    List(
      Version("java", "12.ea.12-open", "https://download.java.net/java/early_access/jdk12/12/GPL/openjdk-12-ea+12_linux-x64_bin.tar.gz", Linux64),
      Version("java", "12.ea.12-open", "https://download.java.net/java/early_access/jdk12/12/GPL/openjdk-12-ea+12_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "12.ea.12-open", "https://download.java.net/java/early_access/jdk12/12/GPL/openjdk-12-ea+12_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "12.ea.08-open", _))
  }

  @ChangeSet(order = "047", id = "047-add_openjdk_java_11.0.0", author = "mdeinum")
  def migrate047(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.0-open", "https://download.java.net/java/GA/jdk11/28/GPL/openjdk-11+28_linux-x64_bin.tar.gz", Linux64),
      Version("java", "11.0.0-open", "https://download.java.net/java/GA/jdk11/28/GPL/openjdk-11+28_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "11.0.0-open", "https://download.java.net/java/GA/jdk11/28/GPL/openjdk-11+28_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "11.ea.28-open", _))
  }

  @ChangeSet(order = "048", id = "048-set_openjdk_java_11.0.0_default", author = "marc0der")
  def migrate048(implicit db: MongoDatabase) = setCandidateDefault("java", "11.0.0-open")

  @ChangeSet(order = "049", id = "049-add_graalvm_1_0_0_rc_7", author = "wololock")
  def migrate049(implicit db: MongoDatabase) = {
    Seq(Linux64, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "1.0.0-rc6-graal", platform))
    List(
      Version(
        candidate = "java",
        version = "1.0.0-rc7-graal",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc7/graalvm-ce-1.0.0-rc7-linux-amd64.tar.gz",
        platform = Linux64),
      Version(
        candidate = "java",
        version = "1.0.0-rc7-graal",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc7/graalvm-ce-1.0.0-rc7-macos-amd64.tar.gz",
        platform = MacOSX))
      .validate()
      .insert()
  }

  @ChangeSet(order = "050", id = "050-add_openjdk_java_12-ea-14", author = "renannprado")
  def migrate050(implicit db: MongoDatabase) = {
    List(
      Version("java", "12.ea.14-open", "https://download.java.net/java/early_access/jdk12/14/GPL/openjdk-12-ea+14_linux-x64_bin.tar.gz", Linux64),
      Version("java", "12.ea.14-open", "https://download.java.net/java/early_access/jdk12/14/GPL/openjdk-12-ea+14_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "12.ea.14-open", "https://download.java.net/java/early_access/jdk12/14/GPL/openjdk-12-ea+14_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "12.ea.12-open", _))
  }

  @ChangeSet(order = "051", id = "051-add_oracle_java_8.0.191", author = "marc0der")
  def migrate051(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.191-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u191-b12/2787e4a523244c269598db4e85c51e0c/jdk-8u191-linux-x64.tar.gz", Linux64),
      Version("java", "8.0.191-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u191-b12/2787e4a523244c269598db4e85c51e0c/jdk-8u191-linux-i586.tar.gz", Linux32),
      Version("java", "8.0.191-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u191-b12/2787e4a523244c269598db4e85c51e0c/jdk-8u191-macosx-x64.dmg", MacOSX),
      Version("java", "8.0.191-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u191-b12/2787e4a523244c269598db4e85c51e0c/jdk-8u191-windows-x64.exe", Windows))
      .validate()
      .insert()
    Seq(Linux64, Linux32, MacOSX, Windows).foreach(removeVersion("java", "8.0.181-oracle", _))
  }

  @ChangeSet(order = "052", id = "052-add_openjdk_java_11.0.1", author = "mdeinum")
  def migrate052(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.1-open", "https://download.java.net/java/GA/jdk11/13/GPL/openjdk-11.0.1_linux-x64_bin.tar.gz", Linux64),
      Version("java", "11.0.1-open", "https://download.java.net/java/GA/jdk11/13/GPL/openjdk-11.0.1_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "11.0.1-open", "https://download.java.net/java/GA/jdk11/13/GPL/openjdk-11.0.1_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "11.0.0-open", _))
  }

  @ChangeSet(order = "053", id = "053-add_openjdk_java_12-ea-15", author = "mdeinum")
  def migrate053(implicit db: MongoDatabase) = {
    List(
      Version("java", "12.ea.15-open", "https://download.java.net/java/early_access/jdk12/15/GPL/openjdk-12-ea+15_linux-x64_bin.tar.gz", Linux64),
      Version("java", "12.ea.15-open", "https://download.java.net/java/early_access/jdk12/15/GPL/openjdk-12-ea+15_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "12.ea.15-open", "https://download.java.net/java/early_access/jdk12/15/GPL/openjdk-12-ea+15_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "12.ea.14-open", _))
  }

  @ChangeSet(order = "054", id = "054-set_openjdk_java_11.0.1_default", author = "marc0der")
  def migrate054(implicit db: MongoDatabase) = setCandidateDefault("java", "11.0.1-open")

  @ChangeSet(order = "055", id = "055-remove_oracle_jdk_10.0.2", author = "marc0der")
  def migrate055(implicit db: MongoDatabase) = Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "10.0.2-oracle", _))

  @ChangeSet(order = "056", id = "056-add_graalvm_1_0_0_rc_8", author = "wololock")
  def migrate056(implicit db: MongoDatabase) = {
    Seq(Linux64, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "1.0.0-rc7-graal", platform))
    List(
      Version(
        candidate = "java",
        version = "1.0.0-rc8-graal",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc8/graalvm-ce-1.0.0-rc8-linux-amd64.tar.gz",
        platform = Linux64),
      Version(
        candidate = "java",
        version = "1.0.0-rc8-graal",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc8/graalvm-ce-1.0.0-rc8-macos-amd64.tar.gz",
        platform = MacOSX))
      .validate()
      .insert()
  }

  @ChangeSet(order = "057", id = "057-add_zulu_11_0_1", author = "vpavic")
  def migrate057(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.1-zulu", "https://cdn.azul.com/zulu/bin/zulu11.2.3-jdk11.0.1-linux_x64.tar.gz", Linux64),
      Version("java", "11.0.1-zulu", "https://cdn.azul.com/zulu/bin/zulu11.2.3-jdk11.0.1-win_x64.zip", Windows),
      Version("java", "11.0.1-zulu", "https://cdn.azul.com/zulu/bin/zulu11.2.3-jdk11.0.1-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
  }

  @ChangeSet(order = "058", id = "058-add_graalvm_1_0_0_rc_7", author = "ilopmar")
  def migrate058(implicit db: MongoDatabase) = {
    List(
      Version(
        candidate = "java",
        version = "1.0.0-rc7-graal",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc7/graalvm-ce-1.0.0-rc7-linux-amd64.tar.gz",
        platform = Linux64),
      Version(
        candidate = "java",
        version = "1.0.0-rc7-graal",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc7/graalvm-ce-1.0.0-rc7-macos-amd64.tar.gz",
        platform = MacOSX))
      .validate()
      .insert()
  }

}
