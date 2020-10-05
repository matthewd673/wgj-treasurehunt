package com.mattdaly.wgj.treasurehunt;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class Sprites {

	//list of all sprites
	public static BufferedImage frog;
<<<<<<< HEAD
	public static BufferedImage dirtBlock;
	public static BufferedImage toughDirtBlock;
	public static BufferedImage treasureBlock;

=======
	
	//characters
	public static BufferedImage drill;
	
	//tiles
	public static BufferedImage background;
	public static BufferedImage dirt;
	public static BufferedImage toughDirt;
	public static BufferedImage treasure;
	
>>>>>>> aff18aa23f599ec61f5cd39b41618fcfc8b37f6d
	public static void loadSprites() {
		
		
		try {
			//load sprite from file
			frog = ImageIO.read(new File("res/frog.png"));
			dirtBlock = ImageIO.read(new File("res/DirtBlock.png"));
			toughDirtBlock = ImageIO.read(new File("res/toughDirtBlock.png"));
			treasureBlock = ImageIO.read(new File("res/toughDirtBlock.png"));
			
			drill = ImageIO.read(new File("res/drill.png"));
			
			background = ImageIO.read(new File("res/background.png"));
			dirt = ImageIO.read(new File("res/dirt.png"));
			toughDirt = ImageIO.read(new File("res/tough-dirt.png"));
			treasure = ImageIO.read(new File("res/treasure.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
