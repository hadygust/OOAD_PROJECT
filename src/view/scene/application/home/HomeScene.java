package view.scene.application.home;

import java.util.ArrayList;

import controller.model.PCController;
import controller.service.factory.AppMenuFactory;
import controller.service.observer.Data;
import controller.service.observer.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import main.Conf;
import main.Main;
import model.PC;
import view.Component;
import view.scene.application.form.BookPCForm;
import view.scene.application.form.FormComponent;
import view.scene.application.form.ManagePCForm;
import view.scene.application.form.ReportPCForm;

public class HomeScene implements Component, Observer{
	
	private PCController pcCon = PCController.getInstance();
	private AppMenuFactory menuFactory = AppMenuFactory.createMenuFactory();
	private String role = Main.user.getRole();
	
	private ArrayList<PC> pcList;
	
	private MenuBar menuBar;
	
	private Scene scene;
	private BorderPane bp;
	
	private FlowPane fp, buttonFP;
	
	private VBox mainContent;
	
	private HomeFormContainer sideMenu;
	
	@Override
	public void init() {
		pcList = pcCon.getAllPC();
		
		bp = new BorderPane();
		scene = new Scene(bp, Conf.APP_WIDTH, Conf.APP_HEIGHT);
		
		fp = new FlowPane();
		
		mainContent = new VBox();
		
		sideMenu = new HomeFormContainer();
		
		if(role.equalsIgnoreCase("Admin")) {
			FormComponent manageForm = new ManagePCForm(this.sideMenu);
			manageForm.addObserver(this);
			sideMenu.addForm(manageForm);
		} else if (role.equalsIgnoreCase("Customer")) {
			FormComponent bookPcForm = new BookPCForm(this.sideMenu);
			bookPcForm.addObserver(this);
			sideMenu.addForm(bookPcForm);
			
			FormComponent reportPCForm = new ReportPCForm(this.sideMenu);
			reportPCForm.addObserver(this);
			sideMenu.addForm(reportPCForm);
		}
		
//		sideMenu.addObserver(this);
		
		buttonFP = new FlowPane();
		
		System.out.println("init home");
		menuBar = menuFactory.createMenu().getMenuBar();
	}
	
	@Override
	public void placeItems() {
		
		refreshPCItem();

		
		bp.setCenter(fp);
		bp.setTop(menuBar);
		
		// ONLY ADMIN CAN ACCESS
		if(role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("customer")) {
			bp.setRight(sideMenu);			
		}
	}
	
	public void refreshPC() {
		pcList.clear();
		
		pcList = pcCon.getAllPC();
	}
	
	public void refreshPCItem() {
		refreshPC();
		fp.getChildren().clear();
		
		for (PC pc : pcList) {
			
			PCItem pcItem = new PCItem(pc);
			for (FormComponent form : sideMenu.getFormList()) {
				pcItem.addObserver(form);
			}
			fp.getChildren().add(pcItem);
		}
	}
	
	@Override
	public void style() {
		BorderPane.setMargin(fp, new Insets(20));
		fp.setHgap(12);
		fp.setVgap(12);
		
	}
	
	@Override
	public void setHandler() {
		// TODO Auto-generated method stub
		
	}
	
	public HomeScene() {
		init();
		placeItems();
		style();
		setHandler();
	}

	public Scene getScene() {
		return scene;
	}

	@Override
	public void update(Data data) {
		refreshPCItem();
	}
	
	
}
