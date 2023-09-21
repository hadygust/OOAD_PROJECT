package model.object.menus;

import controller.service.builder.MenuBuilder;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public abstract class AppMenu {
	protected MenuBar menuBar = new MenuBar();
	protected MenuBuilder builder = new MenuBuilder();
	
	public AppMenu() {
		super();
		init();
	}

	public abstract void init();
	
	protected void addMenus(Menu... menus) {
		menuBar.getMenus().addAll(menus);
	}
	
	public MenuBar getMenuBar() {
		return menuBar;
	}
	
	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}
	
}
