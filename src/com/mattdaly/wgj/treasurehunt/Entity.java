package com.mattdaly.wgj.treasurehunt;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

	public BufferedImage sprite;
	
	public float x;
	public float y;
	public static int w;
	public static int h;
	
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
	}
	
	public void update() {
		v.velX += a.accelY;
		
		x += v.velX;
		y += v.velY;
	}
	
	public void render(Graphics g) {
		RenderSurface.drawSprite(g, sprite, new Rectangle((int)x, (int)y, w, h));
	}
	
}
