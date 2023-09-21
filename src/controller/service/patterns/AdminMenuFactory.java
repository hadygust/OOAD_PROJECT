package controller.service.patterns;

import model.object.menus.AdminMenu;
import model.object.menus.AppMenu;

public class AdminMenuFactory implements AppMenuFactory{

	@Override
	public AppMenu createMenu() {
		// TODO Auto-generated method stub
		return new AdminMenu();
	}

}
