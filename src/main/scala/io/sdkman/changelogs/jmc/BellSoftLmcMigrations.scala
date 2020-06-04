package io.sdkman.changelogs.jmc

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Liberica, Linux64, Version, Windows, _}

@ChangeLog(order = "001")
class BellSoftLmcMigrations {
  @ChangeSet(order = "0001", id = "0001-add_lmc_7_1_1", author = "den1ska")
  def migrate0001(implicit db: MongoDatabase) = {
    List(
      Version(
        "jmc",
        "7.1.1-librca",
        "https://download.bell-sw.com/lmc/7.1.1/bellsoft-lmc7.1.1-linux-amd64.tar.gz",
        Linux64,
        Some(Liberica)
      ),
      Version(
        "jmc",
        "7.1.1-librca",
        "https://download.bell-sw.com/lmc/7.1.1/bellsoft-lmc7.1.1-windows-amd64.zip",
        Windows,
        Some(Liberica)
      )
    ).validate().insert()
    setCandidateDefault("jmc", "7.1.1-librca")
  }
}
