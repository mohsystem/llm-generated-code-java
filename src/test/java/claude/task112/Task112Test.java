package claude.task112;

import com.mongodb.client.*;
import org.bson.Document;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Task112Test {

    static MongoClient mongoClient;
    static MongoDatabase database;
    static MongoCollection<Document> collection;

    @BeforeAll
    static void setUp() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("mydatabase");
        collection = database.getCollection("mycollection");
    }

    @BeforeEach
    void cleanCollection() {
        collection.deleteMany(new Document());
    }

    @AfterAll
    static void tearDown() {
        mongoClient.close();
    }

    @Test
    @Order(1)
    void testCreateDocument() {
        Document doc = new Document("name", "John")
                .append("age", 30);
        collection.insertOne(doc);

        long count = collection.countDocuments();
        assertEquals(1, count, "There should be exactly one document after insertion.");

        Document insertedDoc = collection.find(new Document("name", "John")).first();
        assertNotNull(insertedDoc, "Inserted document should not be null.");
        assertEquals(30, insertedDoc.getInteger("age"), "Age should be 30 after insertion.");
    }

    @Test
    @Order(2)
    void testUpdateDocument() {
        // Insert document first
        Document doc = new Document("name", "John")
                .append("age", 30);
        collection.insertOne(doc);

        // Update the document
        Document query = new Document("name", "John");
        Document update = new Document("$set", new Document("age", 31));
        collection.updateOne(query, update);

        // Verify update
        Document updatedDoc = collection.find(query).first();
        assertNotNull(updatedDoc, "Updated document should not be null.");
        assertEquals(31, updatedDoc.getInteger("age"), "Age should be updated to 31.");
    }

    @Test
    @Order(3)
    void testDeleteDocument() {
        // Insert document first
        Document doc = new Document("name", "John")
                .append("age", 30);
        collection.insertOne(doc);

        // Delete the document
        Document query = new Document("name", "John");
        collection.deleteOne(query);

        // Verify deletion
        Document deletedDoc = collection.find(query).first();
        assertNull(deletedDoc, "Document should be deleted and not found.");
    }

    @Test
    @Order(4)
    void testReadDocuments() {
        // Insert documents
        List<Document> docs = new ArrayList<>();
        docs.add(new Document("name", "Alice").append("age", 25));
        docs.add(new Document("name", "Bob").append("age", 28));
        collection.insertMany(docs);

        // Read documents
        List<Document> retrievedDocs = collection.find().into(new ArrayList<>());

        assertEquals(2, retrievedDocs.size(), "There should be exactly 2 documents.");

        List<String> names = new ArrayList<>();
        for (Document d : retrievedDocs) {
            names.add(d.getString("name"));
        }
        assertTrue(names.contains("Alice"), "Should contain Alice.");
        assertTrue(names.contains("Bob"), "Should contain Bob.");
    }
}
