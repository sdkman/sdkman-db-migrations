# SDKMAN Database Migrations

This enables the users of SDKMAN to contribute new Installation Candidates and related Versions to be served by the API.

## Tools used

This repo uses the popular [db-migrate](https://db-migrate.readthedocs.io/en/latest/) database migration framework used in the node.js community. In order to contribute a PR, it is required to install the necessary toolchain first:

1. Install [nojejs](https://nodejs.org/en/download/) on your system. Which usually includes `npm`, the Node Package Manager.
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

The declares environments:
1. `dev`: A local mongodb installation on your machine used for testing locally.
2. `prod`: The production instance of mongodb which will be updated from the CI build.

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

Everything above should be fairly obvious: the `platform` usually being `UNIVERSAL` and the `url` pointing to a final zip URL resource (no query parameters please!).

Now run the migration locally to ensure that all is well:

        $ db-migrate up

        [INFO] Processed migration 20171106173532-maven-3

And lastly, check to see if your migration made it's way into the datbase:

        $ docker exec -it mongo mongo sdkman
        > db.versions.find({candidate: "maven", version: "3.5.2"});
        { "_id" : ObjectId("5a00ac5eda48c7289ef2e527"), "candidate" : "maven", "version" : "3.5.2", "platform" : "UNIVERSAL", "url" : "https://archive.apache.org/dist/maven/maven-3/3.5.2/binaries/apache-maven-3.5.2-bin.zip" }

Once we satisfied that everything worked, add and push this to your forked repo and raise a PR:

        $ git add migrations
        $ git push origin master

## Fast track

It is usually worth notifying us of the PR on the [cli-dev](gitter.im/sdkman/cli-dev) Gitter chat in case we miss your PR.