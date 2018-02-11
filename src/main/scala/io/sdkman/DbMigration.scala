package io.sdkman

import com.github.mongobee.Mongobee

object DbMigration extends App {
  val runner = new Mongobee("mongodb://scopuli:27017/sdkman")
  runner.setDbName("sdkman")
  runner.setChangeLogsScanPackage("io.sdkman.changelogs")
  runner.execute()
}
