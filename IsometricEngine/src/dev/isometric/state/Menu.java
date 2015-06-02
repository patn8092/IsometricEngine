package dev.isometric.state;

import java.awt.Graphics;

import dev.isometric.main.Isometric;

public abstract class Menu {
	
	protected Isometric iso;
	
	public Menu(Isometric iso) {
		this.iso = iso;
	}
	
	public abstract void update();
	public abstract void paint(Graphics g);
}
