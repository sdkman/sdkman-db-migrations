# SDKMAN Database Migrations

[![Build Status](https://travis-ci.org/sdkman/sdkman-db-migrations.svg?branch=master)](https://travis-ci.org/sdkman/sdkman-db-migrations)
[![Gitter chat](https://badges.gitter.im/sdkman/cli-dev.png)](https://gitter.im/sdkman/cli-dev)

This enables the users of SDKMAN to contribute new Installation Candidates and related Versions to be served by the API.

## Tools used

This repo uses [mongobee](https://github.com/mongobee/mongobee) as database migration framework. In order to contribute a PR, it is required to have a local installation of MongoDB on your machine. Alternatively run it up with Docker (works on Linux):

        $ docker run -d --network=host --name=mongo mongo:3.2

## The Build

The build is a standard Gradle build, with migration code written in Scala. To run migrations against your local database, simply run the following:

        $ ./gradlew clean run

## The Model

The domain used for describing releases has two entities: `candidates` and `versions`. These are modelled as two distinct collections in our MongoDB datastore.

### Candidates

This collection holds information about the SDK itself including the name, description, website url, distribution and default version. A typical entry would look something like this:

        { 
                "_id" : ObjectId("562beacb601daf84cec59999"),
                "candidate" : "scala", 
                "default" : "2.12.4", 
                "description" : "Scala is a programming language for general software applications. Scala has full support for functional programming and a very strong static type system...", 
                "websiteUrl" : "http://www.scala-lang.org/", 
                "name" : "Scala", 
                "distribution" : "UNIVERSAL"
        }

The `distribution` is usually set to `UNIVERSAL` unless platform specific binaries are to be served in which case it should be set to `PLATFORM_SPECIFIC`.

### Versions

The `versions` collection will hold information about individual releases for a specific Candidate. It has fields representing the candidate, version, (absolute) URL to the binary, as well as platform.

        {
                "_id" : ObjectId("5a09d2dcffd8c740664b335b"), 
                "candidate" : "kotlin", 
                "version" : "1.1.60", 
                "platform" : "UNIVERSAL", 
                "url" : "https://github.com/JetBrains/kotlin/releases/download/v1.1.60/kotlin-compiler-1.1.60.zip"
        }

When serving up a simple universal zip binary, we always set the `platform` field to `UNIVERSAL`. Multi-platform SDKs (such as Java) usually come in several flavours ie. `LINUX_64`, `MAC_OSX` and `WINDOWS_64`. In these cases, multiple entries should be made for each platform binary:

        { "_id": ObjectId("xxx"), "candidate": "java", "version": "9.0.4", "platform": "LINUX_64", "url": "https://java_binary_linux.zip" },
        { "_id": ObjectId("xxx"), "candidate": "java", "version": "9.0.4", "platform": "MAC_OSX", "url": "https://java_binary_osx.zip" },
        { "_id": ObjectId("xxx"), "candidate": "java", "version": "9.0.4", "platform": "WINDOWS_64", "url": "https://java_binary_windows.zip" }

## Workflow

Migration scripts can be found under [changelogs](https://github.com/sdkman/sdkman-db-migrations/tree/master/src/main/scala/io/sdkman/changelogs) and are divided by candidate. Various helper functions have been provided at package scope to perform simple tasks such as adding a Version / Candidate or setting a new Default version.

#### Adding a new Candidate migration class

Simply fork this repository and then add a db migration in the appropriate file (create a new class if your Candidate is not represented). Also ensure that the changelog order is set to the next value available among migration classes:

        @ChangeLog(order = "004")
        class JBakeMigrations {
            //TODO: migrations here
        }

#### Adding a new default Version (universal binary)

        @ChangeSet(order = "007", id = "007-add_scala_2_12_5", author = "marc0der")
          def migrate007(implicit db: MongoDatabase) = {
            Version("scala", "2.12.5", "https://downloads.lightbend.com/scala/2.12.5/scala-2.12.5.zip")
              .validate()
              .insert()
              .asCandidateDefault()
        }

Alternatively, a function is provided on package scope that allows the default version to be set explicitly:

        setCandidateDefault("groovy", "3.0.0")

#### Adding a historic Version (universal binary)

        @ChangeSet(order = "006", id = "006-add_scala_2_12_4", author = "marc0der")
          def migrate006(implicit db: MongoDatabase) =
            Version("scala", "2.12.4", "https://downloads.lightbend.com/scala/2.12.4/scala-2.12.4.zip")
              .validate()
              .insert()
        
#### Adding a new Version for multiple platforms

        @ChangeSet(order = "005", id = "005-add_oracle_jdk_10_0_0", author = "marc0der")
          def migrate005(implicit db: MongoDatabase) = {
            List(
              Version("java", "10.0.0-oracle", "http://download.oracle.com/java/jdk/10/7ea/jdk-10_osx-x64_bin.dmg", MacOSX),
              Version("java", "10.0.0-oracle", "http://download.oracle.com/java/jdk/10/7ea/jdk-10_linux-x64_bin.tar.gz", Linux),
              Version("java", "10.0.0-oracle", "http://download.oracle.com/java/jdk/10/7ea/jdk-10_windows-x64_bin.exe", Windows)
            ).validate().insert()
            setCandidateDefault("java", "10.0.0-oracle")
        }
        
Currently, four platforms identifiers are provided: `Linux`, `Windows`, `MacOSX` and `Universal` as the default.

#### Adding a new Candidate

        @ChangeSet(order = "001", id = "001_add_cxf_3_2_4", author = "r0b0")
        def migration001(implicit db: MongoDatabase) = {
            Candidate(
              candidate = "cxf",
              name = "CXF",
              description = "Apache CXF is an open source services framework...",
              websiteUrl = "https://cxf.apache.org/",
              distribution = "UNIVERSAL"
            ).insert()
        }

#### Removal of Candidates and Versions

        removeCandidate(candidate = "kobolt")
        removeAllVersions(candidate = "kobolt")
        removeVersion(candidate = "java", version = "10.0.0-oracle", platform = MacOSX)

## Fast track

It is usually worth notifying us of the PR on the [cli-dev](https://gitter.im/sdkman/cli-dev) Gitter chat in case we miss your PR.
