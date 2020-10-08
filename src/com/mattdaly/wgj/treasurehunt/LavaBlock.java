package com.mattdaly.wgj.treasurehunt;
import java.awt.Graphics;

import java.awt.Rectangle;

public class LavaBlock extends Block{
	
	AnimationManager animationManager;

	public LavaBlock(int x, int y) {
		super(x, y, Sprites.lava1, 0);
		collider = false;
		animationManager = new AnimationManager();
	}

	//can't be broken
	public void breakBlock(Drill breakingDrill) {
		breakingDrill.explode();
		return;
	}

	public void render(Graphics g) {
		sprite = animationManager.getCurrentLava();
		Rectangle renderRect = Main.renderSurface.cam.getRenderRect(new Rectangle((int)x, (int)y, 32, 32));
		Main.renderSurface.drawSprite(g, animationManager.getCurrentLava(), renderRect);
	}
	
	
	
}
