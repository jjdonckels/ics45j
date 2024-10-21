package labs.lab3;

import java.util.ArrayList;

/**
 * This class is used to calculate the average, smallest, largest and range of
 * the values.
 */
public class DataSet {
	// ADD YOUR INSTANCE VARIABLES HERE
	private ArrayList<Double> data;

	/**
	 * Constructs a DataSet object to hold the number of items, the extreme values
	 * and the sum.
	 */
	public DataSet() {
		data = new ArrayList<Double>();
	}

	/**
	 * Adds a value to this data set.
	 * 
	 * @param x the input value
	 */
	public void add(double x) {
		data.add(x);
	}
	
	/**
	 * Method used to calculate the sum of the data set.
	 * 
	 * @return sum the sum of the data set
	 */
	public double getSum() {
		double sum = 0;
		for (double d : data)
			sum += d;
		
		return sum;
	}

	/**
	 * Method used to calculate the average of the data set.
	 * 
	 * @return average the average of the data set
	 */
	public double getAverage() {
		// Because sum is a double, sum / n will not throw an
		// exception.
		
		return getSum() / data.size();
	}

	/**
	 * The smallest value contained in the data set.
	 * 
	 * @return the smallest value in the data set
	 */
	public double getSmallest() {
		int minIndex = 0;
		
		// check if data only has one element
		if (data.size() == 1)
			return data.get(minIndex);
		
		// this is for when data has more than 1 element
		for (int i = 1; i < data.size(); ++i)
		{
			if (data.get(i) < data.get(minIndex))
				minIndex = i;
		}
		
		return data.get(minIndex);
	}

	/**
	 * The largest value contained in the data set.
	 * 
	 * @return the largest value in the data set
	 */
	public double getLargest() {
		int maxIndex = 0;
		
		// when data only has 1 element
		if (data.size() == 1)
			return data.get(maxIndex);
		
		// when data has more than 1 element
		for (int i = 1; i < data.size(); ++i)
		{
			if (data.get(i) > data.get(maxIndex))
				maxIndex = i;
		}
		
		return data.get(maxIndex);
	}

	/**
	 * The range of values in the data set.
	 * 
	 * @return the range of values in the data set
	 */
	public double getRange() {
		return getLargest() - getSmallest();
	}

	/**
	 * Gets the total number of input values.
	 * 
	 * @return n the total number of inputs
	 */
	public int getCount() {
		return data.size();
	}
}
