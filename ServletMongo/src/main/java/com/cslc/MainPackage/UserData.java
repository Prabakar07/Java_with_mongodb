package com.cslc.MainPackage;

import org.bson.Document;

public class UserData {
    private Connect con;

    public UserData() {
        con = new Connect();
        con.getConnection();
    }

    public void storeUserCredentials(String userName, String userPassword) {
        try {
            // Create a new document to store user credentials
            Document document = new Document("user_name", userName)
                                    .append("user_password", userPassword);
            // Specify the collection where the document will be stored
            String collectionName = "user_credentials";
            // Insert the document into the collection
            con.insertDocument(collectionName, document);
            System.out.println("User credentials stored successfully.");
        } catch (Exception e) {
            System.out.println("Failed to store user credentials: " + e.getMessage());
        }
    }

    public void viewUserCredentials() {
        try {
            // Specify the collection to query
            String collectionName = "user_credentials";
            // Perform a find operation to retrieve all documents from the collection
            con.executeSelectQuery(collectionName, new Document());
            System.out.println("Viewed user credentials successfully.");
        } catch (Exception e) {
            System.out.println("Failed to view user credentials: " + e.getMessage());
        }
    }

    public void closeConnection() {
        con.closeConnection();
        System.out.println("Closed MongoDB connection.");
    }
}
