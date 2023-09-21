package model;

import controller.service.observer.Data;

public class PC implements Data{
	private int id;
	private String condition;
	
	public PC(int id, String condition) {
		super();
		this.id = id;
		this.condition = condition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
}
