package view.scene.application.home;

import java.util.ArrayList;

import controller.service.observer.Observer;
import controller.service.observer.Subject;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import main.Conf;
import model.PC;
import view.Component;

public class PCItem extends VBox implements Subject, Component{
	
	private ArrayList<Observer> obsList = new ArrayList<>();
	
	private PC pc;
	private Text idTxt, conditionTxt;
	
	public PCItem(int id, String condition) {

		idTxt = new Text(id + "");
		conditionTxt = new Text(condition);
		
		pc = new PC(id, condition);
		
		init();
		style();
		setHandler();
	}
		
	public PCItem(PC pc) {

		
		this.pc = pc;
		
		init();
		placeItems();
		style();
		setHandler();
	}

	@Override
	public void init() {
		idTxt = new Text(pc.getId() + "");
		conditionTxt = new Text(pc.getCondition());
	}
	
	@Override
	public void placeItems() {
		// TODO Auto-generated method stub
		getChildren().addAll(idTxt, conditionTxt);
	}

	@Override
	public void style() {

		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		
		setPrefWidth(Conf.PC_ITEM_WIDTH);
		setPrefHeight(Conf.PC_ITEM_HEIGHT);
		
//		setStyle("-fx-background-radius: 12");
		if(pc.getCondition().toLowerCase().equals("maintenance")) {
			setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(12), null)));
		} else if(pc.getCondition().toLowerCase().equals("usable")) {
			setBackground(new Background(new BackgroundFill(Color.CHARTREUSE, new CornerRadii(12), null)));		
		} else {
			setBackground(new Background(new BackgroundFill(Color.CRIMSON, new CornerRadii(12), null)));
		}
		
		idTxt.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 18));
		conditionTxt.setFont(Font.font("Calibri", FontWeight.SEMI_BOLD, 18));
		
		addShadow();
	}
	
	private void addShadow() {
		DropShadow shadow = new DropShadow(2, 1, 1, Color.GREY);
		setEffect(shadow);
	}
	
	@Override
	public void setHandler() {
		this.setOnMouseClicked(x -> {
			notifyObserver();
		});
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (Observer observer : obsList) {
			observer.update(this.pc);
		}
	}

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.obsList.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.obsList.remove(obs);
	}
}
