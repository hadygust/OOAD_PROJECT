package view.scene.application.form;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.model.PCBookController;
import controller.model.PCController;
import controller.service.AlertService;
import controller.service.observer.Data;
import controller.service.observer.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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

public class ReportPCForm extends FormComponent{
	
	private PCController pcCon = PCController.getInstance();
	private PCBookController bookCon = PCBookController.getInstance();
	private AlertService alert = AlertService.getInstance();
	private ArrayList<Observer> obsList = new ArrayList<>();
	private PC pc = null;
	
	private FlowPane buttonFP;

	private GridPane gp;
	private Text formTitle, idTxt, dateTxt, pcIdTxt;
	private TextField idTF, pcIdTF;
	private DatePicker dateDP;

	private Button bookButton;
	
//	private Button addPcButton, deletePcButton, updatePcButton, clearButton;

	@Override
	public void init() {
		gp = new GridPane();
		buttonFP = new FlowPane();
		
		formTitle = new Text("Book PC");
		idTxt = new Text("Book Id");
		dateTxt = new Text("Book Date");
		pcIdTxt = new Text("PC ID");
		
		idTF = new TextField();
		pcIdTF = new TextField();
		
		idTF.setDisable(true);
		pcIdTF.setDisable(true);
		
		dateDP = new DatePicker();
		
		bookButton = new Button("Book PC");
	}

	@Override
	public void placeItems() {
		gp.add(idTxt, 0, 0);
		gp.add(idTF, 1, 0);
		gp.add(pcIdTxt, 0, 1);
		gp.add(pcIdTF, 1, 1);
		gp.add(dateTxt, 0, 2);
		gp.add(dateDP, 1, 2);

		buttonFP.getChildren().addAll(bookButton);
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
		
		idTF.setPrefWidth(Conf.SIDE_MENU_FORM_WIDTH);
		dateDP.setPrefWidth(Conf.SIDE_MENU_FORM_WIDTH);
		pcIdTF.setPrefWidth(Conf.SIDE_MENU_FORM_WIDTH);
		
		bookButton.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 16));
		
		buttonFP.setHgap(20);
		buttonFP.setAlignment(Pos.CENTER);
	}

	@Override
	public void setHandler() {

		bookButton.setOnMouseClicked(x -> {
			LocalDate date = dateDP.getValue();
			Pair<Boolean, String> reply = bookCon.bookPC(pc, date);
			
			if(!reply.getValue().isEmpty()) {
				alert.errorAlert("Book Failed", reply.getValue());
			} else {
				alert.infoAlert("Book Success", "Click ok to continue");
			}
		});
	}

	@Override
	public void addObserver(Observer obs) {
		obsList.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		obsList.remove(obs);
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : obsList) {
			observer.update(pc);
		}
	}

	@Override
	public void update(Data data) {
		pc = (PC) data;
		
		formTitle.setText("Book PC " + pc.getId());
		idTF.setText(bookCon.getLastId() + "");
		pcIdTF.setText(pc.getId() + "");;
		bookButton.setDisable(false);
	}

}
