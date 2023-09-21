package model;

import java.sql.Timestamp;

public class TransactionDetail {
	private int id;
	private int userId;
	private Timestamp bookTime;

	public TransactionDetail(int id, int userId, Timestamp bookTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.bookTime = bookTime;
	}

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

	public Timestamp getBookTime() {
		return bookTime;
	}

	public void setBookTime(Timestamp bookTime) {
		this.bookTime = bookTime;
	}
	
	
}
