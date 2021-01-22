package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "042")
class LayrryMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_layrry_candidate",
    author = "aalmiray"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "layrry",
      name = "Layrry",
      description =
        "Layrry - A Launcher and API for Modularized Java Applications. It allows to assemble modularized applications based on Maven artifact coordinates of the (modular) JARs to include. Layrry utilizes the Java Module System's notion of module layers, allowing multiple versions of one module to be used within an application at the same time, as well as dynamically adding and removing modules at application runtime.",
      websiteUrl = "https://github.com/moditect/layrry/"
    ).insert()
}
