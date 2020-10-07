package com.mattdaly.wgj.treasurehunt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block extends Entity{
	
	
	public boolean broken;
	private int toughness;
	
	//not sure why these were defined again for blocks:
	//seems to work without them...
	//public int x,y;
	//public BufferedImage sprite;
	
	public Block(int x, int y, BufferedImage sprite, int toughness) {
		super(sprite, x, y, 32, 32);
		this.toughness = toughness;
		broken = false;		
    }
			
		
	
	public int getToughness() {
		return toughness;
	}
	public void MinusToughness() {
	
		toughness--;
		if(toughness<2)
			sprite = Sprites.dirt;
		if(toughness<1)
			breakBlock();
	}
	
	public void breakBlock() {
		broken = true;
		collider = false;
		
		/*
		ParticleSystem particleSystem = new ParticleSystem(x, y);
		particleSystem.spawnParticles(12, sprite);
		*/
		
		sprite = Sprites.background;
	}
	
	public void spawnBlockParticles() {
		ParticleSystem particleSystem = new ParticleSystem(x + 16, y + 16);
		particleSystem.spawnParticles(12, sprite);
	}
	
	

}
