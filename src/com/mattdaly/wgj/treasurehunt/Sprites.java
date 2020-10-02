package com.mattdaly.wgj.treasurehunt;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class Sprites {

	//list of all sprites
	public static BufferedImage frog;
	
	public static void loadSprites() {
		
		try {
			//load sprite from file
			frog = ImageIO.read(new File("res/frog.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
