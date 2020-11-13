package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Alibaba, Linux64, Version, removeVersion}

@ChangeLog(order = "039")
class AlibabaDragonwellMigrations {

  @ChangeSet(
    order = "002",
    id = "002-add_dragonwell-11.0.8",
    author = "eddumelendez"
  )
  def migrate002(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "OpenJDK11U-jdk_x64_linux_dragonwell_dragonwell-11.0.8.3_jdk-11.0.8-ga.tar.gz"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.8-albba",
            s"https://github.com/alibaba/dragonwell11/releases/download/dragonwell-11.0.8.3_jdk-11.0.8-ga/$binary",
            platform,
            Some(Alibaba)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "003",
    id = "003-add_dragonwell-8u272",
    author = "eddumelendez"
  )
  def migrate003(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "Alibaba_Dragonwell_8.5.4-GA_Linux_x64.tar.gz"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8u272-albba",
            s"https://github.com/alibaba/dragonwell8/releases/download/dragonwell-8.5.4_jdk8u272-ga/$binary",
            platform,
            Some(Alibaba)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8u262-albba", version.platform)
      }

}
