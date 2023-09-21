package view.scene.authentication;

import controller.authentication.AuthenticationController;
import controller.model.UserController;
import controller.service.AlertService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Pair;
import model.User;
import view.Component;

public class RegisterScene implements Component{
	private AuthenticationController authController = AuthenticationController.getInstance();
	private UserController userController = UserController.getInstance();
	private AlertService alert = AlertService.getInstance();
	
	private Scene scene;
	private BorderPane bp;
	
	private VBox vb;
	private GridPane gp;
	private FlowPane idFP, usernameFP, passwordFP, confirmFP, ageFP, buttonFP;
	
	private Text title;
	private Text idTxt, usernameTxt, passwordTxt, confirmTxt, ageTxt;
	
	private TextField idTF, usernameTF;
	private PasswordField passwordPF, confirmPF;
	private Spinner<Integer> ageSP;
	
	private Button loginBtn, registerBtn;
	
	@Override
	public void init() {
		bp = new BorderPane();
		scene = new Scene(bp, 400, 500);
		
		gp = new GridPane();
		
		vb = new VBox();
		idFP = new FlowPane();
		usernameFP = new FlowPane();
		passwordFP = new FlowPane();
		confirmFP = new FlowPane();
		ageFP = new FlowPane();
		buttonFP = new FlowPane();
		
		title = new Text("Register");
		
		idTxt = new Text("ID");
		usernameTxt = new Text("Username");
		passwordTxt = new Text("Password");
		confirmTxt = new Text("Confirm Password");
		ageTxt = new Text("Age");
		
		idTF = new TextField();
		idTF.setDisable(true);
		idTF.setText((userController.getLastId() + 1) + "");
		usernameTF = new TextField();
		passwordPF = new PasswordField();
		confirmPF = new PasswordField();
		
		ageSP = new Spinner<>(new IntegerSpinnerValueFactory(13, 65));
		
		loginBtn = new Button("Login");
		registerBtn = new Button("Register");
	}

	@Override
	public void placeItems() {
		// TODO Auto-generated method stub
		
//		idFP.getChildren().addAll(idTxt, idTF);
//		usernameFP.getChildren().addAll(usernameTxt, usernameTF);
//		passwordFP.getChildren().addAll(passwordTxt, passwordPF);
//		confirmFP.getChildren().addAll(confirmTxt, confirmPF);
//		ageFP.getChildren().addAll(ageTxt, ageSP);
		
		gp.add(idTxt, 0, 0);
		gp.add(idTF, 1, 0);
		gp.add(usernameTxt, 0, 1);
		gp.add(usernameTF, 1, 1);
		gp.add(passwordTxt, 0, 2);
		gp.add(passwordPF, 1, 2);
		gp.add(confirmTxt, 0, 3);
		gp.add(confirmPF, 1, 3);
		gp.add(ageTxt, 0, 4);
		gp.add(ageSP, 1, 4);
		
		buttonFP.getChildren().addAll(loginBtn, registerBtn);
		
		vb.getChildren().addAll(
				title,
				gp,
//				idFP,
//				usernameFP,
//				passwordFP,
//				confirmFP, 
//				ageFP,
				buttonFP);
		
		bp.setCenter(vb);
	}

	@Override
	public void style() {
		// TODO Auto-generated method stub
		title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		
		idTxt.setFont(Font.font("Calibri", FontWeight.MEDIUM, 16));
		usernameTxt.setFont(Font.font("Calibri", FontWeight.MEDIUM, 16));
		passwordTxt.setFont(Font.font("Calibri", FontWeight.MEDIUM, 16));
		confirmTxt.setFont(Font.font("Calibri", FontWeight.MEDIUM, 16));
		ageTxt.setFont(Font.font("Calibri", FontWeight.MEDIUM, 16));
		
		idFP.setAlignment(Pos.CENTER);
		usernameFP.setAlignment(Pos.CENTER);
		passwordFP.setAlignment(Pos.CENTER);
		confirmFP.setAlignment(Pos.CENTER);
		ageFP.setAlignment(Pos.CENTER);
		buttonFP.setAlignment(Pos.CENTER);

		idFP.setHgap(10);
		usernameFP.setHgap(10);
		passwordFP.setHgap(10);
		confirmFP.setHgap(10);
		ageFP.setHgap(10);
		buttonFP.setHgap(10);
		
		loginBtn.setPrefWidth(80);
		loginBtn.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		registerBtn.setPrefWidth(80);
		registerBtn.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		
		vb.setAlignment(Pos.CENTER);
		vb.setSpacing(20);
		
		bp.setMargin(buttonFP, new Insets(10, 0, 20, 0));
	}

	@Override
	public void setHandler() {
		// TODO Auto-generated method stub
		loginBtn.setOnMouseClicked(x -> {
			
			authController.goToLogin();
		});
		
		registerBtn.setOnMouseClicked(x -> {
			
			String username = usernameTF.getText();
			String password = passwordPF.getText();
			String confirm = confirmPF.getText();
			int age = ageSP.getValue();
			
			Pair<User, String> data = authController.register(username, password, confirm, age);
			User user = data.getKey();
			String message = data.getValue();
			
			if(!message.isEmpty()) {
				alert.errorAlert("Register Failed", message);
			} else {
				authController.goToApp();
			}
		});
	}

	public RegisterScene() {
		super();
		init();
		placeItems();
		style();
		setHandler();
	}

	public void reset() {
		usernameTF.setText("");;
		passwordPF.setText("");;
		confirmPF.setText("");;
		
		ageSP.setValueFactory(new IntegerSpinnerValueFactory(13, 65));;
	}
	
	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
}
