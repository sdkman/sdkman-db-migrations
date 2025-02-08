package io.sdkman;

import com.github.mongobee.Mongobee;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.containers.MongoDBContainer;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DbMigrationTest {

    private static final String DB_NAME = "sdkman";
    private MongoDBContainer mongoContainer;
    private MongoClient mongoClient;

    @BeforeAll
    void setUp() {
        // Start a Testcontainers MongoDB instance
        // Apple Silicon requires a minimum version of 5,
        // though in prod there seems to be a version 3.2 running.
        mongoContainer = new MongoDBContainer("mongo:5.0");
        mongoContainer.start();
    }

    @AfterAll
    void tearDown() {
        if (mongoContainer != null) mongoContainer.stop();
    }

    @BeforeEach
    void initializeMongoClient() {
        // Create a MongoClient connected to the container
        MongoClientURI uri = new MongoClientURI(mongoContainer.getConnectionString());
        mongoClient = new MongoClient(uri);
    }

    @AfterEach
    void closeMongoClient() {
        if (mongoClient != null) mongoClient.close();
    }

    @Test
    void testDbMigration() {
        try {
            // Configure Mongobee to use the Testcontainers MongoDB
            // Note, testing DbMigration class directly would require slight refactoring to inject test container
            Mongobee mongobee = new Mongobee(mongoContainer.getConnectionString());
            mongobee.setDbName(DB_NAME); // Set the database name
            mongobee.setChangeLogsScanPackage("io.sdkman.changelogs");
            mongobee.execute(); // Execute the migration

            // Verify the migration by checking an expected collection or data
            MongoDatabase database = mongoClient.getDatabase(DB_NAME);

            boolean collectionExists =
                    database.listCollectionNames().into(new java.util.ArrayList<>()).contains("candidates");
            assertTrue(collectionExists, "Expected collection does not exist after migration!");

            // Add more verifications as needed (e.g., checking documents, indexes, etc.)
        } catch (Exception e) {
            Assertions.fail("Migration failed: " + e.getMessage());
        }
    }
}