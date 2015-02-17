package ba.bitcamp.vedadz.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import ba.bitcamp.vedadz.model.*;
import ba.bitcamp.vedadz.view.*;

public class ApplicationController {

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
	public static  void home(){
		//prikaz home GUI-a.
		Contact c = Contact.find(1);
		ApplicationView.home(c);
	}
	
	public static void list(){
		Contact [] all = Contact.all();
		ApplicationView.list(all);
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
