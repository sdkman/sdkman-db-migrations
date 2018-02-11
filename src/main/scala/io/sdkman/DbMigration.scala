package io.sdkman

import com.github.mongobee.Mongobee

object DbMigration extends App {
  val runner = new Mongobee("mongodb://localhost:27017")
  runner.setDbName("sdkman")
  runner.setChangeLogsScanPackage("io.sdkman.changelogs")
  runner.execute()
}
