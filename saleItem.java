import java.io.*;
import java.text.*;
import java.util.*;


public class saleItem {
	
	private String productType1; //First type of sale product e.g. Clothing/Entertainment, should be a Mandatory input
	private String productType2; //Second type of sale product e.g. Shirt/Pants/Shoes, should be a mandatory input
	private String brandName; //Brand name of product, optional input
	private String productName; //product name, optional input
	private String occasion; //Sets occasion for the item
	private String foundBy; //user who found the sale, always filled automatically
	private double originalPrice; //Original price of product, optional
	private double salePrice; //sale price of product, mandatory
	private boolean inStock; //true/false if item is still in stock or on sale
	private String areaFound; //area item was found, should be selectable via drop down list, mandatory
	private String storeFound; //store item was foun, should be selectable via drop down list depending on area, mandatory
	private Date updateDate;
	
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    
	public saleItem(){ //Initializes saleItem
		productType1 = null; 
		productType2 = null;
		brandName = null;
		productName = null;
		occasion = null;
		foundBy = null;
		originalPrice = 0.0;
		salePrice = 0.0;
		inStock = false;
		areaFound = null;
		storeFound = null;
		Date udate = new Date();
		sdf.format(udate);
		updateDate = udate;
	}
	
	public void setProductType1(String type){ //Sets the first product type
		this.productType1 = type;
	}
	
	public String getProductType1(){ //Gets the first product type
		return this.productType1;
	}
	
	public void setProductType2(String type){ //Sets the second product type
		this.productType2 = type;
	}
	
	public String getProductType2(){ //Gets the second product type 
		return this.productType2;
	}
	public void setBrandName(String name){ //sets the brand name of product
		this.brandName = name;
	}
	
	public String getBrandName(){ //gets the brand name
		return this.brandName;
	}
	
	public void setOccasion(String name){ //sets occasion for the item
		this.occasion = name;
	}
	
	public String getOccasion(){ //gets the occasion for the item
		return this.occasion;
	}
	
	public void setProductName(String name){ //sets the name of product
		this.productName = name;
	}
	
	public String getProductName(){ //gets the product name
		return this.productName;
	}
	
	
	public void setFoundBy(String name){ //sets the user who found the object
		this.foundBy = name;
	}
	
	public String returnFoundBy(){ //returns the user that found the item
		return this.foundBy;
	}
	
	public void setOriginalPrice(double price){ //sets the original price of the object
		this.originalPrice = price;
	}
	
	public double returnOriginalPrice(){ //returns the original price of the item
		return this.originalPrice; 
	}
	
	public void setSalePrice(double price){ //sets the sale price of the object
		this.salePrice = price;
	}
	
	public double returnSalePrice(){ //returns the sale price
		return this.salePrice;
		
	}
	
	
	public void setInStock(boolean stock){ //sets whether the object is still in stock, true/false
		this.inStock = stock;
	}
	
	public boolean returnInStock(){ //sets whether the item is still in stock/on sale
		return this.inStock;
	}
	
	public void setArea(String area){ //sets area the sale product is in
		this.areaFound = area;
	}
	
	public String returnAreaFound(){ //returns the area the product is found in
		return this.areaFound;
	}
	
	public void setStore(String storeFound){ //sets store the sale product is in
		this.storeFound = storeFound;
	}
	
	public String returnStore(){ //returns the store  item is found in
		return this.storeFound;
	}
	
	public Date updateDate(){ //sets the date the item is updated
		return this.updateDate();
	}
	
	public void setDate(){ //returns the date the item was last updated
		sdf.format(this.updateDate);
	}
	
	public void displaySale(){ //print all aspects of sale product
		System.out.println("Type of Product: " + productType1);
		System.out.println("Type of " + productType1 + ": " + productType2);
		System.out.println("Occasion: " + occasion);
		System.out.println("Brand: " + brandName);
		System.out.println("Name:  " +productName);
		System.out.println("Found by: "+ foundBy);
		if(this.originalPrice == 0.0){
			
		}
		else{
			System.out.println("Orginal Price: " +originalPrice);
		}
		System.out.println("Sale Price: " + salePrice);
		System.out.println("Date Updated: " + updateDate);
		System.out.println("In stock/Still on Sale?: " + inStock);
		System.out.println("Area: " + areaFound);
		System.out.println("Store: " + storeFound);

	}
}
