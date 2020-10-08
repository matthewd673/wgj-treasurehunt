package com.mattdaly.wgj.treasurehunt;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JComponent;
import javax.swing.JPanel;

//custom jcomponent whose paint event will be used to render game elements
public class RenderSurface extends JComponent {

	public Camera cam;
	
	int w;
	int h;
	
	Color backgroundColor = new Color(20, 24, 49);
	
	public RenderSurface(int w, int h)
	{
		this.w = w;
		this.h = h;
		
		cam = new Camera(0, 0, w, h);
	}
	
	//main draw loop
	public void paint(Graphics g)
	{	
		
		//begin draw calls
		//draw clear color
		fillRectangle(g, new Rectangle(0, 0, w, h), backgroundColor);
		
		for(Entity e : Main.entityManager.entityList) {
			e.render(g);
		}

		//ui drawing
		//heat bar
		if(Main.drill != null) {
			int heat = Main.drill.drillHeat;
			int maxHeat = Main.drill.maxHeat;

			drawSprite(g, Sprites.heatbarBackground, new Rectangle(4, 4, maxHeat * 4, 16));
			drawSprite(g, Sprites.heatbar, new Rectangle(4, 4, heat * 4, 16));
		}

		//gem bar
		int gemX = 4;
		int gemY = 24;
		for(int i = 0; i < Main.treasureCt; i++) {
			
			if(gemX > 80) {
				gemX = 4;
				gemY += 16;
			}
			
			
			drawSprite(g, Sprites.treasureUi, new Rectangle(gemX, gemY, 20, 20));
			
			
			gemX += 8; 
		}
		
		//call super paint (end of draw calls)
		super.paint(g);
		
	}	
	
	//simplified draw call
	public static void drawSprite(Graphics g, BufferedImage image, Rectangle rect) {
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
	
	public static void fillRectangle(Graphics g, Rectangle rect, Color color) {
		g.setColor(color);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}
	
}
