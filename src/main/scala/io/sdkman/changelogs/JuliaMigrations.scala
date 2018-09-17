package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "015")
class JuliaMigrations {

  @ChangeSet(order = "001", id = "001_add_julia_candidate", author = "gitqlt")
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate     = "julia",
      default       = Some("1.0.0"),
      name          = "Julia",
      description   = "Julia is a high-performance high-level general-purpose dynamic programming language",
      websiteUrl    = "https://julialang.org/",
      distribution  = "PLATFORM_SPECIFIC"
    ).insert()

    List(
      Version(
        candidate   = "julia",
        version     = "1.0.0",
        url         = "https://julialang-s3.julialang.org/bin/winnt/x64/1.0/julia-1.0.0-win64.exe",
        platform    = Windows
      ),
      Version(
        candidate   = "julia",
        version     = "1.0.0",
        url         = "https://julialang-s3.julialang.org/bin/linux/x64/1.0/julia-1.0.0-linux-x86_64.tar.gz",
        platform    = Linux64
      ),
      Version(
        candidate   = "julia",
        version     = "1.0.0",
        url         = "https://julialang-s3.julialang.org/bin/linux/armv7l/1.0/julia-1.0.0-linux-armv7l.tar.gz",
        platform    = MacOSX
      ))
      .validate()
      .insert()
  }
}
