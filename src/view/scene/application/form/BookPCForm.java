package view.scene.application.form;

import java.util.ArrayList;

import controller.model.PCController;
import controller.service.AlertService;
import controller.service.observer.Data;
import controller.service.observer.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Pair;
import main.Conf;
import model.PC;

public class BookPCForm extends FormComponent{

	private PCController pcCon = PCController.getInstance();
	private AlertService alert = AlertService.getInstance();
	private ArrayList<Observer> obsList = new ArrayList<>();
	private PC pc = null;
	
	private FlowPane buttonFP;

	private GridPane gp;
	private Text formTitle, idTxt, dateTxt, pcIdTxt;
	private TextField idTF, pcIdTF;
	private DatePicker dateDP;

//	private Button addPcButton, deletePcButton, updatePcButton, clearButton;

	@Override
	public void init() {
		gp = new GridPane();
		buttonFP = new FlowPane();
		
		formTitle = new Text("PC Number");
		idTxt = new Text("Id");
		dateTxt = new Text("Book Date");
		pcIdTxt = new Text("PC ID");
		
		idTF = new TextField();
		pcIdTF = new TextField();
		
//		idTF.setDisable(true);
		pcIdTF.setDisable(true);
		
		dateDP = new DatePicker();
		

//		addPcButton = new Button("Add PC");
//		deletePcButton = new Button("Delete PC");
//		updatePcButton = new Button("Update PC");
//		clearButton = new Button("Clear Form");
//		
//		deletePcButton.setDisable(true);
//		updatePcButton.setDisable(true);
//		clearButton.setDisable(true);
	}

	@Override
	public void placeItems() {
		gp.add(idTxt, 0, 0);
		gp.add(idTF, 1, 0);
		gp.add(dateTxt, 0, 1);
		gp.add(dateDP, 1, 1);
		gp.add(pcIdTxt, 0, 2);
		gp.add(pcIdTF, 1, 2);


//		buttonFP.getChildren().addAll(addPcButton, deletePcButton, updatePcButton, clearButton);

		getChildren().addAll(formTitle, gp, buttonFP);

	}

	@Override
	public void style() {
		setPrefWidth(Conf.SIDE_MENU_WIDTH);
		
		setAlignment(Pos.CENTER);
		setSpacing(52);
		setPadding(new Insets(0, 0, 60, 0));
		
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(24);
		gp.setVgap(32);
		
		formTitle.setFont(Font.font("Calibri", FontWeight.BOLD, 48));
		idTxt.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 24));
		dateTxt.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 24));
		pcIdTxt.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 24));
		
//		conditionTF.setFont(Font.font(16));
		idTF.setPrefWidth(Conf.SIDE_MENU_FORM_WIDTH);
		dateDP.setPrefWidth(Conf.SIDE_MENU_FORM_WIDTH);
		pcIdTF.setPrefWidth(Conf.SIDE_MENU_FORM_WIDTH);
		
		
//		addPcButton.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 16));
//		deletePcButton.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 16));
//		updatePcButton.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 16));
//		clearButton.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 16));
		
		buttonFP.setHgap(20);
		buttonFP.setAlignment(Pos.CENTER);
	}

	@Override
	public void setHandler() {
		// TODO Auto-generated method stub
//		addPcButton.setOnMouseClicked(x -> {
//			Pair<Boolean, String> reply = pcCon.addNewPC(idTF.getText());
//			
//			if(reply.getKey()) {
//				notifyObserver();
//				reset();
//			} else {
//				alert.errorAlert("Add PC Failed!", reply.getValue());
//			}
//		});
//		
//		deletePcButton.setOnMouseClicked(x -> {
//			Pair<Boolean, String> reply = pcCon.deletePC(pc);
//			System.out.println("Click del");
//			for (Observer observer : obsList) {
//				System.out.println(observer);
//			}
//			if(reply.getKey()) {
//				notifyObserver();	
//				reset();
//			} else {
//				alert.errorAlert("Delete Failed!", reply.getValue());
//			}
//		});
//		
//		updatePcButton.setOnMouseClicked(x -> {
//			
//			pcCon.updatePCCondition(pc, conditionTF.getValue());
//			notifyObserver();
//		});
//		
//		clearButton.setOnMouseClicked(x -> {
//			reset();
//		});
	}
	
	public void reset() {

		pc = null;
		
		formTitle.setText("PC Number");
		dateDP.setValue(null);
		
		idTF.setText("");
		
//		deletePcButton.setDisable(true);
//		updatePcButton.setDisable(true);
//		clearButton.setDisable(true);
//		addPcButton.setDisable(false);
		
		idTF.setDisable(false);
		
	}
	
	public BookPCForm() {
		 init();
		 placeItems();
		 style();
		 setHandler();
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
