
public class saleItem {
	
	private String productType1; //First type of sale product e.g. Clothing/Entertainment, should be a Mandatory input
	private String productType2; //Second type of sale product e.g. Shirt/Pants/Shoes, should be a mandatory input
	private String brandName; //Brand name of product, optional input
	private String productName; //product name, optional input
	private String foundBy; //user who found the sale, always filled automatically
	private double originalPrice; //Original price of product, optional
	private double salePrice; //sale price of product, mandatory
	private Integer monthUpdated; //month item was last updated
	private Integer dayUpdated; //day item was last updated
	private Integer yearUpdated; //year item was last updated
	private boolean inStock; //true/false if item is still in stock or on sale
	private String areaFound; //area item was found, should be selectable via drop down list, mandatory
	private String storeFound; //store item was foun, should be selectable via drop down list depending on area, mandatory
	
	public saleItem(String name){ //Initializes saleItem
		productType1 = null; 
		productType2 = null;
		brandName = null;
		productName = null;
		foundBy = null;
		originalPrice = 0.0;
		salePrice = 0.0;
		monthUpdated = null;
		dayUpdated = null;
		yearUpdated = null;
		inStock = false;
		areaFound = null;
		storeFound = null;
		
	}
	
	public void setProductType1(String type){ //Sets the first product type
		this.productType1 = type;
	}
	
	public void setProductType2(String type){ //Sets the second product type
		this.productType2 = type;
	}
	
	public void setBrandName(String name){ //sets the brand name of product
		this.brandName = name;
	}
	
	public void setProductName(String name){ //sets the name of product
		this.productName = name;
	}
	
	public void setFoundBy(String name){ //sets the user who found the object
		this.foundBy = name;
	}
	
	public void setOriginalPrice(double price){ //sets the original price of the object
		this.originalPrice = price;
	}
	
	public void setSalePrice(double price){ //sets the sale price of the object
		this.salePrice = price;
	}
	
	public void setMonthUpdated(Integer month){ //sets the month the product was last updated
		this.monthUpdated = month;
	}
	
	public void setDayUpdated(Integer day){ //sets the day the product was last updated 
		this.dayUpdated = day;
	}
	
	public void setYearUpdated(Integer year){ //sets the year the product was last updated
		this.yearUpdated = year;
	}
	
	public void setInStock(boolean stock){ //sets whether the object is still in stock, true/false
		this.inStock = stock;
	}
	
	public void setArea(String area){ //sets area the sale product is in
		this.areaFound = area;
	}
	
	public void setStore(String storeFound){ //sets store the sale product is in
		this.storeFound = storeFound;
	}
	
	public void displaySale(){ //print all aspects of sale product
		System.out.println(productType1);
		System.out.println(productType2);
		System.out.println(brandName);
		System.out.println(productName);
		System.out.println(foundBy);
		System.out.println(originalPrice);
		System.out.println(salePrice);
		System.out.println(monthUpdated);
		System.out.println(dayUpdated);
		System.out.println(yearUpdated);
		System.out.println(inStock);
		System.out.println(areaFound);
		System.out.println(productType2);
		System.out.println(storeFound);

	}
}
