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
		
		ArrayList<Entity> renderList = Main.entityManager.getEntitiesInRange((int)cam.x, (int)cam.y, cam.screenW, cam.screenH);
		//System.out.println(renderList.size());
		
		Collections.sort(renderList);
		
		for(Entity e : renderList) {
			e.render(g);
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
	
	public static void drawRectangle(Graphics g, Rectangle rect, Color color) {
		g.drawRect(rect.x, rect.y, rect.width, rect.height);
	}
	
}
