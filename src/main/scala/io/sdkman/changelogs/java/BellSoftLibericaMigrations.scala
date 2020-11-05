package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Linux64, MacOSX, Version, Windows, _}

@ChangeLog(order = "020")
class BellSoftLibericaMigrations {

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

  @ChangeSet(
    order = "0021",
    id = "0021-add_bellsoft_8_0_265",
    author = "strizhik"
  )
  def migrate0021(implicit db: MongoDatabase): Unit = {

    Map(
      Linux32 -> "bellsoft-jdk8u265+1-linux-i586.tar.gz",
      Linux64 -> "bellsoft-jdk8u265+1-linux-amd64.tar.gz",
      Windows -> "bellsoft-jdk8u265+1-windows-amd64.zip",
      MacOSX  -> "bellsoft-jdk8u265+1-macos-amd64.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.265-librca",
            s"https://download.bell-sw.com/java/8u265+1/$binary",
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
            "8.0.262-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = "0022",
    id = "0022-add_bellsoft_8_0_265_fx",
    author = "strizhik"
  )
  def migrate0022(implicit db: MongoDatabase): Unit = {

    Map(
      Linux32 -> "bellsoft-jdk8u265+1-linux-i586-full.tar.gz",
      Linux64 -> "bellsoft-jdk8u265+1-linux-amd64-full.tar.gz",
      Windows -> "bellsoft-jdk8u265+1-windows-amd64-full.zip",
      MacOSX  -> "bellsoft-jdk8u265+1-macos-amd64-full.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.265.fx-librca",
            s"https://download.bell-sw.com/java/8u265+1/$binary",
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
            "8.0.262.fx-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = "0023",
    id = "0023-add_linuxarm64_bellsoft_8_11_14",
    author = "dvdkruk"
  )
  def migrate0023(implicit db: MongoDatabase): Unit = {
    Map(
      "8.0.265-librca"   -> "8u265+1/bellsoft-jdk8u265+1-linux-aarch64.tar.gz",
      "11.0.8.librca"    -> "11.0.8+10/bellsoft-jdk11.0.8+10-linux-aarch64.tar.gz",
      "11.0.8.fx-librca" -> "11.0.8+10/bellsoft-jdk11.0.8+10-linux-aarch64-full.tar.gz",
      "14.0.2.librca"    -> "14.0.2+13/bellsoft-jdk14.0.2+13-linux-aarch64.tar.gz",
      "14.0.2.fx-librca" -> "14.0.2+13/bellsoft-jdk14.0.2+13-linux-aarch64-full.tar.gz"
    ).map {
        case (version, binary) =>
          Version(
            "java",
            version,
            s"https://download.bell-sw.com/java/$binary",
            LinuxARM64,
            Some(Liberica)
          )
      }
      .toList
      .validate()
      .insert()
  }

  @ChangeSet(
    order = "0024",
    id = "0024-correcting_linuxarm64_bellsoft_labels-11-14",
    author = "dvdkruk"
  )
  def migrate0024(implicit db: MongoDatabase): Unit = {
    Map(
      "11.0.8-librca" -> "11.0.8+10/bellsoft-jdk11.0.8+10-linux-aarch64.tar.gz",
      "14.0.2-librca" -> "14.0.2+13/bellsoft-jdk14.0.2+13-linux-aarch64.tar.gz"
    ).map {
        case (version, binary) =>
          Version(
            "java",
            version,
            s"https://download.bell-sw.com/java/$binary",
            LinuxARM64,
            Some(Liberica)
          )
      }
      .toList
      .validate()
      .insert()
    removeVersion("java", "11.0.8.librca", LinuxARM64)
    removeVersion("java", "14.0.2.librca", LinuxARM64)
  }
  @ChangeSet(
    order = "0025",
    id = "0025-add_bellsoft_15_0_0",
    author = "poad"
  )
  def migrate0025(implicit db: MongoDatabase): Unit = {

    Map(
      LinuxARM64 -> "bellsoft-jdk15+36-linux-aarch64.tar.gz",
      Linux32    -> "bellsoft-jdk15+36-linux-i586.tar.gz",
      Linux64    -> "bellsoft-jdk15+36-linux-amd64.tar.gz",
      Windows    -> "bellsoft-jdk15+36-windows-amd64.zip",
      MacOSX     -> "bellsoft-jdk15+36-macos-amd64.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.0.0-librca",
            s"https://download.bell-sw.com/java/15+36/$binary",
            platform,
            Some(Liberica)
          )
      }
      .toList
      .validate()
      .insert()
  }

  @ChangeSet(
    order = "0026",
    id = "0026-add_bellsoft_15_0_0_fx",
    author = "poad"
  )
  def migrate0026(implicit db: MongoDatabase): Unit = {

    Map(
      LinuxARM64 -> "bellsoft-jdk15+36-linux-aarch64-full.tar.gz",
      Linux64    -> "bellsoft-jdk15+36-linux-amd64-full.tar.gz",
      Windows    -> "bellsoft-jdk15+36-windows-amd64-full.zip",
      MacOSX     -> "bellsoft-jdk15+36-macos-amd64-full.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.0.0-fx-librca",
            s"https://download.bell-sw.com/java/15+36/$binary",
            platform,
            Some(Liberica)
          )
      }
      .toList
      .validate()
      .insert()
  }

  @ChangeSet(
    order = "0027",
    id = "0027-remove_bellsoft_15_0_0_fx_temp",
    author = "poad"
  )
  def migrate0027(implicit db: MongoDatabase): Unit = {
    Seq(LinuxARM64, Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(
          candidate = "java",
          version = "15.0.0-fx-librca",
          platform
        )
    )
  }

  @ChangeSet(
    order = "0028",
    id = "0028-readd_bellsoft_15_0_0_fx",
    author = "poad"
  )
  def migrate0028(implicit db: MongoDatabase): Unit = {

    Map(
      LinuxARM64 -> "bellsoft-jdk15+36-linux-aarch64-full.tar.gz",
      Linux64    -> "bellsoft-jdk15+36-linux-amd64-full.tar.gz",
      Windows    -> "bellsoft-jdk15+36-windows-amd64-full.zip",
      MacOSX     -> "bellsoft-jdk15+36-macos-amd64-full.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.0.0.fx-librca",
            s"https://download.bell-sw.com/java/15+36/$binary",
            platform,
            Some(Liberica)
          )
      }
      .toList
      .validate()
      .insert()
  }

  @ChangeSet(
    order = "0029",
    id = "0029-add_bellsoft_8_0_272",
    author = "poad"
  )
  def migrate0029(implicit db: MongoDatabase): Unit = {

    Map(
      LinuxARM64 -> "bellsoft-jdk8u272+10-linux-aarch64.tar.gz",
      Linux32    -> "bellsoft-jdk8u272+10-linux-i586.tar.gz",
      Linux64    -> "bellsoft-jdk8u272+10-linux-amd64.tar.gz",
      Windows    -> "bellsoft-jdk8u272+10-windows-amd64.zip",
      MacOSX     -> "bellsoft-jdk8u272+10-macos-amd64.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.272-librca",
            s"https://download.bell-sw.com/java/8u272+10/$binary",
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
            "8.0.265-librca",
            version.platform
          )
      )
  }
  @ChangeSet(
    order = "0030",
    id = "0030-add_bellsoft_8_0_272.fx",
    author = "poad"
  )
  def migrate0030(implicit db: MongoDatabase): Unit = {

    Map(
      Linux32 -> "bellsoft-jdk8u272+10-linux-i586-full.tar.gz",
      Linux64 -> "bellsoft-jdk8u272+10-linux-amd64-full.tar.gz",
      Windows -> "bellsoft-jdk8u272+10-windows-amd64-full.zip",
      MacOSX  -> "bellsoft-jdk8u272+10-macos-amd64-full.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.272.fx-librca",
            s"https://download.bell-sw.com/java/8u272+10/$binary",
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
            "8.0.265,fx-librca",
            version.platform
          )
      )
  }

  @ChangeSet(
    order = "0031",
    id = "0031-add_bellsoft_11_0_9",
    author = "poad"
  )
  def migrate0031(implicit db: MongoDatabase): Unit = {

    Map(
      LinuxARM64 -> "bellsoft-jdk11.0.9+11-linux-aarch64.tar.gz",
      Linux32    -> "bellsoft-jdk11.0.9+11-linux-i586.tar.gz",
      Linux64    -> "bellsoft-jdk11.0.9+11-linux-amd64.tar.gz",
      Windows    -> "bellsoft-jdk11.0.9+11-windows-amd64.zip",
      MacOSX     -> "bellsoft-jdk11.0.9+11-macos-amd64.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.9-librca",
            s"https://download.bell-sw.com/java/11.0.9+11/$binary",
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
            "11.0.8-librca",
            version.platform
          )
      )
  }
  @ChangeSet(
    order = "0032",
    id = "0032-add_bellsoft_11_0_9.fx",
    author = "poad"
  )
  def migrate0032(implicit db: MongoDatabase): Unit = {

    Map(
      LinuxARM64 -> "bellsoft-jdk11.0.9+11-linux-aarch64-full.tar.gz",
      Linux64    -> "bellsoft-jdk11.0.9+11-linux-amd64-full.tar.gz",
      Windows    -> "bellsoft-jdk11.0.9+11-windows-amd64-full.zip",
      MacOSX     -> "bellsoft-jdk11.0.9+11-macos-amd64-full.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.9.fx-librca",
            s"https://download.bell-sw.com/java/11.0.9+11/$binary",
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
            "11.0.8.fx-librca",
            version.platform
          )
      )
  }

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
    order = "0036",
    id = "0036-remove_bellsoft_11_0_9+10",
    author = "poad"
  )
  def migrate0036(implicit db: MongoDatabase): Unit = {
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
    order = "0037",
    id = "0037-add_bellsoft_11_0_9+12",
    author = "poad"
  )
  def migrate0037(implicit db: MongoDatabase): Unit = {
    Map(
      LinuxARM64 -> "bellsoft-jdk11.0.9+12-linux-aarch64.tar.gz",
      Linux32    -> "bellsoft-jdk11.0.9+12-linux-i586.tar.gz",
      Linux64    -> "bellsoft-jdk11.0.9+12-linux-amd64.tar.gz",
      Windows    -> "bellsoft-jdk11.0.9+12-windows-amd64.zip",
      MacOSX     -> "bellsoft-jdk11.0.9+12-macos-amd64.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.9-librca",
            s"https://download.bell-sw.com/java/11.0.9+12/$binary",
            platform,
            Some(Liberica)
          )
      }
      .toList
      .validate()
      .insert()
  }

  @ChangeSet(
    order = "0038",
    id = "0038-remove_bellsoft_11_0_9+10.fx",
    author = "poad"
  )
  def migrate0038(implicit db: MongoDatabase): Unit = {
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
    order = "0039",
    id = "0039-add_bellsoft_11_0_9+12.fx",
    author = "poad"
  )
  def migrate0039(implicit db: MongoDatabase): Unit = {
    Map(
      LinuxARM64 -> "bellsoft-jdk11.0.9+12-linux-aarch64-full.tar.gz",
      Linux64    -> "bellsoft-jdk11.0.9+12-linux-amd64-full.tar.gz",
      Windows    -> "bellsoft-jdk11.0.9+12-windows-amd64-full.zip",
      MacOSX     -> "bellsoft-jdk11.0.9+12-macos-amd64-full.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.9.fx-librca",
            s"https://download.bell-sw.com/java/11.0.9+12/$binary",
            platform,
            Some(Liberica)
          )
      }
      .toList
      .validate()
      .insert()
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
            "8.0.272,fx-librca",
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

}
