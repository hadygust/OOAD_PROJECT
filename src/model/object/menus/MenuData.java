package model.object.menus;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import main.Main;

public class MenuData {
	
//	private static final Menu MANAGE_PC = new Menu("Manage Pc");
//	private static final Menu VIEW = new Menu("View");
//	private static final Menu REPORT = new Menu("Report");
//	private static final Menu STAFF = new Menu("Staff");
//	
//	private static final MenuItem HOME = new MenuItem("Home");
//	private static final MenuItem VIEW_TRANSACTION_HISTORY = new MenuItem("Transaction History");
//	
//	private static final MenuItem MAKE_REPORT = new MenuItem("Make Report");
//	private static final MenuItem VIEW_REPORT = new MenuItem("View Report");
//	
//	private static final MenuItem VIEW_STAFF = new MenuItem("View Staff");
//	private static final MenuItem VIEW_JOB = new MenuItem("Job");
	
	public static Menu buildMenu(Menu menu, MenuItem... items) {
		menu.getItems().clear();
		menu.getItems().addAll(items);
		
		return menu;
	}
	
	static {
//		HOME.setOnAction(x -> {
//			Main.appStage.showHome();
//		});
//		
//		VIEW_TRANSACTION_HISTORY.setOnAction(x -> {
//			Main.appStage.showTransactionHistory();
//			System.out.println("tr history");
//		});
//		
//		VIEW_JOB.setOnAction(x -> {
//			Main.appStage.showJob();
//		});
	}

	public static Menu getManagePc() {
		return new Menu("Manage Pc");
	}

	public static Menu getView() {
		return new Menu("View");
	}

	public static Menu getReport() {
		return new Menu("Report");
	}

	public static Menu getStaff() {
		return new Menu("Staff");
	}

	public static MenuItem getHome() {
		MenuItem home = new MenuItem("Home");
		
		home.setOnAction(x -> {
			Main.appStage.showHome();
		});
		
		return home;
	}

	public static MenuItem getViewTransactionHistory() {
		
		
		MenuItem transactionHistory =  new MenuItem("Transaction History");
		
		transactionHistory.setOnAction(x -> {
			Main.appStage.showTransactionHistory();
		});
		
		return transactionHistory;
	}

	public static MenuItem getMakeReport() {
		return new MenuItem("Make Report");
	}

	public static MenuItem getViewReport() {
		return new MenuItem("View Report");
	}

	public static MenuItem getViewStaff() {
		return new MenuItem("View Staff");
	}

	public static MenuItem getViewJob() {
		MenuItem job = new MenuItem("Job");
		
		job.setOnAction(x -> {
			Main.appStage.showJob();
		});
		
		return job;
	}
	
	
	
}
