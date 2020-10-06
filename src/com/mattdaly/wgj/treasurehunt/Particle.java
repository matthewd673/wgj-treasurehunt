package com.mattdaly.wgj.treasurehunt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Particle extends Entity {
	
	int lifespan;
	Color col;
	
	public Particle(float x, float y, Velocity v, int lifespan, Color col) {

		super(Sprites.pixel, x, y, 4, 4);
		
		this.v = v;
		this.lifespan = lifespan;		
		this.col = col;
		
	}
	
	public void update() {
		if(lifespan < 0)
			return;
		else
			lifespan--;
		
		if(lifespan <= 0)
			Main.entityManager.removeEntity(this);
		
		super.update();
	}
	
	public void render(Graphics g) {
		Rectangle renderRect = Main.renderSurface.cam.getRenderRect(new Rectangle((int)x, (int)y, w, h));
		RenderSurface.fillRectangle(g, renderRect, col);
	}
	
}
