package model.object.menus;

import javafx.scene.control.Menu;

public class TechnicianMenu extends AppMenu{

	@Override
	public void init() {
		Menu jobMenu = MenuData.buildMenu(MenuData.getView(), MenuData.getHome(), MenuData.getViewJob());
		
		addMenus(jobMenu);
	}

}
