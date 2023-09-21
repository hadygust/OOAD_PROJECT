package model;

import java.time.LocalDateTime;

public class Report {
	
	private int id;
	private int userId;
	private int pcId;
	private String note;
	private LocalDateTime date;
	
	public Report(int id, int userId, int pcId, String note, LocalDateTime date) {
		super();
		this.id = id;
		this.userId = userId;
		this.pcId = pcId;
		this.note = note;
		this.date = date;
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

	public int getPcId() {
		return pcId;
	}

	public void setPcId(int pcId) {
		this.pcId = pcId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	

}
