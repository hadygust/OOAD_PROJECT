package model;

import java.time.LocalDateTime;

public class TransactionHeader {
	private int id;
	private int userId;
	private LocalDateTime transactionDate;
	
	public TransactionHeader(int id, int userId, LocalDateTime transactionDate) {
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

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
}
