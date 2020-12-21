package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{AdoptOpenJDK, Linux64, MacOSX, Version, Windows, _}

@ChangeLog(order = "016")
class AdoptOpenJdkMigrations {

  @ChangeSet(
    order = "0001",
    id = "0001-add_adoptopenjdk_13_0_1",
    author = "timw"
  )
  def migrate0001(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "13.0.1.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk13-binaries/releases/download/jdk-13.0.1%2B9/OpenJDK13U-jdk_x64_linux_hotspot_13.0.1_9.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "13.0.1.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk13-binaries/releases/download/jdk-13.0.1%2B9/OpenJDK13U-jdk_x64_windows_hotspot_13.0.1_9.zip",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "13.0.1.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk13-binaries/releases/download/jdk-13.0.1%2B9/OpenJDK13U-jdk_x64_mac_hotspot_13.0.1_9.tar.gz",
        Windows,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "13.0.1.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk13-binaries/releases/download/jdk-13.0.1%2B9_openj9-0.17.0/OpenJDK13U-jdk_x64_linux_openj9_13.0.1_9_openj9-0.17.0.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "13.0.1.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk13-binaries/releases/download/jdk-13.0.1%2B9_openj9-0.17.0/OpenJDK13U-jdk_x64_mac_openj9_13.0.1_9_openj9-0.17.0.tar.gz",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "13.0.1.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk13-binaries/releases/download/jdk-13.0.1%2B9_openj9-0.17.0/OpenJDK13U-jdk_x64_windows_openj9_13.0.1_9_openj9-0.17.0.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach { platform =>
      removeVersion("java", "13.0.0.j9-adpt", platform)
      removeVersion("java", "13.0.0.hs-adpt", platform)
    }
  }

  @ChangeSet(
    order = "0002",
    id = "0002-add_adoptopenjdk-hs_11_0_6",
    author = "poad"
  )
  def migrate0002(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.6.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.6+10/OpenJDK11U-jdk_x64_linux_hotspot_11.0.6_10.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "11.0.6.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.6+10/OpenJDK11U-jdk_x64_mac_hotspot_11.0.6_10.tar.gz",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "11.0.6.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.6+10/OpenJDK11U-jdk_x64_windows_hotspot_11.0.6_10.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
    setCandidateDefault("java", "11.0.6.hs-adpt")
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "11.0.5.hs-adpt", _)
    )
  }

  @ChangeSet(
    order = "0003",
    id = "0003-add_adoptopenjdk-j9_11_0_6",
    author = "poad"
  )
  def migrate0003(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.6.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.6%2B10_openj9-0.18.0/OpenJDK11U-jdk_x64_linux_openj9_11.0.6_10_openj9-0.18.0.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "11.0.6.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.6%2B10_openj9-0.18.0/OpenJDK11U-jdk_x64_mac_openj9_11.0.6_10_openj9-0.18.0.tar.gz",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "11.0.6.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.6%2B10_openj9-0.18.0/OpenJDK11U-jdk_x64_windows_openj9_11.0.6_10_openj9-0.18.0.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "11.0.5.j9-adpt", _)
    )
  }

  @ChangeSet(
    order = "0004",
    id = "0004-add_adoptopenjdk-hs_8_0_242",
    author = "poad"
  )
  def migrate0004(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.242.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u242-b08/OpenJDK8U-jdk_x64_linux_hotspot_8u242b08.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "8.0.242.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u242-b08/OpenJDK8U-jdk_x64_mac_hotspot_8u242b08.tar.gz",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "8.0.242.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u242-b08/OpenJDK8U-jdk_x64_windows_hotspot_8u242b08.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
    setCandidateDefault("java", "8.0.242.hs-adpt")
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "8.0.232.hs-adpt", _)
    )
  }

  @ChangeSet(
    order = "0005",
    id = "0005-set_adoptopenjdk_11.0.5.hs_as_default",
    author = "marc0der"
  )
  def migrate0005(implicit db: MongoDatabase) =
    setCandidateDefault("java", "11.0.6.hs-adpt")

  @ChangeSet(
    order = "0006",
    id = "0006-add_adoptopenjdk-j9_8_0_242",
    author = "poad"
  )
  def migrate0006(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.242.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u242-b08_openj9-0.18.1/OpenJDK8U-jdk_x64_linux_openj9_8u242b08_openj9-0.18.1.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "8.0.242.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u242-b08_openj9-0.18.1/OpenJDK8U-jdk_x64_mac_openj9_8u242b08_openj9-0.18.1.tar.gz",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "8.0.242.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u242-b08_openj9-0.18.1/OpenJDK8U-jdk_x64_windows_openj9_8u242b08_openj9-0.18.1.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "8.0.232.j9-adpt", _)
    )
  }

  @ChangeSet(
    order = "0007",
    id = "0007-add_adoptopenjdk-hs_13_0_2",
    author = "poad"
  )
  def migrate0007(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "13.0.2.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk13-binaries/releases/download/jdk-13.0.2%2B8/OpenJDK13U-jdk_x64_linux_hotspot_13.0.2_8.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "13.0.2.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk13-binaries/releases/download/jdk-13.0.2%2B8/OpenJDK13U-jdk_x64_mac_hotspot_13.0.2_8.tar.gz",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "13.0.2.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk13-binaries/releases/download/jdk-13.0.2%2B8/OpenJDK13U-jdk_x64_windows_hotspot_13.0.2_8.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "13.0.1.hs-adpt", _)
    )
  }

  @ChangeSet(
    order = "0008",
    id = "0008-add_adoptopenjdk-j9_13_0_2",
    author = "poad"
  )
  def migrate0008(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "13.0.2.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk13-binaries/releases/download/jdk-13.0.2%2B8_openj9-0.18.0/OpenJDK13U-jdk_x64_linux_openj9_13.0.2_8_openj9-0.18.0.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "13.0.2.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk13-binaries/releases/download/jdk-13.0.2%2B8_openj9-0.18.0/OpenJDK13U-jdk_x64_mac_openj9_13.0.2_8_openj9-0.18.0.tar.gz",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "13.0.2.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk13-binaries/releases/download/jdk-13.0.2%2B8_openj9-0.18.0/OpenJDK13U-jdk_x64_windows_openj9_13.0.2_8_openj9-0.18.0.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "13.0.1.j9-adpt", _)
    )
  }

  @ChangeSet(
    order = "0009",
    id = "0009-add_adoptopenjdk-hs_14_0_0",
    author = "poad"
  )
  def migrate0009(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "14.0.0.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk14-binaries/releases/download/jdk-14%2B36/OpenJDK14U-jdk_x64_linux_hotspot_14_36.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "14.0.0.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk14-binaries/releases/download/jdk-14%2B36/OpenJDK14U-jdk_x64_mac_hotspot_14_36.tar.gz",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "14.0.0.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk14-binaries/releases/download/jdk-14%2B36/OpenJDK14U-jdk_x64_windows_hotspot_14_36.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "0010",
    id = "0010-add_adoptopenjdk-j9_14_0_0",
    author = "poad"
  )
  def migrate0010(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "14.0.0.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk14-binaries/releases/download/jdk-14%2B36_openj9-0.19.0/OpenJDK14-jdk_x64_linux_openj9_14_36_openj9-0.19.0.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "14.0.0.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk14-binaries/releases/download/jdk-14%2B36_openj9-0.19.0/OpenJDK14-jdk_x64_mac_openj9_14_36_openj9-0.19.0.tar.gz",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "14.0.0.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk14-binaries/releases/download/jdk-14%2B36_openj9-0.19.0/OpenJDK14-jdk_x64_windows_openj9_14_36_openj9-0.19.0.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "0011",
    id = "0011-add_adoptopenjdk-hs_11_0_7",
    author = "poad"
  )
  def migrate0011(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.7.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.7%2B10/OpenJDK11U-jdk_x64_linux_hotspot_11.0.7_10.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "11.0.7.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.7%2B10/OpenJDK11U-jdk_x64_mac_hotspot_11.0.7_10.tar.gz",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "11.0.7.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.7%2B10/OpenJDK11U-jdk_x64_windows_hotspot_11.0.7_10.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "11.0.6.hs-adpt", _)
    )
  }

  @ChangeSet(
    order = "0012",
    id = "0012-add_adoptopenjdk-j9_11_0_7",
    author = "poad"
  )
  def migrate0012(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.7.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.7%2B10_openj9-0.20.0/OpenJDK11U-jdk_x64_linux_openj9_11.0.7_10_openj9-0.20.0.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "11.0.7.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.7%2B10_openj9-0.20.0/OpenJDK11U-jdk_x64_mac_openj9_11.0.7_10_openj9-0.20.0.tar.gz",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "11.0.7.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.7%2B10_openj9-0.20.0/OpenJDK11U-jdk_x64_windows_openj9_11.0.7_10_openj9-0.20.0.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "11.0.6.j9-adpt", _)
    )
  }

  @ChangeSet(
    order = "0013",
    id = "0013-add_add_adoptopenjdk-hs_8_0_252",
    author = "poad"
  )
  def migrate0013(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.252.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u252-b09/OpenJDK8U-jdk_x64_linux_hotspot_8u252b09.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "8.0.252.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u252-b09/OpenJDK8U-jdk_x64_mac_hotspot_8u252b09.tar.gz",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "8.0.252.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u252-b09/OpenJDK8U-jdk_x64_windows_hotspot_8u252b09.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "8.0.242.hs-adpt", _)
    )
  }

  @ChangeSet(
    order = "0014",
    id = "0014-add_adoptopenjdk-j9_8_0_252",
    author = "poad"
  )
  def migrate0014(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.252.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u252-b09_openj9-0.20.0/OpenJDK8U-jdk_x64_linux_openj9_8u252b09_openj9-0.20.0.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "8.0.252.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u252-b09_openj9-0.20.0/OpenJDK8U-jdk_x64_mac_openj9_8u252b09_openj9-0.20.0.tar.gz",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "8.0.252.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u252-b09_openj9-0.20.0/OpenJDK8U-jdk_x86-32_windows_openj9_8u252b09_openj9-0.20.0.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "8.0.242.j9-adpt", _)
    )
  }

  @ChangeSet(
    order = "0015",
    id = "0015-add_adoptopenjdk-j9_14_0_1",
    author = "poad"
  )
  def migrate0015(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "14.0.1.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk14-binaries/releases/download/jdk-14.0.1%2B7_openj9-0.20.0/OpenJDK14U-jdk_x64_linux_openj9_14.0.1_7_openj9-0.20.0.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "14.0.1.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk14-binaries/releases/download/jdk-14.0.1%2B7_openj9-0.20.0/OpenJDK14U-jdk_x64_mac_openj9_14.0.1_7_openj9-0.20.0.tar.gz",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "14.0.1.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk14-binaries/releases/download/jdk-14.0.1%2B7_openj9-0.20.0/OpenJDK14U-jdk_x64_windows_openj9_14.0.1_7_openj9-0.20.0.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.0.0.j9-adpt", _)
    )
  }

  @ChangeSet(
    order = "0016",
    id = "0016-add_adoptopenjdk-hs_14_0_1",
    author = "poad"
  )
  def migrate0016(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "14.0.1.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk14-binaries/releases/download/jdk-14.0.1%2B7/OpenJDK14U-jdk_x64_linux_hotspot_14.0.1_7.tar.gz",
        Linux64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "14.0.1.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk14-binaries/releases/download/jdk-14.0.1%2B7/OpenJDK14U-jdk_x64_mac_hotspot_14.0.1_7.tar.gz",
        MacOSX,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "14.0.1.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk14-binaries/releases/download/jdk-14.0.1%2B7/OpenJDK14U-jdk_x64_windows_hotspot_14.0.1_7.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.0.0.hs-adpt", _)
    )
  }

  @ChangeSet(
    order = "0017",
    id = "0017-set_adoptopenjdk_11.0.7.hs_as_default",
    author = "vpavic"
  )
  def migrate0017(implicit db: MongoDatabase) =
    setCandidateDefault("java", "11.0.7.hs-adpt")

  @ChangeSet(
    order = "0018",
    id = "0018-change_windows_adoptopenjdk-j9_8_0_252_to_64_bit",
    author = "abcfy2"
  )
  def migrate0018(implicit db: MongoDatabase) = {
    removeVersion("java", "8.0.252.j9-adpt", Windows)
    List(
      Version(
        "java",
        "8.0.252.j9-adpt",
        "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u252-b09.1_openj9-0.20.0/OpenJDK8U-jdk_x64_windows_openj9_8u252b09_openj9-0.20.0.zip",
        Windows,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "0019",
    id = "0019-add_adoptopenjdk-hs_11_0_8",
    author = "poad"
  )
  def migrate0019(implicit db: MongoDatabase) =
    Map(
      Linux64 -> "OpenJDK11U-jdk_x64_linux_hotspot_11.0.8_10.tar.gz",
      MacOSX  -> "OpenJDK11U-jdk_x64_mac_hotspot_11.0.8_10.tar.gz",
      Windows -> "OpenJDK11U-jdk_x64_windows_hotspot_11.0.8_10.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.8.hs-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.8%2B10/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "11.0.7.hs-adpt", version.platform)
      }

  @ChangeSet(
    order = "0020",
    id = "0020-set_adoptopenjdk_11.0.8.hs_as_default",
    author = "poad"
  )
  def migrate0020(implicit db: MongoDatabase) =
    setCandidateDefault("java", "11.0.8.hs-adpt")

  @ChangeSet(
    order = "0021",
    id = "0021-add_adoptopenjdk-j9_11_0_8",
    author = "poad"
  )
  def migrate0021(implicit db: MongoDatabase) =
    Map(
      Linux64 ->
        "OpenJDK11U-jdk_x64_linux_openj9_11.0.8_10_openj9-0.21.0.tar.gz",
      MacOSX  -> "OpenJDK11U-jdk_x64_mac_openj9_11.0.8_10_openj9-0.21.0.tar.gz",
      Windows -> "OpenJDK11U-jdk_x64_windows_openj9_11.0.8_10_openj9-0.21.0.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.8.j9-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.8%2B10_openj9-0.21.0/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "11.0.7.j9-adpt", version.platform)
      }

  @ChangeSet(
    order = "0022",
    id = "0022-add_adoptopenjdk-hs_14_0_2",
    author = "poad"
  )
  def migrate0022(implicit db: MongoDatabase) =
    Map(
      Linux64 -> "OpenJDK14U-jdk_x64_linux_hotspot_14.0.2_12.tar.gz",
      MacOSX  -> "OpenJDK14U-jdk_x64_mac_hotspot_14.0.2_12.tar.gz",
      Windows -> "OpenJDK14U-jdk_x64_windows_hotspot_14.0.2_12.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "14.0.2.hs-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk14-binaries/releases/download/jdk-14.0.2%2B12/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "14.0.1.hs-adpt", version.platform)
      }

  @ChangeSet(
    order = "0023",
    id = "0023-add_adoptopenjdk-j9_14_0_2",
    author = "poad"
  )
  def migrate0023(implicit db: MongoDatabase) =
    Map(
      Linux64 ->
        "OpenJDK14U-jdk_x64_linux_openj9_14.0.2_12_openj9-0.21.0.tar.gz",
      MacOSX  -> "OpenJDK14U-jdk_x64_mac_openj9_14.0.2_12_openj9-0.21.0.tar.gz",
      Windows -> "OpenJDK14U-jdk_x64_windows_openj9_14.0.2_12_openj9-0.21.0.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "14.0.2.j9-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk14-binaries/releases/download/jdk-14.0.2%2B12_openj9-0.21.0/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "14.0.1.j9-adpt", version.platform)
      }

  @ChangeSet(
    order = "0027",
    id = "0027-add_adoptopenjdk-8-11-linuxarm",
    author = "delight"
  )
  def migrate0027(implicit db: MongoDatabase) =
    List(
      Version(
        "java",
        "8.0.275.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u275-b01/OpenJDK8U-jdk_arm_linux_hotspot_8u275b01.tar.gz",
        LinuxARM32,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "11.0.9.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.9.1%2B1/OpenJDK11U-jdk_arm_linux_hotspot_11.0.9.1_1.tar.gz",
        LinuxARM32,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()

  @ChangeSet(
    order = "0028",
    id = "0028-add_adoptopenjdk-8-11-linuxarm64",
    author = "dvdkruk"
  )
  def migrate0028(implicit db: MongoDatabase) =
    List(
      Version(
        "java",
        "8.0.252.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u252-b09/OpenJDK8U-jdk_aarch64_linux_hotspot_8u252b09.tar.gz",
        LinuxARM64,
        Some(AdoptOpenJDK)
      ),
      Version(
        "java",
        "11.0.8.hs-adpt",
        "https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.8%2B10/OpenJDK11U-jdk_aarch64_linux_hotspot_11.0.8_10.tar.gz",
        LinuxARM64,
        Some(AdoptOpenJDK)
      )
    ).validate()
      .insert()

  @ChangeSet(
    order = "0029",
    id = "0029-add_adoptopenjdk-hs_15_0_0",
    author = "poad"
  )
  def migrate0029(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> "OpenJDK15U-jdk_aarch64_linux_hotspot_15_36.tar.gz",
      Linux64    -> "OpenJDK15U-jdk_x64_linux_hotspot_15_36.tar.gz",
      MacOSX     -> "OpenJDK15U-jdk_x64_mac_hotspot_15_36.tar.gz",
      Windows    -> "OpenJDK15U-jdk_x64_windows_hotspot_15_36.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.0.0.hs-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk15-binaries/releases/download/jdk-15%2B36/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "0030",
    id = "0030-add_adoptopenjdk-j9_15_0_0",
    author = "poad"
  )
  def migrate0030(implicit db: MongoDatabase) =
    Map(
      Linux64 -> "OpenJDK15U-jdk_x64_linux_openj9_15_36_openj9-0.22.0.tar.gz",
      MacOSX  -> "OpenJDK15U-jdk_x64_mac_openj9_15_36_openj9-0.22.0.tar.gz",
      Windows -> "OpenJDK15U-jdk_x64_windows_openj9_15_36_openj9-0.22.0.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.0.0.j9-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk15-binaries/releases/download/jdk-15%2B36_openj9-0.22.0/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "0031",
    id = "0031-add_adoptopenjdk-j9_8_0_272",
    author = "eddumelendez"
  )
  def migrate0031(implicit db: MongoDatabase) =
    Map(
      Linux64 -> "OpenJDK8U-jdk_x64_linux_openj9_8u272b10_openj9-0.23.0.tar.gz",
      MacOSX  -> "OpenJDK8U-jdk_x64_mac_openj9_8u272b10_openj9-0.23.0.tar.gz",
      Windows -> "OpenJDK8U-jdk_x64_windows_openj9_8u272b10_openj9-0.23.0.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.272.j9-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u272-b10_openj9-0.23.0/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8.0.265.j9-adpt", version.platform)
      }

  @ChangeSet(
    order = "0034",
    id = "0034-add_adoptopenjdk-j9_11_0_9",
    author = "poad"
  )
  def migrate0034(implicit db: MongoDatabase) =
    Map(
      Linux64    -> "OpenJDK11U-jdk_x64_linux_openj9_11.0.9_11_openj9-0.23.0.tar.gz",
      Windows    -> "OpenJDK11U-jdk_x64_windows_openj9_11.0.9_11_openj9-0.23.0.zip",
      MacOSX     -> "OpenJDK11U-jdk_x64_mac_openj9_11.0.9_11_openj9-0.23.0.tar.gz",
      LinuxARM64 -> "OpenJDK11U-jdk_aarch64_linux_openj9_11.0.9_11_openj9-0.23.0.tar.gz"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.9.j9-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.9%2B11_openj9-0.23.0/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "11.0.8.j9-adpt", version.platform)
      }

  @ChangeSet(
    order = "0035",
    id = "0035-add_adoptopenjdk-hs_15_0_1",
    author = "poad"
  )
  def migrate0035(implicit db: MongoDatabase) =
    Map(
      Linux64    -> "OpenJDK15U-jdk_x64_linux_hotspot_15.0.1_9.tar.gz",
      Windows    -> "OpenJDK15U-jdk_x64_windows_hotspot_15.0.1_9.zip",
      MacOSX     -> "OpenJDK15U-jdk_x64_mac_hotspot_15.0.1_9.tar.gz",
      LinuxARM64 -> "OpenJDK15U-jdk_aarch64_linux_hotspot_15.0.1_9.tar.gz"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.0.1.hs-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk15-binaries/releases/download/jdk-15.0.1%2B9/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "15.0.0.hs-adpt", version.platform)
      }

  @ChangeSet(
    order = "0036",
    id = "0036-add_adoptopenjdk-j9_15_0_1",
    author = "poad"
  )
  def migrate0036(implicit db: MongoDatabase) =
    Map(
      Linux64    -> "OpenJDK15U-jdk_x64_linux_openj9_15.0.1_9_openj9-0.23.0.tar.gz",
      Windows    -> "OpenJDK15U-jdk_x64_windows_openj9_15.0.1_9_openj9-0.23.0.zip",
      MacOSX     -> "OpenJDK15U-jdk_x64_mac_openj9_15.0.1_9_openj9-0.23.0.tar.gz",
      LinuxARM64 -> "OpenJDK15U-jdk_aarch64_linux_openj9_15.0.1_9_openj9-0.23.0.tar.gz"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.0.1.j9-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk15-binaries/releases/download/jdk-15.0.1%2B9_openj9-0.23.0/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "15.0.0.j9-adpt", version.platform)
      }

  @ChangeSet(
    order = "0038",
    id = "0038-add_adoptopenjdk-11.0.9",
    author = "eddumelendez"
  )
  def migrate0038(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> "OpenJDK11U-jdk_aarch64_linux_11.0.9_11.tar.gz",
      Linux64    -> "OpenJDK11U-jdk_x64_linux_11.0.9_11.tar.gz",
      Windows    -> "OpenJDK11U-jdk_x64_windows_11.0.9_11.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.9.open-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk11-upstream-binaries/releases/download/jdk-11.0.9%2B11/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "0039",
    id = "0039-set_adoptopenjdk_11.0.9.hs_as_default",
    author = "poad"
  )
  def migrate0039(implicit db: MongoDatabase) =
    setCandidateDefault("java", "11.0.9.hs-adpt")

  @ChangeSet(
    order = "0040",
    id = "0040-remove_adoptopenjdk-mac-j9_11_0_9",
    author = "eddumelendez"
  )
  def migrate0040(implicit db: MongoDatabase) =
    removeVersion("java", "11.0.9.j9-adpt", MacOSX)

  @ChangeSet(
    order = "0041",
    id = "0041-update_adoptopenjdk-mac-j9_11_0_9",
    author = "eddumelendez"
  )
  def migrate0041(implicit db: MongoDatabase) =
    Map(
      MacOSX -> "OpenJDK11U-jdk_x64_mac_openj9_11.0.9_11_openj9-0.23.0.tar.gz"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.9.j9-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.9%2B11.1_openj9-0.23.0/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "0044",
    id = "0044-add_adoptopenjdk-open-8u275",
    author = "eddumelendez"
  )
  def migrate0044(implicit db: MongoDatabase) =
    Map(
      Linux64 -> "OpenJDK8U-jdk_x64_linux_8u275b01.tar.gz",
      Windows -> "OpenJDK8U-jre_x64_windows_8u275b01.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.275.open-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk8-upstream-binaries/releases/download/jdk8u275-b01/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8.0.272.open-adpt", version.platform)
      }

  @ChangeSet(
    order = "0045",
    id = "0045-remove_adoptopenjdk-open-11_0_9",
    author = "eddumelendez"
  )
  def migrate0045(implicit db: MongoDatabase) =
    Seq(
      LinuxARM64,
      Linux64,
      Windows
    ).foreach { platform =>
      removeVersion("java", "11.0.9.open-adpt", platform)
    }

  @ChangeSet(
    order = "0046",
    id = "0046-add_adoptopenjdk-open_11_0_9.1",
    author = "eddumelendez"
  )
  def migrate0046(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> "OpenJDK11U-jdk_aarch64_linux_11.0.9.1_1.tar.gz",
      Linux64    -> "OpenJDK11U-jdk_x64_linux_11.0.9.1_1.tar.gz",
      Windows    -> "OpenJDK11U-jdk_x64_windows_11.0.9.1_1.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.9.open-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk11-upstream-binaries/releases/download/jdk-11.0.9.1%2B1/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "0048",
    id = "0048-remove_adoptopenjdk-hs_11_0_9",
    author = "eddumelendez"
  )
  def migrate0048(implicit db: MongoDatabase) =
    Seq(
      LinuxARM64,
      Linux64,
      Windows,
      MacOSX
    ).foreach { platform =>
      removeVersion("java", "11.0.9.hs-adpt", platform)
    }

  @ChangeSet(
    order = "0049",
    id = "0049-add_adoptopenjdk-hs_11.0.9.1_1",
    author = "eddumelendez"
  )
  def migrate0049(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> "OpenJDK11U-jdk_aarch64_linux_hotspot_11.0.9.1_1.tar.gz",
      Linux64    -> "OpenJDK11U-jdk_x64_linux_hotspot_11.0.9.1_1.tar.gz",
      Windows    -> "OpenJDK11U-jdk_x64_windows_hotspot_11.0.9.1_1.zip",
      MacOSX     -> "OpenJDK11U-jdk_x64_mac_hotspot_11.0.9.1_1.tar.gz"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.9.hs-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.9.1%2B1/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "0050",
    id = "0050-add_adoptopenjdk-hs_8_0_275",
    author = "eddumelendez"
  )
  def migrate0050(implicit db: MongoDatabase) =
    Map(
      Linux64 -> "OpenJDK8U-jdk_x64_linux_hotspot_8u275b01.tar.gz",
      MacOSX  -> "OpenJDK8U-jdk_x64_mac_hotspot_8u275b01.tar.gz",
      Windows -> "OpenJDK8U-jdk_x64_windows_hotspot_8u275b01.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.275.hs-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u275-b01/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8.0.272.hs-adpt", version.platform)
      }

  @ChangeSet(
    order = "0051",
    id = "0051-add_adoptopenjdk-j9_8_0_275",
    author = "abcfy2"
  )
  def migrate0051(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> "OpenJDK8U-jdk_aarch64_linux_openj9_8u275b01_openj9-0.23.0.tar.gz",
      Linux64    -> "OpenJDK8U-jdk_x64_linux_openj9_8u275b01_openj9-0.23.0.tar.gz",
      MacOSX     -> "OpenJDK8U-jdk_x64_mac_openj9_8u275b01_openj9-0.23.0.tar.gz",
      Windows    -> "OpenJDK8U-jdk_x64_windows_openj9_8u275b01_openj9-0.23.0.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.275.j9-adpt",
            s"https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u275-b01_openj9-0.23.0/$binary",
            platform,
            Some(AdoptOpenJDK)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8.0.272.j9-adpt", version.platform)
      }

  @ChangeSet(
    order = "052",
    id = "052-hide-java-versions",
    author = "eddumelendez"
  )
  def migrate052(implicit db: MongoDatabase): Unit =
    hideVersion("java", "8.0.272.hs-adpt")
}
