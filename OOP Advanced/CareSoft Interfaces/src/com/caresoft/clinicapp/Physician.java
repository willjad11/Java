package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	
	public Physician(Integer id) {
		super(id);
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
	public boolean assignPin(int pin) {
		if (pin > 9999 || pin < 1000) {
			System.out.println("Pin must be 4 digits.");
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
			System.out.println("No ID match.");
			return false;
		}
	}
}
