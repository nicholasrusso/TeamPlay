package test;

import static org.junit.Assert.*;
import user.User;
import user.UserSearch;
import java.util.ArrayList;

import org.junit.Test;

public class TestUserSearch {

	@Test
	public void getUsersResultsNotEmpty() {
		UserSearch searcher = new UserSearch("");
		ArrayList<User> users = searcher.getUsers();
		
		assert(users.size() > 0);
	}
	
	@Test
	public void getUsersResultsEmpty() {
		UserSearch searcher = new UserSearch("DOES_NOT_EXIST");
		ArrayList<User> users = searcher.getUsers();
		
		assert(users.size() == 0);
	}
	
	@Test
	public void getUsersResultsAllUsernamesNotEmpty() {
		UserSearch searcher = new UserSearch("");
		ArrayList<User> users = searcher.getUsers();
	 
		for (User user : users) {
			assertNotEquals("", user.getUsername());
			System.out.println(user.getUsername());
		}
	}

}
