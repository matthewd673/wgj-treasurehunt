package com.mattdaly.wgj.treasurehunt;

import java.awt.*;
import java.awt.image.BufferedImage;

//custom jcomponent whose paint event will be used to render game elements
public class RenderSurface extends Canvas {

	int w;
	int h;
	
	public RenderSurface(int w, int h)
	{
		this.w = w;
		this.h = h;
	}
	
	//main draw loop
	public void paint(Graphics g)
	{		
		g.clearRect(0, 0, w, h);
		
		//actual drawing code
		drawSprite(g, Sprites.frog, new Rectangle(Main.frogX, 40, 24, 24));
		
	}
	
	//simplified draw call
	void drawSprite(Graphics g, BufferedImage image, Rectangle rect)
	{
		g.drawImage(
				image,
				rect.x,
				rect.y,
				rect.x + rect.width,
				rect.y + rect.height,
				0,
				0,
				image.getWidth(),
				image.getHeight(),
				null
				);
	}
	
}
