package controller.service;

import java.time.LocalDate;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import model.TransactionDetail;

public class TableService {
	
	public static void setIntValue(TableColumn<TransactionDetail, Integer> col, String name) {
		col.setCellValueFactory(new PropertyValueFactory<>(name));
	}
	
	public static void setDateValue(TableColumn<TransactionDetail, LocalDate> col, String name) {
		col.setCellValueFactory(new PropertyValueFactory<>(name));
	}
	
	public static void setStringValue(TableColumn<TransactionDetail, String> col, String name) {
		col.setCellValueFactory(new PropertyValueFactory<>(name));
	}

}
