package model;

import javafx.scene.control.Button;

public class Job {
	
	private int id;
	private int userId;
	private int pcId;
	private String status;
	
	public Job(int id, int userId, int pcId, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.pcId = pcId;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
//	public Button getCompleteButton() {
//		Button completeButton = new Button("Complete Job");
//		
//		completeButton.setOnAction(x -> {
//			
//		});
//		
//		return completeButton;
//	}

}
