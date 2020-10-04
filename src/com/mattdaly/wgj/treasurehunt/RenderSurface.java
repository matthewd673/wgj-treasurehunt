package com.mattdaly.wgj.treasurehunt;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JPanel;

//custom jcomponent whose paint event will be used to render game elements
public class RenderSurface extends JComponent {

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
		
		//begin draw calls
		
		drawSprite(g, Sprites.frog, new Rectangle(Main.frogX, Main.frogY, 24, 24));
		
		//call super paint (end of draw calls)
		super.paint(g);
		
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
