package controller.service.patterns;

import main.Main;
import model.object.menus.AppMenu;

public interface AppMenuFactory {

	public AppMenu createMenu();
	
	public static AppMenuFactory createMenuFactory() {
		System.out.println(Main.user.getRole());
		switch(Main.user.getRole().toLowerCase()) {
			case "customer":
				return new CustomerMenuFactory();
			case "admin":
				return new AdminMenuFactory();
			default: 
				return new CustomerMenuFactory();
		}
		
	}
	
}
