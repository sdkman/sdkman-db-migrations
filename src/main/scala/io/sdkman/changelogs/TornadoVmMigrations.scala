package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "090")
class TornadoVmMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_tornadovm_candidate",
    author = "nishanth-abishek"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "tornadovm",
      name = "TornadoVM",
      description =
        "TornadoVM is a JVM plugin that enables the execution of Java programs on heterogeneous hardware such as multi-core CPUs, GPUs, and FPGAs.",
      websiteUrl = "https://tornadovm.org",
    ).insert()
}
