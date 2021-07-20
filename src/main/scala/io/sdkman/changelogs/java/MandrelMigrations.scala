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
    order = "001",
    id = "001-add_mandrel_20_1_0_1",
    author = "AlexKovynev"
  )
  def migrate001(implicit db: MongoDatabase): Unit =
    List(
      Version(
        candidate = "java",
        version = "20.1.0.1-mandrel",
        url =
          "https://github.com/graalvm/mandrel/releases/download/mandrel-20.1.0.1.Final/mandrel-java11-linux-amd64-20.1.0.1.Final.tar.gz",
        platform = Linux64,
        vendor = Some(Mandrel)
      )
    ).validate()
      .insert()

  @ChangeSet(
    order = "002",
    id = "002-add_mandrel_20_2_0_0",
    author = "poad"
  )
  def migrate002(implicit db: MongoDatabase): Unit =
    List(
      Version(
        candidate = "java",
        version = "20.2.0.0-mandrel",
        url =
          "https://github.com/graalvm/mandrel/releases/download/mandrel-20.2.0.0.Final/mandrel-java11-linux-amd64-20.2.0.0.Final.tar.gz",
        platform = Linux64,
        vendor = Some(Mandrel)
      )
    ).validate()
      .insert()

  @ChangeSet(
    order = "003",
    id = "003-add_mandrel_20_1_0_3",
    author = "zakkak"
  )
  def migrate003(implicit db: MongoDatabase): Unit =
    List(
      Version(
        candidate = "java",
        version = "20.1.0.3-mandrel",
        url =
          "https://github.com/graalvm/mandrel/releases/download/mandrel-20.1.0.3.Final/mandrel-java11-linux-amd64-20.1.0.3.Final.tar.gz",
        platform = Linux64,
        vendor = Some(Mandrel)
      )
    ).validate()
      .insert()

  @ChangeSet(
    order = "004",
    id = "004-add_mandrel-20_1_0_4-20_3_1_2-21_0_0_0",
    author = "zakkak"
  )
  def migrate004(implicit db: MongoDatabase): Unit =
    Map(
      "20.1.0.4" -> List((Linux64, "linux-amd64", "tar.gz")),
      "20.3.1.2" -> List(
        (Linux64, "linux-amd64", "tar.gz"),
        (Windows, "windows-amd64", "zip")
      ),
      "21.0.0.0" -> List(
        (Linux64, "linux-amd64", "tar.gz"),
        (Windows, "windows-amd64", "zip")
      )
    ).flatMap {
        case (version, platforms) =>
          platforms.map {
            case (platform, mandrelPlatform, suffix) =>
              Version(
                candidate = "java",
                version = s"$version-mandrel",
                url =
                  s"https://github.com/graalvm/mandrel/releases/download/mandrel-$version.Final/mandrel-java11-$mandrelPlatform-$version.Final.$suffix",
                platform = platform,
                vendor = Some(Mandrel)
              )
          }
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "005",
    id = "005-replace_mandrel-20_3_1_2-21_0_0_0-rm_mandrel-20_2_0_0-20_1_0_3",
    author = "zakkak"
  )
  def migrate005(implicit db: MongoDatabase): Unit = {
    hideVersion("java", "20.2.0.0-mandrel")
    hideVersion("java", "20.1.0.3-mandrel")
    removeVersion("java", "20.3.1.2-mandrel", Linux64)
    removeVersion("java", "20.3.1.2-mandrel", Windows)
    removeVersion("java", "21.0.0.0-mandrel", Linux64)
    removeVersion("java", "21.0.0.0-mandrel", Windows)
    Map(
      "20.3.1.2" -> List(
        (Linux64, "linux-amd64", "tar.gz"),
        (Windows, "windows-amd64", "zip")
      ),
      "21.0.0.0" -> List(
        (Linux64, "linux-amd64", "tar.gz"),
        (Windows, "windows-amd64", "zip")
      )
    ).flatMap {
        case (version, platforms) =>
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
      .toList
      .validate()
      .insert()
  }

  @ChangeSet(
    order = "006",
    id = "006-hide_mandrel-20_3_1_2-21_0_0_0-add_mandrel-20_3_2_0-21_1_0_0",
    author = "zakkak"
  )
  def migrate006(implicit db: MongoDatabase): Unit = {
    hideVersion("java", "20.3.1.2-mandrel")
    hideVersion("java", "21.0.0.0-mandrel")
    var platforms = List(
      (Linux64, "linux-amd64", "tar.gz"),
      (Windows, "windows-amd64", "zip")
    )
    var versions = List("20.3.2.0", "21.1.0.0")
    versions
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

  @ChangeSet(
    order = "007",
    id = "007-hide_mandrel-20_3_2_0-21_1_0_0-add_mandrel-20_3_3_0-21_2_0_0",
    author = "zakkak"
  )
  def migrate007(implicit db: MongoDatabase): Unit = {
    hideVersion("java", "20.3.2.0-mandrel")
    hideVersion("java", "21.1.0.0-mandrel")
    var platforms = List(
      (Linux64, "linux-amd64", "tar.gz"),
      (Windows, "windows-amd64", "zip")
    )
    var versions = List("20.3.3.0", "21.2.0.0")
    versions
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
