package model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class TransactionDetail {
	private int id;
	private int userId;
	private int pcId;
	private LocalDate bookTime;

	public TransactionDetail(int id, int userId, int pcId, LocalDate bookTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.pcId = pcId;
		this.bookTime = bookTime;
	}

	public int getPcId() {
		return pcId;
	}

	public void setPcId(int pcId) {
		this.pcId = pcId;
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

	public LocalDate getBookTime() {
		return bookTime;
	}

	public void setBookTime(LocalDate bookTime) {
		this.bookTime = bookTime;
	}
	
	
}
