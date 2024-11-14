package labs.lab7;

import java.util.PriorityQueue;

public class EmergencyRoom {

	private PriorityQueue<Patient> patients;


	public EmergencyRoom() {
		// FILL IN
	}


	/**
	 * Adds a patient to the ER queue with the given injury and description
	 * 
	 * @param injury
	 * @param description
	 */
	public void addPatient(Injury injury, String description) {
		// FILL IN
	}


	/**
	 * Gets the next highest priority patient
	 */
	public Patient nextPatient() {
		return new Patient(Injury.SEIZURE, ""); // FIX ME
	}
}