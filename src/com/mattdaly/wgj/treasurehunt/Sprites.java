package com.mattdaly.wgj.treasurehunt;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class Sprites {

	//list of all sprites
	public static BufferedImage frog;
	
	public static BufferedImage pixel;
	
	//characters
	public static BufferedImage drill;
	
	//tiles
	public static BufferedImage background;
	public static BufferedImage dirt;
	public static BufferedImage toughDirt;
	public static BufferedImage treasure;
	public static BufferedImage water;
	public static BufferedImage ice;
	public static BufferedImage surface;
	public static BufferedImage sky;
	public static BufferedImage treasureParticle;
	
	public static void loadSprites() {
		
		
		try {
			//load sprite from file
			frog = ImageIO.read(new File("res/frog.png"));
			
			pixel = ImageIO.read(new File("res/pixel.png"));
			
			drill = ImageIO.read(new File("res/drill.png"));
			
			background = ImageIO.read(new File("res/background.png"));
			dirt = ImageIO.read(new File("res/dirt.png"));
			toughDirt = ImageIO.read(new File("res/tough-dirt.png"));
			treasure = ImageIO.read(new File("res/treasure.png"));
			water = ImageIO.read(new File("res/water.png"));
			ice = ImageIO.read(new File("res/ice.png"));
			surface = ImageIO.read(new File("res/surface.png"));
			sky = ImageIO.read(new File("res/sky.png"));
			treasureParticle = ImageIO.read(new File("res/treasure-particle.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
