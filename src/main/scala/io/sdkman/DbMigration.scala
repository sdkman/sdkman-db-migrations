package io.sdkman

import com.github.mongobee.Mongobee

object DbMigration extends App with Configuration {

  mongoUsernameO
    .fold(localMongoConn)(mongoUsername => remoteMongoConn(mongoUsername))
    .setDbName(mongoDatabase)
    .setChangeLogsScanPackage("io.sdkman.changelogs")
    .execute()

  lazy val localMongoConn = mongobee(s"mongodb://$mongoHost:$mongoPort")

  def remoteMongoConn(username: String) =
    mongobee(
      s"mongodb://$username:$mongoPassword@$mongoHost:$mongoPort/$mongoDatabase?authMechanism=SCRAM-SHA-1"
    )

  private def mongobee(url: String) = new Mongobee(url)
}
