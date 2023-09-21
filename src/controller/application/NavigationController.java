package controller.application;

import javafx.stage.Stage;
import main.Main;
import model.object.menus.MenuData;
import view.scene.application.home.HomeScene;
import view.stage.ApplicationStage;

public class NavigationController {
	
	static {
		MenuData.HOME.setOnAction(x -> {
			Main.appStage.setScene(new HomeScene().getScene());
		});
		
//		MenuData.
	}

}
