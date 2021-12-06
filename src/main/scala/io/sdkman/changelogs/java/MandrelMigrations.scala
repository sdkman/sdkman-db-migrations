package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{
  Linux64,
  Windows,
  Mandrel,
  Version,
  removeVersion,
  hideVersion
}

@ChangeLog(order = "035")
class MandrelMigrations {

  @ChangeSet(
    order = "007",
    id = "007-hide_mandrel-20_3_2_0-21_1_0_0-add_mandrel-20_3_3_0-21_2_0_0",
    author = "zakkak"
  )
  def migrate007(implicit db: MongoDatabase): Unit = {
    hideVersion("java", "20.3.2.0-mandrel")
    hideVersion("java", "21.1.0.0-mandrel")
    val platforms = List(
      (Linux64, "linux-amd64", "tar.gz"),
      (Windows, "windows-amd64", "zip")
    )
    List("20.3.3.0", "21.2.0.0")
      .map { version =>
        platforms.map {
          case (platform, mandrelPlatform, suffix) =>
            Version(
              candidate = "java",
              version = s"$version-mandrel",
              url =
                s"https://github.com/graalvm/mandrel/releases/download/mandrel-$version-Final/mandrel-java11-$mandrelPlatform-$version-Final.$suffix",
              platform = platform,
              vendor = Some(Mandrel)
            )
        }
      }
      .validate()
      .insert()
  }

}
