package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "005")
class CxfMigrations {

  @ChangeSet(order = "001", id = "001_add_cxf_3_2_4", author = "marc0der")
  def migration001(implicit db: MongoDatabase) = {
    insertVersion(Version("cxf", "3.2.4", Some("UNIVERSAL"), "http://www.apache.org/dyn/closer.lua/cxf/3.2.4/apache-cxf-3.2.4.zip"))
    setCandidateDefault("cxf", "3.2.4")
  }
}
