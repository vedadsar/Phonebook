package ba.bitcamp.vedadz.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import ba.bitcamp.vedadz.model.*;
import ba.bitcamp.vedadz.view.*;
/**
 * Class which controls our program. 
 * Main funcions  start from here. 
 * @author vedad
 *
 */
public class ApplicationController {

	/**
	 * Method which creates contact.
	 * It create local contact and saving it with method from contact class.
	 * After it it redirects to home panel.
	 * If saving is done successfuly we'll gett message about it.
	 * Same if saving failed.
	 * @param name
	 * @param surname
	 * @param number
	 */
	public static void create(String name, String surname, String number){
		Contact newContact = new Contact(name, surname, number);
		if(newContact.save() == true){
			//TODO redirect to contact info
			home();
			JOptionPane.showMessageDialog(null, "Successfuly created contact "+newContact.getName(), "ERROR", JOptionPane.INFORMATION_MESSAGE);	
		}else{
		JOptionPane.showMessageDialog(null, "Creating contact failed!","ERROR", JOptionPane.WARNING_MESSAGE);	
		}
	}
	
	/**
	 * Method which changes current panel  to home panel.
	 */
	public static  void home(){
		ApplicationView.home();
	}
	
	/**
	 * Method for showing list panel.
	 */
	public static void list(){
		Contact [] all = Contact.all(); //Getting all contacts
		ApplicationView.list(all);		//Sending it as parameter
	}
	
	public static void main(String[] args) {
	
		try {
			Application.init();	
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		Main.init();		
		home();
	}

	public static void addContact() {
		ApplicationView.add();		
	}

}
