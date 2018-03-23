package users;

import exceptions.IncorrectFormatException;

/**
 * User object that takes an email and a password
 * 
 * @author Rachel Ashburn
 * This is an abstract class to hold details of User
 * User could be anyone who uses a system.
 * 
 * Use Cases:
 * + Users have a password
 * + Users have an email
 * + Users email must have an '@' character
 */
public class User {

	private String email;
	private String password;
	
	/**
	 * Constructor for a new User.
	 * Requires an email and a password String to function
	 * @param email
	 * @param password
	 * @throws IncorrectFormatException If the email does not contain an @
	 */
	public User(String email, String password) throws IncorrectFormatException {
		
		if (this.hasAmpersand(email)) {
			this.email = email;
			this.password = password;
		} else {
			throw new IncorrectFormatException("Email must have an @ symbol.");
		}

	}
	
	/**
	 * Returns the user's email
	 * @return email associated with the user
	 */
	public String getUserEmail() {
		return this.email;
	}
	
	/**
	 * Returns true if emails match, false if not
	 * @param email Email to be checked
	 * @return boolean
	 */
	public boolean checkEmail(String email) {
		if (this.email.equals(email)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if passwords match, false if not
	 * @param password Password to be checked
	 * @return 
	 */
	public boolean checkPassword(String password) {
		if (this.password.equals(password)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks the String for an ampersand.
	 * Internal use only.
	 * Returns true if found, false if not.
	 * @param email
	 * @return boolean
	 */
	private boolean hasAmpersand(String email) {
		return email.contains("@");
	}
	
}
