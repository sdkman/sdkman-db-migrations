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
  hideVersion,
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

  @ChangeSet(
    order = "025",
    id = "025-hide-java-versions",
    author = "eddumelendez"
  )
  def migrate025(implicit db: MongoDatabase): Unit =
    Seq("7.0.181-zulu", "8.0.202-zulu", "8.0.272-zulu")
      .foreach(version => hideVersion("java", version))

  @ChangeSet(
    order = "026",
    id = "026-hide-java-versions",
    author = "eddumelendez"
  )
  def migrate026(implicit db: MongoDatabase): Unit =
    Seq(
      "8.0.275-zulu",
      "9.0.7-zulu",
      "10.0.2-zulu",
      "12.0.2-zulu",
      "13.0.5-zulu",
      "14.0.2-zulu"
    ).foreach(version => hideVersion("java", version))

  @ChangeSet(
    order = "027",
    id = "027-hide-java-versions",
    author = "eddumelendez"
  )
  def migrate027(implicit db: MongoDatabase): Unit =
    hideVersion("java", "15.0.2-zulu")

  @ChangeSet(
    order = "028",
    id = "0028-add_zulu_7_0_302",
    author = "jorsol"
  )
  def migrate028(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu/bin/zulu7.46.0.11-ca-jdk7.0.302-linux_x64.tar.gz"),
      Windows -> ("zulu/bin/zulu7.46.0.11-ca-jdk7.0.302-win_x64.zip"),
      MacOSX  -> ("zulu/bin/zulu7.46.0.11-ca-jdk7.0.302-macosx_x64.tar.gz")
    ).map {
        case (platform, path) =>
          Version(
            "java",
            "7.0.302-zulu",
            s"https://cdn.azul.com/$path",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "7.0.292-zulu", version.platform)
      }

  @ChangeSet(
    order = "029",
    id = "0029-add_zulu_8_0_292",
    author = "jorsol"
  )
  def migrate029(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu/bin/zulu8.54.0.21-ca-jdk8.0.292-linux_x64.tar.gz"),
      Windows -> ("zulu/bin/zulu8.54.0.21-ca-jdk8.0.292-win_x64.zip"),
      MacOSX  -> ("zulu/bin/zulu8.54.0.21-ca-jdk8.0.292-macosx_x64.tar.gz")
    ).map {
        case (platform, path) =>
          Version(
            "java",
            "8.0.292-zulu",
            s"https://cdn.azul.com/$path",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8.0.282-zulu", version.platform)
      }

  @ChangeSet(
    order = "030",
    id = "0030-add_zulu_11_0_11",
    author = "jorsol"
  )
  def migrate030(implicit db: MongoDatabase) =
    Map(
      Linux64    -> ("zulu/bin/zulu11.48.21-ca-jdk11.0.11-linux_x64.tar.gz"),
      LinuxARM64 -> ("zulu-embedded/bin/zulu11.48.21-ca-jdk11.0.11-linux_aarch64.tar.gz"),
      Windows    -> ("zulu/bin/zulu11.48.21-ca-jdk11.0.11-win_x64.zip"),
      MacOSX     -> ("zulu/bin/zulu11.48.21-ca-jdk11.0.11-macosx_x64.tar.gz")
    ).map {
        case (platform, path) =>
          Version(
            "java",
            "11.0.11-zulu",
            s"https://cdn.azul.com/$path",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "11.0.10-zulu", version.platform)
      }

  @ChangeSet(
    order = "031",
    id = "0031-add_zulu_13_0_7",
    author = "jorsol"
  )
  def migrate031(implicit db: MongoDatabase) =
    Map(
      Linux64    -> ("zulu/bin/zulu13.40.15-ca-jdk13.0.7-linux_x64.tar.gz"),
      LinuxARM64 -> ("zulu-embedded/bin/zulu13.40.15-ca-jdk13.0.7-linux_aarch64.tar.gz"),
      Windows    -> ("zulu/bin/zulu13.40.15-ca-jdk13.0.7-win_x64.zip"),
      MacOSX     -> ("zulu/bin/zulu13.40.15-ca-jdk13.0.7-macosx_x64.tar.gz")
    ).map {
        case (platform, path) =>
          Version(
            "java",
            "13.0.7-zulu",
            s"https://cdn.azul.com/$path",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "13.0.6-zulu", version.platform)
      }

  @ChangeSet(
    order = "032",
    id = "0032-add_zulu_15_0_3",
    author = "jorsol"
  )
  def migrate032(implicit db: MongoDatabase) =
    Map(
      Linux64    -> ("zulu/bin/zulu15.32.15-ca-jdk15.0.3-linux_x64.tar.gz"),
      LinuxARM64 -> ("zulu-embedded/bin/zulu15.32.15-ca-jdk15.0.3-linux_aarch64.tar.gz"),
      Windows    -> ("zulu/bin/zulu15.32.15-ca-jdk15.0.3-win_x64.zip "),
      MacOSX     -> ("zulu/bin/zulu15.32.15-ca-jdk15.0.3-macosx_x64.tar.gz")
    ).map {
        case (platform, path) =>
          Version(
            "java",
            "15.0.3-zulu",
            s"https://cdn.azul.com/$path",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "15.0.2-zulu", version.platform)
      }
}
