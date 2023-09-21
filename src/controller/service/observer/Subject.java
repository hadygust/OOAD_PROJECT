package controller.service.observer;

import java.util.ArrayList;

public interface Subject {
	
	public void addObserver(Observer obs);
	public void removeObserver(Observer obs);
	public void notifyObserver();

}
