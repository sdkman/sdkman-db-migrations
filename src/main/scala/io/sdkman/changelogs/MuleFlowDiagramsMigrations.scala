package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "028")
class MuleFlowDiagramsMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_muleflowdiagrams_candidate",
    author = "manikmagar"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = "mulefd",
      name = "Mule Flow Diagrams",
      description =
        "Mule Flow Diagrams is an open source tool that lets you generate flow dependency graph and diagrams for your Mule configurations.",
      websiteUrl = "https://github.com/manikmagar/mule-flow-diagrams/",
      distribution = "UNIVERSAL"
    ).insert()
  }
}
