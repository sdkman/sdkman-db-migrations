package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "088")
class HscMigrations {
  @ChangeSet(order = "001", id = "001_add_hsc_2_0_0_rc3", author = "ascheman")
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = "hsc",
      name = "HSC (HTML Sanity Check)",
      description =
        "HSC (HTML Sanity Check) is a fast and lightweight tool for checking HTML, links, and accessibility issues. It helps ensure clean, error-free web content and integrates seamlessly into CI/CD workflows.",
      websiteUrl = "https://hsc.aim42.org/"
    ).insert()
  }
}
