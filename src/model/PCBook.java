package model;

import java.util.Date;

public class PCBook {
	
	private int id;
	private int userId;
	private int pcId;
	private Date bookDate;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPcId() {
		return pcId;
	}

	public void setPcId(int pcId) {
		this.pcId = pcId;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public PCBook(int id, int userId, int pcId, Date bookDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.pcId = pcId;
		this.bookDate = bookDate;
	}
	
	

}
