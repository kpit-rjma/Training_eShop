package users;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import exceptions.*;

/**
 * Customer object, extension of User object.
 * Used to store Customer and customer-specific information.
 * 
 * @author Rachel
 * 
 * Use Cases:
 * + Customer has primary key automatically generated
 * + Customer has an email (String)
 * + Customer has a DOB (Date)
 * + Customer has a ContactInfo Class (nested)
 * 
 * + Customer's age must be > 18 years old
 */
public class Customer {
	
	private static final int MINIMUM_AGE = 18;
	
	private UUID key;
	private User user;
	private Date dateOfBirth;
	private ContactInfo contactInfo;
	
	public Customer (String email, String password, Date dob, int countryCode, String state, int zip, long phone) throws IncorrectFormatException, AgeNotAllowedException {
		this.key = UUID.randomUUID();
		
		try {
			this.user = new User(email, password);
		} catch (IncorrectFormatException e) {
			throw new IncorrectFormatException(e.getMessage());
		}
		
		if (this.calculateAge(dob) < MINIMUM_AGE) {
			throw new AgeNotAllowedException("Customer is too young!");
		}
		
		this.dateOfBirth = dob;
		this.contactInfo = new ContactInfo(countryCode, state, zip, phone);
	}
	
	/**
	 * Returns age in years
	 * @param dob
	 * @return int age in years
	 */
    private int calculateAge(Date dob) {
    	LocalDate birthDate = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	LocalDate currentDate = LocalDate.now();
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
	
	/**
	 * Returns user key
	 * @return UUID
	 */
	public UUID getKey() {
		return this.key;
	}
	
	/**
	 * Returns the email address
	 * @return String
	 */
	public String getEmail() {
		return this.user.getUserEmail();
	}
	
	/**
	 * Returns a boolean if the passwords stored match
	 * @param password
	 * @return boolean True if match
	 */
	public boolean isPassword(String password) {
		return this.user.checkPassword(password);
	}
	
	public String toString() {
		String s = "";
		s += "Email: " + this.getEmail() + "\n";
		s += "Date of Birth: " + this.dateOfBirth.toString() + "\n";
		s += this.contactInfo.toString();
		return s;
	}

	/**
	 * Stores a phone number (country code included), state,
	 * and zip code.
	 * @author Rachel
	 *
	 * + ContactInfo has Country Code
	 * + ContactInfo has State
	 * + ContactInfo has Zip Code
	 * + ContactInfo has a Phone Number
	 */
	public class ContactInfo {
		
		private int countryCode;
		private String state;
		private int zipCode;
		private long phoneNumber;
		
		/**
		 * Constructor for a ContactInfo object
		 * @param cc Country Code (int)
		 * @param st State (String)
		 * @param zc ZipCode (int)
		 * @param pn Phone Number (long)
		 */
		public ContactInfo(int cc, String st, int zc, long pn) {
			this.countryCode = cc;
			this.state = st;
			this.zipCode = zc;
			this.phoneNumber = pn;
		}
		
		/**
		 * To String method for Contact info object
		 * Outputs like so:
		 * ----------------
		 * Phone Number: (##) ########
		 * Location: STATE, ######
		 */
		public String toString() {
			String s = "";
			s += "Phone Number: (" + this.countryCode + ") " + this.phoneNumber + "\n";
			s += "Location: " + this.state + ", " + this.zipCode;
			return s;
		}
		
		/**
		 * Getter for phone number (long)
		 * @return
		 */
		public long getPhoneNumber() {
			return this.phoneNumber;
		}
		
		/**
		 * Getter for state (String)
		 * @return
		 */
		public String getState() {
			return this.state;
		}
		
		/**
		 * Getter for zip code (int)
		 * @return
		 */
		public int getZipCode() {
			return this.zipCode;
		}
		
		/**
		 * Getter for country code (int)
		 * @return
		 */
		public int getCountryCode() {
			return this.countryCode;
		}
		
	}
	
}
