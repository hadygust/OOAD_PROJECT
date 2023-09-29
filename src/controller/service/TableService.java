package controller.service;

import java.time.LocalDate;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableService <T>{
	
	public static void setIntValue(TableColumn<?, Integer> col, String name) {
		col.setCellValueFactory(new PropertyValueFactory<>(name));
	}
	
	public static void setDateValue(TableColumn<?, LocalDate> col, String name) {
		col.setCellValueFactory(new PropertyValueFactory<>(name));
	}
	
	public static void setStringValue(TableColumn<?, String> col, String name) {
		col.setCellValueFactory(new PropertyValueFactory<>(name));
	}

}
