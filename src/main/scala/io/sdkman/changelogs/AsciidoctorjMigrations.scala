package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "015")
class AsciidoctorjMigrations {

  @ChangeSet(order = "001", id = "001_add_asciidoctorj_1_6_0", author = "rvprasad")
  def migration001(implicit db: MongoDatabase) = {
    Version("asciidoctorj", "1.6.0", "https://bintray.com/asciidoctor/maven/download_file?file_path=org%2Fasciidoctor%2Fasciidoctorj%2F1.6.0%2Fasciidoctorj-1.6.0-bin.zip")
      .validate()
      .insert()
      .asCandidateDefault()
  }
}

