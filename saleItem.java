
public class saleItem {
	
	private String productType1;
	private String productType2;
	private String brandName;
	private String productName;
	private String foundBy;
	private double originalPrice;
	private double salePrice;
	private Integer monthUpdated;
	private Integer dayUpdated;
	private Integer yearUpdated;
	private boolean inStock;
	private String areaFound;
	private String storeFound;
	
	public saleItem(String name){
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
	
	public void setProductType1(String type){
		this.productType1 = type;
	}
	
	public void setProductType2(String type){
		this.productType2 = type;
	}
	
	public void setBrandName(String name){
		this.brandName = name;
	}
	
	public void setProductName(String name){
		this.productName = name;
	}
	
	public void setFoundBy(String name){
		this.foundBy = name;
	}
	
	public void setOriginalPrice(double price){
		this.originalPrice = price;
	}
	
	public void setSalePrice(double price){
		this.salePrice = price;
	}
	
	public void setMonthUpdated(Integer month){
		this.monthUpdated = month;
	}
	
	public void setdayUpdated(Integer day){
		this.dayUpdated = day;
	}
	
	public void setYearUpdated(Integer year){
		this.yearUpdated = year;
	}
	
	public void setInStock(boolean stock){
		this.inStock = stock;
	}
	
	public void setArea(String area){
		this.areaFound = area;
	}
	
	public void setStore(String storeFound){
		this.storeFound = storeFound;
	}
	
	public void displaySale(){
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
