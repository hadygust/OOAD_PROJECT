package model.object.menus;

import javafx.scene.control.Menu;

public class AdminMenu extends AppMenu{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		Menu view = builder.create(MenuData.VIEW).addAll(MenuData.HOME, MenuData.VIEW_TRANSACTION_HISTORY).build();
		Menu report = builder.create(MenuData.REPORT).addAll(MenuData.VIEW_REPORT, MenuData.MAKE_REPORT).build();
		Menu staff = builder.create(MenuData.STAFF).addAll(MenuData.VIEW_STAFF, MenuData.VIEW_JOB).build();
		
		addMenus(view, report, staff);
		
	}

}
