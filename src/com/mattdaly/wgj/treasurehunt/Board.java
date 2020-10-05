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
		
		x = 0;
		y = 0;
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				
				//random tile generation (we can change later)
				double rand  = Math.random();
				
				if(rand<.6) {
					board[i][j] = new DirtBlock(x, y);
				}
				else if(rand<.95) {
					board[i][j] = new ToughDirtBlock(x, y);
				}
				else 
					board[i][j] = new TreasureBlock(x, y);
		              
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
	
	


