package objects;

public class Book {
	private long ISBN;
	private String name;
	private Integer stock;
	
	public Book(long isbn, Integer stock, String name) {
		this.ISBN = isbn;
		this.stock = stock;
		this.name = name;
	}
	
	public long getISBN() {
		return ISBN;
	}
	
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	
	public Integer getStock() {
		return stock;
	}
	
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
