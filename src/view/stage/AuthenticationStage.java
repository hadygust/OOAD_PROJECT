package view.stage;

import javafx.stage.Stage;
import view.scene.authentication.LoginScene;
import view.scene.authentication.RegisterScene;

public class AuthenticationStage extends Stage{

	LoginScene loginScene = null;
	RegisterScene registerScene = null;
	
	public AuthenticationStage() {
		loginScene = new LoginScene();
		this.setScene(loginScene.getScene());
	}
	
	public void displayLogin() {
		if(loginScene == null) loginScene = new LoginScene();
		loginScene.reset();
		setScene(loginScene.getScene());
	}
	
	public void displayRegister() {
		if(registerScene == null) registerScene = new RegisterScene();
		registerScene.reset();
		setScene(registerScene.getScene());
	}

}
