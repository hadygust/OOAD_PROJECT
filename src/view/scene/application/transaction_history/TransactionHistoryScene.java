package view.scene.application.transaction_history;

import controller.service.factory.AppMenuFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import main.Conf;
import main.Main;
import view.Component;

public class TransactionHistoryScene implements Component{

	private AppMenuFactory menuFactory = AppMenuFactory.createMenuFactory();
	private String role = Main.user.getRole();
	
	private ScrollPane sp;
	
	private HBox hb;
	
	private VBox detailVb, headerVb;
	
	private MenuBar menuBar;
	
	private Text detailTitle, headerTitle;
	
	private TransactionDetailTableView transactionDetailTable;	
//	private TransactionHeaderTableView transactionHeaderTable;
	
	private Scene scene;
	private BorderPane bp;
	
	
	@Override
	public void init() {
		
		bp = new BorderPane();
		scene = new Scene(bp, Conf.APP_WIDTH, Conf.APP_HEIGHT);
		
		sp = new ScrollPane();
		hb = new HBox();
		
		detailVb = new VBox();
		headerVb = new VBox();
		
		detailTitle = new Text("Transaction Details");
		headerTitle = new Text("Transaction Headers");
		menuBar = menuFactory.createMenu().getMenuBar();
		
		transactionDetailTable = new TransactionDetailTableView();
//		transactionHeaderTable = new TransactionHeaderTableView();
	}

	@Override
	public void placeItems() {

		if(Main.user.getRole().equalsIgnoreCase("Admin")) {
			TransactionHeaderTableView transactionHeaderTable = new TransactionHeaderTableView();
			transactionHeaderTable.addObserver(transactionDetailTable);
			detailVb.getChildren().addAll(headerTitle, transactionHeaderTable);			
		}

		detailVb.getChildren().addAll(detailTitle, transactionDetailTable);
		
		sp.setContent(detailVb);
		
		bp.setTop(menuBar);
		bp.setCenter(sp);
	}

	@Override
	public void style() {
		// TODO Auto-generated method stub
		sp.setFitToWidth(true);
		sp.setPadding(new Insets(0, 0, 60, 0));
		hb.setAlignment(Pos.CENTER);
		
		detailTitle.setFont(Font.font("Calibri", FontWeight.BOLD, Conf.TITLE_FONT));
		headerTitle.setFont(Font.font("Calibri", FontWeight.BOLD, Conf.TITLE_FONT));
		
		detailVb.setPadding(new Insets(Conf.DEFAULT_PADDING));
		headerVb.setPadding(new Insets(Conf.DEFAULT_PADDING));
		
		detailVb.setSpacing(40);
		detailVb.setAlignment(Pos.CENTER);
		headerVb.setSpacing(40);
		headerVb.setAlignment(Pos.CENTER);
	}

	@Override
	public void setHandler() {
		// TODO Auto-generated method stub
		
	}
	
	public TransactionHistoryScene() {
		init();
		placeItems();
		style();
		setHandler();
	}
	
	public Scene getScene() {
		return scene;
	}
	
}
