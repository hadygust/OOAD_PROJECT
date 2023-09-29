package model;

import java.time.LocalDate;

import controller.service.observer.Data;

public class TransactionHeader implements Data{
	private int id;
	private int userId;
	private LocalDate transactionDate;
	
	public TransactionHeader(int id, int userId, LocalDate transactionDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.transactionDate = transactionDate;
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

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
}
