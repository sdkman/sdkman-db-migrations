package io.sdkman

import com.github.mongobee.Mongobee

object DbMigration extends App with Configuration {

  mongoUsernameO.fold(mongobee(s"mongodb://$mongoHost:$mongoPort")) { mongoUsername =>
    mongobee(s"mongodb://$mongoUsername:$mongoPassword@$mongoHost:$mongoPort")
  }.setDbName(mongoDatabase)
    .setChangeLogsScanPackage("io.sdkman.changelogs")
    .execute()

  private def mongobee(url: String) = new Mongobee(url)
}
