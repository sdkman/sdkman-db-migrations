
package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "002")
class JavaMigrations {

  @ChangeSet(order = "071", id = "071-add_oracle_java_8.0.201", author = "marc0der")
  def migrate071(implicit db: MongoDatabase) = {
    List(
      Version("java", "8.0.201-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-linux-x64.tar.gz", Linux64),
      Version("java", "8.0.201-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-linux-i586.tar.gz", Linux32),
      Version("java", "8.0.201-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-macosx-x64.dmg", MacOSX),
      Version("java", "8.0.201-oracle", "http://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-windows-x64.exe", Windows))
      .validate()
      .insert()
    Seq(Linux64, Linux32, MacOSX, Windows).foreach(removeVersion("java", "8.0.191-oracle", _))
  }
}
