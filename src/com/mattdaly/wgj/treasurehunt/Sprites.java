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
		public static BufferedImage drill1;
		public static BufferedImage drill2;
		public static BufferedImage drill3;
		public static BufferedImage drill4;
		
		//tiles
		public static BufferedImage background;
		public static BufferedImage caveBackground;
		public static BufferedImage dirt;
		public static BufferedImage toughDirt;
		public static BufferedImage treasure;
		public static BufferedImage water;
		public static BufferedImage ice;
		public static BufferedImage surface;
		public static BufferedImage sky;
		public static BufferedImage treasureParticle;
		
		//lava
		public static BufferedImage lava1;
		public static BufferedImage lava2;
		public static BufferedImage lava3;
		public static BufferedImage lava4;
		public static BufferedImage lava5;
		public static BufferedImage lava6;
		public static BufferedImage lava7;
		public static BufferedImage lava8;
		public static BufferedImage lava9;
		public static BufferedImage lava10;
		public static BufferedImage lava11;
		public static BufferedImage lava12;
		public static BufferedImage lava13;
		public static BufferedImage lava14;
		public static BufferedImage lava15;
		public static BufferedImage lava16;
		
		public static void loadSprites() {
			
			
			try {
				//load sprite from file

				
				pixel = ImageIO.read(new File("res/pixel.png"));
				
				drill1 = ImageIO.read(new File("res/drill/drill1.png"));
				drill2 = ImageIO.read(new File("res/drill/drill2.png"));
				drill3 = ImageIO.read(new File("res/drill/drill3.png"));
				drill4 = ImageIO.read(new File("res/drill/drill4.png"));
				
				lava1 = ImageIO.read(new File("res/lava/lava1.png"));
				lava2 = ImageIO.read(new File("res/lava/lava2.png"));
				lava3 = ImageIO.read(new File("res/lava/lava3.png"));
				lava4 = ImageIO.read(new File("res/lava/lava4.png"));
				lava5 = ImageIO.read(new File("res/lava/lava5.png"));
				lava6 = ImageIO.read(new File("res/lava/lava6.png"));
				lava7 = ImageIO.read(new File("res/lava/lava7.png"));
				lava8 = ImageIO.read(new File("res/lava/lava8.png"));
				lava9 = ImageIO.read(new File("res/lava/lava9.png"));
				lava10 = ImageIO.read(new File("res/lava/lava10.png"));
				lava11 = ImageIO.read(new File("res/lava/lava11.png"));
				lava12 = ImageIO.read(new File("res/lava/lava12.png"));
				lava13 = ImageIO.read(new File("res/lava/lava13.png"));
				lava14 = ImageIO.read(new File("res/lava/lava14.png"));
				lava15 = ImageIO.read(new File("res/lava/lava15.png"));
				lava16 = ImageIO.read(new File("res/lava/lava16.png"));
				
				background = ImageIO.read(new File("res/background.png"));
				caveBackground = ImageIO.read(new File("res/caveBackground.png"));
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
