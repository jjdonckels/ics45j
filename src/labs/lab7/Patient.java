package labs.lab7;

/**
 * Class representing a patient in a hospital emergency room
 */
public class Patient implements Comparable<Patient> {

	private Injury injury;
	private String description;

	/**
	 * Creates a new Patient object with the given injury and description
	 */
	public Patient(Injury injury, String description) {
		this.injury = injury;
		this.description = description;
	}


	public int getPriority() {
		return Injury.getTriageLevel(injury);
	}


	public Injury getInjury() {
		return injury;
	}


	public String getDescription() {
		return description;
	}


	/**
	 * Compares patients by priority
	 */
	@Override
	public int compareTo(Patient p) {
		if (getPriority() < p.getPriority())
			return -1;
		else if (getPriority() > p.getPriority())
			return 1;
		return 0;
	}
	
	
	/**
	 * Returns a string representation of this patient in the format:
	 * "Injury: [INJURY], Description: [DESCRIPTION]"
	 */
	@Override
	public String toString() {
		String returnMe = "Injury: ";
		
		if (injury == Injury.SEIZURE) 
			returnMe += "SEIZURE";
		else if (injury == Injury.HEMORRHAGE)
			returnMe += "HEMORRHAGE";
		else if (injury == Injury.CHEST_PAIN)
			returnMe += "CHEST PAIN";
		else if (injury == Injury.BURN)
			returnMe += "BURN";
		else if (injury == Injury.FRACTURE)
			returnMe += "FRACTURE";
		else if (injury == Injury.ABDOMINAL_PAIN)
			returnMe += "ABDOMINAL PAIN";
		else
			returnMe += "OTHER";
		
		returnMe += ", Description: " + description;
		
		return returnMe;
	}

}