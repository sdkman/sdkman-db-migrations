package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Linux64, MacOSX, OpenJDK, Version, Windows, removeVersion}

@ChangeLog(order = "022")
class OpenJdkMigrations {

  @ChangeSet(order = "001", id = "001-add_openjdk_java_14-ea-20", author = "eddumelendez")
  def migrate001(implicit db: MongoDatabase): Unit = {
    List(
      Version("java", "14.ea.20-open", "https://download.java.net/java/early_access/jdk14/20/GPL/openjdk-14-ea+20_linux-x64_bin.tar.gz", Linux64, Some(OpenJDK)),
      Version("java", "14.ea.20-open", "https://download.java.net/java/early_access/jdk14/20/GPL/openjdk-14-ea+20_osx-x64_bin.tar.gz", MacOSX, Some(OpenJDK)),
      Version("java", "14.ea.20-open", "https://download.java.net/java/early_access/jdk14/20/GPL/openjdk-14-ea+20_windows-x64_bin.zip", Windows, Some(OpenJDK)))
      .validate()
      .insert()
    Seq(Linux64, MacOSX, Windows).foreach(removeVersion("java", "14.ea.18-open", _))
  }

}
