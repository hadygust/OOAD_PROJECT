package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.User;
import view.stage.ApplicationStage;
import view.stage.AuthenticationStage;

public class Main extends Application{
	
	public static User user = null;
	
	public static ApplicationStage appStage = null;
	public static AuthenticationStage authStage = null;
	
	public static void main(String[] args) {
		launch();
		System.out.println("asd");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		authStage = new AuthenticationStage();
		
		showAuth();
		
//		Stage stage = new Stage();
//		stage.setScene(new Scene(new BorderPane(), 111, 111));
//		stage.show();
	}
	
	public static void showApp() {
		if(appStage == null) {
			appStage = new ApplicationStage();
			System.out.println("appcreated");
		}
		if(authStage != null && authStage.isShowing()) {
			authStage.close();
		}
		appStage.setFullScreen(true);
		appStage.setResizable(false);
		appStage.show();
	}
	
	public static void showAuth() {
		if(appStage != null && appStage.isShowing()) {
			appStage.close();
		}
		authStage.show();
	}
	
}
