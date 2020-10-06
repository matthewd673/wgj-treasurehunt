package com.mattdaly.wgj.treasurehunt;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity implements Comparable {
	
	public BufferedImage sprite;
	
	public float x;
	public float y;
	public int w;
	public int h;
	
	public String hash;
	public int zIndex;
	
	public Velocity v;
	public Acceleration a;
	
	public Entity(BufferedImage sprite, float x, float y, int w, int h) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		v = new Velocity(0, 0);
		a = new Acceleration(0);
		
		updateHash();
	}
	
	public void update() {
		v.velX += a.accelY;
		
		x += v.velX;
		y += v.velY;
		
		updateHash();
	}
	
	public void render(Graphics g) {
		Rectangle renderRect = Main.renderSurface.cam.getRenderRect(this); //get renderrect from camera
		RenderSurface.drawSprite(g, sprite, renderRect);
	}
	
	public void updateHash()
	{
		hash = ((int)x / 256) + "," + ((int)y / 256);
	}
	
	@Override
	public int compareTo(Object o) {
		Entity e = (Entity)o;
		return this.zIndex - e.zIndex;
	}
	
}
