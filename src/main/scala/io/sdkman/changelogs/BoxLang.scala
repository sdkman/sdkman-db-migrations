package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "090")
class BogusMigrations {
    @ChangeSet(order = "001", id = "001_add_boxlang", author = "lmajano")
    def migration001(implicit db: MongoDatabase) = {
        Candidate(
          candidate = "boxlang",
          name = "BoxLang",
          description = "A modern, dynamically and loosely typed scripting language for multiple runtimes.",
          websiteUrl = "https://www.boxlang.io/",
          distribution = "UNIVERSAL"
        ).insert()
    }
}