package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Amazon, Linux64, MacOSX, Version, Windows, _}

@ChangeLog(order = "017")
class AmazonCorrettoMigrations {
  @ChangeSet(
    order = "0001",
    id = "0001-add_corretto_java8_update_242",
    author = "poad"
  )
  def migrate0001(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.242-amzn",
        "https://corretto.aws/downloads/resources/8.242.07.1/amazon-corretto-8.242.07.1-linux-x64.tar.gz",
        Linux64,
        Some(Amazon)
      ),
      Version(
        "java",
        "8.0.242-amzn",
        "https://corretto.aws/downloads/resources/8.242.07.1/amazon-corretto-8.242.07.1-macosx-x64.tar.gz",
        MacOSX,
        Some(Amazon)
      ),
      Version(
        "java",
        "8.0.242-amzn",
        "https://corretto.aws/downloads/resources/8.242.07.1/amazon-corretto-8.242.07.1-windows-x64-jdk.zip",
        Windows,
        Some(Amazon)
      )
    ).validate().insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      platform =>
        removeVersion(candidate = "java", version = "8.0.232-amzn", platform)
    )
  }

  @ChangeSet(
    order = "0002",
    id = "0002-add_corretto_java11_update_6",
    author = "poad"
  )
  def migrate0002(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.6-amzn",
        "https://corretto.aws/downloads/resources/11.0.6.10.1/amazon-corretto-11.0.6.10.1-linux-x64.tar.gz",
        Linux64,
        Some(Amazon)
      ),
      Version(
        "java",
        "11.0.6-amzn",
        "https://corretto.aws/downloads/resources/11.0.6.10.1/amazon-corretto-11.0.6.10.1-macosx-x64.tar.gz",
        MacOSX,
        Some(Amazon)
      ),
      Version(
        "java",
        "11.0.6-amzn",
        "https://corretto.aws/downloads/resources/11.0.6.10.1/amazon-corretto-11.0.6.10.1-windows-x64-jdk.zip",
        Windows,
        Some(Amazon)
      )
    ).validate().insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      platform =>
        removeVersion(candidate = "java", version = "11.0.5-amzn", platform)
    )
  }
  
  @ChangeSet(
    order = "0003",
    id = "0003-add_corretto_java11_update_6_hotfix",
    author = "dr29bart"
  )
  def migrate0003(implicit db: MongoDatabase) = {
    Seq(MacOSX, Windows).foreach(
      platform =>
        removeVersion(candidate = "java", version = "11.0.6-amzn", platform)
    )
    List(
      Version(
        "java",
        "11.0.6-amzn",
        "https://corretto.aws/downloads/resources/11.0.6.10.1/amazon-corretto-11.0.6.10.1-2-macosx-x64.tar.gz",
        MacOSX,
        Some(Amazon)
      ),
      Version(
        "java",
        "11.0.6-amzn",
        "https://corretto.aws/downloads/resources/11.0.6.10.1/amazon-corretto-11.0.6.10.1-1-windows-x64-jdk.zip",
        Windows,
        Some(Amazon)
      )
    ).validate().insert()
  }
}
