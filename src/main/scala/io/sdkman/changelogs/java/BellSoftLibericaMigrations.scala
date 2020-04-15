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
}
