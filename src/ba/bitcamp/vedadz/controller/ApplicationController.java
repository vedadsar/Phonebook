package ba.bitcamp.vedadz.controller;

import java.sql.SQLException;

import ba.bitcamp.vedadz.model.*;
import ba.bitcamp.vedadz.view.*;

public class ApplicationController {

	
	public static  void home(){
		//prikaz home GUI-a.
		Contact c = Contact.find(1);
		ApplicationView.home(c);
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

}
