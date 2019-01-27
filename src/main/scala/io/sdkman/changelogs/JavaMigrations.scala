package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "002")
class JavaMigrations {

  @ChangeSet(order = "039", id = "039-update_java_default", author = "vpavic")
  def migrate039(implicit db: MongoDatabase) = setCandidateDefault("java", "8.0.181-zulu")

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

  @ChangeSet(order = "060", id = "060-add_graalvm_1_0_0_rc_9", author = "wololock")
  def migrate060(implicit db: MongoDatabase) = {
    List(
      Version(
        candidate = "java",
        version = "1.0.0-rc9-graal",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc9/graalvm-ce-1.0.0-rc9-linux-amd64.tar.gz",
        platform = Linux64),
      Version(
        candidate = "java",
        version = "1.0.0-rc9-graal",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc9/graalvm-ce-1.0.0-rc9-macos-amd64.tar.gz",
        platform = MacOSX))
      .validate()
      .insert()
  }

  @ChangeSet(order = "065", id = "065-remove-openjdk_java_11.e.26", author = "machielg")
  def migrate065(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "11.e.26-openjdk", platform))
  }

  @ChangeSet(order = "066", id = "066-add_graalvm_1_0_0_rc_10", author = "wololock")
  def migrate066(implicit db: MongoDatabase) = {
    List(
      Version(
        candidate = "java",
        version = "1.0.0-rc10-graa",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc10/graalvm-ce-1.0.0-rc10-linux-amd64.tar.gz",
        platform = Linux64),
      Version(
        candidate = "java",
        version = "1.0.0-rc10-graa",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc10/graalvm-ce-1.0.0-rc10-macos-amd64.tar.gz",
        platform = MacOSX))
      .validate()
      .insert()
  }

  @ChangeSet(order = "067", id = "067-add_openjdk_java_12-ea-26", author = "mdeinum")
  def migrate067(implicit db: MongoDatabase) = {
    List(
      Version("java", "12.ea.26-open", "https://download.java.net/java/early_access/jdk12/26/GPL/openjdk-12-ea+26_linux-x64_bin.tar.gz", Linux64),
      Version("java", "12.ea.26-open", "https://download.java.net/java/early_access/jdk12/26/GPL/openjdk-12-ea+26_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "12.ea.26-open", "https://download.java.net/java/early_access/jdk12/26/GPL/openjdk-12-ea+26_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "12.ea.20-open", _))
  }

  @ChangeSet(order = "068", id = "068-add_openjdk_java_13-ea-02", author = "mdeinum")
  def migrate068(implicit db: MongoDatabase) = {
    List(
      Version("java", "13.ea.02-open", "https://download.java.net/java/early_access/jdk13/2/GPL/openjdk-13-ea+2_linux-x64_bin.tar.gz", Linux64),
      Version("java", "13.ea.02-open", "https://download.java.net/java/early_access/jdk13/2/GPL/openjdk-13-ea+2_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "13.ea.02-open", "https://download.java.net/java/early_access/jdk13/2/GPL/openjdk-13-ea+2_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
  }

  @ChangeSet(order = "069", id = "069-add_graalvm_1_0_0_rc_11", author = "ilopmar")
  def migrate069(implicit db: MongoDatabase) = {
    List(
      Version(
        candidate = "java",
        version = "1.0.0-rc11-grl",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc11/graalvm-ce-1.0.0-rc11-linux-amd64.tar.gz",
        platform = Linux64),
      Version(
        candidate = "java",
        version = "1.0.0-rc11-grl",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc11/graalvm-ce-1.0.0-rc11-macos-amd64.tar.gz",
        platform = MacOSX))
      .validate()
      .insert()
  }

  @ChangeSet(order = "070", id = "070-add_corretto_8_0_192", author = "mdeinum")
  def migrate070(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.192-amzn", "https://d3pxv6yz143wms.cloudfront.net/amazon-corretto-preview2-8u192-linux-x64.tar.gz", Linux64),
      Version("java", "8.0.192-amzn", "https://d3pxv6yz143wms.cloudfront.net/amazon-corretto-preview2-8u192-windows-x64-jdk.zip", Windows),
      Version("java", "8.0.192-amzn", "https://d3pxv6yz143wms.cloudfront.net/amazon-corretto-preview2-8u192-macosx-x64.tar.gz", MacOSX)
    ).validate().insert()
  }

  @ChangeSet(order = "071", id = "071-add_oracle_java_8.0.201", author = "marc0der")
  def migrate071(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.201-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-linux-x64.tar.gz", Linux64),
      Version("java", "8.0.201-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-linux-i586.tar.gz", Linux32),
      Version("java", "8.0.201-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-macosx-x64.dmg", MacOSX),
      Version("java", "8.0.201-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-windows-x64.exe", Windows))
      .validate()
      .insert()
    Seq(Linux64, Linux32, MacOSX, Windows).foreach(removeVersion("java", "8.0.191-oracle", _))
  }

  @ChangeSet(order = "072", id = "072-update_openjdk_11_0_2", author = "marc0der")
  def migrate072(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.2-open", "https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz", Linux64),
      Version("java", "11.0.2-open", "https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "11.0.2-open", "https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
    setCandidateDefault("java", "11.0.2-open")
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "11.0.1-open", _))
  }

  @ChangeSet(order = "073", id = "073-update_leiningen_2_8_3", author = "simion-iulian")
  def migrate073(implicit db: MongoDatabase) = {
    List(
      Version("leiningen", "2.8.3", "https://github.com/technomancy/leiningen/releases/download/2.8.3/leiningen-2.8.3-standalone.zip", Linux64),
      Version("leiningen", "2.8.3", "https://github.com/technomancy/leiningen/releases/download/2.8.3/leiningen-2.8.3-standalone.zip", MacOSX),
      Version("leiningen", "2.8.3", "https://github.com/technomancy/leiningen/releases/download/2.8.3/leiningen-2.8.3-standalone.zip", Windows))
      .validate()
      .insert()
    setCandidateDefault("leiningen", "2.8.3")
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("leiningen", "2.8.3", _))
  }
}
