package view.scene.authentication;

import controller.authentication.AuthenticationController;
import controller.service.AlertService;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Pair;
import model.User;
import view.Component;

public class LoginScene implements Component{
	
	AuthenticationController authController = AuthenticationController.getInstance();
	AlertService alert = AlertService.getInstance();
	
	private Scene scene;
	private BorderPane bp;
	
	private VBox vb;
	private FlowPane usernameFP, passwordFP, buttonFP;
	
	private Text title;
	private Text usernameTxt, passwordTxt;
	
	private TextField usernameTF;
	private PasswordField passwordPF;
	
	private Button loginBtn, registerBtn;
	
	@Override
	public void init() {
		bp = new BorderPane();
		scene = new Scene(bp, 400, 500);
		
		vb = new VBox();
		usernameFP = new FlowPane();
		passwordFP = new FlowPane();
		buttonFP = new FlowPane();
		
		title = new Text("Login");
		
		usernameTxt = new Text("Username");
		passwordTxt = new Text("Password");
		
		usernameTF = new TextField();
		passwordPF = new PasswordField();
		
		loginBtn = new Button("Login");
		registerBtn = new Button("Register");
	}

	@Override
	public void placeItems() {
		// TODO Auto-generated method stub
		
		usernameFP.getChildren().addAll(usernameTxt, usernameTF);
		passwordFP.getChildren().addAll(passwordTxt, passwordPF);
		buttonFP.getChildren().addAll(loginBtn, registerBtn);
		
		vb.getChildren().addAll(
				title,
				usernameFP,
				passwordFP,
				buttonFP);
		
		bp.setCenter(vb);
	}

	@Override
	public void style() {
		// TODO Auto-generated method stub
		title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		
		usernameTxt.setFont(Font.font("Calibri", FontWeight.MEDIUM, 16));
		passwordTxt.setFont(Font.font("Calibri", FontWeight.MEDIUM, 16));
		
		usernameFP.setAlignment(Pos.CENTER);
		passwordFP.setAlignment(Pos.CENTER);
		buttonFP.setAlignment(Pos.CENTER);
		
		usernameFP.setHgap(10);
		passwordFP.setHgap(10);
		buttonFP.setHgap(10);
		
		loginBtn.setPrefWidth(80);
		loginBtn.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		registerBtn.setPrefWidth(80);
		registerBtn.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		
		vb.setAlignment(Pos.CENTER);
		vb.setSpacing(20);
	}

	@Override
	public void setHandler() {
		// TODO Auto-generated method stub
		loginBtn.setOnMouseClicked(x -> {
			
			String username = usernameTF.getText();
			String password = passwordPF.getText();
			
			Pair<User, String> data = authController.login(username, password);
			User user = data.getKey();
			String message = data.getValue();
			
			if(!message.isEmpty()) {
				alert.errorAlert("Login Failed!", message);
			} else if (user == null) {
				alert.errorAlert("Login Failed!", "Wrong Username or Password");
			} else {
				authController.goToApp();
			}
		});
		
		registerBtn.setOnMouseClicked(x -> {
			System.out.println("movemovemove");
			authController.goToRegister();
		});
	}

	public LoginScene() {
		super();
		init();
		placeItems();
		style();
		setHandler();
	}
	
	public void reset() {
		this.passwordPF.setText("");
		this.usernameTF.setText("");
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
}
