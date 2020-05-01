package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{
  Linux64,
  MacOSX,
  OpenJDK,
  Version,
  Windows,
  removeVersion
}

@ChangeLog(order = "022")
class OpenJdkMigrations {

  @ChangeSet(
    order = "009",
    id = "009-add_openjdk_java_15-ea-2",
    author = "eddumelendez"
  )
  def migrate009(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.2-open",
        "https://download.java.net/java/early_access/jdk15/2/GPL/openjdk-15-ea+2_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.2-open",
        "https://download.java.net/java/early_access/jdk15/2/GPL/openjdk-15-ea+2_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.2-open",
        "https://download.java.net/java/early_access/jdk15/2/GPL/openjdk-15-ea+2_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "011",
    id = "011-add_openjdk_java_15-ea-4",
    author = "eddumelendez"
  )
  def migrate011(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.4-open",
        "https://download.java.net/java/early_access/jdk15/4/GPL/openjdk-15-ea+4_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.4-open",
        "https://download.java.net/java/early_access/jdk15/4/GPL/openjdk-15-ea+4_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.4-open",
        "https://download.java.net/java/early_access/jdk15/4/GPL/openjdk-15-ea+4_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "012",
    id = "012-remove_openjdk_java_14-ea-28",
    author = "eddumelendez"
  )
  def migrate012(implicit db: MongoDatabase): Unit = {
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.ea.28-open", _)
    )
  }

  @ChangeSet(
    order = "013",
    id = "013-remove_openjdk_java_15-ea-2",
    author = "eddumelendez"
  )
  def migrate013(implicit db: MongoDatabase): Unit = {
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.2-open", _)
    )
  }

  @ChangeSet(
    order = "15",
    id = "015-add_openjdk_java_15-ea-6",
    author = "eddumelendez"
  )
  def migrate015(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.6-open",
        "https://download.java.net/java/early_access/jdk15/6/GPL/openjdk-15-ea+6_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.6-open",
        "https://download.java.net/java/early_access/jdk15/6/GPL/openjdk-15-ea+6_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.6-open",
        "https://download.java.net/java/early_access/jdk15/6/GPL/openjdk-15-ea+6_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.4-open", _)
    )
  }

  @ChangeSet(
    order = "17",
    id = "017-add_openjdk_java_15-ea-7",
    author = "eddumelendez"
  )
  def migrate017(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.7-open",
        "https://download.java.net/java/early_access/jdk15/7/GPL/openjdk-15-ea+7_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.7-open",
        "https://download.java.net/java/early_access/jdk15/7/GPL/openjdk-15-ea+7_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.7-open",
        "https://download.java.net/java/early_access/jdk15/7/GPL/openjdk-15-ea+7_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.6-open", _)
    )
  }

  @ChangeSet(order = "18", id = "018-add_openjdk_java_13.0.2", author = "poad")
  def migrate018(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "13.0.2-open",
        "https://download.java.net/java/GA/jdk13.0.2/d4173c853231432d94f001e99d882ca7/8/GPL/openjdk-13.0.2_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "13.0.2-open",
        "https://download.java.net/java/GA/jdk13.0.2/d4173c853231432d94f001e99d882ca7/8/GPL/openjdk-13.0.2_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "13.0.2-open",
        "https://download.java.net/java/GA/jdk13.0.2/d4173c853231432d94f001e99d882ca7/8/GPL/openjdk-13.0.2_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "13.0.1-open", _)
    )
  }

  @ChangeSet(
    order = "20",
    id = "020-add_openjdk_java_15-ea-8",
    author = "eddumelendez"
  )
  def migrate020(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.8-open",
        "https://download.java.net/java/early_access/jdk15/8/GPL/openjdk-15-ea+8_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.8-open",
        "https://download.java.net/java/early_access/jdk15/8/GPL/openjdk-15-ea+8_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.8-open",
        "https://download.java.net/java/early_access/jdk15/8/GPL/openjdk-15-ea+8_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.7-open", _)
    )
  }

  @ChangeSet(
    order = "021",
    id = "021-update_openjdk_8_0_242",
    author = "andrebrait"
  )
  def migrate021(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "8.0.242-open",
        "https://github.com/AdoptOpenJDK/openjdk8-upstream-binaries/releases/download/jdk8u242-b08/OpenJDK8U-jdk_x64_linux_8u242b08.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "8.0.242-open",
        "https://github.com/AdoptOpenJDK/openjdk8-upstream-binaries/releases/download/jdk8u242-b08/OpenJDK8U-jdk_x64_windows_8u242b08.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, Windows).foreach(
      platform => removeVersion("java", "8.0.232-open", platform)
    )
  }

  @ChangeSet(
    order = "022",
    id = "022-update_openjdk_11_0_6",
    author = "andrebrait"
  )
  def migrate022(implicit db: MongoDatabase) = {
    List(
      Version(
        "java",
        "11.0.6-open",
        "https://github.com/AdoptOpenJDK/openjdk11-upstream-binaries/releases/download/jdk-11.0.6+10/OpenJDK11U-jdk_x64_linux_11.0.6_10.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "11.0.6-open",
        "https://github.com/AdoptOpenJDK/openjdk11-upstream-binaries/releases/download/jdk-11.0.6+10/OpenJDK11U-jdk_x64_windows_11.0.6_10.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, Windows).foreach(
      platform => removeVersion("java", "11.0.5-open", platform)
    )
  }

  @ChangeSet(
    order = "023",
    id = "023-add_openjdk_java_14-ea-35",
    author = "eddumelendez"
  )
  def migrate023(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "14.ea.35-open",
        "https://download.java.net/java/GA/jdk14/076bab302c7b4508975440c56f6cc26a/35/GPL/openjdk-14_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.35-open",
        "https://download.java.net/java/GA/jdk14/076bab302c7b4508975440c56f6cc26a/35/GPL/openjdk-14_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.35-open",
        "https://download.java.net/java/GA/jdk14/076bab302c7b4508975440c56f6cc26a/35/GPL/openjdk-14_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.ea.34-open", _)
    )
  }

  @ChangeSet(
    order = "24",
    id = "024-add_openjdk_java_15-ea-9",
    author = "eddumelendez"
  )
  def migrate024(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.9-open",
        "https://download.java.net/java/early_access/jdk15/9/GPL/openjdk-15-ea+9_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.9-open",
        "https://download.java.net/java/early_access/jdk15/9/GPL/openjdk-15-ea+9_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.9-open",
        "https://download.java.net/java/early_access/jdk15/9/GPL/openjdk-15-ea+9_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.8-open", _)
    )
  }

  @ChangeSet(
    order = "025",
    id = "025-add_openjdk_java_14-ea-36",
    author = "eddumelendez"
  )
  def migrate025(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "14.ea.36-open",
        "https://download.java.net/java/GA/jdk14/076bab302c7b4508975440c56f6cc26a/36/GPL/openjdk-14_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.36-open",
        "https://download.java.net/java/GA/jdk14/076bab302c7b4508975440c56f6cc26a/36/GPL/openjdk-14_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.36-open",
        "https://download.java.net/java/GA/jdk14/076bab302c7b4508975440c56f6cc26a/36/GPL/openjdk-14_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.ea.35-open", _)
    )
  }

  @ChangeSet(
    order = "26",
    id = "026-add_openjdk_java_15-ea-10",
    author = "eddumelendez"
  )
  def migrate026(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.10-open",
        "https://download.java.net/java/early_access/jdk15/10/GPL/openjdk-15-ea+10_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.10-open",
        "https://download.java.net/java/early_access/jdk15/10/GPL/openjdk-15-ea+10_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.10-open",
        "https://download.java.net/java/early_access/jdk15/10/GPL/openjdk-15-ea+10_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.9-open", _)
    )
  }

  @ChangeSet(
    order = "27",
    id = "027-add_openjdk_java_15-ea-11",
    author = "eddumelendez"
  )
  def migrate027(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.11-open",
        "https://download.java.net/java/early_access/jdk15/11/GPL/openjdk-15-ea+11_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.11-open",
        "https://download.java.net/java/early_access/jdk15/11/GPL/openjdk-15-ea+11_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.11-open",
        "https://download.java.net/java/early_access/jdk15/11/GPL/openjdk-15-ea+11_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.10-open", _)
    )
  }

  @ChangeSet(
    order = "28",
    id = "028-add_openjdk_java_15-ea-12",
    author = "eddumelendez"
  )
  def migrate028(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.12-open",
        "https://download.java.net/java/early_access/jdk15/12/GPL/openjdk-15-ea+12_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.12-open",
        "https://download.java.net/java/early_access/jdk15/12/GPL/openjdk-15-ea+12_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.12-open",
        "https://download.java.net/java/early_access/jdk15/12/GPL/openjdk-15-ea+12_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.10-open", _)
    )
  }

  @ChangeSet(
    order = "029",
    id = "029-remove_openjdk_java_15-ea-11",
    author = "eddumelendez"
  )
  def migrate029(implicit db: MongoDatabase): Unit = {
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.11-open", _)
    )
  }

  @ChangeSet(
    order = "030",
    id = "030-add_openjdk_java_15-ea-13",
    author = "eddumelendez"
  )
  def migrate030(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.13-open",
        "https://download.java.net/java/early_access/jdk15/13/GPL/openjdk-15-ea+13_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.13-open",
        "https://download.java.net/java/early_access/jdk15/13/GPL/openjdk-15-ea+13_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.13-open",
        "https://download.java.net/java/early_access/jdk15/13/GPL/openjdk-15-ea+13_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.12-open", _)
    )
  }

  @ChangeSet(
    order = "031",
    id = "031-add_openjdk_java_15-ea-14",
    author = "eddumelendez"
  )
  def migrate031(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.14-open",
        "https://download.java.net/java/early_access/jdk15/14/GPL/openjdk-15-ea+14_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.14-open",
        "https://download.java.net/java/early_access/jdk15/14/GPL/openjdk-15-ea+14_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.14-open",
        "https://download.java.net/java/early_access/jdk15/14/GPL/openjdk-15-ea+14_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.13-open", _)
    )
  }

  @ChangeSet(
    order = "032",
    id = "032-add_openjdk_java_14.0.0",
    author = "eddumelendez"
  )
  def migrate032(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "14.0.0-open",
        "https://download.java.net/java/GA/jdk14/076bab302c7b4508975440c56f6cc26a/36/GPL/openjdk-14_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.0.0-open",
        "https://download.java.net/java/GA/jdk14/076bab302c7b4508975440c56f6cc26a/36/GPL/openjdk-14_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.0.0-open",
        "https://download.java.net/java/GA/jdk14/076bab302c7b4508975440c56f6cc26a/36/GPL/openjdk-14_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.ea.36-open", _)
    )
  }
  @ChangeSet(
    order = "033",
    id = "033-retry-add_openjdk_java_13.0.2",
    author = "poad, kishida"
  )
  def migrate033(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "13.0.2-open",
        "https://download.java.net/java/GA/jdk13.0.2/d4173c853231432d94f001e99d882ca7/8/GPL/openjdk-13.0.2_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "13.0.2-open",
        "https://download.java.net/java/GA/jdk13.0.2/d4173c853231432d94f001e99d882ca7/8/GPL/openjdk-13.0.2_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "13.0.2-open",
        "https://download.java.net/java/GA/jdk13.0.2/d4173c853231432d94f001e99d882ca7/8/GPL/openjdk-13.0.2_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "034",
    id = "034-add_openjdk_java_15-ea-15",
    author = "eddumelendez"
  )
  def migrate034(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.15-open",
        "https://download.java.net/java/early_access/jdk15/15/GPL/openjdk-15-ea+15_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.15-open",
        "https://download.java.net/java/early_access/jdk15/15/GPL/openjdk-15-ea+15_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.15-open",
        "https://download.java.net/java/early_access/jdk15/15/GPL/openjdk-15-ea+15_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.14-open", _)
    )
  }

  @ChangeSet(
    order = "035",
    id = "035-add_openjdk_java_15-ea-17",
    author = "eddumelendez"
  )
  def migrate035(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.17-open",
        "https://download.java.net/java/early_access/jdk15/17/GPL/openjdk-15-ea+17_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.17-open",
        "https://download.java.net/java/early_access/jdk15/17/GPL/openjdk-15-ea+17_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.17-open",
        "https://download.java.net/java/early_access/jdk15/17/GPL/openjdk-15-ea+17_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.15-open", _)
    )
  }

  @ChangeSet(
    order = "036",
    id = "036-add_openjdk_java_15-ea-18",
    author = "eddumelendez"
  )
  def migrate036(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.18-open",
        "https://download.java.net/java/early_access/jdk15/18/GPL/openjdk-15-ea+18_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.18-open",
        "https://download.java.net/java/early_access/jdk15/18/GPL/openjdk-15-ea+18_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.18-open",
        "https://download.java.net/java/early_access/jdk15/18/GPL/openjdk-15-ea+18_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.17-open", _)
    )
  }

  @ChangeSet(
    order = "037",
    id = "037-add_openjdk_java_14.0.1",
    author = "eddumelendez"
  )
  def migrate037(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "14.0.1-open",
        "https://download.java.net/java/GA/jdk14.0.1/664493ef4a6946b186ff29eb326336a2/7/GPL/openjdk-14.0.1_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.0.1-open",
        "https://download.java.net/java/GA/jdk14.0.1/664493ef4a6946b186ff29eb326336a2/7/GPL/openjdk-14.0.1_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.0.1-open",
        "https://download.java.net/java/GA/jdk14.0.1/664493ef4a6946b186ff29eb326336a2/7/GPL/openjdk-14.0.1_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.0.0-open", _)
    )
  }

  @ChangeSet(
    order = "038",
    id = "038-add_openjdk_java_15-ea-19",
    author = "eddumelendez"
  )
  def migrate038(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.19-open",
        "https://download.java.net/java/early_access/jdk15/19/GPL/openjdk-15-ea+19_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.19-open",
        "https://download.java.net/java/early_access/jdk15/19/GPL/openjdk-15-ea+19_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.19-open",
        "https://download.java.net/java/early_access/jdk15/19/GPL/openjdk-15-ea+19_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.18-open", _)
    )
  }

  @ChangeSet(
    order = "039",
    id = "039-add_openjdk_java_15-ea-20",
    author = "eddumelendez"
  )
  def migrate039(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.20-open",
        "https://download.java.net/java/early_access/jdk15/20/GPL/openjdk-15-ea+20_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.20-open",
        "https://download.java.net/java/early_access/jdk15/20/GPL/openjdk-15-ea+20_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.20-open",
        "https://download.java.net/java/early_access/jdk15/20/GPL/openjdk-15-ea+20_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.19-open", _)
    )
  }

  @ChangeSet(
    order = "040",
    id = "040-update_openjdk_8_0_252",
    author = "andrebrait"
  )
  def migrate040(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "8.0.252-open",
        "https://github.com/AdoptOpenJDK/openjdk8-upstream-binaries/releases/download/jdk8u252-b09/OpenJDK8U-jdk_x64_linux_8u252b09.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "8.0.252-open",
        "https://github.com/AdoptOpenJDK/openjdk8-upstream-binaries/releases/download/jdk8u252-b09/OpenJDK8U-jdk_x64_windows_8u252b09.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, Windows).foreach(
      platform => removeVersion("java", "8.0.242-open", platform)
    )
  }

  @ChangeSet(
    order = "041",
    id = "041-update_openjdk_11_0_7",
    author = "andrebrait"
  )
  def migrate041(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "11.0.7-open",
        "https://github.com/AdoptOpenJDK/openjdk11-upstream-binaries/releases/download/jdk-11.0.7+10/OpenJDK11U-jdk_x64_linux_11.0.7_10.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "11.0.7-open",
        "https://github.com/AdoptOpenJDK/openjdk11-upstream-binaries/releases/download/jdk-11.0.7+10/OpenJDK11U-jdk_x64_windows_11.0.7_10.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, Windows).foreach(
      platform => removeVersion("java", "11.0.6-open", platform)
    )
  }

  @ChangeSet(
    order = "042",
    id = "042-add_openjdk_java_15-ea-21",
    author = "eddumelendez"
  )
  def migrate042(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "15.ea.21-open",
        "https://download.java.net/java/early_access/jdk15/21/GPL/openjdk-15-ea+21_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.21-open",
        "https://download.java.net/java/early_access/jdk15/21/GPL/openjdk-15-ea+21_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "15.ea.21-open",
        "https://download.java.net/java/early_access/jdk15/21/GPL/openjdk-15-ea+21_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "15.ea.20-open", _)
    )
  }
}
