package com.mattdaly.wgj.treasurehunt;

import java.awt.image.BufferedImage;

public class Frog extends Entity {

	public Frog(BufferedImage sprite, float x, float y) {
		super(sprite, x, y, 32, 32);
	}

	public void update()
	{
		
		if(Main.inputManager.isKeyPressed('w'))
			y-=2;
		if(Main.inputManager.isKeyPressed('s'))
			y+=2;
		if(Main.inputManager.isKeyPressed('a'))
			x-=2;
		if(Main.inputManager.isKeyPressed('d'))
			x+=2;
		
		super.update();
	}
	
}
