package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Linux64, MacOSX, Version, Windows, _}

@ChangeLog(order = "020")
class BellSoftLibericaMigrations {

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
