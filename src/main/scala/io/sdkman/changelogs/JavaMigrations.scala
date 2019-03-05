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

  @ChangeSet(order = "061", id = "061-add_zulu_6_0_119", author = "vpavic")
  def migrate061(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows).foreach(platform => removeVersion(candidate = "java", version = "6.0.113-zulu", platform))
    List(
      Version("java", "6.0.119-zulu", "https://cdn.azul.com/zulu/bin/zulu6.22.0.3-jdk6.0.119-linux_x64.tar.gz", Linux64),
      Version("java", "6.0.119-zulu", "https://cdn.azul.com/zulu/bin/zulu6.22.0.3-jdk6.0.119-win_x64.zip", Windows)
    ).validate().insert()
  }

  @ChangeSet(order = "062", id = "062-add_zulu_7_0_201", author = "vpavic")
  def migrate062(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows).foreach(platform => removeVersion(candidate = "java", version = "7.0.191-zulu", platform))
    List(
      Version("java", "7.0.201-zulu", "https://cdn.azul.com/zulu/bin/zulu7.25.0.5-jdk7.0.201-linux_x64.tar.gz", Linux64),
      Version("java", "7.0.201-zulu", "https://cdn.azul.com/zulu/bin/zulu7.25.0.5-jdk7.0.201-win_x64.zip", Windows)
    ).validate().insert()
  }

  @ChangeSet(order = "063", id = "063-add_zulu_8_0_192", author = "vpavic")
  def migrate063(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "8.0.181-zulu", platform))
    List(
      Version("java", "8.0.192-zulu", "https://cdn.azul.com/zulu/bin/zulu8.33.0.1-jdk8.0.192-linux_x64.tar.gz", Linux64),
      Version("java", "8.0.192-zulu", "https://cdn.azul.com/zulu/bin/zulu8.33.0.1-jdk8.0.192-win_x64.zip", Windows),
      Version("java", "8.0.192-zulu", "https://cdn.azul.com/zulu/bin/zulu8.33.0.1-jdk8.0.192-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
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

  @ChangeSet(order = "073", id = "073-add_zulu_fx_8_0_192", author = "renannprado")
  def migrate073(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.192-fx-zulu", "https://cdn.azul.com/zulu/bin/zulu8.33.0.1-ca-fx-jdk8.0.192-linux_x64.tar.gz", Linux64),
      Version("java", "8.0.192-fx-zulu", "https://cdn.azul.com/zulu/bin/zulu8.33.0.1-ca-fx-jdk8.0.192-win_x64.zip", Windows),
      Version("java", "8.0.192-fx-zulu", "https://cdn.azul.com/zulu/bin/zulu8.33.0.1-ca-fx-jdk8.0.192-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
  }

  @ChangeSet(order = "074", id = "074-add_zulu_fx_11_0_1", author = "renannprado")
  def migrate074(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.1-fx-zulu", "https://cdn.azul.com/zulu/bin/zulu11.2.5-ca-fx-jdk11.0.1-linux_x64.tar.gz", Linux64),
      Version("java", "11.0.1-fx-zulu", "https://cdn.azul.com/zulu/bin/zulu11.2.5-ca-fx-jdk11.0.1-win_x64.zip", Windows),
      Version("java", "11.0.1-fx-zulu", "https://cdn.azul.com/zulu/bin/zulu11.2.5-ca-fx-jdk11.0.1-macosx_x64.zip", MacOSX)
    ).validate().insert()
  }

  @ChangeSet(order = "075", id = "075-readd_zulufx_8_0_192", author = "marc0der")
  def migrate075(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.192-zulufx", "https://cdn.azul.com/zulu/bin/zulu8.33.0.1-ca-fx-jdk8.0.192-linux_x64.tar.gz", Linux64),
      Version("java", "8.0.192-zulufx", "https://cdn.azul.com/zulu/bin/zulu8.33.0.1-ca-fx-jdk8.0.192-win_x64.zip", Windows),
      Version("java", "8.0.192-zulufx", "https://cdn.azul.com/zulu/bin/zulu8.33.0.1-ca-fx-jdk8.0.192-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "8.0.192-fx-zulu", _))
  }

  @ChangeSet(order = "076", id = "076-readd_zulufx_11_0_1", author = "marc0der")
  def migrate076(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.1-zulufx", "https://cdn.azul.com/zulu/bin/zulu11.2.5-ca-fx-jdk11.0.1-linux_x64.tar.gz", Linux64),
      Version("java", "11.0.1-zulufx", "https://cdn.azul.com/zulu/bin/zulu11.2.5-ca-fx-jdk11.0.1-win_x64.zip", Windows),
      Version("java", "11.0.1-zulufx", "https://cdn.azul.com/zulu/bin/zulu11.2.5-ca-fx-jdk11.0.1-macosx_x64.zip", MacOSX)
    ).validate().insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "11.0.1-fx-zulu", _))
  }

  @ChangeSet(order = "077", id = "077-add_zulu_8_0_201", author = "vpavic")
  def migrate077(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.201-zulu", "https://cdn.azul.com/zulu/bin/zulu8.34.0.1-ca-jdk8.0.201-linux_x64.tar.gz", Linux64),
      Version("java", "8.0.201-zulu", "https://cdn.azul.com/zulu/bin/zulu8.34.0.1-ca-jdk8.0.201-win_x64.zip", Windows),
      Version("java", "8.0.201-zulu", "https://cdn.azul.com/zulu/bin/zulu8.34.0.1-ca-jdk8.0.201-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "8.0.192-zulu", platform))
  }

  @ChangeSet(order = "078", id = "078-add_zulu_11_0_2", author = "vpavic")
  def migrate078(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.2-zulu", "https://cdn.azul.com/zulu/bin/zulu11.29.3-ca-jdk11.0.2-linux_x64.tar.gz", Linux64),
      Version("java", "11.0.2-zulu", "https://cdn.azul.com/zulu/bin/zulu11.29.3-ca-jdk11.0.2-win_x64.zip", Windows),
      Version("java", "11.0.2-zulu", "https://cdn.azul.com/zulu/bin/zulu11.29.3-ca-jdk11.0.2-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "11.0.1-zulu", platform))
  }

  @ChangeSet(order = "079", id = "079-add_corretto_8_0_202", author = "joschi")
  def migrate079(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.202-amzn", "https://d2znqt9b1bc64u.cloudfront.net/amazon-corretto-8.202.08.2-linux-x64.tar.gz", Linux64),
      Version("java", "8.0.202-amzn", "https://d2znqt9b1bc64u.cloudfront.net/amazon-corretto-8.202.08.2-windows-x64-jdk.zip", Windows),
      Version("java", "8.0.202-amzn", "https://d2znqt9b1bc64u.cloudfront.net/amazon-corretto-8.202.08.2-macosx-x64.tar.gz", MacOSX)
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "8.0.192-amzn", platform))
  }

  @ChangeSet(order = "080", id = "080-add_graalvm_1_0_0_rc_12", author = "wololock")
  def migrate080(implicit db: MongoDatabase) = {
    List(
      Version(
        candidate = "java",
        version = "1.0.0-rc-12-grl",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc12/graalvm-ce-1.0.0-rc12-linux-amd64.tar.gz",
        platform = Linux64),
      Version(
        candidate = "java",
        version = "1.0.0-rc-12-grl",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc12/graalvm-ce-1.0.0-rc12-macos-amd64.tar.gz",
        platform = MacOSX))
      .validate()
      .insert()
  }

  @ChangeSet(order = "081", id = "081-add_openj9_8_0_202", author = "joschi")
  def migrate081(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.202.j9-adpt", "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u202-b08/OpenJDK8U-jdk_x64_linux_openj9_8u202b08_openj9-0.12.0.tar.gz", Linux64),
      Version("java", "8.0.202.j9-adpt", "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u202-b08/OpenJDK8U-jdk_x64_windows_openj9_8u202b08_openj9-0.12.0.zip", Windows),
      Version("java", "8.0.202.j9-adpt", "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u202-b08/OpenJDK8U-jdk_x64_mac_openj9_8u202b08_openj9-0.12.0.tar.gz", MacOSX)
    ).validate().insert()
  }

  @ChangeSet(order = "082", id = "082-add_openj9_11_0_2", author = "joschi")
  def migrate082(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.2.j9-adpt", "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.2%2B9/OpenJDK11U-jdk_x64_linux_openj9_11.0.2_9_openj9-0.12.0.tar.gz", Linux64),
      Version("java", "11.0.2.j9-adpt", "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.2%2B9/OpenJDK11U-jdk_x64_windows_openj9_11.0.2_9_openj9-0.12.0.zip", Windows),
      Version("java", "11.0.2.j9-adpt", "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.2%2B9/OpenJDK11U-jdk_x64_mac_openj9_11.0.2_9_openj9-0.12.0.tar.gz", MacOSX)
    ).validate().insert()
  }

  @ChangeSet(order = "083", id = "083-add_adoptopenjdk-hs_8_0_202", author = "joschi")
  def migrate083(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.202.hs-adpt", "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u202-b08/OpenJDK8U-jdk_x64_linux_hotspot_8u202b08.tar.gz", Linux64),
      Version("java", "8.0.202.hs-adpt", "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u202-b08/OpenJDK8U-jdk_x64_windows_hotspot_8u202b08.zip", Windows),
      Version("java", "8.0.202.hs-adpt", "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u202-b08/OpenJDK8U-jdk_x64_mac_hotspot_8u202b08.tar.gz", MacOSX)
    ).validate().insert()
  }

  @ChangeSet(order = "084", id = "084-add_adoptopenjdk-hs_11_0_2", author = "joschi")
  def migrate084(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.2.hs-adpt", "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.2%2B9/OpenJDK11U-jdk_x64_linux_hotspot_11.0.2_9.tar.gz", Linux64),
      Version("java", "11.0.2.hs-adpt", "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.2%2B9/OpenJDK11U-jdk_x64_windows_hotspot_11.0.2_9.zip", Windows),
      Version("java", "11.0.2.hs-adpt", "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.2%2B9/OpenJDK11U-jdk_x64_mac_hotspot_11.0.2_9.tar.gz", MacOSX)
    ).validate().insert()
  }

  @ChangeSet(order = "085", id = "085-add_zulu_7_0_211", author = "vpavic")
  def migrate085(implicit db: MongoDatabase) = {
    List(
      Version("java", "7.0.211-zulu", "https://cdn.azul.com/zulu/bin/zulu7.27.0.1-ca-jdk7.0.211-linux_x64.tar.gz", Linux64),
      Version("java", "7.0.211-zulu", "https://cdn.azul.com/zulu/bin/zulu7.27.0.1-ca-jdk7.0.211-win_x64.zip", Windows)
    ).validate().insert()
    Seq(Linux64, Windows).foreach(platform => removeVersion(candidate = "java", version = "7.0.201-zulu", platform))
  }

  @ChangeSet(order = "086", id = "086-add_zulu_8_0_202", author = "vpavic")
  def migrate086(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.202-zulu", "https://cdn.azul.com/zulu/bin/zulu8.36.0.1-ca-jdk8.0.202-linux_x64.tar.gz", Linux64),
      Version("java", "8.0.202-zulu", "https://cdn.azul.com/zulu/bin/zulu8.36.0.1-ca-jdk8.0.202-win_x64.zip", Windows),
      Version("java", "8.0.202-zulu", "https://cdn.azul.com/zulu/bin/zulu8.36.0.1-ca-jdk8.0.202-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "8.0.201-zulu", platform))
  }


  @ChangeSet(order = "087", id = "087-add_openjdk_java_12-ea-31", author = "marc0der")
  def migrate087(implicit db: MongoDatabase): Unit = {
    List(
      Version("java", "12.ea.31-open", "https://download.java.net/java/early_access/jdk12/31/GPL/openjdk-12+31_linux-x64_bin.tar.gz", Linux64),
      Version("java", "12.ea.31-open", "https://download.java.net/java/early_access/jdk12/31/GPL/openjdk-12+31_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "12.ea.31-open", "https://download.java.net/java/early_access/jdk12/31/GPL/openjdk-12+31_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "12.ea.26-open", _))
  }

  @ChangeSet(order = "088", id = "088-add_openjdk_java_13-ea-07", author = "marc0der")
  def migrate088(implicit db: MongoDatabase): Unit = {
    List(
      Version("java", "13.ea.07-open", "https://download.java.net/java/early_access/jdk13/7/GPL/openjdk-13-ea+7_linux-x64_bin.tar.gz", Linux64),
      Version("java", "13.ea.07-open", "https://download.java.net/java/early_access/jdk13/7/GPL/openjdk-13-ea+7_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "13.ea.07-open", "https://download.java.net/java/early_access/jdk13/7/GPL/openjdk-13-ea+7_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "13.ea.02-open", _))
  }
  @ChangeSet(order = "089", id = "089-add_sapmachine_java_11.0.2", author = "msailer")
  def migrate089(implicit db: MongoDatabase): Unit = {
    List(
      Version("java", "11.0.2-sapmchn", "https://github.com/SAP/SapMachine/releases/download/sapmachine-11.0.2/sapmachine-jdk-11.0.2_linux-x64_bin.tar.gz", Linux64),
      Version("java", "11.0.2-sapmchn", "https://github.com/SAP/SapMachine/releases/download/sapmachine-11.0.2/sapmachine-jdk-11.0.2_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "11.0.2-sapmchn", "https://github.com/SAP/SapMachine/releases/download/sapmachine-11.0.2/sapmachine-jdk-11.0.2_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
  }

  @ChangeSet(order = "090", id = "090-add_zulufx_8_0_202", author = "vpavic")
  def migrate090(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.202-zulufx", "https://cdn.azul.com/zulu/bin/zulu8.36.0.1-ca-fx-jdk8.0.202-linux_x64.tar.gz", Linux64),
      Version("java", "8.0.202-zulufx", "https://cdn.azul.com/zulu/bin/zulu8.36.0.1-ca-fx-jdk8.0.202-win_x64.zip", Windows),
      Version("java", "8.0.202-zulufx", "https://cdn.azul.com/zulu/bin/zulu8.36.0.1-ca-fx-jdk8.0.202-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "8.0.192-zulufx", _))
  }

  @ChangeSet(order = "091", id = "091-add_zulufx_11_0_2", author = "vpavic")
  def migrate091(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.2-zulufx", "https://cdn.azul.com/zulu/bin/zulu11.29.3-ca-fx-jdk11.0.2-linux_x64.tar.gz", Linux64),
      Version("java", "11.0.2-zulufx", "https://cdn.azul.com/zulu/bin/zulu11.29.3-ca-fx-jdk11.0.2-win_x64.zip", Windows),
      Version("java", "11.0.2-zulufx", "https://cdn.azul.com/zulu/bin/zulu11.29.3-ca-fx-jdk11.0.2-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "11.0.1-zulufx", _))
  }

  @ChangeSet(order = "092", id = "092-add_corretto_11.0.2", author = "joschi")
  def migrate092(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.2-amzn", "https://d2jnoze5tfhthg.cloudfront.net/amazon-corretto-11.0.2.9.1-linux-x64.tar.gz", Linux64),
      Version("java", "11.0.2-amzn", "https://d2jnoze5tfhthg.cloudfront.net/amazon-corretto-11.0.2.9.1-windows-x64.zip", Windows),
      Version("java", "11.0.2-amzn", "https://d2jnoze5tfhthg.cloudfront.net/amazon-corretto-11.0.2.9.1-macosx-x64.tar.gz", MacOSX)
    ).validate().insert()
  }

  @ChangeSet(order = "093", id = "080-add_graalvm_1_0_0_rc_13", author = "wololock")
  def migrate093(implicit db: MongoDatabase) = {
    List(
      Version(
        candidate = "java",
        version = "1.0.0-rc-13-grl",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc13/graalvm-ce-1.0.0-rc13-linux-amd64.tar.gz",
        platform = Linux64),
      Version(
        candidate = "java",
        version = "1.0.0-rc-13-grl",
        url = "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc13/graalvm-ce-1.0.0-rc13-macos-amd64.tar.gz",
        platform = MacOSX))
      .validate()
      .insert()
  }
}
