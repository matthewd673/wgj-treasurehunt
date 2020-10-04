package com.mattdaly.wgj.treasurehunt;

import java.awt.image.BufferedImage;

public class Frog extends Entity {

	public Frog(BufferedImage sprite, float x, float y) {
		super(sprite, x, y, 32, 32);
	}

	public void update()
	{
		
		if(Main.inputManager.isKeyPressed('w'))
			y--;
		if(Main.inputManager.isKeyPressed('s'))
			y++;
		if(Main.inputManager.isKeyPressed('a'))
			x--;
		if(Main.inputManager.isKeyPressed('d'))
			x++;
		
		super.update();
	}
	
}
