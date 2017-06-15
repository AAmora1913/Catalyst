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
		File file = new File("AllProducts.txt");
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
			item.setBrandName(aspects[2]);
			item.setProductName(aspects[3]);
			item.setFoundBy(aspects[4]);
			item.setOriginalPrice((Double.parseDouble(aspects[5])));
			item.setSalePrice((Double.parseDouble(aspects[6])));
			item.setMonthUpdated(Integer.parseInt(aspects[7]));
			item.setDayUpdated(Integer.parseInt(aspects[8]));
			item.setYearUpdated(Integer.parseInt(aspects[9]));
			if(aspects[10].equals("TRUE")){
				item.setInStock(true);
			}
			else{
				item.setInStock(false);
			}
			item.setStore(aspects[11]);
			item.setArea(aspects[12]);
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
		
		System.out.println("Are you searching via Product Type or Area?");
		System.out.println("");
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
		if(input.equals('1')){
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
}
