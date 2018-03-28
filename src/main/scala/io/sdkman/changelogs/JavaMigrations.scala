package io.sdkman.changelogs

import com.github.mongobee.changeset.ChangeLog
import com.github.mongobee.changeset.ChangeSet
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "002")
class JavaMigrations {
  //TODO: Add new Java migrations here
  @ChangeSet(order = "001", id= "001-add_openjdk_10",author="MaSven")
  def migrate009(implicit db:MongoDatabase)=insertVersions(
    Version("java","10.0.0-openjdk",Some("WINDOWS_64"),"https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_windows-x64_bin.tar.gz"),
    Version("java","10.0.0-openjdk",Some("MAC_OSX"),"https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_osx-x64_bin.tar.gz"),
    Version("java","10.0.0-openjdk",Some("LINUX_64"),"https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_linux-x64_bin.tar.gz")
  )

}
