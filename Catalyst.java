import java.io.*;
import java.util.*;

public class Catalyst {
	
	static ArrayList<String> allLines = new ArrayList<>(); //ArrayList that
	static ArrayList<saleItem> allProducts = new ArrayList<>();
	static Scanner kbd = new Scanner(System.in); //Scanner
	static String username = "WHEN_TWEWY_2"; //Username for Testing
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			

		System.out.println("Thank you for using Catalyst!");
		System.out.println("Would you like to post or search a sale?");
		System.out.println("1. Post a sale");
		System.out.println("2. Search for a sale");
		
		fillCategories(); //Go to function to fill in Products
		
		int choice = kbd.nextInt();
		
		if(choice == 1){ //Go to function to post a sale 
			postSale();
		}
		
		if(choice == 2){ //Go to function to search for a sale
			searchSale();
		}
	}
	
	public static void fillCategories() throws FileNotFoundException{
		
		File file = new File("ClothingDatabase.txt"); //file to represent the Clothing database
		Scanner sc = new Scanner(file); //Scanner to read in files
		
		while(sc.hasNextLine()){ //Scans the Clothing Database file and reads in everything
			String line = sc.nextLine();
			line = line.toUpperCase();
			allLines.add(line);
		}
		
		
		for(int i = 0; i < allLines.size(); i++){ //Creates a saleItem for each line in the Clothing Database
			saleItem item = new saleItem(); //starts a new saleItem Object
			String line = allLines.get(i); //gets the next line from the database
			String[] aspects = line.split(" "); // splits the line by spaces
			item.setProductType1(aspects[0]); //Sets the 1st Product Type
			item.setProductType2(aspects[1]); //Sets the 2nd Product Type
			item.setOccasion(aspects[2]); //Sets the occasion for the Product
			item.setBrandName(aspects[3]); //Sets the Brand name
			item.setProductName(aspects[4]); //Sets the Product Nae
			item.setFoundBy(aspects[5]); //Sets the user that found the sale
			item.setOriginalPrice((Double.parseDouble(aspects[6]))); //Sets the Original Price of the product
			item.setSalePrice((Double.parseDouble(aspects[7]))); //Sets the sale price of the product
			if(aspects[8].equals("TRUE")){ //Checks if the item is still in sale
				item.setInStock(true);
			}
			else{
				item.setInStock(false);
			}
			item.setArea(aspects[9]); //Sets Area the item is found
			item.setStore(aspects[10]); //Sets store the item is found
			allProducts.add(item); //adds the item to an arraylist of Products
		}
	}
	public static void postSale(){ //Function to post a sale
		System.out.println("Posting sale");
		
		System.out.println("What kind of item are you posting (Mandatory)"); //Asks what kind of product the user is posting
		System.out.println("1. Clothing");
		System.out.println("2. Other");
		
		int choice = kbd.nextInt();
		if(choice == 1){ //Function to post Clothing
			postClothing();
		}
		else if(choice == 2){
		}
		
	}
	
	
	public static void searchSale(){ //function for searching for a sale
		System.out.println("Searching for sale");
		
		System.out.println("What are you searching for?");
		System.out.println("1. Clothing");
		System.out.println("2. Other");
		
		int choice = kbd.nextInt();
		if(choice == 1 ){ //Goes to the function for searching for clothing
			searchClothing();
		}
	}

	public static void postClothing(){ //Function for posting a sale for Clothing
		saleItem item = new saleItem();
		
		item.setProductType1("CLOTHING");
		
		System.out.println("What type of Clothing are you posting? (Mandatory)"); //Asks for Product Type 2
		System.out.println("1. Shirts");
		System.out.println("2. Pants");
		System.out.println("3. Shoes");
		System.out.println("4. Other");
		
		int choice = kbd.nextInt();

		//Sets item product type 2
		if(choice == 1){
			item.setProductType2("SHIRT");
		}
		else if(choice == 2){
			item.setProductType2("PANTS");
		}
		else if(choice == 3){
			item.setProductType2("SHOES");
		}
		else if(choice == 4){
			item.setProductType2("OTHER");
		}
		
		System.out.println("What occasion is this for?"); //Asks for Occasion
		System.out.println("1. Formal");
		System.out.println("2. Casual");
		System.out.println("3. Athletic");
		System.out.println("4. Other");
		
	    choice = kbd.nextInt();

	    
		//Sets item occasion
		if(choice == 1){
			item.setOccasion("FORMAL");
		}
		else if(choice == 2){
			item.setOccasion("CASUAL");
		}
		else if(choice == 3){
			item.setOccasion("ATHLETIC");
		}
		else if(choice == 4){
			item.setOccasion("OTHER");
		}
		
		System.out.println("Brand Name (optional, type '1' to skip)"); //Sets Brand name (optional)
		String input = kbd.next();
		if(input.equals("1")){
			item.setBrandName("N/A");
		}
		else{
			item.setBrandName(input.toUpperCase());
		}

		System.out.println("Product Name (optional, type '1' to skip)"); //Sets Product name (optional)
		input = kbd.next();
		input = input.replaceAll(" ", "_");
		if(input.equals("1")){
			item.setBrandName("N/A");
		}
		else{
			item.setProductName(input.toUpperCase());
		}
		
		item.setFoundBy(username); //Sets user who posted the product
		 
		System.out.println("Original Price(optional, type '1' to skip)"); //Sets Original Price of the product
		input = kbd.next();
		if(input.equals("1")){
			item.setOriginalPrice(0.0);
		}
		else{
			item.setOriginalPrice(Double.parseDouble(input));
		}
		
		System.out.println("Sale Price (Mandatory)"); //Sets sale price of the product
		input = kbd.next();
		item.setSalePrice(Double.parseDouble(input));
		
		item.setInStock(true);
		
		System.out.println("What area?"); //Sets Area of the product
		System.out.println("1.King of Prussia (KOP)");
		System.out.println("2. Exton");
		System.out.println("3. Other");
		
		choice = kbd.nextInt();
		if(choice == 1){
			item.setArea("KOP");
		}
		else if(choice == 2){
			item.setArea("EXTON");
		}
		else{
			System.out.println("Please input the area in which you found this item.");
			item.setArea(kbd.next().toUpperCase());
		}
		
		System.out.println("What Store?"); //Sets store of the product
		System.out.println("1. PacSun");
		System.out.println("2. Uniqlo");
		System.out.println("3. Other");
		
		choice = kbd.nextInt();
		if(choice == 1){
			item.setStore("PACSUN");
		}
		else if(choice == 2){
			item.setStore("UNIQLO");
		}
		else{
			System.out.println("What store did you find this in?");
			item.setStore(kbd.next().toUpperCase());
		}
		
		allProducts.add(item);
		
		item.displaySale(); //Displays the details for the sale
	}
	
	public static void searchClothing(){ //Function for searching for clothing
		
		boolean searchArea = false; //Functions as filter
		boolean searchOcc = false;
		boolean searchType = false;
		
		String desArea = null;
		String desOcc = null;
		String desType = null;
		
		System.out.println("Searching for Clothing");
		
		System.out.println("What area are you searching in?"); //Asks user what area they are searching in
		System.out.println("1. KOP");
		System.out.println("2. Exton");
		System.out.println("3. All");
		
		int choice = kbd.nextInt();
		
		if(choice == 1){
			desArea = "KOP";
			searchArea = true;
		}
		else if(choice == 2){
			desArea = "EXTON";
			searchArea = true;
		}
		
		System.out.println("For what occasion?"); //Asks for the occasion of the Clothing
		System.out.println("1. Formal");
		System.out.println("2. Casual");
		System.out.println("3. Athletic");
		System.out.println("4. All");
		
		choice = kbd.nextInt();
		
		if(choice == 1){
			desOcc = "FORMAL";
			searchOcc = true;
		}
		else if(choice == 2){
			desOcc= "CASUAL";
			searchOcc = true;
		}
		else if(choice == 3){
			desOcc = "ATHLETIC";
			searchOcc = true;
		}
		
		
		System.out.println("What kind of Clothing are you searching for?"); //Asks what kind of Clothing user is searching for
		System.out.println("1. Shirts");
		System.out.println("2. Pants");
		System.out.println("3. Shoes");
		System.out.println("4. All");
		choice = kbd.nextInt();
		if(choice == 1){
			searchType = true;
			desType = "SHIRT";
		}
		else if(choice == 2){
			searchType = true;
			desType = "PANTS";
		}
		else if(choice == 3){
			searchType = true;
			desType = "SHOES";
		}
		
		
		System.out.println("Searching...");
		
		ArrayList<saleItem> foundItems = new ArrayList<>();
		
		for(int i = 0; i < allProducts.size(); i++){ //Goes through all of the items on sale and gets the ones matching the user's criteria
			boolean addItem = true;
			saleItem tempItem = allProducts.get(i);
			if(searchArea == true && !(desArea.equals(tempItem.returnAreaFound()))){
				addItem = false;
			}
			if(searchOcc == true && !(desOcc.equals(tempItem.getOccasion()))){
				addItem = false;
			}
			if(searchType == true && !(desType.equals(tempItem.getProductType2()))){
				addItem = false;
			}
			
			if(addItem == true){
				foundItems.add(tempItem);
			}
		}
		
		System.out.println("Found " + foundItems.size() + " items for you!");
		for(int i = 0; i < foundItems.size(); i++){ //Displays all of the items that match the users criteria
			saleItem tempItem = foundItems.get(i);
			tempItem.displaySale();
			System.out.println("------------------------------------------");
		}
	}
}
