package view.scene.application.report_scene;

import java.time.LocalDate;

import controller.model.ReportPCController;
import controller.service.TableService;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.Conf;
import model.Report;
import view.Component;

public class ReportTableView extends TableView<Report> implements Component{
	
	private ReportPCController reportCon = ReportPCController.getInstance();

	private TableColumn<Report, Integer> jobIdColumn;
	private TableColumn<Report, Integer> userIdColumn;
	private TableColumn<Report, Integer> pcIdColumn;
	private TableColumn<Report, String> noteColumn;
	private TableColumn<Report, LocalDate> dateColumn;
	
	
	public ReportTableView(){
		init();
		placeItems();
		style();
		setHandler();
		
		refreshTable();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		jobIdColumn = new TableColumn<>("Report ID");
		userIdColumn = new TableColumn<>("User ID");
		pcIdColumn = new TableColumn<>("PC ID");
		noteColumn = new TableColumn<>("Note");
		dateColumn = new TableColumn<>("Action");
		
		TableService.setIntValue(jobIdColumn, "id");
		TableService.setIntValue(userIdColumn, "userId");
		TableService.setIntValue(pcIdColumn, "pcId");
		TableService.setStringValue(noteColumn, "note");
		TableService.setDateValue(dateColumn, "date");
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void placeItems() {
		// TODO Auto-generated method stub
		this.getColumns().addAll(
			jobIdColumn,
			pcIdColumn,
			noteColumn,
			dateColumn
			);
	}

	@Override
	public void style() {
		// TODO Auto-generated method stub
		jobIdColumn.setStyle("-fx-font-size: " + Conf.TABLE_COLUMN_SIZE + "px;");
		pcIdColumn.setStyle("-fx-font-size: " + Conf.TABLE_COLUMN_SIZE + "px;");
		noteColumn.setStyle("-fx-font-size: " + Conf.TABLE_COLUMN_SIZE + "px;");
		
		this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
		
	}

	@Override
	public void setHandler() {
		// TODO Auto-generated method stub
		
	}
	
	public void refreshTable() {
		System.out.println("asdasd ripres");
		this.getItems().clear();
		this.getItems().addAll(reportCon.getAllReport());
	}
	
}
