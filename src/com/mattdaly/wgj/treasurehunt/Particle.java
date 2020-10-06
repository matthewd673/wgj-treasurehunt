package com.mattdaly.wgj.treasurehunt;

import java.awt.Color;

public class Particle extends Entity {
	
	int lifespan;
	Color col;
	
	public Particle(float x, float y, Velocity v, int lifespan, Color col) {

		super(Sprites.pixel, x, y, 3, 3);
		
		this.v = v;
		this.lifespan = lifespan;		
		this.col = col;
		
	}
	
	public void update() {
		if(lifespan < 0)
			return;
		else
			lifespan--;
	}
	
}
