package view.scene.application.form;

import controller.service.observer.Data;
import controller.service.observer.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import main.Conf;

public class ManagePCFormTemp extends FormComponent{

	private FlowPane buttonFP;

	private GridPane gp;
	private Text formTitle, idTxt, conditionTxt;
	private TextField idTF;
	private ComboBox<String> conditionTF;

	private Button addPcButton, deletePcButton, updatePcButton, clearButton;

	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		gp = new GridPane();
		buttonFP = new FlowPane();
		
		formTitle = new Text("PC Number");
		idTxt = new Text("Id");
		conditionTxt = new Text("Condition");
		
		idTF = new TextField();
		conditionTF = new ComboBox<>();
		conditionTF.getItems().addAll("Broken", "Usable", "Maintenance");
		
//		idTF.setDisable(true);
		conditionTF.setDisable(true);
		

		addPcButton = new Button("Add PC");
		deletePcButton = new Button("Delete PC");
		updatePcButton = new Button("Update PC");
		clearButton = new Button("Clear Form");
		
		deletePcButton.setDisable(true);
		updatePcButton.setDisable(true);
		clearButton.setDisable(true);
	}

	@Override
	public void placeItems() {

				gp.add(idTxt, 0, 0);
				gp.add(idTF, 1, 0);
				gp.add(conditionTxt, 0, 1);
				gp.add(conditionTF, 1, 1);


				buttonFP.getChildren().addAll(addPcButton, deletePcButton, updatePcButton, clearButton);

				getChildren().addAll(formTitle, gp, buttonFP);

	}

	@Override
	public void style() {
		// TODO Auto-generated method stub
		setPrefWidth(Conf.SIDE_MENU_WIDTH);
		setStyle("-fx-border-width: 0 0 0 1px; "
				+ "-fx-border-color: lightgray;");
		
		setAlignment(Pos.CENTER);
		setSpacing(52);
		setPadding(new Insets(0, 0, 60, 0));
		
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(24);
		gp.setVgap(32);
		
		formTitle.setFont(Font.font("Calibri", FontWeight.BOLD, 48));
		idTxt.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 24));
		conditionTxt.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 24));
		
//		conditionTF.setFont(Font.font(16));
		idTF.setPrefWidth(Conf.SIDE_MENU_FORM_WIDTH);
		conditionTF.setPrefWidth(Conf.SIDE_MENU_FORM_WIDTH);
		
		
		addPcButton.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 16));
		deletePcButton.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 16));
		updatePcButton.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 16));
		clearButton.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 16));
		
		buttonFP.setHgap(20);
		buttonFP.setAlignment(Pos.CENTER);
	}

	@Override
	public void setHandler() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Data data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		
	}

}
