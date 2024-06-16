package com.tinderApp.main;

import com.tinderApp.controller.TinderApp;
import com.tinderApp.model.Match;
import com.tinderApp.model.User;

public class Main {
    public static void main(String[] args) {
        TinderApp app = new TinderApp(10, 10);

        // Create users
        User user1 = new User("Nitika", 21, "Female");
        User user2 = new User("Anil", 28, "Male");
        User user3 = new User("Sachin", 30, "Male");

        // Add users
        app.addUser(user1);
        app.addUser(user2);
        app.addUser(user3);

        // List users
        System.out.println("Users:");
        app.listUsers();

        // Create match
        Match match1 = new Match(user1, user2);
        app.addMatch(match1);

        // List matches
        System.out.println("Matches:");
        app.listMatches();

        // Get user matches
        System.out.println("Matches for Nitika:");
        Match[] NitikaMatches = app.getUserMatches("Nitika");
        for (Match match : NitikaMatches) {
            System.out.println(match);
        }

        // Update user
        User updatedNitika = new User("Nitika", 26, "Female");
        app.updateUser("Nitika", updatedNitika);

        // List users after update
        System.out.println("Users after update:");
        app.listUsers();

        // Delete match
        app.deleteMatch(user1, user2);

        // List matches after deletion
        System.out.println("Matches after deletion:");
        app.listMatches();

        // Delete user
        app.deleteUser("Sachin");

        // List users after deletion
        System.out.println("Users after deletion:");
        app.listUsers();
    }
}
