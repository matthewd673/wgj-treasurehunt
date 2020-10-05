package com.mattdaly.wgj.treasurehunt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block extends Entity{
	
	
	public boolean broken;
	private int toughness;
	public int x,y;
	public BufferedImage sprite;
	
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
		if(toughness<1)
			broken = true;
	}
	
	

}
