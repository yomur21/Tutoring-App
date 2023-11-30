package course;

public class Equipment {

	/**
	 * Each equipment has a price, a name, and a profit percentage.
	 */
	private int price;
	private String name;
	private double profitPercentage;
	
	
	/**
	 * 
	 * The constructor.
	 */
	public Equipment(int price, String name, double profitPercentage) {
		this.price = price;
		this.name = name;
		this.profitPercentage = profitPercentage;
	}


	
	/**
	 * Getters and setters to get and set the instance variables.
	 */
	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getProfitPercentage() {
		return profitPercentage;
	}


	public void setProfitPercentage(double profitPercentage) {
		this.profitPercentage = profitPercentage;
	}
	
	
	
	
}
