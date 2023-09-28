package view.scene.application.transaction_history;

import java.time.LocalDate;

import controller.service.TableService;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.TransactionDetail;
import view.Component;

public class TransactionDetailTableView extends TableView<TransactionDetail> implements Component{

	private TableColumn<TransactionDetail, Integer> transactionIdColumn;
	private TableColumn<TransactionDetail, Integer> pcIdColumn;
	private TableColumn<TransactionDetail, LocalDate> bookTimeColumn;
	
	private PropertyValueFactory<TransactionDetail, Integer> transactionIdValue;
	
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
		
	}

	@Override
	public void setHandler() {
		// TODO Auto-generated method stub
		
	}
	
}
