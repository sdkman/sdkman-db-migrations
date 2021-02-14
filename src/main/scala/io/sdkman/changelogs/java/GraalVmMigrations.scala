package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{
  Graal,
  Linux64,
  LinuxARM64,
  MacOSX,
  Version,
  Windows,
  hideVersion,
  removeVersion
}

@ChangeLog(order = "021")
class GraalVmMigrations {

  @ChangeSet(
    order = "001",
    id = "001-add_graalvm_19_3_0",
    author = "eddumelendez"
  )
  def migrate001(implicit db: MongoDatabase) =
    List(
      Version(
        candidate = "java",
        version = "19.3.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0/graalvm-ce-java11-linux-amd64-19.3.0.tar.gz",
        platform = Linux64,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "19.3.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0/graalvm-ce-java11-darwin-amd64-19.3.0.tar.gz",
        platform = MacOSX,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "19.3.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0/graalvm-ce-java11-windows-amd64-19.3.0.zip",
        platform = Windows,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "19.3.0.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0/graalvm-ce-java8-linux-amd64-19.3.0.tar.gz",
        platform = Linux64,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "19.3.0.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0/graalvm-ce-java8-darwin-amd64-19.3.0.tar.gz",
        platform = MacOSX,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "19.3.0.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0/graalvm-ce-java8-windows-amd64-19.3.0.zip",
        platform = Windows,
        vendor = Some(Graal)
      )
    ).validate()
      .insert()

  @ChangeSet(
    order = "002",
    id = "002-add_graalvm_19_3_0_2",
    author = "eddumelendez"
  )
  def migrate002(implicit db: MongoDatabase) =
    List(
      Version(
        candidate = "java",
        version = "19.3.0.2.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0.2/graalvm-ce-java11-linux-amd64-19.3.0.2.tar.gz",
        platform = Linux64,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "19.3.0.2.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0.2/graalvm-ce-java11-darwin-amd64-19.3.0.2.tar.gz",
        platform = MacOSX,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "19.3.0.2.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0.2/graalvm-ce-java11-windows-amd64-19.3.0.2.zip",
        platform = Windows,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "19.3.0.2.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0.2/graalvm-ce-java8-linux-amd64-19.3.0.2.tar.gz",
        platform = Linux64,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "19.3.0.2.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0.2/graalvm-ce-java8-darwin-amd64-19.3.0.2.tar.gz",
        platform = MacOSX,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "19.3.0.2.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0.2/graalvm-ce-java8-windows-amd64-19.3.0.2.zip",
        platform = Windows,
        vendor = Some(Graal)
      )
    ).validate()
      .insert()

  @ChangeSet(order = "003", id = "003-add_graalvm_19_3_1", author = "ilopmar")
  def migrate003(implicit db: MongoDatabase) =
    List(
      Version(
        candidate = "java",
        version = "19.3.1.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.1/graalvm-ce-java11-linux-amd64-19.3.1.tar.gz",
        platform = Linux64,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "19.3.1.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.1/graalvm-ce-java11-darwin-amd64-19.3.1.tar.gz",
        platform = MacOSX,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "19.3.1.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.1/graalvm-ce-java11-windows-amd64-19.3.1.zip",
        platform = Windows,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "19.3.1.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.1/graalvm-ce-java8-linux-amd64-19.3.1.tar.gz",
        platform = Linux64,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "19.3.1.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.1/graalvm-ce-java8-darwin-amd64-19.3.1.tar.gz",
        platform = MacOSX,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "19.3.1.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.1/graalvm-ce-java8-windows-amd64-19.3.1.zip",
        platform = Windows,
        vendor = Some(Graal)
      )
    ).validate()
      .insert()

  @ChangeSet(
    order = "004",
    id = "004-add_graalvm_20_0_0",
    author = "eddumelendez"
  )
  def migrate004(implicit db: MongoDatabase) =
    List(
      Version(
        candidate = "java",
        version = "20.0.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.0.0/graalvm-ce-java11-linux-amd64-20.0.0.tar.gz",
        platform = Linux64,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.0.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.0.0/graalvm-ce-java11-darwin-amd64-20.0.0.tar.gz",
        platform = MacOSX,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.0.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.0.0/graalvm-ce-java11-windows-amd64-20.0.0.zip",
        platform = Windows,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.0.0.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.0.0/graalvm-ce-java8-linux-amd64-20.0.0.tar.gz",
        platform = Linux64,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.0.0.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.0.0/graalvm-ce-java8-darwin-amd64-20.0.0.tar.gz",
        platform = MacOSX,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.0.0.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.0.0/graalvm-ce-java8-windows-amd64-20.0.0.zip",
        platform = Windows,
        vendor = Some(Graal)
      )
    ).validate()
      .insert()

  @ChangeSet(
    order = "005",
    id = "05-add_graalvm_20_1_0",
    author = "eddumelendez"
  )
  def migrate005(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        candidate = "java",
        version = "20.1.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.1.0/graalvm-ce-java11-linux-amd64-20.1.0.tar.gz",
        platform = Linux64,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.1.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.1.0/graalvm-ce-java11-darwin-amd64-20.1.0.tar.gz",
        platform = MacOSX,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.1.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.1.0/graalvm-ce-java11-windows-amd64-20.1.0.zip",
        platform = Windows,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.1.0.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.1.0/graalvm-ce-java8-linux-amd64-20.1.0.tar.gz",
        platform = Linux64,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.1.0.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.1.0/graalvm-ce-java8-darwin-amd64-20.1.0.tar.gz",
        platform = MacOSX,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.1.0.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.1.0/graalvm-ce-java8-windows-amd64-20.1.0.zip",
        platform = Windows,
        vendor = Some(Graal)
      )
    ).validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(
      platform => {
        removeVersion("java", "1.0.0-rc-16-grl", platform)
        removeVersion("java", "19.0.2-grl", platform)
        removeVersion("java", "19.1.1-grl", platform)
        removeVersion("java", "19.2.1-grl", platform)
        removeVersion("java", "19.3.0.r8-grl", platform)
        removeVersion("java", "19.3.0.r11-grl", platform)
        removeVersion("java", "19.3.0.2.r8-grl", platform)
        removeVersion("java", "19.3.0.2.r11-grl", platform)
      }
    )
  }

  @ChangeSet(
    order = "006",
    id = "06-add_graalvm_20_2_0",
    author = "eddumelendez"
  )
  def migrate006(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        candidate = "java",
        version = "20.2.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.2.0/graalvm-ce-java11-linux-amd64-20.2.0.tar.gz",
        platform = Linux64,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.2.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.2.0/graalvm-ce-java11-darwin-amd64-20.2.0.tar.gz",
        platform = MacOSX,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.2.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.2.0/graalvm-ce-java11-windows-amd64-20.2.0.zip",
        platform = Windows,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.2.0.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.2.0/graalvm-ce-java8-linux-amd64-20.2.0.tar.gz",
        platform = Linux64,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.2.0.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.2.0/graalvm-ce-java8-darwin-amd64-20.2.0.tar.gz",
        platform = MacOSX,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.2.0.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.2.0/graalvm-ce-java8-windows-amd64-20.2.0.zip",
        platform = Windows,
        vendor = Some(Graal)
      )
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "007",
    id = "007-add_graalvm_r8_19_3_4",
    author = "eddumelendez"
  )
  def migrate007(implicit db: MongoDatabase): Unit = {
    Map(
      Linux64 -> "graalvm-ce-java8-linux-amd64-19.3.4.tar.gz",
      MacOSX  -> "graalvm-ce-java8-darwin-amd64-19.3.4.tar.gz",
      Windows -> "graalvm-ce-java8-windows-amd64-19.3.4.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "19.3.4.r8-grl",
            s"https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.4/$binary",
            platform,
            Some(Graal)
          )
      }
      .toList
      .validate()
      .insert()
  }

  @ChangeSet(
    order = "008",
    id = "008-add_graalvm_r11_19_3_4",
    author = "eddumelendez"
  )
  def migrate008(implicit db: MongoDatabase): Unit = {
    Map(
      LinuxARM64 -> "graalvm-ce-java11-linux-aarch64-19.3.4.tar.gz",
      Linux64    -> "graalvm-ce-java11-linux-amd64-19.3.4.tar.gz",
      MacOSX     -> "graalvm-ce-java11-darwin-amd64-19.3.4.tar.gz",
      Windows    -> "graalvm-ce-java11-windows-amd64-19.3.4.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "19.3.4.r11-grl",
            s"https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.4/$binary",
            platform,
            Some(Graal)
          )
      }
      .toList
      .validate()
      .insert()
  }

  @ChangeSet(
    order = "009",
    id = "009-add_graalvm_20_3_0",
    author = "eddumelendez"
  )
  def migrate009(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        candidate = "java",
        version = "20.3.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.3.0/graalvm-ce-java11-linux-aarch64-20.3.0.tar.gz",
        platform = LinuxARM64,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.3.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.3.0/graalvm-ce-java11-linux-amd64-20.3.0.tar.gz",
        platform = Linux64,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.3.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.3.0/graalvm-ce-java11-darwin-amd64-20.3.0.tar.gz",
        platform = MacOSX,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.3.0.r11-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.3.0/graalvm-ce-java11-windows-amd64-20.3.0.zip",
        platform = Windows,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.3.0.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.3.0/graalvm-ce-java8-linux-amd64-20.3.0.tar.gz",
        platform = Linux64,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.3.0.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.3.0/graalvm-ce-java8-darwin-amd64-20.3.0.tar.gz",
        platform = MacOSX,
        vendor = Some(Graal)
      ),
      Version(
        candidate = "java",
        version = "20.3.0.r8-grl",
        url =
          "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.3.0/graalvm-ce-java8-windows-amd64-20.3.0.zip",
        platform = Windows,
        vendor = Some(Graal)
      )
    ).validate()
      .insert()
  }

  @ChangeSet(
    order = "010",
    id = "010-hide-graalvm-versions",
    author = "eddumelendez"
  )
  def migrate010(implicit db: MongoDatabase): Unit =
    Seq(
      "19.3.1.r8-grl",
      "19.3.1.r11-grl",
      "19.3.4.r8-grl",
      "19.3.4.r11-grl",
      "20.0.0.r8-grl",
      "20.0.0.r11-grl",
      "20.1.0.r8-grl",
      "20.1.0.r11-grl",
      "20.2.0.r8-grl",
      "20.2.0.r11-grl"
    ).foreach(version => hideVersion("java", version))

  @ChangeSet(
    order = "011",
    id = "011-hide-graalvm-versions",
    author = "eddumelendez"
  )
  def migrate011(implicit db: MongoDatabase): Unit =
    Seq("20.3.0.r8-grl", "20.3.0.r11-grl")
      .foreach(version => hideVersion("java", version))

  @ChangeSet(
    order = "012",
    id = "012-hide-graalvm-versions",
    author = "eddumelendez"
  )
  def migrate012(implicit db: MongoDatabase): Unit =
    Seq("21.0.0.r8-grl", "21.0.0.r11-grl", "20.3.1.r8-grl", "20.3.1.r11-grl")
      .foreach(version => hideVersion("java", version))
}
