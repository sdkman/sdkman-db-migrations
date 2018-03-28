package io.sdkman.changelogs

import com.github.mongobee.changeset.ChangeLog
import com.github.mongobee.changeset.ChangeSet
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "002")
class JavaMigrations {
  //TODO: Add new Java migrations here
  @ChangeSet(order = "002",id ="002-add_openjdk_9_0_4",author="MaSven")
  def migrate008(implicit db: MongoDatabase)=insertVersions(
    Version("java","9.0.4-openjdk",Some("MAC_OSX"),"https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_osx-x64_bin.tar.gz"),
    Version("java","9.0.4-openjdk",Some("LINUX_64"),"https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_linux-x64_bin.tar.gz"),
    Version("java","9.0.4-openjdk",Some("WINDOWS_64"),"https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_windows-x64_bin.tar.gz")
  )

}
