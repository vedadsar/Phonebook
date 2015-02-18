package ba.bitcamp.vedadz.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import ba.bitcamp.vedadz.model.Application;
import ba.bitcamp.vedadz.model.Contact;

public class ModelTest {

	
	
	public static void main(String[] args) {
	try {
		Application.init("phonebook_test");		
		
	} catch (SQLException e) {
		System.err.println("Test failed: no connection");
	}
	
	new Contact(1, "Bob", "Bobs", "123325").save();
	new Contact(2, "Jeff", "Jefferson", "643451").save();
	new Contact(3, "Jane", "Janice", "432625").save();
	
	//Testing.
	System.out.println("Testing find: ");
	testFind();
	System.out.println("Testing all: ");
	testAll();	
	
	String[] tableNames = {"Contact"};
	
	System.out.println("Done testing.");
		
	}

	private static void testFind(){
		//Testing if contact 1 is equal to first contact added.
		//TODO equals method in contact class and rewrite this part of test.
		Contact c = Contact.find(1);
		if(!c.getName().equals("Bob") || !c.getSurname().equals("Bobs") ){
			System.err.println("Contact not equal!");
		}
		//Looking for not existing contact.
		c = Contact.find(4);
		if(c != null)
			System.err.println("Found non existing contact");
		
	}
	
	/**
	 * Class which test if our Contact.all method works fine.
	 * Checking for each contact if its equeals to added contact.
	 */
	private static void testAll(){
		//TODO equals method on contacts class and rewrite this method.
		Contact[] all = Contact.all();
		if(all.length != 3){
			System.err.println("Length does not match");
			return;
		}
		
		if(!all[0].getName().equals("Bob") || !all[0].getSurname().equals("Bobs") ){
			System.err.println("Contact" +all[0] +" not equal!");
		}
		
		if(!all[1].getName().equals("Jeff") || !all[1].getSurname().equals("Jefferson") ){
			System.err.println("Contact" +all[1] +" not equal!");
		}
		
		if(!all[2].getName().equals("Jane") || !all[2].getSurname().equals("Janice") ){
			System.err.println("Contact" +all[2] +" not equal!");
		}
	}	
	
}
