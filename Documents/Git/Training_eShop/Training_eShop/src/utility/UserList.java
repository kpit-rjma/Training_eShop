package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import users.User;

/**
 * Stores a list of basic User objects.
 * This can/should be replaced by databases
 * But who's going to use this little thing?
 * 
 * @author Rachel
 *
 */
public class UserList {
	
	private ArrayList<User> users;

	/**
	 * Constructor (no parameters)
	 * Begins a new UserList object for use
	 */
	public UserList() {
		users = new ArrayList<User>();
	}
	
	/**
	 * Adds a user to the user list. Returns true when successful.
	 * User object should be supplied by the caller.
	 * @param u User object to be added
	 * @return Boolean, true if success, false if not.
	 */
	public boolean addUser(User u){
		try {
			this.users.add(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Adds a user to the user list. Returns true when successful.
	 * Email/password should be supplied by the caller.
	 * @param email User email
	 * @param password User password
	 * @return Boolean, true if success, false if not.
	 */	
	public boolean addUser(String email, String password) {
		try {
			User u = new User(email, password);
			this.users.add(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Sorts the UserList by email Strings.
	 * Does not return anything, does the function silently.
	 * Mostly used internally.
	 */
	public void sortUsers() {
		Collections.sort(this.users, new CustomComparator() );
	}
	
	/**
	 * Custom comparator for sorting the list by email.
	 * Works in Java 8-, not just Java 8 & 8+
	 * 
	 * @author Rachel
	 */
	public class CustomComparator implements Comparator<User> {
	    @Override
	    public int compare(User o1, User o2) {
	        return o1.getUserEmail().compareTo(o2.getUserEmail());
	    }
	}
	
}
