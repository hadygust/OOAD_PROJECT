package view.scene.application.transaction_history;

import java.time.LocalDate;

import controller.model.TransactionController;
import controller.service.GUIService;
import controller.service.TableService;
import controller.service.observer.Data;
import controller.service.observer.Observer;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Conf;
import main.Main;
import model.TransactionDetail;
import model.TransactionHeader;
import view.Component;

public class TransactionDetailTableView extends TableView<TransactionDetail> implements Component, Observer{
	
	private TransactionController transactionCon = TransactionController.getInstace();

	private TableColumn<TransactionDetail, Integer> transactionIdColumn;
	private TableColumn<TransactionDetail, Integer> pcIdColumn;
	private TableColumn<TransactionDetail, LocalDate> bookTimeColumn;
	
	
	public TransactionDetailTableView(){
		init();
		placeItems();
		style();
		setHandler();
		
		refreshTable();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		transactionIdColumn = new TableColumn<>("Transaction ID");
		pcIdColumn = new TableColumn<>("PC ID");
		bookTimeColumn = new TableColumn<>("Book Time");
		
		TableService.setIntValue(transactionIdColumn, "id");
		TableService.setIntValue(pcIdColumn, "pcId");
		TableService.setDateValue(bookTimeColumn, "bookTime");
		
	}

	@Override
	public void placeItems() {
		// TODO Auto-generated method stub
		this.getColumns().addAll(
			transactionIdColumn,
			pcIdColumn,
			bookTimeColumn
			);
	}

	@Override
	public void style() {
		// TODO Auto-generated method stub
		transactionIdColumn.setStyle("-fx-font-size: " + Conf.TABLE_COLUMN_SIZE + "px;");
		pcIdColumn.setStyle("-fx-font-size: " + Conf.TABLE_COLUMN_SIZE + "px;");
		bookTimeColumn.setStyle("-fx-font-size: " + Conf.TABLE_COLUMN_SIZE + "px;");
		
		this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
		
	}

	@Override
	public void setHandler() {
		// TODO Auto-generated method stub
		
	}
	
	public void refreshTable() {
		this.getItems().clear();
		this.getItems().addAll(transactionCon.getUserTransactionDetails(Main.user.getId()));
	}
	
	public void refreshByID(int id) {
		this.getItems().clear();
		this.getItems().addAll(transactionCon.getTransactionDetailsByID(id));
	}

	@Override
	public void update(Data data) {
		// TODO Auto-generated method stub
		
		if(data == null) {
			this.getItems().clear();
			return;
		}
		
		TransactionHeader header = (TransactionHeader) data;
		refreshByID(header.getId());
	}
	
}
