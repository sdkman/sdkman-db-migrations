package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{
  Graal,
  Linux64,
  MacOSX,
  Version,
  Windows,
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

}
