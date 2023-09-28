package view.scene.application.form;

import controller.service.observer.Observer;
import controller.service.observer.Subject;
import javafx.scene.layout.VBox;
import view.Component;
import view.scene.application.home.HomeFormContainer;

public abstract class FormComponent extends VBox implements Observer, Component, Subject{

	public abstract void reset();
	
	protected HomeFormContainer container;

	public FormComponent(HomeFormContainer container) {
		super();
		this.container = container;
	}
	
	
	
}
