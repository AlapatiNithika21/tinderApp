package com.tinderApp.test;

import com.tinderApp.controller.TinderApp;
import com.tinderApp.model.Match;
import com.tinderApp.model.User;

public class TestCaseNegative {
    public static void main(String[] args) {
        TinderApp app = new TinderApp(3, 3);  // Small capacity for easy testing

        // Create users
        User user1 = new User("Tejaswini", 25, "Female");
        User user2 = new User("Anil", 28, "Male");
        User user3 = new User("Priya", 30, "FeMale");
        User user4 = new User("Mounika", 22, "Female");  // Extra user for negative test

        // Add users
        app.addUser(user1);
        app.addUser(user2);
        app.addUser(user3);

        // Negative Test Case 1: Adding Users beyond Capacity
        System.out.println("Attempting to add a user beyond capacity:");
        app.addUser(user4);  // This should fail

        // Negative Test Case 2: Retrieving a Non-Existent User
        System.out.println("Attempting to retrieve a non-existent user:");
        User nonExistentUser = app.getUser("Eve");
        if (nonExistentUser == null) {
            System.out.println("User not found as expected.");
        }

        // Negative Test Case 3: Updating a Non-Existent User
        System.out.println("Attempting to update a non-existent user:");
        app.updateUser("Eve", new User("Eve", 29, "Female"));  // This should fail

        // Negative Test Case 4: Deleting a Non-Existent User
        System.out.println("Attempting to delete a non-existent user:");
        app.deleteUser("Eve");  // This should fail

        // Create match
        Match match1 = new Match(user1, user2);
        Match match2 = new Match(user2, user3);
        Match match3 = new Match(user1, user3);

        // Add matches
        app.addMatch(match1);
        app.addMatch(match2);
        app.addMatch(match3);

        // Negative Test Case 5: Adding Matches beyond Capacity
        System.out.println("Attempting to add a match beyond capacity:");
        Match match4 = new Match(user1, user4);  // Extra match for negative test
        app.addMatch(match4);  // This should fail

        // Negative Test Case 6: Retrieving Matches for a Non-Existent User
        System.out.println("Attempting to retrieve matches for a non-existent user:");
        Match[] nonExistentUserMatches = app.getUserMatches("Eve");
        if (nonExistentUserMatches.length == 0) {
            System.out.println("No matches found for non-existent user as expected.");
        }

        // Negative Test Case 7: Updating a Non-Existent Match
        System.out.println("Attempting to update a non-existent match:");
        app.updateMatch(user1, user4, new Match(user1, user4));  // This should fail

        // Negative Test Case 8: Deleting a Non-Existent Match
        System.out.println("Attempting to delete a non-existent match:");
        app.deleteMatch(user1, user4);  // This should fail

        // For reference, list all users and matches after negative tests
        System.out.println("Users after negative tests:");
        app.listUsers();

        System.out.println("Matches after negative tests:");
        app.listMatches();
    }
}