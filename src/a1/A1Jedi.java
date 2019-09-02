package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		// Create Scanner object to read in console inputs
		Scanner scan = new Scanner(System.in);
		
		// Read in the total number of items in store
		int total_number_of_items = scan.nextInt();
		
		// Create an array to store numbers
		int[] storeNumberItems = new int[total_number_of_items];
				
		// Create an array that stores item names
		String[] storeItemNames = new String[total_number_of_items];
		
		// Create arrays that will iteratively be added to
		int[] customerCounts = new int[total_number_of_items];
		int[] itemCounts = new int[total_number_of_items];
		
		// Create array that will help check for duplicates
		boolean[] customerCounted = new boolean[total_number_of_items];
		
		/* Iterates through the items in the store; takes in
		 * item name and item price
		 */
		for (int i=0; i<storeNumberItems.length; i++) {
			storeItemNames[i] = scan.next();
			scan.nextDouble(); 						/* this represents an input for price, which is not important for this exercise */
		}
		
		int number_of_customers = scan.nextInt();

		/* Iterates through each customer; takes in
		 * item name and item price
		 */
		for (int j=0; j<number_of_customers; j++) {
			scan.next(); 							/* first name, not important */
			scan.next(); 							/* last name, not important */
			
			// Resets boolean array values to all be false
			for (int k=0; k<total_number_of_items; k++) {
				customerCounted[k] = false;
			}
			
			int number_items_bought = scan.nextInt();
			
			int[] itemsBought = new int[number_items_bought];
			
			/* Iterates through each item; takes in quantity
			 * of item and item name
			 * 
			 * Also uses helper methods: addOneToCustomerCount()
			 * and addToItemCount() to add to customerCounts[] and 
			 * itemCounts[]
			 */
			for (int l=0; l<itemsBought.length; l++) {
				
				int quantityItem = scan.nextInt();
				String customerItemName = scan.next();
				
				addOneToCustomerCount(customerItemName, storeItemNames, customerCounts, customerCounted);
				addToItemCount(customerItemName, storeItemNames, itemCounts, quantityItem);
			}	
		
		}
		
		// Close scanner
		
		scan.close();
		
		/* Print results
		 * 
		 * If/else statement was used (if either customerCounts[i] == 0 or 
		 * itemCounts[i] == 0, output statement would have slightly different form)
		 */
		for (int i=0; i<storeNumberItems.length; i++) {
			if (customerCounts[i] == 0 || itemCounts[i] == 0) {
				System.out.println("No customers bought " + storeItemNames[i]);
			}
			else {
				System.out.println(customerCounts[i] + " customers bought " + itemCounts[i] + " " + storeItemNames[i]);
			}
			
		}
		
	}
	
	/* addOneToCustomerCount
	 * Adds one to customerCounts[]
	 * 
	 * Parameters: String customerItemName, String[] storeItemNames, int[] customerCounts, boolean[] customerCounted
	 * 
	 * Iterates through an array of names. If a certain name equals a name in that array, add one to the associated
	 * index in customerCounts[]. 
	 * 
	 * Protects against duplicates (when one customer buys an item more than once) - code will only proceed if the value 
	 * of the associated index in customerCounted[] is false. Adding one to customerCounts[] will turn the value in that 
	 * index from false to true. The for loop (46-48) found in the main code resets all boolean values in customerCounted[]
	 * to false, so each new customer will have a "blank slate" to work with.
	 * 
	 * Preconditions: length of storeItemNames must equal length of customerCounts[] and customerCounted[]
	 */
	
	public static void addOneToCustomerCount(String customerItemName, String[] storeItemNames, int[] customerCounts, boolean[] customerCounted) {
		for (int i=0; i<storeItemNames.length; i++) {
			if (customerItemName.equals(storeItemNames[i])) {
				if (customerCounted[i] == false) {
				  customerCounts[i] += 1;
				  customerCounted[i] = true;
				}
				break;
			}
		}
	}
	
	/* addToItemCount
	 * Adds to itemCounts[]
	 * 
	 * Parameters: String customerItemName, String[] storeItemNames, int[] itemCounts, int quantityItem
	 * 
	 * Iterates through an array of names. If a certain name equals a name in that array, add quantityItem to the associated
	 * index in itemCounts[]. 
	 * 
	 * Preconditions: length of storeItemNames must equal length of itemCounts[]
	 */
	
	public static void addToItemCount(String customerItemName, String[] storeItemNames, int[] itemCounts, int quantityItem) {
		for (int i=0; i<storeItemNames.length; i++) {
			if (customerItemName.equals(storeItemNames[i])) {
				itemCounts[i] += quantityItem;
				break;
			}
		}
	}
	
}
