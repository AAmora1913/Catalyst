import java.io.*;
import java.text.*;
import java.util.*;


public class saleItem {
	
	private String productType1; //First type of sale product e.g. Clothing/Entertainment, should be a Mandatory input
	private String productType2; //Second type of sale product e.g. Shirt/Pants/Shoes, should be a mandatory input
	private String brandName; //Brand name of product, optional input
	private String productName; //product name, optional input
	private String occasion;
	private String foundBy; //user who found the sale, always filled automatically
	private double originalPrice; //Original price of product, optional
	private double salePrice; //sale price of product, mandatory
	private Integer monthUpdated; //month item was last updated
	private Integer dayUpdated; //day item was last updated
	private Integer yearUpdated; //year item was last updated
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
		monthUpdated = null;
		dayUpdated = null;
		yearUpdated = null;
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
	
	public String getProductType1(){
		return this.productType1;
	}
	
	public void setProductType2(String type){ //Sets the second product type
		this.productType2 = type;
	}
	
	public String getProductType2(){
		return this.productType2;
	}
	public void setBrandName(String name){ //sets the brand name of product
		this.brandName = name;
	}
	
	public String getBrandName(){
		return this.brandName;
	}
	
	public void setOccasion(String name){
		this.occasion = name;
	}
	
	public String getOccasion(){
		return this.occasion;
	}
	
	public void setProductName(String name){ //sets the name of product
		this.productName = name;
	}
	
	public String getProductName(){
		return this.productName;
	}
	
	
	public void setFoundBy(String name){ //sets the user who found the object
		this.foundBy = name;
	}
	
	public String returnFoundBy(){
		return this.foundBy;
	}
	
	public void setOriginalPrice(double price){ //sets the original price of the object
		this.originalPrice = price;
	}
	
	public double returnOriginalPrice(){
		return this.originalPrice;
	}
	
	public void setSalePrice(double price){ //sets the sale price of the object
		this.salePrice = price;
	}
	
	public double returnSalePrice(){
		return this.salePrice;
		
	}
	
	public void setMonthUpdated(Integer month){ //sets the month the product was last updated
		this.monthUpdated = month;
	}
	
	public Integer returnMonthUpdated(){
		return this.monthUpdated;
	}
	
	public void setDayUpdated(Integer day){ //sets the day the product was last updated 
		this.dayUpdated = day;
	}
	
	public Integer returnDayUpdated(){
		return this.dayUpdated;
	}
	
	public void setYearUpdated(Integer year){ //sets the year the product was last updated
		this.yearUpdated = year;
	}
	
	public Integer returnYearUpdated(){
		return this.yearUpdated;
	}
	
	public void setInStock(boolean stock){ //sets whether the object is still in stock, true/false
		this.inStock = stock;
	}
	
	public boolean returnInStock(){
		return this.inStock;
	}
	
	public void setArea(String area){ //sets area the sale product is in
		this.areaFound = area;
	}
	
	public String returnAreaFound(){
		return this.areaFound;
	}
	
	public void setStore(String storeFound){ //sets store the sale product is in
		this.storeFound = storeFound;
	}
	
	public String returnStore(){
		return this.storeFound;
	}
	
	public Date updateDate(){
		return this.updateDate();
	}
	
	public void setDate(){
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
		/*System.out.println("Last Updated: " + monthUpdated + "/" + dayUpdated + "/" + yearUpdated); */
		System.out.println("Date Updated: " + updateDate);
		System.out.println("In stock/Still on Sale?: " + inStock);
		System.out.println("Area: " + areaFound);
		System.out.println("Store: " + storeFound);

	}
}
