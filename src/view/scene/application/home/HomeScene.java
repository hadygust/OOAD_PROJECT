package view.scene.application.home;

import java.util.ArrayList;

import controller.model.PCController;
import controller.service.observer.Data;
import controller.service.observer.Observer;
import controller.service.patterns.AppMenuFactory;
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
import view.scene.application.form.ManagePCForm;

public class HomeScene implements Component, Observer{
	
	private PCController pcCon = PCController.getInstance();
	private AppMenuFactory menuFactory = AppMenuFactory.createMenuFactory();
	
	private ArrayList<PC> pcList;
	
	private MenuBar menuBar;
	
	private Scene scene;
	private BorderPane bp;
	
	private FlowPane fp, buttonFP;
	
	private VBox mainContent;
	
	private ManagePCForm sideMenu;
	
	@Override
	public void init() {
		pcList = pcCon.getAllPC();
		
		bp = new BorderPane();
		scene = new Scene(bp, Conf.APP_WIDTH, Conf.APP_HEIGHT);
		
		fp = new FlowPane();
		
		mainContent = new VBox();
		
		sideMenu = new ManagePCForm();
		sideMenu.addObserver(this);
		
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
		if(Main.user.getRole().toLowerCase().equals("admin")) {
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
			pcItem.addObserver(sideMenu);
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
