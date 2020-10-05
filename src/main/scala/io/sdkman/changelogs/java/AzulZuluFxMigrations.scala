package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{
  Linux64,
  MacOSX,
  Version,
  Windows,
  Zulu,
  removeVersion
}

@ChangeLog(order = "018")
class AzulZuluFxMigrations {

  @ChangeSet(order = "0010", id = "0010-add_zulufx_11.0.8", author = "poad")
  def migrate0010(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu11.41.23-ca-fx-jdk11.0.8-linux_x64.tar.gz"),
      MacOSX  -> ("zulu11.41.23-ca-fx-jdk11.0.8-macosx_x64.tar.gz"),
      Windows -> ("zulu11.41.23-ca-fx-jdk11.0.8-win_x64.zip")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.8.fx-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "11.0.7.fx-zulu", version.platform)
      }
  @ChangeSet(order = "0011", id = "0011-add_zulufx_13.0.4", author = "poad")
  def migrate0011(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu13.33.25-ca-fx-jdk13.0.4-linux_x64.tar.gz"),
      MacOSX  -> ("zulu13.33.25-ca-fx-jdk13.0.4-macosx_x64.zip"),
      Windows -> ("zulu13.33.25-ca-fx-jdk13.0.4-win_x64.zip")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "13.0.4.fx-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "13.0.3.fx-zulu", version.platform)
      }

  @ChangeSet(order = "0012", id = "0012-add_zulufx_14.0.2", author = "poad")
  def migrate0012(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu14.29.23-ca-fx-jdk14.0.2-linux_x64.tar.gz"),
      MacOSX  -> ("zulu14.29.23-ca-fx-jdk14.0.2-macosx_x64.tar.gz")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "13.0.4.fx-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "13.0.3.fx-zulu", version.platform)
      }
  @ChangeSet(order = "0013", id = "0013-add_zulufx_8.0.265", author = "poad")
  def migrate0013(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu8.48.0.53-ca-fx-jdk8.0.265-linux_x64.tar.gz"),
      MacOSX  -> ("zulu8.48.0.53-ca-fx-jdk8.0.265-macosx_x64.tar.gz"),
      Windows -> ("zulu8.48.0.53-ca-fx-jdk8.0.265-win_x64.zip")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.265.fx-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8.0.262.fx-zulu", version.platform)
      }
  @ChangeSet(order = "0014", id = "0014-15.0.0", author = "poad")
  def migrate0014(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu15.27.17-ca-fx-jdk15.0.0-linux_x64.tar.gz"),
      MacOSX  -> ("zulu15.27.17-ca-fx-jdk15.0.0-macosx_x64.tar.gz"),
      Windows -> ("zulu15.27.17-ca-fx-jdk15.0.0-win_x64.zip")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.0.0.fx-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "0015",
    id = "0015-remove_zulufx_13.0.4",
    author = "helpermethod"
  )
  def migrate0015(implicit db: MongoDatabase) = {
    Seq(Linux64, MacOSX, Windows)
      .foreach {
        removeVersion("java", "13.0.4.fx-zulu", _)
      }
  }

  @ChangeSet(
    order = "0016",
    id = "0016-add_zulufx_13.0.4",
    author = "helpermethod"
  )
  def migrate0016(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu13.33.25-ca-fx-jdk13.0.4-linux_x64.tar.gz"),
      MacOSX  -> ("zulu13.33.25-ca-fx-jdk13.0.4-macosx_x64.zip"),
      Windows -> ("zulu13.33.25-ca-fx-jdk13.0.4-win_x64.zip")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "13.0.4.fx-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "0017",
    id = "0017-add_zulufx_14.0.2",
    author = "helpermethod"
  )
  def migrate0017(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu14.29.23-ca-fx-jdk14.0.2-linux_x64.tar.gz"),
      MacOSX  -> ("zulu14.29.23-ca-fx-jdk14.0.2-macosx_x64.tar.gz")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "14.0.2.fx-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "13.0.3.fx-zulu", version.platform)
      }
}
