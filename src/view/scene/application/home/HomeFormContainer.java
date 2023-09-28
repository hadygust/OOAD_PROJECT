package view.scene.application.home;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import main.Conf;
import view.Component;
import view.scene.application.form.FormComponent;

public class HomeFormContainer extends VBox implements Component{
	
	private ArrayList<FormComponent> formList;
	
	public HomeFormContainer() {
		// TODO Auto-generated constructor stub
		init();
		placeItems();
		style();
		setHandler();
	}

	@Override
	public void init() {
		formList = new ArrayList<>();
	}

	@Override
	public void placeItems() {
		getChildren().clear();
		getChildren().addAll(formList);
	}

	@Override
	public void style() {
		setPadding(new Insets(10, 20, 10, 20));
		setAlignment(Pos.CENTER);
		setPrefWidth(Conf.SIDE_MENU_WIDTH);
		setStyle("-fx-border-width: 0 0 0 1px; "
				+ "-fx-border-color: lightgray;");
		setSpacing(30);
	}

	@Override
	public void setHandler() {
		// TODO Auto-generated method stub
		
	}
	
	public void addForm(FormComponent form) {
		formList.add(form);
		System.out.println(formList);
		placeItems();
	}
	
	public ArrayList<FormComponent> getFormList(){
		return this.formList;
	}

	public void resetForm() {
		for (FormComponent form : formList) {
			form.reset();
		}
	}
}
