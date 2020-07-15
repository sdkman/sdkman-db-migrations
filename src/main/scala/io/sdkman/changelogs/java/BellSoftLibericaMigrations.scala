package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Linux64, MacOSX, Version, Windows, _}

@ChangeLog(order = "020")
class BellSoftLibericaMigrations {

  final val changeAuthor = "strizhik"

  final val prev8UpdateVersion = 252
  final val new8UpdateVersion  = 262
  final val new8BuildVersion   = 10

  final val prev11UpdateVersion = 7
  final val new11UpdateVersion  = 8
  final val new11BuildVersion   = 10

  final val prev14UpdateVersion = 1
  final val new14UpdateVersion  = 2
  final val new14BuildVersion   = 13

  final val order8 = "0015"
  final val id8    = "0015-add_bellsoft_8_0_262"

  final val order11 = "0016"
  final val id11    = "0016-add_bellsoft_11_0_8"

  final val order14 = "0017"
  final val id14    = "0017-add_bellsoft_14_0_2"

  final val order8fx = "0018"
  final val id8fx    = "0018-add_bellsoft_8_0_262_fx"

  final val order11fx = "0019"
  final val id11fx    = "0019-add_bellsoft_11_0_8_fx"

  final val order14fx = "0020"
  final val id14fx    = "0020-add_bellsoft_14_0_2_fx"

  @ChangeSet(
    order = order8,
    id = id8,
    author = changeAuthor
  )
  def migrate0015(implicit db: MongoDatabase): Unit = {

    Map(
      Linux32 -> s"bellsoft-jdk8u$new8UpdateVersion+$new8BuildVersion-linux-i586.tar.gz",
      Linux64 -> s"bellsoft-jdk8u$new8UpdateVersion+$new8BuildVersion-linux-amd64.tar.gz",
      Windows -> s"bellsoft-jdk8u$new8UpdateVersion+$new8BuildVersion-windows-amd64.zip",
      MacOSX  -> s"bellsoft-jdk8u$new8UpdateVersion+$new8BuildVersion-macos-amd64.zip"
    ).map {
      case (platform, binary) =>
        Version(
          "java",
          s"8.0.$new8UpdateVersion-librca",
          s"https://download.bell-sw.com/java/8u$new8UpdateVersion+$new8BuildVersion/$binary",
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
            s"8.0.$prev8UpdateVersion-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = order11,
    id = id11,
    author = changeAuthor
  )
  def migrate0016(implicit db: MongoDatabase): Unit = {
    Map(
      Linux32 -> s"bellsoft-jdk11.0.$new11UpdateVersion+$new11BuildVersion-linux-i586.tar.gz",
      Linux64 -> s"bellsoft-jdk11.0.$new11UpdateVersion+$new11BuildVersion-linux-amd64.tar.gz",
      Windows -> s"bellsoft-jdk11.0.$new11UpdateVersion+$new11BuildVersion-windows-amd64.zip",
      MacOSX  -> s"bellsoft-jdk11.0.$new11UpdateVersion+$new11BuildVersion-macos-amd64.zip"
    ).map {
      case (platform, binary) =>
        Version(
          "java",
          s"11.0.$new11UpdateVersion-librca",
          s"https://download.bell-sw.com/java/11.0.$new11UpdateVersion+$new11BuildVersion/$binary",
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
            s"11.0.$prev11UpdateVersion-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = order14,
    id = id14,
    author = changeAuthor
  )
  def migrate0017(implicit db: MongoDatabase): Unit = {
    Map(
      Linux32 -> s"bellsoft-jdk14.0.$new14UpdateVersion+$new14BuildVersion-linux-i586.tar.gz",
      Linux64 -> s"bellsoft-jdk14.0.$new14UpdateVersion+$new14BuildVersion-linux-i586.tar.gz",
      Windows -> s"bellsoft-jdk14.0.$new14UpdateVersion+$new14BuildVersion-windows-amd64.zip",
      MacOSX  -> s"bellsoft-jdk14.0.$new14UpdateVersion+$new14BuildVersion-macos-amd64.zip"
    ).map {
      case (platform, binary) =>
        Version(
          "java",
          s"14.0.$new14UpdateVersion-librca",
          s"https://download.bell-sw.com/java/14.0.$new14UpdateVersion+$new14BuildVersion/$binary",
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
            s"14.0.$prev14UpdateVersion-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = order8fx,
    id = id8fx,
    author = changeAuthor
  )
  def migrate0018(implicit db: MongoDatabase): Unit = {

    Map(
      Linux32 -> s"bellsoft-jdk8u$new8UpdateVersion+$new8BuildVersion-linux-i586-full.tar.gz",
      Linux64 -> s"bellsoft-jdk8u$new8UpdateVersion+$new8BuildVersion-linux-amd64-full.tar.gz",
      Windows -> s"bellsoft-jdk8u$new8UpdateVersion+$new8BuildVersion-windows-amd64-full.zip",
      MacOSX  -> s"bellsoft-jdk8u$new8UpdateVersion+$new8BuildVersion-macos-amd64-full.zip"
    ).map {
      case (platform, binary) =>
        Version(
          "java",
          s"8.0.$new8UpdateVersion.fx-librca",
          s"https://download.bell-sw.com/java/8u$new8UpdateVersion+$new8BuildVersion/$binary",
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
            s"8.0.$prev8UpdateVersion.fx-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = order11fx,
    id = id11fx,
    author = changeAuthor
  )
  def migrate0019(implicit db: MongoDatabase): Unit = {
    Map(
      Linux64 -> s"bellsoft-jdk11.0.$new11UpdateVersion+$new11BuildVersion-linux-amd64-full.tar.gz",
      Windows -> s"bellsoft-jdk11.0.$new11UpdateVersion+$new11BuildVersion-windows-amd64-full.zip",
      MacOSX  -> s"bellsoft-jdk11.0.$new11UpdateVersion+$new11BuildVersion-macos-amd64-full.zip"
    ).map {
      case (platform, binary) =>
        Version(
          "java",
          s"11.0.$new11UpdateVersion.fx-librca",
          s"https://download.bell-sw.com/java/11.0.$new11UpdateVersion+$new11BuildVersion/$binary",
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
            s"11.0.$prev11UpdateVersion.fx-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = order14fx,
    id = id14fx,
    author = changeAuthor
  )
  def migrate0020(implicit db: MongoDatabase): Unit = {
    Map(
      Linux64 -> s"bellsoft-jdk14.0.$new14UpdateVersion+$new14BuildVersion-linux-amd64-full.tar.gz",
      Windows -> s"bellsoft-jdk14.0.$new14UpdateVersion+$new14BuildVersion-windows-amd64-full.zip",
      MacOSX  -> s"bellsoft-jdk14.0.$new14UpdateVersion+$new14BuildVersion-macos-amd64-full.zip"
    ).map {
      case (platform, binary) =>
        Version(
          "java",
          s"14.0.$new14UpdateVersion.fx-librca",
          s"https://download.bell-sw.com/java/14.0.$new14UpdateVersion+$new14BuildVersion/$binary",
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
            s"14.0.$prev14UpdateVersion.fx-librca",
            version.platform
          )
      )
  }
  @ChangeSet(
    order = "0015",
    id = "0015-add_bellsoft_8_0_262",
    author = "strizhik"
  )
  def migrate0015(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.262-librca",
        "https://download.bell-sw.com/java/8u262+10/bellsoft-jdk8u262+10-linux-i586.tar.gz",
        Linux32,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.262-librca",
        "https://download.bell-sw.com/java/8u262+10/bellsoft-jdk8u262+10-linux-amd64.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.262-librca",
        "https://download.bell-sw.com/java/8u262+10/bellsoft-jdk8u262+10-windows-amd64.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.262-librca",
        "https://download.bell-sw.com/java/8u262+10/bellsoft-jdk8u262+10-macos-amd64.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "8.0.252-librca", _)
    )
  }

  @ChangeSet(
    order = "0016",
    id = "0016-add_bellsoft_11_0_8",
    author = "strizhik"
  )
  def migrate0016(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.8-librca",
        "https://download.bell-sw.com/java/11.0.8+10/bellsoft-jdk11.0.8+10-linux-i586.tar.gz",
        Linux32,
        Some(Liberica)
      ),
      Version(
        "java",
        "11.0.8-librca",
        "https://download.bell-sw.com/java/11.0.8+10/bellsoft-jdk11.0.8+10-linux-amd64.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "11.0.8-librca",
        "https://download.bell-sw.com/java/11.0.8+10/bellsoft-jdk11.0.8+10-windows-amd64.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "11.0.8-librca",
        "https://download.bell-sw.com/java/11.0.8+10/bellsoft-jdk11.0.8+10-macos-amd64.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "11.0.7-librca", _)
    )
  }

  @ChangeSet(
    order = "0017",
    id = "0017-add_bellsoft_14_0_2",
    author = "strizhik"
  )
  def migrate0017(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "14.0.2-librca",
        "https://download.bell-sw.com/java/14.0.2+13/bellsoft-jdk14.0.2+13-linux-i586.tar.gz",
        Linux32,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.2-librca",
        "https://download.bell-sw.com/java/14.0.2+13/bellsoft-jdk14.0.2+13-linux-amd64.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.2-librca",
        "https://download.bell-sw.com/java/14.0.2+13/bellsoft-jdk14.0.2+13-windows-amd64.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.2-librca",
        "https://download.bell-sw.com/java/14.0.2+13/bellsoft-jdk14.0.2+13-macos-amd64.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.0.1-librca", _)
    )
  }

  @ChangeSet(
    order = "0018",
    id = "0018-add_bellsoft_8_0_262_fx",
    author = "strizhik"
  )
  def migrate0018(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.262.fx-librca",
        "https://download.bell-sw.com/java/8u262+10/bellsoft-jdk8u262+10-linux-i586-full.tar.gz",
        Linux32,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.262.fx-librca",
        "https://download.bell-sw.com/java/8u262+10/bellsoft-jdk8u262+10-linux-amd64-full.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.262.fx-librca",
        "https://download.bell-sw.com/java/8u262+10/bellsoft-jdk8u262+10-windows-amd64-full.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "8.0.262.fx-librca",
        "https://download.bell-sw.com/java/8u262+10/bellsoft-jdk8u262+10-macos-amd64-full.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "8.0.252.fx-librca", _)
    )
  }

  @ChangeSet(
    order = "0019",
    id = "0019-add_bellsoft_11_0_8_fx",
    author = "strizhik"
  )
  def migrate0019(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.8.fx-librca",
        "https://download.bell-sw.com/java/11.0.8+10/bellsoft-jdk11.0.8+10-linux-amd64-full.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "11.0.8.fx-librca",
        "https://download.bell-sw.com/java/11.0.8+10/bellsoft-jdk11.0.8+10-windows-amd64-full.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "11.0.8.fx-librca",
        "https://download.bell-sw.com/java/11.0.8+10/bellsoft-jdk11.0.8+10-macos-amd64-full.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "11.0.7.fx-librca", _)
    )
  }

  @ChangeSet(
    order = "0020",
    id = "0020-add_bellsoft_14_0_2_fx",
    author = "strizhik"
  )
  def migrate0020(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "14.0.2.fx-librca",
        "https://download.bell-sw.com/java/14.0.2+13/bellsoft-jdk14.0.2+13-linux-amd64-full.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.2.fx-librca",
        "https://download.bell-sw.com/java/14.0.2+13/bellsoft-jdk14.0.2+13-windows-amd64-full.zip",
        Windows,
        Some(Liberica)
      ),
      Version(
        "java",
        "14.0.2.fx-librca",
        "https://download.bell-sw.com/java/14.0.2+13/bellsoft-jdk14.0.2+13-macos-amd64-full.zip",
        MacOSX,
        Some(Liberica)
      )
    ).validate().insert()
    Seq(Linux32, Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.0.1.fx-librca", _)
    )
  }

}
