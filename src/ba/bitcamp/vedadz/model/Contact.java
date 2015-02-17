package ba.bitcamp.vedadz.model;

import java.sql.*;

public class Contact extends Application {
	private int ID;
	private String name;
	private String surname;
	private String phoneNumber;
	private final static String tableName = "Contact";
	
	public Contact(){
		this.ID = -1;
		this.name = "unknown";
		this.surname = "unknown";
		this.phoneNumber = "";
	}
	
	public Contact(String name, String surname, String phoneNumber){
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.ID = -1;
	}
	
	public Contact(int ID, String name, String surname, String phoneNumber){
		this.ID = ID;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
	}

	public static Contact find(int ID){
		ResultSet res = Application.find(ID, tableName);
		try {
			int cID = res.getInt("ID");
			String contactName = res.getString("name");
			String contactSurname = res.getString("surname");
			String contactNumber = res.getString("number");
			return new Contact(cID, contactName, contactSurname, contactNumber);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	public boolean save(){
		String values = String.format("(?, '%s', '%s', '%s')", this.name, this.surname, this.phoneNumber);
		return Application.save(tableName, values);
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getID() {
		return ID;
	}
	
}
