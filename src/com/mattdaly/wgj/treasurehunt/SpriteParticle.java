package com.mattdaly.wgj.treasurehunt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class SpriteParticle extends Particle {

	BufferedImage sprite;
	
	public SpriteParticle(float x, float y, int w, int h, Velocity v, int lifespan, BufferedImage sprite) {
		super(x, y, v, lifespan, Color.WHITE);
		this.w = w;
		this.h = h;
		this.sprite = sprite;
	}
	
	public void render(Graphics g) {
		Rectangle renderRect = Main.renderSurface.cam.getRenderRect(this); //get renderrect from camera
		RenderSurface.drawSprite(g, sprite, renderRect);
	}
	
}
