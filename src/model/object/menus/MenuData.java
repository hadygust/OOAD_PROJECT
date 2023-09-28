package model.object.menus;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import main.Main;

public class MenuData {
	
	public static final Menu MANAGE_PC = new Menu("Manage Pc");
	public static final Menu VIEW = new Menu("View");
	public static final Menu REPORT = new Menu("Report");
	public static final Menu STAFF = new Menu("Staff");
	
	public static final MenuItem HOME = new MenuItem("Home");
	public static final MenuItem VIEW_TRANSACTION_HISTORY = new MenuItem("Transaction History");
	
	public static final MenuItem MAKE_REPORT = new MenuItem("Make Report");
	public static final MenuItem VIEW_REPORT = new MenuItem("View Report");
	
	public static final MenuItem VIEW_STAFF = new MenuItem("View Staff");
	public static final MenuItem VIEW_JOB = new MenuItem("Job");
	
	public static Menu buildMenu(Menu menu, MenuItem... items) {
		menu.getItems().clear();
		menu.getItems().addAll(items);
		
		return menu;
	}
	
	static {
		HOME.setOnAction(x -> {
			Main.appStage.showHome();
		});
		
		VIEW_TRANSACTION_HISTORY.setOnAction(x -> {
			Main.appStage.showTransactionHistory();
			System.out.println("tr history");
		});
	}
	
}
