package model.object.menus;

import javafx.scene.control.Menu;

public class CustomerMenu extends AppMenu{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		Menu view = MenuData.buildMenu(MenuData.getView(), MenuData.getHome(), MenuData.getViewTransactionHistory());
		
		addMenus(view);
	}
	
	

}
