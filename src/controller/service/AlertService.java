package controller.service;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;
import main.Main;

public class AlertService {
	
	private static AlertService instance = null;
	private Alert alert = null;
	
	private AlertService() {
		alert = new Alert(AlertType.ERROR);
		setOwner(Main.appStage);
	}
	
	private void setOwner(Window window) {
		// Cannot set owner once stage has been set visible
//		if (window == null) {
//			alert.initOwner(window);
//		} else {
//			if (!window.isShowing()) {
//				alert.initOwner(window);
//			}
//		}
		
	}
	
	public static synchronized AlertService getInstance() {
		return instance = (instance == null) ? new AlertService() : instance;
	}
	
	public void errorAlert(String header, String content) {
		setOwner(Main.appStage);
		alert.setAlertType(AlertType.ERROR);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}

	public void infoAlert(String header, String content) {
		setOwner(Main.appStage);
		alert.setAlertType(AlertType.INFORMATION);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}

	public void warningAlert(String header, String content) {
		setOwner(Main.appStage);
		alert.setAlertType(AlertType.WARNING);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}
	
	public void confirmAlert(String header, String content) {
		setOwner(Main.appStage);
		alert.setAlertType(AlertType.CONFIRMATION);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}
}
