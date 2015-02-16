package ba.bitcamp.vedadz.controller;

import ba.bitcamp.vedadz.view.*;

public class ApplicationController {

	
	public static  void home(){
		//prikaz home GUI-a.
		ApplicationView.home();
	}
	
	public static void main(String[] args) {
		
		// povezivanje sa bazom 
		Main.init();
		
		home();
	}

}
