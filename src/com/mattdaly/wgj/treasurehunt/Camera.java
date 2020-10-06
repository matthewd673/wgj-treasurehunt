package com.mattdaly.wgj.treasurehunt;

import java.awt.Rectangle;

public class Camera {

	public float x;
	public float y;
	
	public int screenW;
	public int screenH;
	
	public int minX;
	public int minY;
	
	public Camera(float x, float y, int screenW, int screenH)
	{
		this.screenW = screenW;
		this.screenH = screenH;
	}
	
	public void lockToEntity(Entity e)
	{
		//get center of entity
		float centerX = e.x + (e.w / 2);//are we shifting in x?
		float centerY = e.y + (e.h / 2);
		
		//set top left of screen accordingly
		moveCam(0, centerY - (screenH / 3));
	}
	
	public void moveCam(float newX, float newY)
	{
		//move within constraints of mins
		if(newX > minX)
			x = newX;
		else
			x = minX;
		
		if(newY > minY)
			y = newY;
		else
			y = minY;
	}
	
	public Rectangle getRenderRect(Entity e)
	{
		return new Rectangle((int)(e.x - x), (int)(e.y - y), e.w, e.h);
	}
	
}
