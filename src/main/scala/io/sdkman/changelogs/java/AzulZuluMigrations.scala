package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{
  Linux64,
  LinuxARM64,
  MacOSX,
  Version,
  Windows,
  Zulu,
  removeVersion
}

@ChangeLog(order = "019")
class AzulZuluMigrations {

  @ChangeSet(
    order = "014",
    id = "0014-add-add_zulu_14_0_2",
    author = "poad"
  )
  def migrate014(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu14.29.23-ca-jdk14.0.2-linux_x64.tar.gz"),
      MacOSX  -> ("zulu14.29.23-ca-jdk14.0.2-macosx_x64.tar.gz"),
      Windows -> ("zulu14.29.23-ca-jdk14.0.2-win_x64.zip")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "14.0.2-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "14.0.1-zulu", version.platform)
      }

  @ChangeSet(
    order = "020",
    id = "0020-add_zulu_8_0_272-b17",
    author = "poad"
  )
  def migrate020(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> ("zulu-embedded/bin/zulu8.50.0.259-ca-jdk8.0.272-linux_aarch64.tar.gz"),
      Linux64    -> ("zulu/bin/zulu8.50.0.21-ca-jdk8.0.272-linux_x64.tar.gz"),
      Windows    -> ("zulu/bin/zulu8.50.0.21-ca-jdk8.0.272-win_x64.zip"),
      MacOSX     -> ("zulu/bin/zulu8.50.0.21-ca-jdk8.0.272-macosx_x64.tar.gz")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.272-zulu",
            s"https://cdn.azul.com/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8.0.265-zulu", version.platform)
      }

  @ChangeSet(
    order = "021",
    id = "0021-add_zulu_11_0_9+11",
    author = "poad"
  )
  def migrate021(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> ("zulu-embedded/bin/zulu11.43.88-ca-jdk11.0.9-linux_aarch64.tar.gz"),
      Linux64    -> ("zulu/bin/zulu11.43.21-ca-jdk11.0.9-linux_x64.tar.gz"),
      Windows    -> ("zulu/bin/zulu11.43.21-ca-jdk11.0.9-win_x64.zip"),
      MacOSX     -> ("zulu/bin/zulu11.43.21-ca-jdk11.0.9-macosx_x64.tar.gz")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.9-zulu",
            s"https://cdn.azul.com/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "11.0.8-zulu", version.platform)
      }

  @ChangeSet(
    order = "022",
    id = "0022-add_zulu_13_0_5+3",
    author = "poad"
  )
  def migrate022(implicit db: MongoDatabase) =
    Map(
      LinuxARM64 -> ("zulu-embedded/bin/zulu13.35.50-ca-jdk13.0.5-linux_aarch64.tar.gz"),
      Linux64    -> ("zulu/bin/zulu13.35.17-ca-jdk13.0.5-linux_x64.tar.gz"),
      Windows    -> ("zulu/bin/zulu13.35.17-ca-jdk13.0.5-win_x64.zip"),
      MacOSX     -> ("zulu/bin/zulu13.35.17-ca-jdk13.0.5-macosx_x64.tar.gz")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "13.0.5-zulu",
            s"https://cdn.azul.com/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "13.0.4-zulu", version.platform)
      }

  @ChangeSet(
    order = "023",
    id = "0023-add_zulu_15_0_1",
    author = "poad"
  )
  def migrate023(implicit db: MongoDatabase) =
    Map(
      Linux64    -> ("zulu/bin/zulu15.28.13-ca-jdk15.0.1-linux_x64.tar.gz"),
      LinuxARM64 -> ("zulu-embedded/bin/zulu15.28.13-ca-jdk15.0.1-linux_aarch64.tar.gz"),
      Windows    -> ("zulu/bin/zulu15.28.13-ca-jdk15.0.1-win_x64.zip"),
      MacOSX     -> ("zulu/bin/zulu15.28.13-ca-jdk15.0.1-macosx_x64.tar.gz")
    ).map {
        case (platform, path) =>
          Version(
            "java",
            "15.0.1-zulu",
            s"https://cdn.azul.com/$path",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "15.0.0-zulu", version.platform)
      }

  @ChangeSet(
    order = "024",
    id = "0024-add_zulu_7_0_282",
    author = "poad"
  )
  def migrate024(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu7.42.0.13-ca-jdk7.0.282-linux_x64.tar.gz"),
      Windows -> ("zulu7.42.0.13-ca-jdk7.0.282-win_x64.zip"),
      MacOSX  -> ("zulu7.42.0.13-ca-jdk7.0.282-macosx_x64.zip")
    ).map {
        case (platform, path) =>
          Version(
            "java",
            "7.0.282-zulu",
            s"https://cdn.azul.com/zulu/bin/$path",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "7.0.262-zulu", version.platform)
      }
}
