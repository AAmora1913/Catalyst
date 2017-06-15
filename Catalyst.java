import java.io.*;
import java.util.*;

public class Catalyst {
	
	static ArrayList allLines = new ArrayList<String>();
	static ArrayList allProducts = new ArrayList<saleItem>();
	static Scanner kbd = new Scanner(System.in); //Scanner

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
			System.out.println(line);
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
		
		for(int i = 0; i < allProducts.size(); i++){
			((saleItem) allProducts.get(i)).displaySale();
		}
	}
	public static void postSale(){
		System.out.println("Posting sale");
		
		String productType1 = null; 
		String productType2 = null;
		String brandName = null;
		String productName = null;
		String foundBy = null;
		Double originalPrice = 0.0;
		Double salePrice = 0.0;
		Integer monthUpdated = null;
		Integer dayUpdated = null;
		Integer yearUpdated = null;
		Boolean inStock = false;
		String areaFound = null;
		String storeFound = null;
		
		System.out.println("What kind of item are you posting?");
		System.out.println("1. Clothing");
		System.out.println("2. Other");
		int choice = kbd.nextInt();
		if(choice == 1){
			productType1 = "CLOTHING";
		}
		else if(choice == 2){
			productType2 = "Other";
		}
		
		if (choice ==1){
			
		}
		
	}
	
	
	public static void searchSale(){
		System.out.println("Searching for sale");
	}

}
