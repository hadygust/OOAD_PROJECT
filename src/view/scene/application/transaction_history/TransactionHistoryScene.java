package view.scene.application.transaction_history;

import controller.service.factory.AppMenuFactory;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import main.Conf;
import main.Main;
import view.Component;

public class TransactionHistoryScene implements Component{

	private AppMenuFactory menuFactory = AppMenuFactory.createMenuFactory();
	private String role = Main.user.getRole();
	
	TransactionDetailTableView transactionDetailTable;
	
	private MenuBar menuBar;
	
	private Scene scene;
	private BorderPane bp;
	
	
	@Override
	public void init() {
		
		bp = new BorderPane();
		scene = new Scene(bp, Conf.APP_WIDTH, Conf.APP_HEIGHT);
		
		menuBar = menuFactory.createMenu().getMenuBar();

		transactionDetailTable = new TransactionDetailTableView();
	}

	@Override
	public void placeItems() {
		// TODO Auto-generated method stub
		bp.setTop(menuBar);
		bp.setCenter(transactionDetailTable);
		bp.setBottom(new Text("shjbgfkshdfadkfhgakdh"));
	}

	@Override
	public void style() {
		// TODO Auto-generated method stub
		
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
