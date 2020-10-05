package com.mattdaly.wgj.treasurehunt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Board {
	
	public int x,y;
	public int w,h;
	

	Block[][] board;
	
	public Board(int w, int h) {
		
		this.w = w;
		this.h = h;
		
		board = new Block[w][h];
			
	}
	
	public void generateBoard() {
		
		x = 0;
		y = 0;
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				
				//random tile generation (we can change later)
				double rand  = Math.random();
				
				if(rand<.55) { //DIRT BLOCK
					DirtBlock dirtBlock = new DirtBlock(x, y);
					if(rand < .1) {
						dirtBlock.breakBlock();
					}
					board[i][j] = dirtBlock;
				}
				else if(rand<.92) { //TOUGH DIRT BLOCK
					board[i][j] = new ToughDirtBlock(x, y);
				}
				else if(rand<.95) { //WATER & ICE
					if(rand < .94)
						board[i][j] = new WaterBlock(x, y);
					else
						board[i][j] = new IceBlock(x, y);
				}
				else //TREASURE BLOCK
					board[i][j] = new TreasureBlock(x, y);
				
				//randomly break some blocks (these will always be normal dirt, based on the above generator)
				if(rand < .08)
					board[i][j].MinusToughness();
				
				//set air and surface blocks at set y levels
				if(i == 1)
					board[i][j] = new SurfaceBlock(x, y);
		        if(i == 0)
		        {
		        	Block skyBlock = new Block(x, y, Sprites.sky, 0);
		        	skyBlock.broken = true;
		        	board[i][j] = skyBlock;
		        }
				
				x += DirtBlock.w;
		    }
			
			x = 0;
			y += DirtBlock.h;
			
		}
		
	}
		
	public void populateBoardEntities() {
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				Main.entityManager.addEntity(board[i][j]);
			}
		}
	}
		
}
	
	


