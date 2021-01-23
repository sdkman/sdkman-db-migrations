package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{
  Linux64,
  MacOSX,
  Version,
  Windows,
  Zulu,
  hideVersion,
  removeVersion
}

@ChangeLog(order = "018")
class AzulZuluFxMigrations {

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
  @ChangeSet(
    order = "0017",
    id = "0017-add_zulufx_14.0.2",
    author = "helpermethod"
  )
  def migrate0017(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu14.29.23-ca-fx-jdk14.0.2-linux_x64.tar.gz"),
      MacOSX  -> ("zulu14.29.23-ca-fx-jdk14.0.2-macosx_x64.tar.gz"),
      Windows -> ("zulu14.29.23-ca-fx-jdk14.0.2-win_x64.tar.gz")
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

  @ChangeSet(order = "0018", id = "0018-add_zulufx_8.0.272", author = "poad")
  def migrate0018(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu8.50.0.21-ca-fx-jdk8.0.272-linux_x64.tar.gz"),
      Windows -> ("zulu8.50.0.21-ca-fx-jdk8.0.272-win_x64.zip"),
      MacOSX  -> ("zulu8.50.0.21-ca-fx-jdk8.0.272-macosx_x64.zip")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8.0.272.fx-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "8.0.265.fx-zulu", version.platform)
      }
  @ChangeSet(order = "0019", id = "0019-15.0.1", author = "poad")
  def migrate0019(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu15.28.13-ca-fx-jdk15.0.1-linux_x64.tar.gz"),
      Windows -> ("zulu15.28.13-ca-fx-jdk15.0.1-win_x64.zip"),
      MacOSX  -> ("zulu15.28.13-ca-fx-jdk15.0.1-macosx_x64.tar.gz")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "15.0.1.fx-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "15.0.0.fx-zulu", version.platform)
      }
  @ChangeSet(order = "0020", id = "0020-add_zulufx_13.0.5", author = "poad")
  def migrate0020(implicit db: MongoDatabase) = {
    Map(
      Linux64 -> ("zulu13.35.17-ca-fx-jdk13.0.5-linux_x64.tar.gz"),
      Windows -> ("zulu13.35.17-ca-fx-jdk13.0.5-win_x64.zip"),
      MacOSX  -> ("zulu13.35.17-ca-fx-jdk13.0.5-macosx_x64.zip")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "13.0.5.fx-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "13.0.4.fx-zulu", version.platform)
      }
  }
  @ChangeSet(order = "0021", id = "0021-add_zulufx_11.0.9", author = "poad")
  def migrate0021(implicit db: MongoDatabase) =
    Map(
      Linux64 -> ("zulu11.43.21-ca-fx-jdk11.0.9-linux_x64.tar.gz"),
      Windows -> ("zulu11.43.21-ca-fx-jdk11.0.9-win_x64.zip"),
      MacOSX  -> ("zulu11.43.21-ca-fx-jdk11.0.9-macosx_x64.zip")
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.9.fx-zulu",
            s"https://cdn.azul.com/zulu/bin/$binary",
            platform,
            Some(Zulu)
          )
      }
      .toList
      .validate()
      .insert()
      .foreach { version =>
        removeVersion("java", "11.0.8.fx-zulu", version.platform)
      }

  @ChangeSet(
    order = "022",
    id = "022-hide-java-versions",
    author = "eddumelendez"
  )
  def migrate022(implicit db: MongoDatabase): Unit =
    hideVersion("java", "8.0.272.fx-zulu")

  @ChangeSet(
    order = "023",
    id = "023-hide-java-versions",
    author = "eddumelendez"
  )
  def migrate023(implicit db: MongoDatabase): Unit =
    Seq(
      "8.0.275.fx-zulu",
      "13.0.5.fx-zulu",
      "14.0.2.fx-zulu"
    ).foreach(version => hideVersion("java", version))
}
