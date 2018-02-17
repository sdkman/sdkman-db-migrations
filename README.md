# SDKMAN Database Migrations

This enables the users of SDKMAN to contribute new Installation Candidates and related Versions to be served by the API.

## Tools used

This repo uses [mongobee](https://github.com/mongobee/mongobee) as database migration framework. In order to contribute a PR, it is required to have a local installation of MongoDB on your machine. Alternatively run it up with Docker (works on Linux):

        $ docker run -d -p 27017:27017 --name=mongo mongo:3.2

## The Build

The build is a standard Gradle build, with migration code written in Scala. To run migrations against your local database, simply run the following:

        $ ./gradlew clean run

## Environments

The two environments as follows:
1. `local`: A local mongodb installation on your machine used for testing locally. This is the default.
2. `prod`: The production instance of mongodb which will be updated from the CI build. This is inferred by environment variables.

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

TODO: write me

## Fast track

It is usually worth notifying us of the PR on the [cli-dev](gitter.im/sdkman/cli-dev) Gitter chat in case we miss your PR.
