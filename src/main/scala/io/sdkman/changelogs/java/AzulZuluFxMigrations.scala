package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{AdoptOpenJDK, Linux64, MacOSX, Version, Windows, _}

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
        "8.0.232-zulufx",
        "https://cdn.azul.com/zulu/bin/zulu8.42.0.23-ca-fx-jdk8.0.232-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "8.0.232-zulufx",
        "https://cdn.azul.com/zulu/bin/zulu8.42.0.23-ca-fx-jdk8.0.232-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "8.0.232-zulufx",
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
        "11.0.5-zulufx",
        "https://cdn.azul.com/zulu/bin/zulu11.35.15-ca-fx-jdk11.0.5-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "11.0.5-zulufx",
        "https://cdn.azul.com/zulu/bin/zulu11.35.15-ca-fx-jdk11.0.5-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "11.0.5-zulufx",
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

}
