package model.object.menus;

import javafx.scene.control.Menu;

public class CustomerMenu extends AppMenu{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		Menu view = MenuData.buildMenu(MenuData.VIEW, MenuData.HOME, MenuData.VIEW_TRANSACTION_HISTORY);
		Menu report = MenuData.buildMenu(MenuData.REPORT, MenuData.MAKE_REPORT);
		
		addMenus(view, report);
	}
	
	

}
