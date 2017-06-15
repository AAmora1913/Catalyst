import java.io.*;
import java.util.*;

public class Catalyst {
	
	static ArrayList allLines = new ArrayList<String>();
	static ArrayList allProducts = new ArrayList<saleItem>();
	static Scanner kbd = new Scanner(System.in); //Scanner
	static String username = "WHEN_TWEWY_2";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			

		System.out.println("Thank you for using Catalyst!");
		System.out.println("Would you like to post or search a sale?");
		System.out.println("1. Post a sale");
		System.out.println("2. Search for a sale");
		
		fillCategories();
		
		int choice = kbd.nextInt();
		
		if(choice == 1){
			postSale();
		}
		
		if(choice == 2){
			searchSale();
		}
	}
	
	public static void fillCategories() throws FileNotFoundException{
		
		Scanner kbd2 = new Scanner(System.in);
		File file = new File("ClothingDatabase.txt");
		Scanner sc = new Scanner(file);
		
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			line = line.toUpperCase();
			//System.out.println(line);
			allLines.add(line);
		}
		
		
		for(int i = 0; i < allLines.size(); i++){
			saleItem item = new saleItem();
			String line = (String) allLines.get(i);
			String[] aspects = line.split(" ");
			item.setProductType1(aspects[0]);
			item.setProductType2(aspects[1]);
			item.setOccasion(aspects[2]);
			item.setBrandName(aspects[3]);
			item.setProductName(aspects[4]);
			item.setFoundBy(aspects[5]);
			item.setOriginalPrice((Double.parseDouble(aspects[6])));
			item.setSalePrice((Double.parseDouble(aspects[7])));
			item.setMonthUpdated(Integer.parseInt(aspects[8]));
			item.setDayUpdated(Integer.parseInt(aspects[9]));
			item.setYearUpdated(Integer.parseInt(aspects[10]));
			if(aspects[11].equals("TRUE")){
				item.setInStock(true);
			}
			else{
				item.setInStock(false);
			}
			item.setArea(aspects[12]);
			item.setStore(aspects[13]);
			allProducts.add(item);
		}
		/*
		for(int i = 0; i < allProducts.size(); i++){
			((saleItem) allProducts.get(i)).displaySale();
		}
		*/
	}
	public static void postSale(){
		System.out.println("Posting sale");
		
		System.out.println("What kind of item are you posting (Mandatory)");
		System.out.println("1. Clothing");
		System.out.println("2. Other");
		
		int choice = kbd.nextInt();
		if(choice == 1){
			postClothing();
		}
		else if(choice == 2){
		}
		
		
		
		
	}
	
	
	public static void searchSale(){
		System.out.println("Searching for sale");
		
		System.out.println("What are you searching for?");
		System.out.println("1. Clothing");
		System.out.println("2. Other");
		
		int choice = kbd.nextInt();
		if(choice == 1 ){
			searchClothing();
		}
	}

	public static void postClothing(){
		saleItem item = new saleItem();
		
		item.setProductType1("CLOTHING");
		
		System.out.println("What type of Clothing are you posting? (Mandatory)");
		System.out.println("1. Shirts");
		System.out.println("2. Pants");
		System.out.println("3. Shoes");
		System.out.println("4. Other");
		
		int choice = kbd.nextInt();

		
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
		
		System.out.println("What occasion is this for?");
		System.out.println("1. Formal");
		System.out.println("2. Casual");
		System.out.println("3. Athletic");
		System.out.println("4. Other");
		
	    choice = kbd.nextInt();

	    
		
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
		
		System.out.println("Brand Name (optional, type '1' to skip)");
		String input = kbd.next();
		if(input.equals("1")){
			item.setBrandName("N/A");
		}
		else{
			item.setBrandName(input.toUpperCase());
		}

		System.out.println("Product Name (optional, type '1' to skip)");
		input = kbd.next();
		input = input.replaceAll(" ", "_");
		if(input.equals("1")){
			item.setBrandName("N/A");
		}
		else{
			item.setProductName(input.toUpperCase());
		}
		
		item.setFoundBy(username);
		
		System.out.println("Original Price(optional, type '1' to skip)");
		input = kbd.next();
		if(input.equals("1")){
			item.setOriginalPrice(0.0);
		}
		else{
			item.setOriginalPrice(Double.parseDouble(input));
		}
		
		System.out.println("Sale Price (Mandatory)");
		input = kbd.next();
		item.setSalePrice(Double.parseDouble(input));
		
		item.setInStock(true);
		
		System.out.println("What area?");
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
		
		System.out.println("What Store?");
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
		
		item.displaySale();
	}
	
	public static void searchClothing(){
		
		boolean searchArea = false;
		boolean searchOcc = false;
		boolean searchType = false;
		
		String desArea = null;
		String desOcc = null;
		String desType = null;
		
		System.out.println("Searching for Clothing");
		
		System.out.println("What area are you searching in?");
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
		
		System.out.println("For what occasion?");
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
		
		
		System.out.println("What kind of Clothing are you searching for?");
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
		
		ArrayList foundItems = new ArrayList<saleItem>();
		
		for(int i = 0; i < allProducts.size(); i++){
			boolean addItem = true;
			saleItem tempItem = (saleItem) allProducts.get(i);
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
		for(int i = 0; i < foundItems.size(); i++){
			saleItem tempItem = (saleItem) foundItems.get(i);
			tempItem.displaySale();
			System.out.println("------------------------------------------");
		}
	}
}
