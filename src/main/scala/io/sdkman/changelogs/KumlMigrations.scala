package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

// ─────────────────────────────────────────────────────────────────────────────
// kUML candidate registration for SDKMAN!.
//
// Stand 2026-06-06: höchste @ChangeLog(order) im Repo war "094". Nächste freie
// Order = "095". Vor PR-Submission noch einmal verifizieren:
//   grep -R --no-filename '@ChangeLog' src/main/scala/io/sdkman/changelogs/ \
//     | sort | tail -n 1
//
// Type: PLATFORM_SPECIFIC. kUML ships jlink-bundled JREs per platform via the
// `runtimeZip`-Gradle-Task — kein universal-Java-Bundle, sondern self-
// contained Mac arm64 / Mac x64 / Linux x64 Archive (alle bereits auf
// GitHub Releases verfügbar als `kuml-runtime-<version>-<target>.zip`).
//
// `distribution = "PLATFORM_SPECIFIC"` is mutually exclusive with
// `"UNIVERSAL"` per SDKMAN! spec. Once set, versions of kUML must always
// be released with a `platform` attribute (MAC_OSX / MAC_ARM64 / LINUX_64).
// ─────────────────────────────────────────────────────────────────────────────

@ChangeLog(order = "095")
class KumlMigrations {
  @ChangeSet(order = "001", id = "001_add_kuml", author = "betschwa")
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "kuml",
      name = "kUML",
      description = "Kotlin-native UML and C4 modelling DSL with renderer pipeline (SVG/PNG/LaTeX).",
      websiteUrl = "https://kuml.dev",
      distribution = "PLATFORM_SPECIFIC"
    ).insert()
  }
}
