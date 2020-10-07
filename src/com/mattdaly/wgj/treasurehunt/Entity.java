package com.mattdaly.wgj.treasurehunt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	
	public BufferedImage sprite;
	
	public float x;
	public float y;
	public int w;
	public int h;
	
	public String hash;
	public int zIndex;
	
	public Velocity v;
	public Acceleration a;
	
	public boolean collider = true;
	
	public Entity(BufferedImage sprite, float x, float y, int w, int h) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		v = new Velocity(0, 0);
		a = new Acceleration(0, 0);
		
		updateHash();
	}
	
	public void update() {
		v.velX += a.accelX;
		v.velY += a.accelY;
		
		a.accelX = 0;
		a.accelY = 0;
		
		x += v.velX;
		y += v.velY;
		
		updateHash();
	}
	
	public void render(Graphics g) {
		Rectangle renderRect = Main.renderSurface.cam.getRenderRect(this); //get renderrect from camera
		RenderSurface.drawSprite(g, sprite, renderRect);
		
		//COLLIDER VISUALIZER
		/*
		if(collider) {
			g.setColor(Color.GREEN);
			Rectangle colRect = Main.renderSurface.cam.getRenderRect(new Rectangle((int)x, (int)y, w, h));
			g.drawRect(colRect.x, colRect.y, colRect.width, colRect.height);
		}
		*/
		
	}
	
	public void updateHash()
	{
		hash = ((int)x / 256) + "," + ((int)y / 256);
	}
	
}
