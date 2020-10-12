package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Dragonwell, Linux64, Version}

@ChangeLog(order = "038")
class AlibabaDragonwellMigrations {

  @ChangeSet(
    order = "001",
    id = "001-add_dragonwell-8u262",
    author = "eddumelendez"
  )
  def migrate001(implicit db: MongoDatabase): Unit =
    Map(
      Linux64 -> "Alibaba_Dragonwell_8.4.4-GA_Linux_x64.tar.gz"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8u262-dwell",
            s"https://github.com/alibaba/dragonwell8/releases/download/dragonwell-8.4.4_jdk8u262-ga/$binary",
            platform,
            Some(Dragonwell)
          )
      }
      .toList
      .validate()
      .insert()

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
            "11.0.8-dwell",
            s"https://github.com/alibaba/dragonwell11/releases/download/dragonwell-11.0.8.3_jdk-11.0.8-ga/$binary",
            platform,
            Some(Dragonwell)
          )
      }
      .toList
      .validate()
      .insert()

}
