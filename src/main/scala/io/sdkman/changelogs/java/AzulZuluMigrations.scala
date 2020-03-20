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

@ChangeLog(order = "019")
class AzulZuluMigrations {

  @ChangeSet(order = "001", id = "001-add_zulu_8_0_232", author = "dimitryc")
  def migrate001(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "8.0.232-zulu", platform)
    )
    List(
      Version(
        "java",
        "8.0.232-zulu",
        "https://cdn.azul.com/zulu/bin/zulu8.42.0.23-ca-jdk8.0.232-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "8.0.232-zulu",
        "https://cdn.azul.com/zulu/bin/zulu8.42.0.23-ca-jdk8.0.232-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "8.0.232-zulu",
        "https://cdn.azul.com/zulu/bin/zulu8.42.0.23-ca-jdk8.0.232-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
  }

  @ChangeSet(order = "002", id = "002-add_zulu_11_0_5", author = "dimitryc")
  def migrate002(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "11.0.5-zulu", platform)
    )
    List(
      Version(
        "java",
        "11.0.5-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.35.15-ca-jdk11.0.5-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "11.0.5-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.35.15-ca-jdk11.0.5-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "11.0.5-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.35.15-ca-jdk11.0.5-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
  }

  @ChangeSet(order = "003", id = "003-add_zulu_8_0_242", author = "poad")
  def migrate003(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.242-zulu",
        "https://cdn.azul.com/zulu/bin/zulu8.44.0.9-ca-jdk8.0.242-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "8.0.242-zulu",
        "https://cdn.azul.com/zulu/bin/zulu8.44.0.9-ca-jdk8.0.242-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "8.0.242-zulu",
        "https://cdn.azul.com/zulu/bin/zulu8.44.0.9-ca-jdk8.0.242-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "8.0.232-zulu", platform)
    )
  }

  @ChangeSet(order = "004", id = "004-add_zulu_11_0_6", author = "poad")
  def migrate004(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.6-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.37.17-ca-jdk11.0.6-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "11.0.6-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.37.17-ca-jdk11.0.6-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "11.0.6-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.37.17-ca-jdk11.0.6-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "11.0.5-zulu", platform)
    )
  }

  @ChangeSet(order = "005", id = "005-add_zulu_13_0_2", author = "poad")
  def migrate005(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "13.0.2-zulu",
        "https://cdn.azul.com/zulu/bin/zulu13.29.9-ca-jdk13.0.2-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "13.0.2-zulu",
        "https://cdn.azul.com/zulu/bin/zulu13.29.9-ca-jdk13.0.2-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "13.0.2-zulu",
        "https://cdn.azul.com/zulu/bin/zulu13.29.9-ca-jdk13.0.2-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "13.0.1-zulu", platform)
    )
  }

  @ChangeSet(
    order = "006",
    id = "006-add_zulu_7_0_252",
    author = "philiplourandos"
  )
  def migrate006(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "7.0.242-zulu", platform)
    )
    List(
      Version(
        "java",
        "7.0.252-zulu",
        "https://cdn.azul.com/zulu/bin/zulu7.36.0.5-ca-jdk7.0.252-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "7.0.252-zulu",
        "https://cdn.azul.com/zulu/bin/zulu7.36.0.5-ca-jdk7.0.252-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "7.0.252-zulu",
        "https://cdn.azul.com/zulu/bin/zulu7.36.0.5-ca-jdk7.0.252-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
  }

  @ChangeSet(
    order = "007",
    id = "007-add_zulu_14_0_",
    author = "philiplourandos"
  )
  def migrate007(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "14.0.0-zulu",
        "https://cdn.azul.com/zulu/bin/zulu14.27.1-ca-jdk14-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "14.0.0-zulu",
        "https://cdn.azul.com/zulu/bin/zulu14.27.1-ca-jdk14-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "14.0.0-zulu",
        "https://cdn.azul.com/zulu/bin/zulu14.27.1-ca-jdk14-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
  }
}
