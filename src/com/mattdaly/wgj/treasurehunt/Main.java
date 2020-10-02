package com.mattdaly.wgj.treasurehunt;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main {

	//important things
	static JFrame frame;
	static RenderSurface renderer;
	
	//temporary!
	public static int frogX = 0;
	
	public static void main(String args[]) {
		
		//load content
		loadContent();
		
		//create frame
		createFrame("Treasure Hunt", 800, 600);
		
		//begin update loop
		beginUpdateLoop();
	}
	
	static void createFrame(String title, int w, int h) {
		//create a new frame with a title
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set frame size
		frame.setSize(w, h);
		frame.setResizable(false);
		
		//create rendersurface on frame
		renderer = new RenderSurface(w, h);
		frame.add(renderer);
		
		//display
		frame.setVisible(true);
	}
	
	//load any necessary content
	static void loadContent() {
		Sprites.loadSprites();
	}
	
	//begin update loop
	static void beginUpdateLoop()
	{
		//assume just above 60fps
		int delay = 16; //60fps = 16.67
		
		//create a new action listener which will call update() on tick
		ActionListener tickListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) { update(); }
		};
		
		//create and start timer
		new Timer(delay, tickListener).start();
	}
	
	//called on every update
	static void update()
	{
		//call render code
		renderer.update(frame.getGraphics());
		
		//temporary!
		frogX++;
	}
	
}
