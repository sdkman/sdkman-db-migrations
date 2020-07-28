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

  @ChangeSet(order = "006", id = "006-add_zulu_14_0_0", author = "poad")
  def migrate006(implicit db: MongoDatabase) = {
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
        "https://cdn.azul.com/zulu/bin/zulu14.27.1-ca-jdk14-macosx_x64.zip",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
  }

  @ChangeSet(order = "007", id = "007-add_zulu_8_0_252", author = "poad")
  def migrate007(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.252-zulu",
        "https://cdn.azul.com/zulu/bin/zulu8.46.0.19-ca-jdk8.0.252-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "8.0.252-zulu",
        "https://cdn.azul.com/zulu/bin/zulu8.46.0.19-ca-jdk8.0.252-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "8.0.252-zulu",
        "https://cdn.azul.com/zulu/bin/zulu8.46.0.19-ca-jdk8.0.252-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "8.0.242-zulu", platform)
    )
  }

  @ChangeSet(order = "008", id = "008-add_zulu_11_0_7", author = "poad")
  def migrate008(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.7-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.39.15-ca-jdk11.0.7-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "11.0.7-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.39.15-ca-jdk11.0.7-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "11.0.7-zulu",
        "https://cdn.azul.com/zulu/bin/zulu11.39.15-ca-jdk11.0.7-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "11.0.6-zulu", platform)
    )
  }
  @ChangeSet(order = "009", id = "009-add_zulu_7_0_262", author = "jorsol")
  def migrate009(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "7.0.262-zulu",
        "https://cdn.azul.com/zulu/bin/zulu7.38.0.11-ca-jdk7.0.262-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "7.0.262-zulu",
        "https://cdn.azul.com/zulu/bin/zulu7.38.0.11-ca-jdk7.0.262-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "7.0.262-zulu",
        "https://cdn.azul.com/zulu/bin/zulu7.38.0.11-ca-jdk7.0.262-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "7.0.242-zulu", platform)
    )
  }

  @ChangeSet(order = "010", id = "010-add_zulu_13_0_3", author = "jorsol")
  def migrate010(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "13.0.3-zulu",
        "https://cdn.azul.com/zulu/bin/zulu13.31.11-ca-jdk13.0.3-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "13.0.3-zulu",
        "https://cdn.azul.com/zulu/bin/zulu13.31.11-ca-jdk13.0.3-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "13.0.3-zulu",
        "https://cdn.azul.com/zulu/bin/zulu13.31.11-ca-jdk13.0.3-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "13.0.2-zulu", platform)
    )
  }

  @ChangeSet(order = "011", id = "011-add_zulu_14_0_1", author = "jorsol")
  def migrate011(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "14.0.1-zulu",
        "https://cdn.azul.com/zulu/bin/zulu14.28.21-ca-jdk14.0.1-linux_x64.tar.gz",
        Linux64,
        Some(Zulu)
      ),
      Version(
        "java",
        "14.0.1-zulu",
        "https://cdn.azul.com/zulu/bin/zulu14.28.21-ca-jdk14.0.1-win_x64.zip",
        Windows,
        Some(Zulu)
      ),
      Version(
        "java",
        "14.0.1-zulu",
        "https://cdn.azul.com/zulu/bin/zulu14.28.21-ca-jdk14.0.1-macosx_x64.tar.gz",
        MacOSX,
        Some(Zulu)
      )
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(
      platform =>
        removeVersion(candidate = "java", version = "14.0.0-zulu", platform)
    )
  }

  @ChangeSet(
    order = "012",
    id = "0012-add-add_zulu_11_0_8",
    author = "poad"
  )
  def migrate012(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu11.41.23-ca-jdk11.0.8-linux_x64.tar.gz"),
      MacOSX  -> ("zulu11.41.23-ca-jdk11.0.8-macosx_x64.tar.gz"),
      Windows -> ("zulu11.41.23-ca-jdk11.0.8-win_x64.zip")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.8-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "11.0.7-zulu", version.platform)
      }

  @ChangeSet(
    order = "013",
    id = "0013-add-add_zulu_8_0_262",
    author = "poad"
  )
  def migrate013(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu8.48.0.49-ca-jdk8.0.262-linux_x64.tar.gz"),
      MacOSX  -> ("zulu8.48.0.49-ca-jdk8.0.262-macosx_x64.tar.gz"),
      Windows -> ("zulu8.48.0.49-ca-jdk8.0.262-win_x64.zip")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.262-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8.0.252-zulu", version.platform)
      }

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
    order = "015",
    id = "0015-add-add_zulu_13_0_4",
    author = "poad"
  )
  def migrate015(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu13.33.25-ca-jdk13.0.4-linux_x64.tar.gz"),
      MacOSX  -> ("zulu13.33.25-ca-jdk13.0.4-macosx_x64.tar.gz"),
      Windows -> ("zulu13.33.25-ca-jdk13.0.4-win_x64.zip")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "13.0.4-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "13.0.3-zulu", version.platform)
      }
  @ChangeSet(
    order = "016",
    id = "016-remove_zulu_8_0_262-b17",
    author = "poad"
  )
  def migrate016(implicit db: MongoDatabase): Unit =
    Seq(
      Linux64,
      MacOSX,
      Windows
    ).foreach { platform =>
      removeVersion("java", "8.0.262-zulu", platform)
    }

  @ChangeSet(
    order = "017",
    id = "0017-readd_zulu_8_0_262-b19",
    author = "poad"
  )
  def migrate017(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu8.48.0.51-ca-jdk8.0.262-linux_x64.tar.gz"),
      MacOSX  -> ("zulu8.48.0.51-ca-jdk8.0.262-macosx_x64.tar.gz"),
      Windows -> ("zulu8.48.0.51-ca-jdk8.0.262-win_x64.zip")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.262-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()

}
