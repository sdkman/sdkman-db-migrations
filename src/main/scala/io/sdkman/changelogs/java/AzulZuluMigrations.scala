package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Linux64, MacOSX, Version, Windows, Zulu, removeVersion}

@ChangeLog(order = "019")
class AzulZuluMigrations {

  @ChangeSet(order = "001", id = "001-add_zulu_8_0_242", author = "dimitryc")
  def migrate001(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "8.0.242-zulu", platform))
    List(
      Version("java", "8.0.242-zulu", "https://cdn.azul.com/zulu/bin/zulu8.44.0.9-ca-jdk8.0.242-linux_x64.tar.gz", Linux64, Some(Zulu)),
      Version("java", "8.0.242-zulu", "https://cdn.azul.com/zulu/bin/zulu8.44.0.9-ca-jdk8.0.242-win_x64.zip", Windows, Some(Zulu)),
      Version("java", "8.0.242-zulu", "https://cdn.azul.com/zulu/bin/zulu8.44.0.9-ca-jdk8.0.242-macosx_x64.tar.gz", MacOSX, Some(Zulu))
    ).validate().insert()
  }

  @ChangeSet(order = "002", id = "002-add_zulu_11_0_6", author = "dimitryc")
  def migrate002(implicit db: MongoDatabase) = {
    Seq(Linux64, Windows, MacOSX).foreach(platform => removeVersion(candidate = "java", version = "11.0.6-zulu", platform))
    List(
      Version("java", "11.0.6-zulu", "https://cdn.azul.com/zulu/bin/zulu11.37.17-ca-jdk11.0.6-linux_x64.tar.gz", Linux64, Some(Zulu)),
      Version("java", "11.0.6-zulu", "https://cdn.azul.com/zulu/bin/zulu11.37.17-ca-jdk11.0.6-win_x64.zip", Windows, Some(Zulu)),
      Version("java", "11.0.6-zulu", "https://cdn.azul.com/zulu/bin/zulu11.37.17-ca-jdk11.0.6-macosx_x64.tar.gz", MacOSX, Some(Zulu))
    ).validate().insert()
  }
}
