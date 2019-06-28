package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "002")
class JavaMigrations {

  @ChangeSet(order = "038", id = "038-add_zulu_10_0_2", author = "vpavic")
  def migrate038(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "10.0.1-zulu", platform))
    List(
      Version("java", "10.0.2-zulu", "https://cdn.azul.com/zulu/bin/zulu10.3+5-jdk10.0.2-linux_x64.tar.gz", Linux64),
      Version("java", "10.0.2-zulu", "https://cdn.azul.com/zulu/bin/zulu10.3+5-jdk10.0.2-win_x64.zip", Windows),
      Version("java", "10.0.2-zulu", "https://cdn.azul.com/zulu/bin/zulu10.3+5-jdk10.0.2-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
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

  @ChangeSet(order = "061", id = "061-add_zulu_6_0_119", author = "vpavic")
  def migrate061(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows).foreach(platform => removeVersion(candidate = "java", version = "6.0.113-zulu", platform))
    List(
      Version("java", "6.0.119-zulu", "https://cdn.azul.com/zulu/bin/zulu6.22.0.3-jdk6.0.119-linux_x64.tar.gz", Linux64),
      Version("java", "6.0.119-zulu", "https://cdn.azul.com/zulu/bin/zulu6.22.0.3-jdk6.0.119-win_x64.zip", Windows)
    ).validate().insert()
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

  @ChangeSet(order = "107", id = "107-add_openjdk_java_12.0.1", author = "eddumelendez")
  def migrate107(implicit db: MongoDatabase): Unit = {
    List(
      Version("java", "12.0.1-open", "https://download.java.net/java/GA/jdk12.0.1/69cfe15208a647278a19ef0990eea691/12/GPL/openjdk-12.0.1_linux-x64_bin.tar.gz", Linux64),
      Version("java", "12.0.1-open", "https://download.java.net/java/GA/jdk12.0.1/69cfe15208a647278a19ef0990eea691/12/GPL/openjdk-12.0.1_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "12.0.1-open", "https://download.java.net/java/GA/jdk12.0.1/69cfe15208a647278a19ef0990eea691/12/GPL/openjdk-12.0.1_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "12.0.0-open", _))
  }

  @ChangeSet(order = "108", id = "108-add_corretto_11.0.3", author = "philiplourandos")
  def migrate108(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.3-amzn", "https://d3pxv6yz143wms.cloudfront.net/11.0.3.7.1/amazon-corretto-11.0.3.7.1-linux-x64.tar.gz", Linux64),
      Version("java", "11.0.3-amzn", "https://d3pxv6yz143wms.cloudfront.net/11.0.3.7.1/amazon-corretto-11.0.3.7.1-windows-x64.zip", Windows),
      Version("java", "11.0.3-amzn", "https://d3pxv6yz143wms.cloudfront.net/11.0.3.7.1/amazon-corretto-11.0.3.7.1-macosx-x64.tar.gz", MacOSX))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "11.0.2-amzn", _))
  }

  @ChangeSet(order = "109", id = "109-add_corretto_8.0.212", author = "philiplourandos")
  def migrate109(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.212-amzn", "https://d3pxv6yz143wms.cloudfront.net/8.212.04.1/amazon-corretto-8.212.04.1-linux-x64.tar.gz", Linux64),
      Version("java", "8.0.212-amzn", "https://d3pxv6yz143wms.cloudfront.net/8.212.04.1/amazon-corretto-8.212.04.1-windows-x64-jdk.zip", Windows),
      Version("java", "8.0.212-amzn", "https://d3pxv6yz143wms.cloudfront.net/8.212.04.1/amazon-corretto-8.212.04.1-macosx-x64.tar.gz", MacOSX))
      .validate()
      .insert()
    Seq(Linux64, Windows).foreach(removeVersion(candidate = "java", version = "8.0.202-amzn", _))
  }

  @ChangeSet(order = "110", id = "110-add_zulu_7_0_222", author = "philiplourandos")
  def migrate110(implicit db: MongoDatabase) = {
    List(
      Version("java", "7.0.222-zulu", "https://cdn.azul.com/zulu/bin/zulu7.29.0.5-ca-jdk7.0.222-linux_x64.tar.gz", Linux64),
      Version("java", "7.0.222-zulu", "https://cdn.azul.com/zulu/bin/zulu7.29.0.5-ca-jdk7.0.222-win_x64.zip", Windows),
      Version("java", "7.0.222-zulu", "https://cdn.azul.com/zulu/bin/zulu7.29.0.5-ca-jdk7.0.222-macosx_x64.zip", MacOSX)
    ).validate().insert()
    Seq(Linux64, Windows).foreach(removeVersion(candidate = "java", version = "7.0.211-zulu", _))
  }

  @ChangeSet(order = "111", id = "111-add_zulu_8_0_212", author = "philiplourandos")
  def migrate111(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.212-zulu", "https://cdn.azul.com/zulu/bin/zulu8.38.0.13-ca-jdk8.0.212-linux_x64.tar.gz", Linux64),
      Version("java", "8.0.212-zulu", "https://cdn.azul.com/zulu/bin/zulu8.38.0.13-ca-jdk8.0.212-win_x64.zip", Windows),
      Version("java", "8.0.212-zulu", "https://cdn.azul.com/zulu/bin/zulu8.38.0.13-ca-jdk8.0.212-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
    Seq(Linux64, Windows).foreach(removeVersion(candidate = "java", version = "8.0.202-zulu", _))
  }

  @ChangeSet(order = "112", id = "112-add_zulu_11_0_3", author = "jorsol")
  def migrate112(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.3-zulu", "https://cdn.azul.com/zulu/bin/zulu11.31.11-ca-jdk11.0.3-linux_x64.tar.gz", Linux64),
      Version("java", "11.0.3-zulu", "https://cdn.azul.com/zulu/bin/zulu11.31.11-ca-jdk11.0.3-win_x64.zip", Windows),
      Version("java", "11.0.3-zulu", "https://cdn.azul.com/zulu/bin/zulu11.31.11-ca-jdk11.0.3-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "11.0.2-zulu", platform))
  }

  @ChangeSet(order = "113", id = "113-add_zulu_12_0_1", author = "jorsol")
  def migrate113(implicit db: MongoDatabase) = {
    List(
      Version("java", "12.0.1-zulu", "https://cdn.azul.com/zulu/bin/zulu12.2.3-ca-jdk12.0.1-linux_x64.tar.gz", Linux64),
      Version("java", "12.0.1-zulu", "https://cdn.azul.com/zulu/bin/zulu12.2.3-ca-jdk12.0.1-win_x64.zip", Windows),
      Version("java", "12.0.1-zulu", "https://cdn.azul.com/zulu/bin/zulu12.2.3-ca-jdk12.0.1-macosx_x64.tar.gz", MacOSX)
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "12.0.0-zulu", platform))
  }

  @ChangeSet(order = "114", id = "114-add_sapmachine_java_11.0.3", author = "jorsol")
  def migrate114(implicit db: MongoDatabase): Unit = {
    List(
      Version("java", "11.0.3-sapmchn", "https://github.com/SAP/SapMachine/releases/download/sapmachine-11.0.3/sapmachine-jdk-11.0.3_linux-x64_bin.tar.gz", Linux64),
      Version("java", "11.0.3-sapmchn", "https://github.com/SAP/SapMachine/releases/download/sapmachine-11.0.3/sapmachine-jdk-11.0.3_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "11.0.3-sapmchn", "https://github.com/SAP/SapMachine/releases/download/sapmachine-11.0.3/sapmachine-jdk-11.0.3_windows-x64_bin.zip", Windows)
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "11.0.2-sapmchn", platform))
  }

  @ChangeSet(order = "115", id = "115-add_sapmachine_java_12.0.1", author = "jorsol")
  def migrate115(implicit db: MongoDatabase): Unit = {
    List(
      Version("java", "12.0.1-sapmchn", "https://github.com/SAP/SapMachine/releases/download/sapmachine-12.0.1/sapmachine-jdk-12.0.1_linux-x64_bin.tar.gz", Linux64),
      Version("java", "12.0.1-sapmchn", "https://github.com/SAP/SapMachine/releases/download/sapmachine-12.0.1/sapmachine-jdk-12.0.1_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "12.0.1-sapmchn", "https://github.com/SAP/SapMachine/releases/download/sapmachine-12.0.1/sapmachine-jdk-12.0.1_windows-x64_bin.zip", Windows)
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "12.0.0-sapmchn", platform))
  }

  @ChangeSet(order = "122", id = "122-add_bellsoft_8_0_212", author = "den1ska")
  def migrate122(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.212-librca", "https://download.bell-sw.com/java/8u212/bellsoft-jdk8u212-linux-i586.tar.gz", Linux32),
      Version("java", "8.0.212-librca", "https://download.bell-sw.com/java/8u212/bellsoft-jdk8u212-linux-amd64.tar.gz", Linux64),
      Version("java", "8.0.212-librca", "https://download.bell-sw.com/java/8u212/bellsoft-jdk8u212-windows-amd64.zip", Windows),
      Version("java", "8.0.212-librca", "https://download.bell-sw.com/java/8u212/bellsoft-jdk8u212-macos-amd64.zip", MacOSX)
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(removeVersion("java", "8.0.202-librca", _))
  }

  @ChangeSet(order = "123", id = "123-add_bellsoft_11_0_3", author = "den1ska")
  def migrate123(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.3-librca", "https://download.bell-sw.com/java/11.0.3/bellsoft-jdk11.0.3-linux-i586.tar.gz", Linux32),
      Version("java", "11.0.3-librca", "https://download.bell-sw.com/java/11.0.3/bellsoft-jdk11.0.3-linux-amd64.tar.gz", Linux64),
      Version("java", "11.0.3-librca", "https://download.bell-sw.com/java/11.0.3/bellsoft-jdk11.0.3-windows-amd64.zip", Windows),
      Version("java", "11.0.3-librca", "https://download.bell-sw.com/java/11.0.3/bellsoft-jdk11.0.3-macos-amd64.zip", MacOSX)
    ).validate().insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "11.0.2-librca", _))
  }

  @ChangeSet(order = "124", id = "124-add_bellsoft_12_0_1", author = "den1ska")
  def migrate124(implicit db: MongoDatabase) = {
    List(
      Version("java", "12.0.1-librca", "https://download.bell-sw.com/java/12.0.1/bellsoft-jdk12.0.1-linux-i586.tar.gz", Linux32),
      Version("java", "12.0.1-librca", "https://download.bell-sw.com/java/12.0.1/bellsoft-jdk12.0.1-linux-amd64.tar.gz", Linux64),
      Version("java", "12.0.1-librca", "https://download.bell-sw.com/java/12.0.1/bellsoft-jdk12.0.1-windows-amd64.zip", Windows),
      Version("java", "12.0.1-librca", "https://download.bell-sw.com/java/12.0.1/bellsoft-jdk12.0.1-macos-amd64.zip", MacOSX)
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(removeVersion("java", "12.0.0-librca", _))
  }

  @ChangeSet(order = "125", id = "12-5update_openjdk_11_0_2", author = "eddumelendez")
  def migrate125(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.2-open", "https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz", Linux64),
      Version("java", "11.0.2-open", "https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_osx-x64_bin.tar.gz", MacOSX),
      Version("java", "11.0.2-open", "https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_windows-x64_bin.zip", Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "11.0.1-open", _))
  }

  @ChangeSet(order = "127", id = "127-add_adoptopenjdk-hs_8_0_212", author = "eddumelendez")
  def migrate127(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.212.hs-adpt", "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u212-b03/OpenJDK8U-jdk_x64_linux_hotspot_8u212b03.tar.gz", Linux64),
      Version("java", "8.0.212.hs-adpt", "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u212-b03/OpenJDK8U-jdk_x64_mac_hotspot_8u212b03.tar.gz", MacOSX),
      Version("java", "8.0.212.hs-adpt", "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u212-b03/OpenJDK8U-jdk_x64_windows_hotspot_8u212b03.zip", Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "8.0.202.hs-adpt", _))
  }

  @ChangeSet(order = "128", id = "128-add_openj9_8_0_212", author = "eddumelendez")
  def migrate128(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.212.j9-adpt", "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u212-b03_openj9-0.14.0/OpenJDK8U-jdk_x64_linux_openj9_8u212b03_openj9-0.14.0.tar.gz", Linux64),
      Version("java", "8.0.212.j9-adpt", "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u212-b03_openj9-0.14.0/OpenJDK8U-jdk_x64_mac_openj9_8u212b03_openj9-0.14.0.tar.gz", MacOSX),
      Version("java", "8.0.212.j9-adpt", "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u212-b03_openj9-0.14.0/OpenJDK8U-jdk_x64_windows_openj9_8u212b03_openj9-0.14.0.zip", Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "8.0.202.j9-adpt", _))
  }

  @ChangeSet(order = "129", id = "129-add_adoptopenjdk-hs_11_0_3", author = "eddumelendez")
  def migrate129(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.3.hs-adpt", "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.3%2B7/OpenJDK11U-jdk_x64_linux_hotspot_11.0.3_7.tar.gz", Linux64),
      Version("java", "11.0.3.hs-adpt", "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.3%2B7/OpenJDK11U-jdk_x64_mac_hotspot_11.0.3_7.tar.gz", MacOSX),
      Version("java", "11.0.3.hs-adpt", "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.3%2B7/OpenJDK11U-jdk_x64_windows_hotspot_11.0.3_7.zip", Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "11.0.2.hs-adpt", _))
  }

  @ChangeSet(order = "130", id = "130-add_openj9_11_0_3", author = "eddumelendez")
  def migrate130(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.3.j9-adpt", "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.3%2B7_openj9-0.14.0/OpenJDK11U-jdk_x64_linux_openj9_11.0.3_7_openj9-0.14.0.tar.gz", Linux64),
      Version("java", "11.0.3.j9-adpt", "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.3%2B7_openj9-0.14.0/OpenJDK11U-jdk_x64_windows_openj9_11.0.3_7_openj9-0.14.0.zip", MacOSX),
      Version("java", "11.0.3.j9-adpt", "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.3%2B7_openj9-0.14.0/OpenJDK11U-jdk_x64_mac_openj9_11.0.3_7_openj9-0.14.0.tar.gz", Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "11.0.2.j9-adpt", _))
  }

  @ChangeSet(order = "131", id = "131-add_adoptopenjdk-j9_12_0_1", author = "jaegerk")
  def migrate131(implicit db: MongoDatabase) = {
    List(
      Version("java", "12.0.1.j9-adpt", "https://github.com/AdoptOpenJDK/openjdk12-binaries/releases/download/jdk-12.0.1%2B12_openj9-0.14.1/OpenJDK12U-jdk_x64_linux_openj9_12.0.1_12_openj9-0.14.1.tar.gz", Linux64),
      Version("java", "12.0.1.j9-adpt", "https://github.com/AdoptOpenJDK/openjdk12-binaries/releases/download/jdk-12.0.1%2B12_openj9-0.14.1/OpenJDK12U-jdk_x64_windows_openj9_12.0.1_12_openj9-0.14.1.zip", Windows),
      Version("java", "12.0.1.j9-adpt", "https://github.com/AdoptOpenJDK/openjdk12-binaries/releases/download/jdk-12.0.1%2B12_openj9-0.14.1/OpenJDK12U-jdk_x64_mac_openj9_12.0.1_12_openj9-0.14.1.tar.gz", MacOSX)
    ).validate().insert()
  }

  @ChangeSet(order = "132", id = "132-add_adoptopenjdk-hs_12_0_1", author = "jaegerk")
  def migrate132(implicit db: MongoDatabase) = {
    List(
      Version("java", "12.0.1.hs-adpt", "https://github.com/AdoptOpenJDK/openjdk12-binaries/releases/download/jdk-12.0.1%2B12/OpenJDK12U-jdk_x64_linux_hotspot_12.0.1_12.tar.gz", Linux64),
      Version("java", "12.0.1.hs-adpt", "https://github.com/AdoptOpenJDK/openjdk12-binaries/releases/download/jdk-12.0.1%2B12/OpenJDK12U-jdk_x64_mac_hotspot_12.0.1_12.tar.gz", MacOSX)
    ).validate().insert()
  }

  @ChangeSet(order = "134", id = "134-add_adoptopenjdk-hs-windows_12_0_1", author = "kjjaeger")
  def migrate134(implicit db: MongoDatabase) =
    Version("java", "12.0.1.hs-adpt", "https://github.com/AdoptOpenJDK/openjdk12-binaries/releases/download/jdk-12.0.1%2B12/OpenJDK12U-jdk_x64_windows_hotspot_12.0.1_12.zip", Windows)
      .validate().insert()

  @ChangeSet(order = "135", id = "135-fix_broken_adopt_openjdk_j9_11_0_3", author = "marc0der")
  def migrate135(implicit db: MongoDatabase) = {
    val candidate = "java"
    val version = "11.0.3.j9-adpt"
    Seq(Windows, MacOSX).foreach(p => removeVersion(candidate, version, p))
    List(
      Version(candidate, version, "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.3%2B7_openj9-0.14.0/OpenJDK11U-jdk_x64_windows_openj9_11.0.3_7_openj9-0.14.0.zip", Windows),
      Version(candidate, version, "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.3%2B7_openj9-0.14.0/OpenJDK11U-jdk_x64_mac_openj9_11.0.3_7_openj9-0.14.0.tar.gz", MacOSX))
      .validate()
      .insert()
  }

  @ChangeSet(order = "138", id = "138-add_graalvm_19_0_0", author = "ilopmar")
  def migrate138(implicit db: MongoDatabase) = {
    List(
      Version(
        candidate = "java",
        version = "19.0.0-grl",
        url = "https://github.com/oracle/graal/releases/download/vm-19.0.0/graalvm-ce-linux-amd64-19.0.0.tar.gz",
        platform = Linux64),
      Version(
        candidate = "java",
        version = "19.0.0-grl",
        url = "https://github.com/oracle/graal/releases/download/vm-19.0.0/graalvm-ce-darwin-amd64-19.0.0.tar.gz",
        platform = MacOSX),
      Version(
        candidate = "java",
        version = "19.0.0-grl",
        url = "https://github.com/oracle/graal/releases/download/vm-19.0.0/graalvm-ce-windows-amd64-19.0.0.zip",
        platform = Windows))
      .validate()
      .insert()
    Seq(Linux64, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "1.0.0-rc-14-grl", platform))
  }

  @ChangeSet(order = "144", id = "144-add_graalvm_19_0_2", author = "wololock")
  def migrate144(implicit db: MongoDatabase) = {
    List(
      Version(
        candidate = "java",
        version = "19.0.2-grl",
        url = "https://github.com/oracle/graal/releases/download/vm-19.0.2/graalvm-ce-linux-amd64-19.0.2.tar.gz",
        platform = Linux64,
        vendor = Some(Graal)),
      Version(
        candidate = "java",
        version = "19.0.2-grl",
        url = "https://github.com/oracle/graal/releases/download/vm-19.0.2/graalvm-ce-darwin-amd64-19.0.2.tar.gz",
        platform = MacOSX,
        vendor = Some(Graal)),
      Version(
        candidate = "java",
        version = "19.0.2-grl",
        url = "https://github.com/oracle/graal/releases/download/vm-19.0.2/graalvm-ce-windows-amd64-19.0.2.zip",
        platform = Windows,
        vendor = Some(Graal)))
      .validate()
      .insert()
  }

  @ChangeSet(order = "148", id = "148-add_openjdk_java_14-ea-2", author = "eddumelendez")
  def migrate148(implicit db: MongoDatabase): Unit = {
    List(
      Version("java", "14.ea.2-open", "https://download.java.net/java/early_access/jdk14/2/GPL/openjdk-14-ea+2_linux-x64_bin.tar.gz", Linux64, Some(OpenJDK)),
      Version("java", "14.ea.2-open", "https://download.java.net/java/early_access/jdk14/2/GPL/openjdk-14-ea+2_osx-x64_bin.tar.gz", MacOSX, Some(OpenJDK)),
      Version("java", "14.ea.2-open", "https://download.java.net/java/early_access/jdk14/2/GPL/openjdk-14-ea+2_windows-x64_bin.zip", Windows, Some(OpenJDK)))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "14.ea.1-open", _))
  }

  @ChangeSet(order = "149", id = "149-add_openjdk_java_13-ea-27", author = "eddumelendez")
  def migrate149(implicit db: MongoDatabase): Unit = {
    List(
      Version("java", "13.ea.27-open", "https://download.java.net/java/early_access/jdk13/27/GPL/openjdk-13-ea+27_linux-x64_bin.tar.gz", Linux64, Some(OpenJDK)),
      Version("java", "13.ea.27-open", "https://download.java.net/java/early_access/jdk13/27/GPL/openjdk-13-ea+27_osx-x64_bin.tar.gz", MacOSX, Some(OpenJDK)),
      Version("java", "13.ea.27-open", "https://download.java.net/java/early_access/jdk13/27/GPL/openjdk-13-ea+27_windows-x64_bin.zip", Windows, Some(OpenJDK)))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "13.ea.26-open", _))
  }
}
