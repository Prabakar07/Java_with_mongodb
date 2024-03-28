package com.cslc.MainPackage;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

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

    public void executeSelectQuery(String collectionName, Document query) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        // Perform your select query here using the provided query
    }

    public void closeConnection() {
        mongoClient.close();
        System.out.println("Connection to MongoDB closed.");
    }
}
