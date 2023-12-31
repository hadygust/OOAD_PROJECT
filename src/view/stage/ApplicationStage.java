package view.stage;

import javafx.stage.Stage;
import view.scene.application.home.HomeScene;
import view.scene.application.job_scene.JobScene;
import view.scene.application.report_scene.ReportScene;
import view.scene.application.transaction_history.TransactionHistoryScene;

public class ApplicationStage extends Stage{
	
	private HomeScene homeScene = null;
	private TransactionHistoryScene transactionHistoryScene = null;
	private JobScene jobScene = null;
	private ReportScene reportScene = null;
	
	
	public ApplicationStage() {
		// TODO Auto-generated constructor stub
		super();
		homeScene = new HomeScene();
		this.setScene(homeScene.getScene());
	}
	
	public void showHome() {
		if(homeScene == null) {
			homeScene = new HomeScene();
		}
		
		
		
		setScene(homeScene.getScene());
	}
	
	public void showTransactionHistory() {
		if(transactionHistoryScene == null) {
			transactionHistoryScene = new TransactionHistoryScene();
		}
		
		
		
		setScene(transactionHistoryScene.getScene());
//		setScene(new TransactionHistoryScene().getScene());
	}
	
	public void showJob() {
		if(jobScene == null) {
			jobScene = new JobScene();
		}
		
		setScene(jobScene.getScene());
	}
	
	public void showReport() {
		if(reportScene == null) {
			reportScene = new ReportScene();
		}
		
		setScene(reportScene.getScene());
	}
	
}
