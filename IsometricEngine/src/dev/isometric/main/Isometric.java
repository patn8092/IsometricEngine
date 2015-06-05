package dev.isometric.main;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Isometric extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 320,
			HEIGHT = (WIDTH * 9) / 12;
	public static int TILE_WIDTH = 24,
			TILE_HEIGHT = 12,
			TILE_WIDTH_HALF = TILE_WIDTH / 2,
			TILE_HEIGHT_HALF = TILE_HEIGHT / 2;
	
	private BufferedImage tileImage;
	private int[][] tiles;
	
	/**
	 * Instantiates the Isometric class. 
	 */
	public Isometric() {
		try {
			tileImage = ImageIO.read(getClass().getResource("/tile.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		tiles = new int[16][16];
		
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[i].length; j++) {
				tiles[i][j] = 0x00;
			}
		}
		
	}
	
	public void paint(Graphics g) {
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[i].length; j++) {
				Point p = new Point(i, j);
				g.drawImage(tileImage, mapToScreen(p).x + getOffsetX(), mapToScreen(p).y + getOffsetY(), null);
			}
		}
	}
	
	/**
	 * 
	 * @param p - A point containing the indices of <code>(x,y)</code> 
	 * 			in the <b>map array</b>.  
	 * 
	 * @return A point containing the absolute coordinates 
	 * 			on the screen converted from parameter <b>p</b>
	 */
	public Point mapToScreen(Point p) {
		return new Point(
					(p.x - p.y) * TILE_WIDTH_HALF ,
					(p.x + p.y) * TILE_HEIGHT_HALF
				);
	}
	
	public Point screenToMap(Point p) {
		return new Point(
				(p.x / TILE_WIDTH_HALF + p.y / TILE_HEIGHT_HALF) / 2,
				(p.y / TILE_HEIGHT_HALF - (p.x / TILE_WIDTH_HALF)) / 2
				);
	}
	
	public int getOffsetX() {
		return getWidth()/2 - TILE_WIDTH_HALF;
	}
	
	public int getOffsetY() {
		return getHeight()/2 - TILE_HEIGHT_HALF * tiles.length;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Isometric Tiles");
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(new Isometric());
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
