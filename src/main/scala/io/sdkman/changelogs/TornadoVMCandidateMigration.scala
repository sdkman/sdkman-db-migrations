package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "050")
class TornadoVMMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_tornadovm_candidate",
    author = "stratika"
  )
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "tornadovm",
      name = "TornadoVM",
      description =
        "TornadoVM is a plug-in to OpenJDK and GraalVM that allows Java programmers to automatically run on heterogeneous hardware (GPUs, FPGAs, multi-core CPUs).",
      websiteUrl = "https://www.tornadovm.org/",
      distribution = "PLATFORM_SPECIFIC"
    ).insert()
  }
}
