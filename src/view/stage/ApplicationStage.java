package view.stage;

import javafx.stage.Stage;
import view.scene.application.home.HomeScene;

public class ApplicationStage extends Stage{
	
	private HomeScene homeScene = null;
	
	public ApplicationStage() {
		// TODO Auto-generated constructor stub
		super();
		homeScene = new HomeScene();
		this.setScene(homeScene.getScene());
	}
	
	public void displayHome() {
		if(homeScene == null) {
			homeScene = new HomeScene();
		}
		
		
		
		setScene(homeScene.getScene());
	}
	
}
