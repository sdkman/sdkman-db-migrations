package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "095")
class RegulusMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_regulus_candidate",
    author = "dipankar"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "regulus-cli",
      name = "Regulus CLI",
      description = """The Regulus compliance plane — scaffold a regulated
          |Google ADK agent in 60 seconds. Encodes 10 EU + UK regulations
          |(EU AI Act, GDPR, DORA, NIS2, EHDS, UK GDPR, FCA SYSC, PRA SS1/23,
          |PRA SS2/21, NHS DSPT) and 6 governance frameworks as runtime
          |ADK plugin profiles. Ships a CLI for generating compliant
          |projects and a Spring Boot starter that auto-wires every
          |plugin from `application.yaml`.""".stripMargin,
      websiteUrl = "https://regulus.neullabs.com",
      distribution = "UNIVERSAL"
    ).insert()
}
