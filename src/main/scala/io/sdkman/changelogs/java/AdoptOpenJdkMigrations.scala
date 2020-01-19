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
}
