package com.mattdaly.wgj.treasurehunt;
import java.awt.image.BufferedImage;


public class AnimationManager {
	
	
	
	
	
	public BufferedImage[] drill;
	public BufferedImage[] lava;
<<<<<<< HEAD
	int count;
=======
	int lavaCount;
	int lavaDelay;
	int drillCount; 
>>>>>>> 9a1d546ab24496bf7d8ca90dc439441dee628285
	
	
	
	public AnimationManager() {
		
<<<<<<< HEAD
		count = -1;
=======
		drillCount = -1;
		lavaCount = 0;
		lavaDelay = 0;
>>>>>>> 9a1d546ab24496bf7d8ca90dc439441dee628285
		
		//drill
		drill = new BufferedImage[4];
		
		
		drill[0] = Sprites.drill1;
		drill[1] = Sprites.drill2;
		drill[2] = Sprites.drill3;
		drill[3] = Sprites.drill4;
		
		lava = new BufferedImage[16];
		//Lava
		lava[0] =  Sprites.lava1;
		lava[1] =  Sprites.lava2;
		lava[2] =  Sprites.lava3;
		lava[3] =  Sprites.lava4;
		lava[4] =  Sprites.lava5;
		lava[5] =  Sprites.lava6;
		lava[6] =  Sprites.lava7;
		lava[7] =  Sprites.lava8;
		lava[8] =  Sprites.lava9;
		lava[9] =  Sprites.lava10;
		lava[10] =  Sprites.lava11;
		lava[11] =  Sprites.lava12;
		lava[12] =  Sprites.lava13;
		lava[13] =  Sprites.lava14;
		lava[14] =  Sprites.lava15;
		lava[15] =  Sprites.lava16;
	
	}
	

	

	
	public BufferedImage getCurrentDrill() {
		
<<<<<<< HEAD
		count++;
		
		if(count > 3)
			count = 0;
		return drill[count];
=======
		drillCount++;
		
		if(drillCount > 3)
			drillCount = 0;
		return drill[drillCount];
>>>>>>> 9a1d546ab24496bf7d8ca90dc439441dee628285
		
		
	}
	
<<<<<<< HEAD
=======
	public BufferedImage getCurrentLava() {
		
		lavaDelay++;
		//makes lava move slower
		if(lavaDelay % 25 == 0) {
			lavaDelay = 0;
			lavaCount++;
		}
		
		if(lavaCount > 15)
			lavaCount = 0;
		return lava[lavaCount];
		
		
	}
	
	
>>>>>>> 9a1d546ab24496bf7d8ca90dc439441dee628285
}




