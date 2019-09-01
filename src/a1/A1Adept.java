package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		// Create Scanner object to read in console inputs
		
		Scanner scan = new Scanner(System.in);
		
		// Read in the total number of items in store

		int total_number_of_items = scan.nextInt();
		
		// Create an array to store numbers
		
		int[] storeNumberItems = new int[total_number_of_items];
		
		// Create arrays that hold item name and item price
		
		String[] storeItemNames = new String[total_number_of_items];
		double[] itemPrices = new double[total_number_of_items];
		
		/* Iterates through the items in the store; takes in
		 * item name and item price
		 */
		
		for (int i=0; i<storeNumberItems.length; i++) {
			storeItemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
			
		}
		
		// Read in the total number of customers
		
		int number_of_customers = scan.nextInt();
		
		// Create an array to store numbers
		
		int[] numberCustomers = new int[number_of_customers];
		
		// Create arrays to hold names and amounts
		
		String[] names = new String[number_of_customers];
		double[] totalAmounts = new double[number_of_customers];
		
		/* Iterates through each customer;
		 * takes in first name, last name, and number of
		 * items bought
		 */
		
		for (int j=0; j<numberCustomers.length; j++) {
			String firstName = scan.next();
			String lastName = scan.next();
			
			int number_items_bought = scan.nextInt();
			
			int[] itemsBought = new int[number_items_bought];
			
			// Initialize amount paid 
			
			double amount = 0.0;
			
			/* Iterates through each item;
			 * takes in quantity of item and item name
			 */
			
			for (int k=0; k<itemsBought.length; k++) {
				int quantityItem = scan.nextInt();
				String customerItemName = scan.next();
				
				// Uses getItemPrice() method to get price based on customerItemName
				
				double price = getItemPrice(customerItemName, storeItemNames, itemPrices);
				
				// Adds prices for each unique item, summing to the total amount paid
				
				amount += quantityItem * price;
			}
			
			// Fill in arrays that are used in output
			
			names[j] = firstName + " " + lastName;
			totalAmounts[j] = amount;
		}
		
		// Close scanner
		
		scan.close();
		
		// Print results
		
		System.out.println("Biggest: " + names[getMaxIndex(totalAmounts)] +" (" + String.format("%.2f", findValueMax(totalAmounts)) + ")");
		System.out.println("Smallest: " + names[getMinIndex(totalAmounts)] + " (" + String.format("%.2f", findValueMin(totalAmounts)) + ")");
		System.out.println("Average: " + String.format("%.2f", (calculateValueSum(totalAmounts)) / ((double) number_of_customers)));
		
	}
	
	/* getItemPrice
	 * Retrieves an item price
	 * 
	 * Parameters: String customerItemName, String[] storeItemNames, double[] itemPrices
	 * 
	 * Iterates through an array of names. If a certain name equals a name in that array, return
	 * the price associated with the index of that name.
	 * 
	 * Preconditions: length of storeItemNames must equal length of itemPrices
	 */
	
	public static double getItemPrice(String customerItemName, String[] storeItemNames, double[] itemPrices) {
		for (int i=0; i<storeItemNames.length; i++) {
			if (customerItemName.equals(storeItemNames[i])) {
				return itemPrices[i];
			}
		}
		
		return 0.0;
		
	}
	
	/* getMaxIndex
	 * Retrieves the index associated with the maximum amount
	 * 
	 * Parameters: double[] totalAmounts
	 * 
	 * Iterates through the array of total amounts. Finds and returns the index
	 * of the maximum amount.
	 * 
	 * Preconditions: input array must not be null
	 */
	
	public static int getMaxIndex(double[] totalAmounts) {
		for (int i=0; i<totalAmounts.length; i++) {
			if (totalAmounts[i] == (findValueMax(totalAmounts))) {
				return i;
			}
		}
		return 0;
		
	}
	
	/* getMinIndex
	 * Retrieves the index associated with the minimum amount
	 * 
	 * Parameters: double[] totalAmounts
	 * 
	 * Iterates through the array of total amounts. Finds and returns the index
	 * of the minimum amount.
	 * 
	 * Preconditions: input array must not be null
	 */
	
	public static int getMinIndex(double[] totalAmounts) {
		for (int i=0; i<totalAmounts.length; i++) {
			if (totalAmounts[i] == (findValueMin(totalAmounts))) {
				return i;
			}
		}
		return 0;
		
	}
	
	/* EXTRACTED FROM A1Example.java; simply changed 
	 * type from int to double
	 * 
	 * calculateValueSum 
	 * Calculates the sum on an array of doubles
	 *
	 * Input: array of doubles: vals
	 * 
	 * Output: doubles sum of values in vals
	 * 
	 * Preconditions:
	 * Input array must not be null.
	 */
	
	static double calculateValueSum(double[] vals) {
		
		double sum = 0;
		
		for (int i=0; i<vals.length; i++) {
			sum += vals[i];
		}
		
		return sum;
	}
	
	/* EXTRACTED FROM A1Example.java; simply changed 
	 * type from int to double
	 * 
	 * findValueMin
	 * Finds and returns the minimum value in an array of doubles
	 * 
	 * Input: array of doubles vals
	 * 
	 * Output: minimum value found within the array
	 * 
	 * Preconditions:
	 * Input array must not be null and must contain at least one value.
	 */
	
	static double findValueMin(double[] vals) {
		
		// Initialize current minimum to first value in array.
		double cur_min = vals[0];
		
		// Starting with second value (if any), compare each value
		// in array with current minimum and replace if smaller.
		
		for (int i=1; i < vals.length; i++) {
			if (vals[i] < cur_min) {
				cur_min = vals[i];
			}
		}
		
		return cur_min;
	}

	/* EXTRACTED FROM A1Example.java; simply changed 
	 * type from int to double
	 * 
	 * findValueMax
	 * Finds and returns the maximum value in an array of doubles
	 * 
	 * Input: array of doubles vals
	 * 
	 * Output: maximum value found within the array
	 * 
	 * Preconditions:
	 * Input array must not be null and must contain at least one value.
	 */
	
	static double findValueMax(double[] vals) {
		
		// Initialize current minimum to first value in array.
		double cur_max = vals[0];
		
		// Starting with second value (if any), compare each value
		// in array with current minimum and replace if smaller.
		
		for (int i=1; i < vals.length; i++) {
			if (vals[i] > cur_max) {
				cur_max = vals[i];
			}
		}
		
		return cur_max;
	}
	
}

// FIND A MORE ELEGANT SOLUTION
// In hindsight, I probably created more work for myself by using the helper methods found in A1Example. 