package gtp4o.task112;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
        mongoClient = new MongoClient("localhost", 27017);
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
                .append("age", 30)
                .append("city", "New York");
        collection.insertOne(doc);

        long count = collection.countDocuments();
        assertEquals(1, count, "There should be exactly one document after insertion.");

        Document insertedDoc = collection.find(new Document("name", "John")).first();
        assertNotNull(insertedDoc, "Inserted document should not be null.");
        assertEquals(30, insertedDoc.getInteger("age"), "Age should be 30 after insertion.");
        assertEquals("New York", insertedDoc.getString("city"), "City should be New York after insertion.");
    }

    @Test
    @Order(2)
    void testUpdateDocument() {
        Document doc = new Document("name", "John")
                .append("age", 30)
                .append("city", "New York");
        collection.insertOne(doc);

        collection.updateOne(new Document("name", "John"),
                new Document("$set", new Document("age", 31)));

        Document updatedDoc = collection.find(new Document("name", "John")).first();
        assertNotNull(updatedDoc, "Updated document should not be null.");
        assertEquals(31, updatedDoc.getInteger("age"), "Age should be updated to 31.");
        assertEquals("New York", updatedDoc.getString("city"), "City should stay New York after update.");
    }

    @Test
    @Order(3)
    void testDeleteDocument() {
        Document doc = new Document("name", "John")
                .append("age", 30)
                .append("city", "New York");
        collection.insertOne(doc);

        collection.deleteOne(new Document("name", "John"));

        Document deletedDoc = collection.find(new Document("name", "John")).first();
        assertNull(deletedDoc, "Document should be deleted and not found.");
    }

    @Test
    @Order(4)
    void testReadDocuments() {
        List<Document> docs = new ArrayList<>();
        docs.add(new Document("name", "Alice").append("age", 25).append("city", "Paris"));
        docs.add(new Document("name", "Bob").append("age", 28).append("city", "London"));
        collection.insertMany(docs);

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
