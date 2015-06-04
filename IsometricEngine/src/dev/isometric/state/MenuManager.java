package dev.isometric.state;

public class MenuManager {
	
	private static Menu currentMenu;
	
	public static void setCurrentMenu(Menu m) {
		currentMenu = m;
	}
	
	public static Menu getCurrentMenu() {
		return currentMenu;
	}
}
