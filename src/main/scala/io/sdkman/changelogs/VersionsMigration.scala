package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import org.bson.Document

@ChangeLog(order = "001")
class VersionsMigration extends DocumentConversion {

  import scala.collection.JavaConverters._

  @ChangeSet(order = "001", id = "addJava904Zulu", author = "marc0der")
  def migrate(db: MongoDatabase): Unit = {
    db.getCollection("versions").insertMany(List[Document](
      CandidateVersion("java", "9.0.4-zulu", Some("LINUX_64"), "https://cdn.azul.com/zulu/bin/zulu9.0.4.1-jdk9.0.4-linux_x64.zip"),
      CandidateVersion("java", "9.0.4-zulu", Some("MAC_OSX"), "https://cdn.azul.com/zulu/bin/zulu9.0.4.1-jdk9.0.4-macosx_x64.zip"),
      CandidateVersion("java", "9.0.4-zulu", Some("WINDOWS_64"), "https://cdn.azul.com/zulu/bin/zulu9.0.4.1-jdk9.0.4-win_x64.zip")).asJava)
  }
}
