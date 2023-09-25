package model;

import java.time.LocalDate;
import java.util.Date;

public class PCBook {
	
	private int id;
	private int userId;
	private int pcId;
	private LocalDate bookDate;
	
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

	public LocalDate getBookDate() {
		return bookDate;
	}

	public void setBookDate(LocalDate bookDate) {
		this.bookDate = bookDate;
	}

	public PCBook(int id, int userId, int pcId, LocalDate bookDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.pcId = pcId;
		this.bookDate = bookDate;
	}
	
	

}
