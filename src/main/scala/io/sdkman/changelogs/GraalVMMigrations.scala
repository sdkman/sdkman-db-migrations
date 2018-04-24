package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "008")
class GraalVMMigrations {

  @ChangeSet(order = "001", id = "001-add-graalvm-ce-1.0.0-rc1", author = "shelajev")
  def migration001(implicit db: MongoDatabase): Unit = {
    insertCandidate(
      Candidate(candidate = "graalvm",
        name = "GraalVM",
        description = "GraalVM is a universal virtual machine for running applications written in JavaScript, Python 3, Ruby, R, JVM-based languages like Java, Scala, Kotlin, and LLVM-based languages such as C and C++.",
        default = "1.0.0-rc1",
        websiteUrl = "http://graalvm.org",
        distribution = "PLATFORM_SPECIFIC"))

    insertVersion(Version("graalvm", "1.0.0-rc1", "https://github.com/oracle/graal/releases/download/vm-1.0.0-rc1/graalvm-ce-1.0.0-rc1-linux-amd64.tar.gz", Linux))
  }

}
