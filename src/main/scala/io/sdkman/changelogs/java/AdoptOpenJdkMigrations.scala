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
}
