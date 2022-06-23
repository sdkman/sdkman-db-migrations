package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Alibaba, Linux64, Version, removeVersion}

@ChangeLog(order = "039")
class AlibabaDragonwellMigrations {

  @ChangeSet(
    order = "004",
    id = "004-update_dragonwell_versions",
    author = "joeyleeeeeee97"
  )
  def migrate002(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "Alibaba_Dragonwell_11.0.15.11.9_x64_linux.tar.gz"
      LinuxARM64 -> "Alibaba_Dragonwell_11.0.15.11.9_aarch64_linux.tar.gz"
      Windows -> "Alibaba_Dragonwell_11.0.15.11.9_x64_windows.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.15.11-albba",
            s"https://github.com/alibaba/dragonwell11/releases/download/dragonwell-11.0.15.11.9_jdk-11.0.15-ga/$binary",
            platform,
            Some(Alibaba)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
              removeVersion("java", "11.0.15.11-albba", version.platform)
            }

  @ChangeSet(
    order = "004",
    id = "004-update_dragonwell_versions",
    author = "joeyleeeeeee97"
  )
  def migrate003(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "Alibaba_Dragonwell_8.11.12_x64_linux.tar.gz"
      LinuxARM64 -> "Alibaba_Dragonwell_8.11.12_aarch64_linux.tar.gz"
      Windows -> "Alibaba_Dragonwell_8.11.12_x64_windows.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8u332-albba",
            s"https://github.com/alibaba/dragonwell8/releases/download/dragonwell-8.11.12_jdk8u332-ga/$binary",
            platform,
            Some(Alibaba)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8u332-albba", version.platform)
      }

  @ChangeSet(
    order = "004",
    id = "004-update_dragonwell_versions",
    author = "joeyleeeeeee97"
  )
  def migrate003(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "Alibaba_Dragonwell_17.0.3.0.3+7_x64_linux.tar.gz"
      LinuxARM64 -> "Alibaba_Dragonwell_17.0.3.0.3+7_aarch64_linux.tar.gz"
      Windows -> "Alibaba_Dragonwell_17.0.3.0.3+7_x64_windows.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "17.0.3-albba",
            s"https://github.com/alibaba/dragonwell17/releases/download/dragonwell-17.0.3.0.3%2B7_jdk-17.0.3-ga/$binary",
            platform,
            Some(Alibaba)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "17.0.3-albba", version.platform)
      }
}
