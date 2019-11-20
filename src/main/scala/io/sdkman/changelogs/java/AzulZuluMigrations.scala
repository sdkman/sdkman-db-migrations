package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Linux64, MacOSX, Version, Windows, Zulu, removeVersion}

@ChangeLog(order = "019")
class AzulZuluMigrations {

  @ChangeSet(order = "001", id = "001-add_zulu_7_0_242", author = "jorsol")
  def migrate001(implicit db: MongoDatabase) = {
    List(
      Version("java", "7.0.242-zulu", "https://cdn.azul.com/zulu/bin/zulu7.34.0.5-ca-jdk7.0.242-linux_x64.tar.gz", Linux64, Some(Zulu)),
      Version("java", "7.0.242-zulu", "https://cdn.azul.com/zulu/bin/zulu7.34.0.5-ca-jdk7.0.242-win_x64.zip", Windows, Some(Zulu))
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "7.0.232-zulu", platform))
  }

  @ChangeSet(order = "002", id = "002-add_zulu_8_0_232", author = "jorsol")
  def migrate002(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.232-zulu", "https://cdn.azul.com/zulu/bin/zulu8.42.0.23-ca-jdk8.0.232-linux_x64.tar.gz", Linux64, Some(Zulu)),
      Version("java", "8.0.232-zulu", "https://cdn.azul.com/zulu/bin/zulu8.42.0.23-ca-jdk8.0.232-win_x64.zip", Windows, Some(Zulu)),
      Version("java", "8.0.232-zulu", "https://cdn.azul.com/zulu/bin/zulu8.42.0.23-ca-jdk8.0.232-macosx_x64.tar.gz", MacOSX, Some(Zulu))
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "8.0.222-zulu", platform))
  }

  @ChangeSet(order = "003", id = "003-add_zulu_11_0_5", author = "jorsol")
  def migrate003(implicit db: MongoDatabase) = {
    List(
      Version("java", "11.0.5-zulu", "https://cdn.azul.com/zulu/bin/zulu11.35.15-ca-jdk11.0.5-linux_x64.tar.gz", Linux64, Some(Zulu)),
      Version("java", "11.0.5-zulu", "https://cdn.azul.com/zulu/bin/zulu11.35.15-ca-jdk11.0.5-win_x64.zip", Windows, Some(Zulu)),
      Version("java", "11.0.5-zulu", "https://cdn.azul.com/zulu/bin/zulu11.35.15-ca-jdk11.0.5-macosx_x64.tar.gz", MacOSX, Some(Zulu))
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "11.0.4-zulu", platform))
  }

  @ChangeSet(order = "004", id = "004-add_zulu_13_0_1", author = "jorsol")
  def migrate004(implicit db: MongoDatabase) = {
    List(
      Version("java", "13.0.1-zulu", "https://cdn.azul.com/zulu/bin/zulu13.28.11-ca-jdk13.0.1-linux_x64.tar.gz", Linux64, Some(Zulu)),
      Version("java", "13.0.1-zulu", "https://cdn.azul.com/zulu/bin/zulu13.28.11-ca-jdk13.0.1-win_x64.zip", Windows, Some(Zulu)),
      Version("java", "13.0.1-zulu", "https://cdn.azul.com/zulu/bin/zulu13.28.11-ca-jdk13.0.1-macosx_x64.tar.gz", MacOSX, Some(Zulu))
    ).validate().insert()
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "13.0.0-zulu", platform))
  }
}
