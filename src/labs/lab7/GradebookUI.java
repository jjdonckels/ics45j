package labs.lab7;

import java.util.Scanner;

/**
 * A program to add, remove, modify or print student names and grades.
 */
public class GradebookUI {
	
	public static void main(String[] args) {
		Gradebook gradebook = new Gradebook();
		Scanner in = new Scanner(System.in);

		boolean done = false;
		while (!done) {
			System.out.println("A)dd R)emove M)odify P)rint Q)uit");
			String input = in.next().toUpperCase();
			if (input.equals("Q"))
				done = true;
			else if (input.equals("A")) {
				System.out.print("Enter the student's name: ");
				String name = in.next();
				System.out.print("Enter the student's grade: ");
				String grade = in.next();
				
				gradebook.addEntry(name, grade);
			} else if (input.equals("R")) {
				System.out.print("Enter the student's name: ");
				String name = in.next();
				gradebook.removeEntry(name);
			} else if (input.equals("M")) {
				System.out.print("Enter the student's name: ");
				String name = in.next();
				System.out.print("Enter the student's grade: ");
				String grade = in.next();
				gradebook.modifyEntry(name, grade);
			} else if (input.equalsIgnoreCase("P")) {
				String[] entries = gradebook.getEntries();
				for (String entry : entries)
					System.out.println(entry);
			} else
				done = true;
		}
	}
}