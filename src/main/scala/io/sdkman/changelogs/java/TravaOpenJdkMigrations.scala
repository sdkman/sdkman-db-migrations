package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{
  Linux64,
  MacOSX,
  TravaOpenJdk,
  Version,
  Windows,
  removeVersion
}

@ChangeLog(order = "040")
class TravaOpenJdkMigrations {

  @ChangeSet(
    order = "001",
    id = "001-add_TravaOpenJdk-8_0_232",
    author = "brunoRoemers"
  )
  def migrate001(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "8.0.232-trava",
        "https://github.com/TravaOpenJDK/trava-jdk-8-dcevm/releases/download/dcevm8u232b09/java8-openjdk-dcevm-linux.tar.gz",
        Linux64,
        Some(TravaOpenJdk)
      ),
      Version(
        "java",
        "8.0.232-trava",
        "https://github.com/TravaOpenJDK/trava-jdk-8-dcevm/releases/download/dcevm8u232b09/java8-openjdk-dcevm-osx.tar.gz",
        MacOSX,
        Some(TravaOpenJdk)
      )
    ).validate().insert()
  }

  @ChangeSet(
    order = "003",
    id = "003-remove_TravaOpenJdk-11_0_9",
    author = "eddumelendez"
  )
  def migrate003(implicit db: MongoDatabase): Unit =
    Seq(
      Linux64,
      MacOSX,
      Windows
    ).foreach { platform =>
      removeVersion("java", "11.0.9-trava", platform)
    }

  @ChangeSet(
    order = "004",
    id = "004-add_TravaOpenJdk-11_0_9",
    author = "brunoRoemers"
  )
  def migrate004(implicit db: MongoDatabase): Unit = {
    List(
      Version(
        "java",
        "11.0.9-trava",
        "https://github.com/TravaOpenJDK/trava-jdk-11-dcevm/releases/download/dcevm-11.0.9%2B2/java11-openjdk-dcevm-linux.tar.gz",
        Linux64,
        Some(TravaOpenJdk)
      ),
      Version(
        "java",
        "11.0.9-trava",
        "https://github.com/TravaOpenJDK/trava-jdk-11-dcevm/releases/download/dcevm-11.0.9%2B2/java11-openjdk-dcevm-osx.tar.gz",
        MacOSX,
        Some(TravaOpenJdk)
      ),
      Version(
        "java",
        "11.0.9-trava",
        "https://github.com/TravaOpenJDK/trava-jdk-11-dcevm/releases/download/dcevm-11.0.9%2B2/java11-openjdk-dcevm-windows.zip",
        Windows,
        Some(TravaOpenJdk)
      )
    ).validate().insert()
  }

}
