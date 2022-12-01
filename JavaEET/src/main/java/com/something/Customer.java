package com.something;
import java.io.Serializable;

//IF the class implements Serializable, it means that this class is Bean
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fName;
	private String lName;
	private String phone;
	
	public Customer() {
		this.fName = "";
		this.lName= "";
		this.phone = "";
	}
	
	public Customer(String fName, String lName, String score) {
		this.fName = fName;
		this.lName= lName;
		this.phone = score;
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fname) {
		this.fName = fname;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lname) {
		this.lName = lname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	;
	
	
}
