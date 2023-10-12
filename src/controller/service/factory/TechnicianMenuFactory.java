package controller.service.factory;

import model.object.menus.AppMenu;
import model.object.menus.TechnicianMenu;

public class TechnicianMenuFactory implements AppMenuFactory{

	@Override
	public AppMenu createMenu() {
		// TODO Auto-generated method stub
		return new TechnicianMenu();
	}

}
