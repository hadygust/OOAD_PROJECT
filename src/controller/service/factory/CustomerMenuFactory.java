package controller.service.factory;

import model.object.menus.AppMenu;
import model.object.menus.CustomerMenu;

public class CustomerMenuFactory implements AppMenuFactory{

	@Override
	public AppMenu createMenu() {
		// TODO Auto-generated method stub
		return new CustomerMenu();
	}
	
}
