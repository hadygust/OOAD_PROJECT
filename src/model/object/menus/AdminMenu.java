package model.object.menus;

import javafx.scene.control.Menu;

public class AdminMenu extends AppMenu{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		Menu view = builder.create(MenuData.getView()).addAll(MenuData.getHome(), MenuData.getViewTransactionHistory()).build();
		Menu report = builder.create(MenuData.getReport()).addAll(MenuData.getViewReport(), MenuData.getMakeReport()).build();
		Menu staff = builder.create(MenuData.getStaff()).addAll(MenuData.getViewStaff(), MenuData.getViewJob()).build();
		
		addMenus(view, report, staff);
		
	}

}
