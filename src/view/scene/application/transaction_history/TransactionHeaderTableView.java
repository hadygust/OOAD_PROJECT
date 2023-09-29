package view.scene.application.transaction_history;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.model.TransactionController;
import controller.service.TableService;
import controller.service.observer.Observer;
import controller.service.observer.Subject;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Conf;
import main.Main;
import model.TransactionDetail;
import model.TransactionHeader;
import view.Component;

public class TransactionHeaderTableView extends TableView<TransactionHeader> implements Component, Subject{

	private TransactionController transactionCon = TransactionController.getInstace();
	
	private ArrayList<Observer> obsList = new ArrayList<>();
	
	private TransactionHeader selected = null;

	private TableColumn<TransactionHeader, Integer> transactionIdColumn;
	private TableColumn<TransactionHeader, Integer> userIdColumn;
	private TableColumn<TransactionHeader, LocalDate> transactionDateColumn;
	
	public TransactionHeaderTableView(){
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
		userIdColumn = new TableColumn<>("User ID");
		transactionDateColumn = new TableColumn<>("Transaction Date");
		
		TableService.setIntValue(transactionIdColumn, "id");
		TableService.setIntValue(userIdColumn, "userId");
		TableService.setDateValue(transactionDateColumn, "transactionDate");
		
	}

	@Override
	public void placeItems() {
		// TODO Auto-generated method stub
		this.getColumns().addAll(
			transactionIdColumn,
			userIdColumn,
			transactionDateColumn
			);
	}

	@Override
	public void style() {
		// TODO Auto-generated method stub
		transactionIdColumn.setStyle("-fx-font-size: " + Conf.TABLE_COLUMN_SIZE + "px;");
		userIdColumn.setStyle("-fx-font-size: " + Conf.TABLE_COLUMN_SIZE + "px;");
		transactionDateColumn.setStyle("-fx-font-size: " + Conf.TABLE_COLUMN_SIZE + "px;");
		
		this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
		
	}

	@Override
	public void setHandler() {
		// TODO Auto-generated method stub
		this.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TransactionHeader>() {

			@Override
			public void changed(ObservableValue<? extends TransactionHeader> observable, TransactionHeader oldValue,
					TransactionHeader newValue) {
				// TODO Auto-generated method stub
				selected = newValue;
				notifyObserver();
			}
		});
	}
	
	public void refreshTable() {
		this.getItems().clear();
		
		this.getItems().addAll(transactionCon.getAllTransactionHeaders());
	}

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		obsList.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		obsList.remove(obs);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (Observer observer : obsList) {
			observer.update(selected);
		}
	}
	
	
}
