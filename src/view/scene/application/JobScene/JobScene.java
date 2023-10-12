package view.scene.application.JobScene;

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
import view.scene.application.transaction_history.TransactionDetailTableView;
import view.scene.application.transaction_history.TransactionHeaderTableView;

public class JobScene implements Component {
	
	private AppMenuFactory menuFactory = AppMenuFactory.createMenuFactory();
	private String role = Main.user.getRole();
	
	private ScrollPane sp;
	
	private HBox hb;
	
	private VBox vb;
	
	private MenuBar menuBar;
	
	private Text jobTitle;
	
	private JobTableView jobTable;	
//	private TransactionHeaderTableView transactionHeaderTable;
	
	private Scene scene;
	private BorderPane bp;
	
	
	@Override
	public void init() {
		
		bp = new BorderPane();
		scene = new Scene(bp, Conf.APP_WIDTH, Conf.APP_HEIGHT);
		
		sp = new ScrollPane();
		hb = new HBox();
		
		vb = new VBox();
//		headerVb = new VBox();
		
		jobTitle = new Text("Jobs");
//		headerTitle = new Text("Transaction Headers");
		menuBar = menuFactory.createMenu().getMenuBar();
		
		jobTable = new JobTableView();
//		transactionHeaderTable = new TransactionHeaderTableView();
	}

	@Override
	public void placeItems() {

//		if(Main.user.getRole().equalsIgnoreCase("Admin")) {
//			TransactionHeaderTableView transactionHeaderTable = new TransactionHeaderTableView();
//			transactionHeaderTable.addObserver(jobTable);
//			detailVb.getChildren().addAll(headerTitle, transactionHeaderTable);			
//		}

		vb.getChildren().addAll(jobTitle, jobTable);
		
		sp.setContent(vb);
		
		bp.setTop(menuBar);
		bp.setCenter(sp);
	}

	@Override
	public void style() {
		// TODO Auto-generated method stub
		sp.setFitToWidth(true);
		sp.setPadding(new Insets(0, 0, 60, 0));
		hb.setAlignment(Pos.CENTER);
		
		jobTitle.setFont(Font.font("Calibri", FontWeight.BOLD, Conf.TITLE_FONT));
		
		vb.setPadding(new Insets(Conf.DEFAULT_PADDING));
		
		vb.setSpacing(40);
		vb.setAlignment(Pos.CENTER);
	}

	@Override
	public void setHandler() {
		// TODO Auto-generated method stub
		
	}
	
	public JobScene() {
		init();
		placeItems();
		style();
		setHandler();
	}
	
	public Scene getScene() {
		return scene;
	}
	

}
