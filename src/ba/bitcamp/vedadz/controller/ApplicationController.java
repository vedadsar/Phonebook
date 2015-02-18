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
			viewUser(newContact.getID());
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
			Application.init("phonebook");	
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		Main.init();		
		home();
	}
	public static void viewUser(int id){
		Contact current = Contact.find(id);
		ApplicationView.user(current);
	}

	public static void addContact() {
		ApplicationView.add();		
	}
	
	public static void update(int id){
		Contact current = Contact.find(id);
		ApplicationView.update(current);
	}
	
	public static void update(Contact current) {
		current.update();
		ApplicationView.update(current);
	}

	public static void delete(int id) {
		Contact.delete(id);
		list();
	}

}
