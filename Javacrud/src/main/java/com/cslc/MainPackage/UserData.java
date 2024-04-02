package com.cslc.MainPackage;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.model.Filters;

public class UserData {
    private Connect con;

    public UserData() {
        con = new Connect();
        con.getConnection();
    }

    public void insertUser(String userName, String userPassword) {
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

    public String updateUser(String userId, String newUserName, String newUserPassword) {
        try {
            // Create a filter to find the user by user_id
            Document filter = new Document("user_name", newUserName);
            // Create an update document
            Document update = new Document("$set", new Document("user_name", newUserName)
                                                      .append("user_password", newUserPassword));
            // Specify the collection where the document will be updated
            String collectionName = "user_credentials";
            // Update the document in the collection
            return con.updateDocument(collectionName, filter, update);
        } catch (Exception e) {
            return "Failed to update user credentials: " + e.getMessage();
        }
    }
    

    public void deleteUser(String userId) {
        try {
            // Create a filter to specify the document to delete based on user name
            Bson filter = Filters.eq("user_id_name", userId);
            
            // Specify the collection where the document will be deleted from
            String collectionName = "user_credentials";
            
            // Delete the document from the collection
            con.deleteDocument(collectionName, filter);
            System.out.println("User credentials deleted successfully.");
        } catch (Exception e) {
            System.out.println("Failed to delete user credentials: " + e.getMessage());
        }
    }
    

    // public Document getUser(String userId) {
    //     try {
    //         // Create a filter to find the user by user_id
    //         Document filter = new Document("user_id", userId);
    //         // Specify the collection where the document will be retrieved from
    //         String collectionName = "user_credentials";
    //         // Retrieve the document from the collection
    //         return con.getDocument(collectionName, filter);
    //     } catch (Exception e) {
    //         System.out.println("Failed to retrieve user credentials: " + e.getMessage());
    //         return null;
    //     }
    // }

    public void closeConnection() {
        con.closeConnection();
        System.out.println("Closed MongoDB connection.");
    }
}
