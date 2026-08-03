package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "096")
class ModelJarsMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_modeljars",
    author = "bsbodden"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = "modeljars",
      name = "ModelJars",
      description =
        "ModelJars discovers qualified local AI models and securely pulls verified weights for in-process JVM inference.",
      websiteUrl = "https://modeljars.org",
      distribution = "PLATFORM_SPECIFIC"
    ).insert()
  }
}
