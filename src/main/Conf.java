package main;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class Conf {
	
	private static Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

	public static final double APP_WIDTH = screenSize.getWidth();
	public static final double APP_HEIGHT = screenSize.getHeight();
			
	public static final int PC_ITEM_WIDTH = 184;
	public static final int PC_ITEM_HEIGHT = 124;
	
	public static final int SIDE_MENU_WIDTH = 464;
	public static final int SIDE_MENU_HEIGHT = 960;
	
	public static final int SIDE_MENU_FORM_WIDTH = 200;
	
	public static final double DEFAULT_PADDING = 24;
	
	public static final int TABLE_COLUMN_SIZE = 20;
	
	public static final int TITLE_FONT = 42;
}
