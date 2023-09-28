package view.scene.application.form;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.model.PCBookController;
import controller.model.PCController;
import controller.model.ReportPCController;
import controller.service.AlertService;
import controller.service.observer.Data;
import controller.service.observer.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Pair;
import main.Conf;
import model.PC;
import view.scene.application.home.HomeFormContainer;

public class ReportPCForm extends FormComponent{
	
	private ReportPCController reportCon = ReportPCController.getInstance();
	private PCBookController bookCon = PCBookController.getInstance();
	private AlertService alert = AlertService.getInstance();
	private ArrayList<Observer> obsList = new ArrayList<>();
	private PC pc = null;
	
	private FlowPane buttonFP;

	private GridPane gp;
	private Text formTitle, idTxt, noteTxt, pcIdTxt;
	private TextField pcIdTF;
	private TextArea noteTA;

	private Button reportButton;
	
//	private Button addPcButton, deletePcButton, updatePcButton, clearButton;

	@Override
	public void init() {
		gp = new GridPane();
		buttonFP = new FlowPane();
		
		formTitle = new Text("Report PC");
		noteTxt = new Text("Report Note");
		pcIdTxt = new Text("PC ID");
		
		pcIdTF = new TextField();
		
		pcIdTF.setDisable(true);

		noteTA = new TextArea();
		
		reportButton = new Button("Report PC");
	}
	
	public ReportPCForm(HomeFormContainer container) {
		super(container);
		if(container == null) {
			System.out.println("Container null");
		} else {
			System.out.println("Not null");
		}
		init();
		placeItems();
		style();
		setHandler();
	}

	@Override
	public void placeItems() {
		gp.add(pcIdTxt, 0, 0);
		gp.add(pcIdTF, 1, 0);
		gp.add(noteTxt, 0, 1);
		gp.add(noteTA, 1, 1);

		buttonFP.getChildren().addAll(reportButton);
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
		noteTxt.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 24));
		pcIdTxt.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 24));
		
		noteTxt.setTextOrigin(VPos.TOP);
		
		pcIdTF.setPrefWidth(Conf.SIDE_MENU_FORM_WIDTH);
		
		reportButton.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 16));
		
		buttonFP.setHgap(20);
		buttonFP.setAlignment(Pos.CENTER);
	}

	@Override
	public void setHandler() {

		reportButton.setOnMouseClicked(x -> {
			
			String note = noteTA.getText();
			
			Pair<Boolean, String> reply = reportCon.addReport(pc, note);
			
			if(!reply.getValue().isEmpty()) {
				alert.errorAlert("Add Report Failed", reply.getValue());
			}
			
			alert.infoAlert("Report Added Successfully!", "Press ok to continue");
			container.resetForm();
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
		
		formTitle.setText("Report PC " + pc.getId());
		pcIdTF.setText(pc.getId() + "");;
		reportButton.setDisable(false);
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		formTitle.setText("Report PC");
		pcIdTF.setText("");
		noteTA.setText("");
	}

}
