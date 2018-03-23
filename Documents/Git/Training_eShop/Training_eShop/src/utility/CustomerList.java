package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import users.Customer;

public class CustomerList {

	private ArrayList<Customer> customers;

	/**
	 * Constructor (no parameters)
	 * Begins a new CustomerList object for use
	 */
	public CustomerList() {
		customers = new ArrayList<Customer>();
	}
	
	/**
	 * Adds a customer to the customer list. Returns true when successful.
	 * User object should be supplied by the caller.
	 * @param u User object to be added
	 * @return Boolean, true if success, false if not.
	 */
	public boolean addCustomer(Customer c){
		try {
			this.customers.add(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Adds a user to the user list. Returns true when successful.
	 * Parameters should be supplied by the caller.
	 * @return Boolean, true if success, false if not.
	 */	
	public boolean addCustomer(String email, String password, Date dob, int countryCode, String state, int zip, long phone) {
		try {
			Customer c = new Customer(email, password, dob, countryCode, state, zip, phone);
			this.customers.add(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Sorts the CustomerList by email Strings.
	 * Does not return anything, does the function silently.
	 * Mostly used internally.
	 */
	public void sortCustomers() {
		Collections.sort(this.customers, new CustomComparator() );
	}
	
	/**
	 * Custom comparator for sorting the list by email.
	 * Works in Java 8-, not just Java 8 & 8+
	 * 
	 * @author Rachel
	 */
	public class CustomComparator implements Comparator<Customer> {
	    @Override
	    public int compare(Customer o1, Customer o2) {
	        return o1.getEmail().compareTo(o2.getEmail());
	    }
	}
	
}
