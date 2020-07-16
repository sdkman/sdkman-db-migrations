package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Linux64, MacOSX, Version, Windows, _}

@ChangeLog(order = "020")
class BellSoftLibericaMigrations {
  @ChangeSet(order = "0001", id = "0001-add_bellsoft_8_0_242", author = "poad")
  def migrate0001(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.242-librca",
        "https://download.bell-sw.com/java/8u242+7/bellsoft-jdk8u242+7-linux-i586.tar.gz",
        Linux32,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.242-librca",
        "https://download.bell-sw.com/java/8u242+7/bellsoft-jdk8u242+7-linux-amd64.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.242-librca",
        "https://download.bell-sw.com/java/8u242+7/bellsoft-jdk8u242+7-windows-amd64.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.242-librca",
        "https://download.bell-sw.com/java/8u242+7/bellsoft-jdk8u242+7-macos-amd64.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "8.0.232-librca", _)
    )
  }

  @ChangeSet(order = "0002", id = "0002-add_bellsoft_11_0_6", author = "poad")
  def migrate0002(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.6-librca",
        "https://download.bell-sw.com/java/11.0.6+10/bellsoft-jdk11.0.6+10-linux-i586.tar.gz",
        Linux32,
        Some(Liberica)
      ),
      Version(
        "java",
        "11.0.6-librca",
        "https://download.bell-sw.com/java/11.0.6+10/bellsoft-jdk11.0.6+10-linux-amd64.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "11.0.6-librca",
        "https://download.bell-sw.com/java/11.0.6+10/bellsoft-jdk11.0.6+10-windows-amd64.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "11.0.6-librca",
        "https://download.bell-sw.com/java/11.0.6+10/bellsoft-jdk11.0.6+10-macos-amd64.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "11.0.5-librca", _)
    )
  }

  @ChangeSet(order = "0003", id = "0003-add_bellsoft_13_0_2", author = "poad")
  def migrate0003(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "13.0.2-librca",
        "https://download.bell-sw.com/java/13.0.2+9/bellsoft-jdk13.0.2+9-linux-i586.tar.gz",
        Linux32,
        Some(Liberica)
      ),
      Version(
        "java",
        "13.0.2-librca",
        "https://download.bell-sw.com/java/13.0.2+9/bellsoft-jdk13.0.2+9-linux-amd64.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "13.0.2-librca",
        "https://download.bell-sw.com/java/13.0.2+9/bellsoft-jdk13.0.2+9-windows-amd64.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "13.0.2-librca",
        "https://download.bell-sw.com/java/13.0.2+9/bellsoft-jdk13.0.2+9-macos-amd64.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "13.0.1-librca", _)
    )
  }

  @ChangeSet(
    order = "0004",
    id = "0004-add_bellsoft_13_0_2_fx",
    author = "strizhik"
  )
  def migrate0004(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "13.0.2.fx-librca",
        "https://download.bell-sw.com/java/13.0.2+9/bellsoft-jdk13.0.2+9-linux-amd64-full.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "13.0.2.fx-librca",
        "https://download.bell-sw.com/java/13.0.2+9/bellsoft-jdk13.0.2+9-windows-amd64-full.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "13.0.2.fx-librca",
        "https://download.bell-sw.com/java/13.0.2+9/bellsoft-jdk13.0.2+9-macos-amd64-full.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
  }

  @ChangeSet(
    order = "0005",
    id = "0005-add_bellsoft_11_0_6_fx",
    author = "strizhik"
  )
  def migrate0005(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.6.fx-librca",
        "https://download.bell-sw.com/java/11.0.6+10/bellsoft-jdk11.0.6+10-linux-amd64-full.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "11.0.6.fx-librca",
        "https://download.bell-sw.com/java/11.0.6+10/bellsoft-jdk11.0.6+10-windows-amd64-full.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "11.0.6.fx-librca",
        "https://download.bell-sw.com/java/11.0.6+10/bellsoft-jdk11.0.6+10-macos-amd64-full.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
  }

  @ChangeSet(
    order = "0006",
    id = "0006-add_bellsoft_8_0_242_fx",
    author = "strizhik"
  )
  def migrate0006(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.242.fx-librca",
        "https://download.bell-sw.com/java/8u242+7/bellsoft-jdk8u242+7-linux-i586-full.tar.gz",
        Linux32,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.242.fx-librca",
        "https://download.bell-sw.com/java/8u242+7/bellsoft-jdk8u242+7-linux-amd64-full.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.242.fx-librca",
        "https://download.bell-sw.com/java/8u242+7/bellsoft-jdk8u242+7-windows-amd64-full.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.242.fx-librca",
        "https://download.bell-sw.com/java/8u242+7/bellsoft-jdk8u242+7-macos-amd64-full.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
  }

  @ChangeSet(order = "0007", id = "0007-add_bellsoft_14_0_0", author = "poad")
  def migrate0007(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "14.0.0-librca",
        "http://download.bell-sw.com/java/14+36/bellsoft-jdk14+36-linux-i586.tar.gz",
        Linux32,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.0-librca",
        "http://download.bell-sw.com/java/14+36/bellsoft-jdk14+36-linux-amd64.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.0-librca",
        "http://download.bell-sw.com/java/14+36/bellsoft-jdk14+36-windows-amd64.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.0-librca",
        "http://download.bell-sw.com/java/14+36/bellsoft-jdk14+36-macos-amd64.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
  }
  @ChangeSet(
    order = "0008",
    id = "0008-add_bellsoft_14_0_0_fx",
    author = "poad"
  )
  def migrate0008(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "14.0.0.fx-librca",
        "http://download.bell-sw.com/java/14+36/bellsoft-jre14+36-linux-amd64-full.tar.gz",
        Linux32,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.0.fx-librca",
        "http://download.bell-sw.com/java/14+36/bellsoft-jdk14+36-linux-amd64-full.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.0.fx-librca",
        "http://download.bell-sw.com/java/14+36/bellsoft-jdk14+36-windows-amd64-full.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.0.fx-librca",
        "http://download.bell-sw.com/java/14+36/bellsoft-jdk14+36-macos-amd64-full.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
  }

  @ChangeSet(order = "0009", id = "0009-add_bellsoft_8_0_252", author = "poad")
  def migrate0009(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.252-librca",
        "https://download.bell-sw.com/java/8u252+9/bellsoft-jdk8u252+9-linux-i586.tar.gz",
        Linux32,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.252-librca",
        "https://download.bell-sw.com/java/8u252+9/bellsoft-jdk8u252+9-linux-amd64.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.252-librca",
        "https://download.bell-sw.com/java/8u252+9/bellsoft-jdk8u252+9-windows-amd64.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.252-librca",
        "https://download.bell-sw.com/java/8u252+9/bellsoft-jdk8u252+9-macos-amd64.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "8.0.242-librca", _)
    )
  }

  @ChangeSet(
    order = "0010",
    id = "0010-add_bellsoft_11_0_7",
    author = "poad"
  )
  def migrate0010(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.7-librca",
        "https://download.bell-sw.com/java/11.0.7+10/bellsoft-jdk11.0.7+10-linux-i586.tar.gz",
        Linux32,
        Some(Liberica)
      ),
      Version(
        "java",
        "11.0.7-librca",
        "https://download.bell-sw.com/java/11.0.7+10/bellsoft-jdk11.0.7+10-linux-amd64.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "11.0.7-librca",
        "https://download.bell-sw.com/java/11.0.7+10/bellsoft-jdk11.0.7+10-windows-amd64.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "11.0.7-librca",
        "https://download.bell-sw.com/java/11.0.7+10/bellsoft-jdk11.0.7+10-macos-amd64.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "11.0.6-librca", _)
    )
  }

  @ChangeSet(order = "0011", id = "0011-add_bellsoft_14_0_1", author = "poad")
  def migrate0011(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "14.0.1-librca",
        "https://download.bell-sw.com/java/14.0.1+8/bellsoft-jdk14.0.1+8-linux-i586.tar.gz",
        Linux32,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.1-librca",
        "https://download.bell-sw.com/java/14.0.1+8/bellsoft-jdk14.0.1+8-linux-amd64.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.1-librca",
        "https://download.bell-sw.com/java/14.0.1+8/bellsoft-jdk14.0.1+8-windows-amd64.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.1-librca",
        "https://download.bell-sw.com/java/14.0.1+8/bellsoft-jdk14.0.1+8-macos-amd64.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.0.0-librca", _)
    )
  }

  @ChangeSet(
    order = "0012",
    id = "0012-add_bellsoft_8_0_252_fx",
    author = "poad"
  )
  def migrate0012(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.252.fx-librca",
        "https://download.bell-sw.com/java/8u252+9/bellsoft-jdk8u252+9-linux-i586-full.tar.gz",
        Linux32,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.252.fx-librca",
        "https://download.bell-sw.com/java/8u252+9/bellsoft-jdk8u252+9-linux-amd64-full.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.252.fx-librca",
        "https://download.bell-sw.com/java/8u252+9/bellsoft-jdk8u252+9-windows-amd64-full.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.252.fx-librca",
        "https://download.bell-sw.com/java/8u252+9/bellsoft-jdk8u252+9-macos-amd64-full.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "8.0.242.fx-librca", _)
    )
  }

  @ChangeSet(
    order = "0013",
    id = "0013-add_bellsoft_11_0_7_fx",
    author = "poad"
  )
  def migrate0013(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.7.fx-librca",
        "https://download.bell-sw.com/java/11.0.7+10/bellsoft-jdk11.0.7+10-linux-amd64-full.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "11.0.7.fx-librca",
        "https://download.bell-sw.com/java/11.0.7+10/bellsoft-jdk11.0.7+10-windows-amd64-full.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "11.0.7.fx-librca",
        "https://download.bell-sw.com/java/11.0.7+10/bellsoft-jdk11.0.7+10-macos-amd64-full.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "11.0.6.fx-librca", _)
    )
  }

  @ChangeSet(
    order = "0014",
    id = "0014-add_bellsoft_14_0_1_fx",
    author = "poad"
  )
  def migrate0014(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "14.0.1.fx-librca",
        "https://download.bell-sw.com/java/14.0.1+8/bellsoft-jdk14.0.1+8-linux-amd64-full.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.1.fx-librca",
        "https://download.bell-sw.com/java/14.0.1+8/bellsoft-jdk14.0.1+8-windows-amd64-full.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.1.fx-librca",
        "https://download.bell-sw.com/java/14.0.1+8/bellsoft-jdk14.0.1+8-macos-amd64-full.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.0.0.fx-librca", _)
    )
  }

  @ChangeSet(
    order = "0015",
    id = "0015-add_bellsoft_8_0_262",
    author = "strizhik"
  )
  def migrate0015(implicit db: MongoDatabase): Unit = {

    Map(
      Linux32 -> "bellsoft-jdk8u262+10-linux-i586.tar.gz",
      Linux64 -> "bellsoft-jdk8u262+10-linux-amd64.tar.gz",
      Windows -> "bellsoft-jdk8u262+10-windows-amd64.zip",
      MacOSX  -> "bellsoft-jdk8u262+10-macos-amd64.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.262-librca",
            s"https://download.bell-sw.com/java/8u262+10/$binary",
            platform,
            Some(Liberica)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach(
        version =>
          removeVersion(
            "java",
            "8.0.252-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = "0016",
    id = "0016-add_bellsoft_11_0_8",
    author = "strizhik"
  )
  def migrate0016(implicit db: MongoDatabase): Unit = {
    Map(
      Linux32 -> "bellsoft-jdk11.0.8+10-linux-i586.tar.gz",
      Linux64 -> "bellsoft-jdk11.0.8+10-linux-amd64.tar.gz",
      Windows -> "bellsoft-jdk11.0.8+10-windows-amd64.zip",
      MacOSX  -> "bellsoft-jdk11.0.8+10-macos-amd64.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.8-librca",
            s"https://download.bell-sw.com/java/11.0.8+10/$binary",
            platform,
            Some(Liberica)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach(
        version =>
          removeVersion(
            "java",
            "11.0.7-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = "0017",
    id = "0017-add_bellsoft_14_0_2",
    author = "strizhik"
  )
  def migrate0017(implicit db: MongoDatabase): Unit = {
    Map(
      Linux32 -> "bellsoft-jdk14.0.2+13-linux-i586.tar.gz",
      Linux64 -> "bellsoft-jdk14.0.2+13-linux-i586.tar.gz",
      Windows -> "bellsoft-jdk14.0.2+13-windows-amd64.zip",
      MacOSX  -> "bellsoft-jdk14.0.2+13-macos-amd64.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "14.0.2-librca",
            s"https://download.bell-sw.com/java/14.0.2+13/$binary",
            platform,
            Some(Liberica)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach(
        version =>
          removeVersion(
            "java",
            "14.0.1-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = "0018",
    id = "0018-add_bellsoft_8_0_262_fx",
    author = "strizhik"
  )
  def migrate0018(implicit db: MongoDatabase): Unit = {

    Map(
      Linux32 -> "bellsoft-jdk8u262+10-linux-i586-full.tar.gz",
      Linux64 -> "bellsoft-jdk8u262+10-linux-amd64-full.tar.gz",
      Windows -> "bellsoft-jdk8u262+10-windows-amd64-full.zip",
      MacOSX  -> "bellsoft-jdk8u262+10-macos-amd64-full.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.262.fx-librca",
            s"https://download.bell-sw.com/java/8u262+10/$binary",
            platform,
            Some(Liberica)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach(
        version =>
          removeVersion(
            "java",
            "8.0.252.fx-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = "0019",
    id = "0019-add_bellsoft_11_0_8_fx",
    author = "strizhik"
  )
  def migrate0019(implicit db: MongoDatabase): Unit = {
    Map(
      Linux64 -> "bellsoft-jdk11.0.8+10-linux-amd64-full.tar.gz",
      Windows -> "bellsoft-jdk11.0.8+10-windows-amd64-full.zip",
      MacOSX  -> "bellsoft-jdk11.0.8+10-macos-amd64-full.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.8.fx-librca",
            s"https://download.bell-sw.com/java/11.0.8+10/$binary",
            platform,
            Some(Liberica)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach(
        version =>
          removeVersion(
            "java",
            "11.0.7.fx-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = "0020",
    id = "0020-add_bellsoft_14_0_2_fx",
    author = "strizhik"
  )
  def migrate0020(implicit db: MongoDatabase): Unit = {
    Map(
      Linux64 -> "bellsoft-jdk14.0.2+13-linux-amd64-full.tar.gz",
      Windows -> "bellsoft-jdk14.0.2+13-windows-amd64-full.zip",
      MacOSX  -> "bellsoft-jdk14.0.2+13-macos-amd64-full.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "14.0.2.fx-librca",
            s"https://download.bell-sw.com/java/14.0.2+13/$binary",
            platform,
            Some(Liberica)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach(
        version =>
          removeVersion(
            "java",
            "14.0.1.fx-librca",
            version.platform
          )
      )
  }
}
