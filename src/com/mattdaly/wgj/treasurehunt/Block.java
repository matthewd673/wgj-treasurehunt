package com.mattdaly.wgj.treasurehunt;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block extends Entity{
	
	
	public boolean broken;
	private int initialToughness;
	private int toughness;
	
	//not sure why these were defined again for blocks:
	//seems to work without them...
	//public int x,y;
	//public BufferedImage sprite;
	
	public Block(int x, int y, BufferedImage sprite, int toughness) {
		super(sprite, x, y, 32, 32);
		this.initialToughness = toughness;
		this.toughness = toughness;
		//broken = true;
    }
			
		
	
	public int getToughness() {
		return toughness;
	}
	public void MinusToughness() {
	
		toughness--;
		if(toughness<2)
			sprite = Sprites.dirt;
		if(toughness<1)
			breakBlock(null);
	}
	
	public void breakBlock(Drill breakingDrill) {

		
		broken = true;
		collider = false;

		sprite = Sprites.background;

		if(breakingDrill != null)
			breakingDrill.addHeat(initialToughness);
	}
	public void spawnBlockParticles() {
		ParticleSystem particleSystem = new ParticleSystem(x, y);
		particleSystem.spawnParticles(12, sprite);
	}
	
	public void render(Graphics g) {
		if(!broken)
			super.render(g);
	}
	
}
