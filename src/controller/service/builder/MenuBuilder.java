package controller.service.builder;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class MenuBuilder {
	
	Menu menu;
	
	public MenuBuilder create(Menu menu) {
		this.menu = menu;
		return this;
	}

	public MenuBuilder add(MenuItem item) {
		this.menu.getItems().add(item);
		return this;
	}
	
	public MenuBuilder addAll(MenuItem... items ) {
		this.menu.getItems().addAll(items);
		return this;
	}
	
	public Menu build() {
		return menu;
	}
}
