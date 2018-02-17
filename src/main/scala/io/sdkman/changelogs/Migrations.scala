package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.{Candidate, CandidateVersion}
import org.bson.Document

import scala.collection.JavaConverters._

@ChangeLog(order = "001")
class Migrations {

  @ChangeSet(order = "001", id = "001-add_java_904_zulu", author = "marc0der")
  def _001(db: MongoDatabase) = db.getCollection("versions").insertMany(List[Document](
    CandidateVersion("java", "9.0.4-zulu", Some("MAC_OSX"), "https://cdn.azul.com/zulu/bin/zulu9.0.4.1-jdk9.0.4-macosx_x64.zip"),
    CandidateVersion("java", "9.0.4-zulu", Some("WINDOWS_64"), "https://cdn.azul.com/zulu/bin/zulu9.0.4.1-jdk9.0.4-win_x64.zip")).asJava)

  @ChangeSet(order = "002", id = "002-add_boot", author = "szdavid92")
  def _002(db: MongoDatabase) = {
    db.getCollection("candidates").insertOne(
      Candidate(
        candidate = "boot-clj",
        default = "2.7.2",
        description = """
                        |Boot is a Clojure build framework and ad-hoc Clojure script evaluator.
                        |Boot provides a runtime environment that includes all of the tools needed
                        |to build Clojure projects from scripts written in Clojure that run in the
                        |context of the project.
                      """.stripMargin,
        websiteUrl = "http://boot-clj.com/",
        name = "Boot",
        distribution = Some("UNIVERSAL")))

    db.getCollection("versions").insertOne(
      CandidateVersion("boot-clj", "2.7.2", Some("UNIVERSAL"), "https://github.com/boot-clj/boot/releases/download/2.7.2/boot.jar")
    )
  }
}
