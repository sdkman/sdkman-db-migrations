# SDKMAN Database Migrations

This enables the users of SDKMAN to contribute new Installation Candidates and related Versions to be served by the API.

## Tools used

This repo uses the popular [db-migrate](https://db-migrate.readthedocs.io/en/latest/) database migration framework used in the node.js community. In order to contribute a PR, it is required to install the necessary toolchain first:

1. Install [nodejs](https://nodejs.org/en/download/) on your system, which usually includes `npm`, the Node Package Manager.
2. Perform a global install of `db-migrate` using `npm`. This might require `sudo` for access:

        $ sudo npm install -g db-migrate

3. Install the mongo driver for db-migrate:

        $ sudo npm install -g db-migrate-mongodb

4. Test that db-migrate is working:

        $ db-migrate --version
          0.10.0-beta.24

5. Install mongodb locally (I usually use Docker):

        $ docker run -d --network=host --name=mongo mongo:3.2

## Configuration
The configuration file for `db-migrate` can be found in **database.json**, and it declares two distinct environments.

## Environments

The declared environments:
1. `dev`: A local mongodb installation on your machine used for testing locally.
2. `prod`: The production instance of mongodb which will be updated from the CI build.

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

When serving up a simple universal zip binary, we always set the `platform` field to `UNIVERSAL`.

## Workflow

Every new Version should be submitted as an individual database migration PR. Start by stepping into this repo folder and create a new migration script using the `db-migrate` CLI. We will be using a release of Maven 3.5.2 as an example:

        $ db-migrate create maven_3.5.2

        [INFO] Created migration at /home/dude/src/sdkman/sdkman-db-migrations/migrations/20171106173711-maven-3.5.2.js

A new migration script has now been created, open this script in your favourite editor and implement the `up` function appropriately:

        exports.up = function(db) {
            return db.insert("versions", {
                "candidate" : "maven", 
                "version" : "3.5.2", 
                "platform" : "UNIVERSAL", 
                "url" : "https://archive.apache.org/dist/maven/maven-3/3.5.2/binaries/apache-maven-3.5.2-bin.zip"
            });
        };

Now run the migration locally to ensure that all is well:

        $ db-migrate up

        [INFO] Processed migration 20171106173532-maven-3

And lastly, check to see if your migration made it's way into the datbase:

        $ docker exec -it mongo mongo sdkman
        > db.versions.find({candidate: "maven", version: "3.5.2"});
        { "_id" : ObjectId("5a00ac5eda48c7289ef2e527"), "candidate" : "maven", "version" : "3.5.2", "platform" : "UNIVERSAL", "url" : "https://archive.apache.org/dist/maven/maven-3/3.5.2/binaries/apache-maven-3.5.2-bin.zip" }

Once we satisfied that everything worked, add and push this to your forked repo and raise a PR:

        $ git add migrations
        $ git commit -m 'Added Maven 3.5.2'
        $ git push origin master

## Example migrations

For convenience, some examples have been added to the `examples` folder of this repo. This contains examples for:

* New Candidate
* A Major Version release (default Version)
* A Minor Version release (non-default Version)

## Fast track

It is usually worth notifying us of the PR on the [cli-dev](gitter.im/sdkman/cli-dev) Gitter chat in case we miss your PR.
