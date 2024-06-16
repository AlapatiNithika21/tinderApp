package com.tinderApp.controller;

import java.util.Arrays;

import com.tinderApp.model.Match;
import com.tinderApp.model.User;

//CRUD---> create,Retrive,update,Delete
public class TinderApp {
	
	private User[] users;
	private Match[] matches;
	int userCount;
	int matchCount;
	
	public TinderApp(int userCapacity,int matchCapacity)
	{
		users= new User[userCapacity];
		matches=new Match[matchCapacity];
		userCount=0;
		matchCount=0;
		
	}
	
	//createUser
	public void addUser(User user)
	{
		if(userCount<users.length)
		{
			users[userCount++]=user;
		}
		else
		{
			System.out.println("user capacity is reached");
		}
	}
	
	//readUser
	
	public User getUser(String userName)
	{
		for(int i=0;i<userCount;i++)
		{
			if(users[i].getUserName().equals(userName))
			{
				return users[i];
			}
		}
		return null;
	}
	
	// Update User
    public void updateUser(String username, User updatedUser) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUserName().equals(username)) {
                users[i] = updatedUser;
                return;
            }
        }
        System.out.println("User not found.");
    }
	
 // Delete User
    public void deleteUser(String username) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUserName().equals(username)) {
                // Shift remaining users to the left
                for (int j = i; j < userCount - 1; j++) {
                    users[j] = users[j + 1];
                }
                users[--userCount] = null; // Clear last element
                return;
            }
        }
        System.out.println("User not found.");
    }
    
    // Create Match
    public void addMatch(Match match) {
        if (matchCount < matches.length) {
            matches[matchCount++] = match;
        } else {
            System.out.println("Match capacity reached.");
        }
    }

    // Read Match
    public Match[] getUserMatches(String username) {
        Match[] userMatches = new Match[matchCount];
        int count = 0;
        for (int i = 0; i < matchCount; i++) {
            if (matches[i].getUser1().getUserName().equals(username) || matches[i].getUser2().getUserName().equals(username)) {
                userMatches[count++] = matches[i];
            }
        }
        return Arrays.copyOf(userMatches, count);
    }

    // Update Match (Not typically a required operation in matchmaking apps, but included for completeness)
    public void updateMatch(User user1, User user2, Match updatedMatch) {
        for (int i = 0; i < matchCount; i++) {
            if ((matches[i].getUser1().equals(user1) && matches[i].getUser2().equals(user2)) ||
                (matches[i].getUser1().equals(user2) && matches[i].getUser2().equals(user1))) {
                matches[i] = updatedMatch;
                return;
            }
        }
        System.out.println("Match not found.");
    }

    // Delete Match
    public void deleteMatch(User user1, User user2) {
        for (int i = 0; i < matchCount; i++) {
            if ((matches[i].getUser1().equals(user1) && matches[i].getUser2().equals(user2)) ||
                (matches[i].getUser1().equals(user2) && matches[i].getUser2().equals(user1))) {
                // Shift remaining matches to the left
                for (int j = i; j < matchCount - 1; j++) {
                    matches[j] = matches[j + 1];
                }
                matches[--matchCount] = null; // Clear last element
                return;
            }
        }
        System.out.println("Match not found.");
    }

    // List All Users
    public void listUsers() {
        for (int i = 0; i < userCount; i++) {
            System.out.println(users[i]);
        }
    }

    // List All Matches
    public void listMatches() {
        for (int i = 0; i < matchCount; i++) {
            System.out.println(matches[i]);
        }
    }

}