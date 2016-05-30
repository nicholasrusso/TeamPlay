package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import user.User;
import user.UserSearch;

/*
 * Test Type: Unit Test
 * Author: Michael Haskell
 */

public class TestUserSearch {

	@Test
	public void getUsersResultsNotEmpty() {
		UserSearch searcher = new UserSearch("");
		ArrayList<User> users = (ArrayList<User>) searcher.getUsers();
		
		assertFalse(users.isEmpty());
	}
	
	@Test
	public void getUsersResultsEmpty() {
		UserSearch searcher = new UserSearch("DOES_NOT_EXIST");
		ArrayList<User> users = (ArrayList<User>) searcher.getUsers();
		
		assertTrue(users.isEmpty());
	}
	
	@Test
	public void getUsersResultsAllUsernamesNotEmpty() {
		UserSearch searcher = new UserSearch("");
		ArrayList<User> users = (ArrayList<User>) searcher.getUsers();
	 
		for (User user : users) {
			assertFalse("".equals(user.getUsername()));
		}
	}
	
	@Test
	public void getUsersResultsFindTestUser() {
		UserSearch searcher = new UserSearch("testuser1");
		ArrayList<User> users = (ArrayList<User>) searcher.getUsers();
		
		assertTrue(users.size() == 1);
	}
}
