package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "075")
class AtmosphereMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_atmosphere_candidate",
    author = "jfarcand"
  )
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "atmosphere",
      name = "Atmosphere",
      description =
        "Real-time transport layer for Java AI agents. Build once with @Agent — deliver over WebTransport/HTTP3, WebSocket, SSE, gRPC, MCP, A2A, AG-UI, or any transport.",
      websiteUrl = "https://github.com/Atmosphere/atmosphere",
      distribution = "UNIVERSAL"
    ).insert()
  }
}
