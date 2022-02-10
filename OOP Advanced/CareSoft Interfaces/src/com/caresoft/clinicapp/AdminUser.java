package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
	
	
	public AdminUser(Integer id, String role) {
		super(id);
		this.setRole(role);
		this.setEmployeeID(id);
		this.securityIncidents = new ArrayList<String>();
	}
	
	public boolean assignPin(int pin) {
		if (pin > 999999 || pin < 100000) {
			System.out.println("Pin must be 6 digits.");
			return false;
		}
		else {
			this.setPin(pin);
			System.out.println("New pin set!");
			return true;
		}
	}

	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (confirmedAuthID == this.getId()) {
			System.out.println("ID matches.");
			return true;
		}
		else {
			this.authIncident();
			System.out.println("No ID match.");
			return false;
		}
	}
	
	public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
	
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return this.securityIncidents;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
}
