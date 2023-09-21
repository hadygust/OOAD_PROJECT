package controller.service;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertService {
	
	private static AlertService instance = null;
	
	private AlertService() {}
	
	public static synchronized AlertService getInstance() {
		return instance = (instance == null) ? new AlertService() : instance;
	}
	
	public void errorAlert(String header, String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}

	public void infoAlert(String header, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}

	public void warningAlert(String header, String content) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}
	
	public void confirmAlert(String header, String content) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}
}
