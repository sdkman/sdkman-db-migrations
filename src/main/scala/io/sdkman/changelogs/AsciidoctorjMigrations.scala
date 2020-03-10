package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "015")
class AsciidoctorjMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_asciidoctorj_1_6_0",
    author = "rvprasad"
  )
  def migration001(implicit db: MongoDatabase) = {
    Version(
      "asciidoctorj",
      "1.6.0",
      "https://dl.bintray.com/asciidoctor/maven/org/asciidoctor/asciidoctorj/1.6.0/asciidoctorj-1.6.0-bin.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
  }
}
