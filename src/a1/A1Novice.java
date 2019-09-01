package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		// Create Scanner object to read in console inputs
		
		Scanner scan = new Scanner(System.in);
		
		// Read in the total number of customers
		
		int number_of_customers = scan.nextInt();
		
		// Create an array to store numbers
		
		int[] numberCustomers = new int[number_of_customers];
		
		// Create arrays containing the data that will be output
		
		String[] firstNames = new String[number_of_customers];
		String[] lastNames = new String[number_of_customers];
		double[] totalPrice = new double[number_of_customers];
		
		/* Iterates through each customer; takes in first 
		 * name, last name, and the number of items a 
		 * customer buys
		 * 
		 * Will also calculate the total price for each customer
		 */
		
		for (int i=0; i<numberCustomers.length; i++) {
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			
			int number_of_items = scan.nextInt();
			
			// Create an array to store numbers
			
			int[] numberItems = new int[number_of_items];
			
			// Create arrays to store inputs
			
			int[] quantityItem = new int[number_of_items];
			String[] itemName = new String[number_of_items];
			double[] itemPrice = new double[number_of_items];
			
			/* Create an array containing the calculation:
			 * (integer quantity of item bought) * (price of item as a double);
			 * 
			 * Can be thought of as "total price of each item"
			 */
			
			double[] eachPrice = new double[number_of_items];
			
			/* Iterates through each item; takes in the integer quantity
			 * of item bought, the name of the item, and the price of the
			 * item as a double
			 * 
			 * Also makes the calculation for eachPrice
			 */
			
			for (int j=0; j<numberItems.length; j++) {
				quantityItem[j] = scan.nextInt();
				itemName[j] = scan.next();
				itemPrice[j] = scan.nextDouble();
				
				eachPrice[j] = quantityItem[j] * itemPrice[j];
			}				
			
			// Calculates total price for each customer; makes use of
			// helper function calculateValueSum
			
			totalPrice[i] = calculateValueSum(eachPrice);
			
		}
		
		// Close scanner
		
		scan.close();
		
		// Print results
		
		for (int i=0; i<numberCustomers.length; i++) {
		System.out.println(firstNames[i].charAt(0) + ". " + lastNames[i] + ": " + String.format("%.2f", totalPrice[i]));
			
		}
		
	}	
	
	/* EXTRACTED FROM A1Example.java; simply changed 
	 * type from int to double
	 * 
	 * calculateValueSum  
	 * Calculates the sum on an array of doubles
	 * 
	 * Input: array of doubles: vals
	 * 
	 * Output: double sum of values in vals
	 * 
	 * Preconditions:
	 * Input array must not be null.
	 */
	
	static double calculateValueSum(double[] vals) {
		
		double sum = 0.0;
		
		for (int i=0; i<vals.length; i++) {
			sum += vals[i];
		}
		
		return sum;
	}
	
}

