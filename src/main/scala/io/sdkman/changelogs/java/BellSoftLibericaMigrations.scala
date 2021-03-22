package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Linux64, MacOSX, Version, Windows, _}

@ChangeLog(order = "020")
class BellSoftLibericaMigrations {

  @ChangeSet(
    order = "0034",
    id = "0034-add_bellsoft_15_0_1.fx",
    author = "poad"
  )
  def migrate0034(implicit db: MongoDatabase): Unit = {

    Map(
      LinuxARM64 -> "bellsoft-jdk15.0.1+9-linux-aarch64-full.tar.gz",
      Linux64    -> "bellsoft-jdk15.0.1+9-linux-amd64-full.tar.gz",
      Windows    -> "bellsoft-jdk15.0.1+9-windows-amd64-full.zip",
      MacOSX     -> "bellsoft-jdk15.0.1+9-macos-amd64-full.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.0.1.fx-librca",
            s"https://download.bell-sw.com/java/15.0.1+9/$binary",
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
            "15.0.0.fx-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = "0035",
    id = "0035-add_bellsoft_15_0_1",
    author = "poad"
  )
  def migrate0035(implicit db: MongoDatabase): Unit = {
    Map(
      LinuxARM64 -> "bellsoft-jdk15.0.1+9-linux-aarch64.tar.gz",
      Linux32    -> "bellsoft-jdk15.0.1+9-linux-i586.tar.gz",
      Linux64    -> "bellsoft-jdk15.0.1+9-linux-amd64.tar.gz",
      Windows    -> "bellsoft-jdk15.0.1+9-windows-amd64.zip",
      MacOSX     -> "bellsoft-jdk15.0.1+9-macos-amd64.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.0.1-librca",
            s"https://download.bell-sw.com/java/15.0.1+9/$binary",
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
            "115.0.1-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = "0040",
    id = "0040-add_bellsoft_8_0_275",
    author = "poad"
  )
  def migrate0040(implicit db: MongoDatabase): Unit = {

    Map(
      LinuxARM64 -> "bellsoft-jdk8u275+1-linux-aarch64.tar.gz",
      Linux32    -> "bellsoft-jdk8u275+1-linux-i586.tar.gz",
      Linux64    -> "bellsoft-jdk8u275+1-linux-amd64.tar.gz",
      Windows    -> "bellsoft-jdk8u275+1-windows-amd64.zip",
      MacOSX     -> "bellsoft-jdk8u275+1-macos-amd64.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.275-librca",
            s"https://download.bell-sw.com/java/8u275+1/$binary",
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
            "8.0.272-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = "0041",
    id = "0041-add_bellsoft_8_0_275.fx",
    author = "poad"
  )
  def migrate0041(implicit db: MongoDatabase): Unit = {

    Map(
      Linux32 -> "bellsoft-jdk8u275+1-linux-i586-full.tar.gz",
      Linux64 -> "bellsoft-jdk8u275+1-linux-amd64-full.tar.gz",
      Windows -> "bellsoft-jdk8u275+1-windows-amd64-full.zip",
      MacOSX  -> "bellsoft-jdk8u275+1-macos-amd64-full.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.275.fx-librca",
            s"https://download.bell-sw.com/java/8u275+1/$binary",
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
            "8.0.272.fx-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = "0042",
    id = "0042-remove_bellsoft_11_0_9+12",
    author = "poad"
  )
  def migrate0042(implicit db: MongoDatabase): Unit = {
    Seq(LinuxARM64, Linux32, Linux64, Windows, MacOSX)
      .foreach(
        platform =>
          removeVersion(
            "java",
            "11.0.9-librca",
            platform
          )
      )
  }

  @ChangeSet(
    order = "0043",
    id = "0043-add_bellsoft_11_0_9.1+1",
    author = "poad"
  )
  def migrate0043(implicit db: MongoDatabase): Unit = {
    Map(
      LinuxARM64 -> "bellsoft-jdk11.0.9.1+1-linux-aarch64.tar.gz",
      Linux32    -> "bellsoft-jdk11.0.9.1+1-linux-i586.tar.gz",
      Linux64    -> "bellsoft-jdk11.0.9.1+1-linux-amd64.tar.gz",
      Windows    -> "bellsoft-jdk11.0.9.1+1-windows-amd64.zip",
      MacOSX     -> "bellsoft-jdk11.0.9.1+1-macos-amd64.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.9-librca",
            s"https://github.com/bell-sw/Liberica/releases/download/11.0.9.1%2B1/$binary",
            platform,
            Some(Liberica)
          )
      }
      .toList
      .validate()
      .insert()
  }

  @ChangeSet(
    order = "0044",
    id = "0044-remove_bellsoft_11_0_9+10.fx",
    author = "poad"
  )
  def migrate0044(implicit db: MongoDatabase): Unit = {
    Seq(LinuxARM64, Linux32, Linux64, Windows, MacOSX)
      .foreach(
        platform =>
          removeVersion(
            "java",
            "11.0.9.fx-librca",
            platform
          )
      )
  }

  @ChangeSet(
    order = "0045",
    id = "0045-add_bellsoft_11_0_9+12.fx",
    author = "poad"
  )
  def migrate0045(implicit db: MongoDatabase): Unit = {
    Map(
      LinuxARM64 -> "bellsoft-jdk11.0.9.1+1-linux-aarch64-full.tar.gz",
      Linux64    -> "bellsoft-jdk11.0.9.1+1-linux-amd64-full.tar.gz",
      Windows    -> "bellsoft-jdk11.0.9.1+1-windows-amd64-full.zip",
      MacOSX     -> "bellsoft-jdk11.0.9.1+1-macos-amd64-full.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.9.fx-librca",
            s"https://github.com/bell-sw/Liberica/releases/download/11.0.9.1%2B1/$binary",
            platform,
            Some(Liberica)
          )
      }
      .toList
      .validate()
      .insert()
  }

  @ChangeSet(
    order = "045",
    id = "045-hide-java-versions",
    author = "eddumelendez"
  )
  def migrate045(implicit db: MongoDatabase): Unit =
    hideVersion("java", "8.0.265.fx-librca")

  @ChangeSet(
    order = "046",
    id = "046-hide-java-versions",
    author = "eddumelendez"
  )
  def migrate046(implicit db: MongoDatabase): Unit =
    Seq(
      "8.0.275-librca",
      "8.0.275.fx-librca",
      "11.0.9-librca",
      "11.0.9.fx-librca",
      "15.0.1-librca",
      "15.0.1.fx-librca"
    ).foreach(version => hideVersion("java", version))

  @ChangeSet(
    order = "047",
    id = "047-hide-java-versions",
    author = "eddumelendez"
  )
  def migrate047(implicit db: MongoDatabase): Unit =
    Seq(
      "12.0.2-librca",
      "13.0.2-librca",
      "13.0.2.fx-librca",
      "14.0.2-librca",
      "14.0.2.fx-librca"
    ).foreach(version => hideVersion("java", version))

  @ChangeSet(
    order = "048",
    id = "048-hide-java-versions",
    author = "eddumelendez"
  )
  def migrate048(implicit db: MongoDatabase): Unit =
    Seq(
      "15.0.2.fx-librca",
      "15.0.2-librca"
    ).foreach(version => hideVersion("java", version))
}
