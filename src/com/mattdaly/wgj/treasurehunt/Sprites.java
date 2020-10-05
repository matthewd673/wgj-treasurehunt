package com.mattdaly.wgj.treasurehunt;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class Sprites {

	//list of all sprites
	public static BufferedImage frog;
	public static BufferedImage dirtBlock;
	public static BufferedImage toughDirtBlock;
	public static BufferedImage treasureBlock;

	public static void loadSprites() {
		
		
		try {
			//load sprite from file
			frog = ImageIO.read(new File("res/frog.png"));
			dirtBlock = ImageIO.read(new File("res/DirtBlock.png"));
			toughDirtBlock = ImageIO.read(new File("res/toughDirtBlock.png"));
			treasureBlock = ImageIO.read(new File("res/toughDirtBlock.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
