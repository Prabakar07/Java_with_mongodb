package com.cslc.MainPackage;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public class Connect {
    private MongoClient mongoClient;
    private MongoDatabase database;

    public Connect() {
        mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
        database = mongoClient.getDatabase("mydb"); // Replace "your_database_name" with your actual database name
    }

    public void getConnection() {
        // Establish connection to MongoDB
        System.out.println("Connection to MongoDB established.");
    }

    public void insertDocument(String collectionName, Document document) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertOne(document);
    }

    public void deleteDocument(String collectionName, Bson filter) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.deleteOne(filter);
    }
    
    public String updateDocument(String collectionName, Document filter, Document update) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            collection.updateOne(filter, update);
            return "Success";
        } catch (Exception e) {
            return "Failed to update user credentials: " + e.getMessage();
        }
        
    }

    public void closeConnection() {
        mongoClient.close();
        System.out.println("Connection to MongoDB closed.");
    }
}
