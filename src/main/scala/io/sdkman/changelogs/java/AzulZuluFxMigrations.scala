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

  @ChangeSet(
    order = "0001",
    id = "0001-add_zulufx_8_0_232",
    author = "poad"
  )
  def migrate0001(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.232.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu8.42.0.23-ca-fx-jdk8.0.232-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "8.0.232.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu8.42.0.23-ca-fx-jdk8.0.232-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "8.0.232.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu8.42.0.23-ca-fx-jdk8.0.232-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
  }

  @ChangeSet(order = "0002", id = "0002-add_zulufx_11_0_5", author = "poad")
  def migrate0002(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.5.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.35.15-ca-fx-jdk11.0.5-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "11.0.5.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.35.15-ca-fx-jdk11.0.5-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "11.0.5.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.35.15-ca-fx-jdk11.0.5-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
  }

  @ChangeSet(
    order = "0003",
    id = "0003-remove_old_zulufx_8_0_202",
    author = "poad"
  )
  def migrate0003(implicit db: MongoDatabase) =
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "8.0.202-zulufx", platform)
    )

  @ChangeSet(
    order = "0004",
    id = "0004-remove_old_zulufx_11_0_2",
    author = "poad"
  )
  def migrate0004(implicit db: MongoDatabase) =
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "11.0.2-zulufx", platform)
    )

  @ChangeSet(order = "0005", id = "0005-add_zulufx_11_0_6", author = "poad")
  def migrate0005(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.6.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.37.19-ca-fx-jdk11.0.6-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "11.0.6.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.37.19-ca-fx-jdk11.0.6-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "11.0.6.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.37.19-ca-fx-jdk11.0.6-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "11.0.5.fx-zulu", platform)
    )
  }

  @ChangeSet(
    order = "0006",
    id = "0006-add_zulufx_8_0_252",
    author = "poad"
  )
  def migrate0006(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.252.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu8.46.0.19-ca-fx-jdk8.0.252-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "8.0.252.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu8.46.0.19-ca-fx-jdk8.0.252-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "8.0.252.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu8.46.0.19-ca-fx-jdk8.0.252-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "8.0.242.fx-zulu", platform)
    )
  }

  @ChangeSet(order = "0007", id = "0007-add_zulufx_11_0_7", author = "poad")
  def migrate0007(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.7.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.39.15-ca-fx-jdk11.0.7-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "11.0.7.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.39.15-ca-fx-jdk11.0.7-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "11.0.7.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.39.15-ca-fx-jdk11.0.7-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "11.0.6.fx-zulu", platform)
    )
  }

  @ChangeSet(order = "0008", id = "0008-add_zulufx_13_0_3", author = "poad")
  def migrate0008(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "13.0.3.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu13.31.11-ca-fx-jdk13.0.3-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "13.0.3.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu13.31.11-ca-fx-jdk13.0.3-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "13.0.3.fx-zulu",
        "https://cdn.azul.com/zulu/bin/zulu13.31.11-ca-fx-jdk13.0.3-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "13.0.2.fx-zulu", platform)
    )
  }
  @ChangeSet(order = "0009", id = "0009-add_zulufx_8.0.262", author = "poad")
  def migrate0009(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu8.48.0.51-ca-fx-jdk8.0.262-linux_x64.tar.gz"),
      MacOSX  -> ("zulu8.48.0.51-ca-fx-jdk8.0.262-macosx_x64.tar.gz"),
      Windows -> ("zulu8.48.0.51-ca-fx-jdk8.0.262-win_x64.zip")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.262.fx-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8.0.252.fx-zulu", version.platform)
      }
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
}
