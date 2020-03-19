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
    order = "002",
    id = "002-add_openjdk_java_14-ea-22",
    author = "eddumelendez"
  )
  def migrate002(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "14.ea.22-open",
        "https://download.java.net/java/early_access/jdk14/22/GPL/openjdk-14-ea+22_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.22-open",
        "https://download.java.net/java/early_access/jdk14/22/GPL/openjdk-14-ea+22_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.22-open",
        "https://download.java.net/java/early_access/jdk14/22/GPL/openjdk-14-ea+22_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.ea.20-open", _)
    )
  }

  @ChangeSet(
    order = "003",
    id = "003-add_openjdk_java_14-ea-23",
    author = "eddumelendez"
  )
  def migrate003(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "14.ea.23-open",
        "https://download.java.net/java/early_access/jdk14/23/GPL/openjdk-14-ea+23_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.23-open",
        "https://download.java.net/java/early_access/jdk14/23/GPL/openjdk-14-ea+23_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.23-open",
        "https://download.java.net/java/early_access/jdk14/23/GPL/openjdk-14-ea+23_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.ea.22-open", _)
    )
  }

  @ChangeSet(
    order = "004",
    id = "004-add_openjdk_java_14-ea-24",
    author = "eddumelendez"
  )
  def migrate004(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "14.ea.24-open",
        "https://download.java.net/java/early_access/jdk14/24/GPL/openjdk-14-ea+24_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.24-open",
        "https://download.java.net/java/early_access/jdk14/24/GPL/openjdk-14-ea+24_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.24-open",
        "https://download.java.net/java/early_access/jdk14/24/GPL/openjdk-14-ea+24_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.ea.23-open", _)
    )
  }

  @ChangeSet(
    order = "005",
    id = "005-add_openjdk_java_14-ea-25",
    author = "eddumelendez"
  )
  def migrate005(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "14.ea.25-open",
        "https://download.java.net/java/early_access/jdk14/25/GPL/openjdk-14-ea+25_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.25-open",
        "https://download.java.net/java/early_access/jdk14/25/GPL/openjdk-14-ea+25_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.25-open",
        "https://download.java.net/java/early_access/jdk14/25/GPL/openjdk-14-ea+25_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.ea.24-open", _)
    )
  }

  @ChangeSet(
    order = "006",
    id = "006-add_openjdk_java_14-ea-26",
    author = "eddumelendez"
  )
  def migrate006(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "14.ea.26-open",
        "https://download.java.net/java/early_access/jdk14/26/GPL/openjdk-14-ea+26_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.26-open",
        "https://download.java.net/java/early_access/jdk14/26/GPL/openjdk-14-ea+26_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.26-open",
        "https://download.java.net/java/early_access/jdk14/26/GPL/openjdk-14-ea+26_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.ea.25-open", _)
    )
  }

  @ChangeSet(
    order = "007",
    id = "007-add_openjdk_java_14-ea-27",
    author = "eddumelendez"
  )
  def migrate007(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "14.ea.27-open",
        "https://download.java.net/java/early_access/jdk14/27/GPL/openjdk-14-ea+27_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.27-open",
        "https://download.java.net/java/early_access/jdk14/27/GPL/openjdk-14-ea+27_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.27-open",
        "https://download.java.net/java/early_access/jdk14/27/GPL/openjdk-14-ea+27_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.ea.26-open", _)
    )
  }

  @ChangeSet(
    order = "008",
    id = "008-add_openjdk_java_14-ea-28",
    author = "eddumelendez"
  )
  def migrate008(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "14.ea.28-open",
        "https://download.java.net/java/early_access/jdk14/28/GPL/openjdk-14-ea+28_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.28-open",
        "https://download.java.net/java/early_access/jdk14/28/GPL/openjdk-14-ea+28_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.28-open",
        "https://download.java.net/java/early_access/jdk14/28/GPL/openjdk-14-ea+28_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.ea.27-open", _)
    )
  }

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
    order = "010",
    id = "010-add_openjdk_java_14-ea-30",
    author = "eddumelendez"
  )
  def migrate010(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "14.ea.30-open",
        "https://download.java.net/java/early_access/jdk14/30/GPL/openjdk-14-ea+30_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.30-open",
        "https://download.java.net/java/early_access/jdk14/30/GPL/openjdk-14-ea+30_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.30-open",
        "https://download.java.net/java/early_access/jdk14/30/GPL/openjdk-14-ea+30_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.ea.27-open", _)
    )
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
    order = "014",
    id = "014-add_openjdk_java_14-ea-32",
    author = "eddumelendez"
  )
  def migrate014(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "14.ea.32-open",
        "https://download.java.net/java/early_access/jdk14/32/GPL/openjdk-14-ea+32_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.32-open",
        "https://download.java.net/java/early_access/jdk14/32/GPL/openjdk-14-ea+32_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.32-open",
        "https://download.java.net/java/early_access/jdk14/32/GPL/openjdk-14-ea+32_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.ea.30-open", _)
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
    order = "016",
    id = "016-add_openjdk_java_14-ea-33",
    author = "eddumelendez"
  )
  def migrate016(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "14.ea.33-open",
        "https://download.java.net/java/early_access/jdk14/33/GPL/openjdk-14-ea+33_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.33-open",
        "https://download.java.net/java/early_access/jdk14/33/GPL/openjdk-14-ea+33_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.33-open",
        "https://download.java.net/java/early_access/jdk14/33/GPL/openjdk-14-ea+33_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.ea.32-open", _)
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
    order = "019",
    id = "019-add_openjdk_java_14-ea-34",
    author = "eddumelendez"
  )
  def migrate019(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "14.ea.34-open",
        "https://download.java.net/java/early_access/jdk14/34/GPL/openjdk-14-ea+34_linux-x64_bin.tar.gz",
        Linux64,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.34-open",
        "https://download.java.net/java/early_access/jdk14/34/GPL/openjdk-14-ea+34_osx-x64_bin.tar.gz",
        MacOSX,
        Some(OpenJDK)
      ),
      Version(
        "java",
        "14.ea.34-open",
        "https://download.java.net/java/early_access/jdk14/34/GPL/openjdk-14-ea+34_windows-x64_bin.zip",
        Windows,
        Some(OpenJDK)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      removeVersion("java", "14.ea.33-open", _)
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
}
