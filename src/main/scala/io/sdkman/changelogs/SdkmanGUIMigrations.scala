package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "090")
class SdkmanGUIMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_sdkmangui_candidate",
    author = "youngledo"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "sdkmangui",
      name = "SDKMAN GUI",
      description = "Cross-platform, supports Windows, macOS, Ubuntu. Built with JavaFX + Maven, inspired by Applite's design aesthetic, offering an elegant GUI interface for SDKMAN.",
      websiteUrl = "https://github.com/youngledo/sdkman-gui"
    ).insert()
}
