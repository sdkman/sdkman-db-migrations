package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "020")
class BellSoftLibericaMigrations {
  @ChangeSet(order = "0001", id = "0001-add_bellsoft_8_0_242", author = "poad")
  def migrate0001(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.242-librca", "https://download.bell-sw.com/java/8u242+7/bellsoft-jdk8u242+7-linux-i586.tar.gz", Linux32, Some(Liberica)),
      Version("java", "8.0.242-librca", "https://download.bell-sw.com/java/8u242+7/bellsoft-jdk8u242+7-linux-amd64.tar.gz", Linux64, Some(Liberica)),
      Version("java", "8.0.242-librca", "https://download.bell-sw.com/java/8u242+7/bellsoft-jdk8u242+7-windows-amd64.zip", Windows, Some(Liberica)),
      Version("java", "8.0.242-librca", "https://download.bell-sw.com/java/8u242+7/bellsoft-jdk8u242+7-macos-amd64.zip", MacOSX, Some(Liberica))
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(removeVersion("java", "8.0.232-librca", _))
  }

  @ChangeSet(order = "0002", id = "0002-add_bellsoft_11_0_6", author = "poad")
  def migrate0002(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.6-librca", "https://download.bell-sw.com/java/11.0.6+11/bellsoft-jdk11.0.6+10-linux-i586.tar.gz", Linux32, Some(Liberica)),
      Version("java", "11.0.6-librca", "https://download.bell-sw.com/java/11.0.6+11/bellsoft-jdk11.0.6+10-linux-amd64.tar.gz", Linux64, Some(Liberica)),
      Version("java", "11.0.6-librca", "https://download.bell-sw.com/java/11.0.6+11/bellsoft-jdk11.0.6+10-windows-amd64.zip", Windows, Some(Liberica)),
      Version("java", "11.0.6-librca", "https://download.bell-sw.com/java/11.0.6+11/bellsoft-jdk11.0.6+14-macos-amd64.zip", MacOSX, Some(Liberica))
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(removeVersion("java", "11.0.5-librca", _))
  }

  @ChangeSet(order = "0003", id = "0003-add_bellsoft_13_0_2", author = "poad")
  def migrate0003(implicit db: MongoDatabase) = {
    List(
      Version("java", "13.0.2-librca", "https://download.bell-sw.com/java/13.0.2/bellsoft-jdk13.0.2-linux-i586.tar.gz", Linux32, Some(Liberica)),
      Version("java", "13.0.2-librca", "https://download.bell-sw.com/java/13.0.2/bellsoft-jdk13.0.2-linux-amd64.tar.gz", Linux64, Some(Liberica)),
      Version("java", "13.0.2-librca", "https://download.bell-sw.com/java/13.0.2/bellsoft-jdk13.0.2-windows-amd64.zip", Windows, Some(Liberica)),
      Version("java", "13.0.2-librca", "https://download.bell-sw.com/java/13.0.2/bellsoft-jdk13.0.2-macos-amd64.zip", MacOSX, Some(Liberica))
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(removeVersion("java", "13.0.1-librca", _))
  }


}
