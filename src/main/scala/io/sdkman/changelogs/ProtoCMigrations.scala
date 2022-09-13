package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "074")
class ProtoCMigrations {
  @ChangeSet(
    order = "001",
    id = "001-add_protoc_candidate",
    author = "manojshr"
  )
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "protoc",
      name = "Protobuf Compiler (protoc)",
      description =
        "protoc is a compiler for protocol buffers (.proto) definitions files." +
          " It generates the code that can read and write data in the programming language of your choice (all popular ones).",
      websiteUrl = "https://github.com/protocolbuffers/protobuf"
    ).insert()
  }
}
