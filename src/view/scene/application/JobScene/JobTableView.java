package view.scene.application.JobScene;

import java.time.LocalDate;

import controller.model.JobController;
import controller.model.TransactionController;
import controller.service.GUIService;
import controller.service.TableService;
import controller.service.observer.Data;
import controller.service.observer.Observer;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import main.Conf;
import main.Main;
import model.Job;
import model.TransactionDetail;
import model.TransactionHeader;
import view.Component;

public class JobTableView extends TableView<Job> implements Component{
	
	private JobController jobCon = JobController.getInstance();

	private TableColumn<Job, Integer> jobIdColumn;
	private TableColumn<Job, Integer> pcIdColumn;
	private TableColumn<Job, String> statusColumn;
	private TableColumn<Job, Button> completeColumn;
	
	
	public JobTableView(){
		init();
		placeItems();
		style();
		setHandler();
		
		refreshTable();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		jobIdColumn = new TableColumn<>("Job ID");
		pcIdColumn = new TableColumn<>("PC ID");
		statusColumn = new TableColumn<>("Status");
		completeColumn = new TableColumn<>("Action");
		

		completeColumn.setCellFactory(new Callback<TableColumn<Job,Button>, TableCell<Job,Button>>() {

			@Override
			public TableCell<Job, Button> call(TableColumn<Job, Button> param) {
				
				final TableCell<Job, Button> tc = new TableCell<Job, Button>() {

                    private final Button completeBtn = new Button("Complete Job");

                    @Override
                    public void updateItem(Button item, boolean empty) {
                    	
                    	completeBtn.setOnAction((ActionEvent event) -> {
                            Job data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data);
                            
                            if(data.getStatus().equalsIgnoreCase("Complete")) {
                				completeBtn.setDisable(true);
                			} else {

                				completeBtn.setOnAction(e -> {
                					jobCon.UpdateJobStatus(data.getId(), "Complete");
                					refreshTable();
                				});
                			}
                			
                        });
                    	
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(completeBtn);
                        }
                    }
                };
				
				
		        tc.setAlignment(Pos.CENTER);

		        
		         
		        return tc;
			}
		});
		
		
		TableService.setIntValue(jobIdColumn, "id");
		TableService.setIntValue(pcIdColumn, "pcId");
		TableService.setStringValue(statusColumn, "status");
//		completeColumn.setCellValueFactory(x -> {
//			
//			Button completeBtn = new Button("Complete Job");
//			
//			if(x.getValue().getStatus().equalsIgnoreCase("Complete")) {
//				completeBtn.setDisable(true);
//			} else {
//
//				completeBtn.setOnAction(e -> {
//					jobCon.UpdateJobStatus(x.getValue().getId(), "Complete");
//					refreshTable();
//				});
//			}
//			
//			
//			return new SimpleObjectProperty<>(completeBtn);
//		});
		
		
	}

	@Override
	public void placeItems() {
		// TODO Auto-generated method stub
		this.getColumns().addAll(
			jobIdColumn,
			pcIdColumn,
			statusColumn,
			completeColumn
			);
	}

	@Override
	public void style() {
		// TODO Auto-generated method stub
		jobIdColumn.setStyle("-fx-font-size: " + Conf.TABLE_COLUMN_SIZE + "px;");
		pcIdColumn.setStyle("-fx-font-size: " + Conf.TABLE_COLUMN_SIZE + "px;");
		statusColumn.setStyle("-fx-font-size: " + Conf.TABLE_COLUMN_SIZE + "px;");
		
		this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
		
	}

	@Override
	public void setHandler() {
		// TODO Auto-generated method stub
		
	}
	
	public void refreshTable() {
		System.out.println("asdasd ripres");
		this.getItems().clear();
		this.getItems().addAll(jobCon.getTechnicianJobs(Main.user.getId()));
	}
	
//	public void refreshByID(int id) {
//		this.getItems().clear();
//		this.getItems().addAll(transactionCon.getTransactionDetailsByID(id));
//	}
	
}
