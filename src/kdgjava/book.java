package kdgjava;

public class book {
	private int bookid;
	private String title;
	private String writer;
	private String company;
	private int printedDate;
	private int price;
	public book(int bookid, String title, String writer, String company, int printedDate, int price) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.writer = writer;
		this.company = company;
		this.printedDate = printedDate;
		this.price = price;
	}
	
	public int getBookid() { return bookid; }
	public void setBookid(int bookid) { this.bookid = bookid; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getWriter() { return writer; }
	public void setWriter(String writer) { this.writer = writer; }
	public String getCompany() { return company; }
	public void setCompany(String company) { this.company = company; }
	public int getPrintedDate() { return printedDate; }
	public void setPrintedDate(int printedDate) { this.printedDate = printedDate; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price;  }
	
}
