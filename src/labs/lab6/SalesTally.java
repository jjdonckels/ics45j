package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads in a sales file and calculates the total amount for each service
 * category when requested
 */
public class SalesTally {

	private ArrayList<Sale> sales;

	/**
	 * Constructor
	 * 
	 * @param salesFileName sales file name
	 */
	public SalesTally(String salesFileName) {
		sales = new ArrayList<Sale>();
		
		try 
		{
			Scanner in = new Scanner(new File(salesFileName));
			
			while (in.hasNext()) 
			{
				String line = in.nextLine();
				
				Scanner lineScanner = new Scanner(line);
				lineScanner.useDelimiter(";");
				String currName = lineScanner.next();
				String currService = lineScanner.next();
				double currAmount = lineScanner.nextDouble();
				String currDate = lineScanner.next();
				
				System.out.println(currName + "\n" + currService + "\n" + currAmount + "\n" + currDate + "\n");
				
				sales.add(new Sale(currName, currService, currAmount, currDate));
			}
		}
		catch (FileNotFoundException e) 
		{
			System.out.print("File: " + salesFileName + " not found");
		}
		
		
	}


	/**
	 * Returns the total amount of sales for the given category
	 * 
	 * @param category
	 * 
	 * @return total amount of sales for the given category
	 */
	public double getCategoryTotal(String category) {
		double total = 0;
		
		for (int i = 0; i < sales.size(); ++i)
		{
			if (sales.get(i).getServiceCategory().equals(category))
				total += sales.get(i).getAmount();
		}
		
		return total;
	}

}
