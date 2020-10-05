package com.mattdaly.wgj.treasurehunt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Board {
	
	public int x,y;

	public Board() {
		
		Block[][] board = new Block[20][40];
		x = 0;
		y = 0;
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				
				
				
				//random tile generation (we can change later)
				double rand  = Math.random();
				
				if(rand<.6) {
					board[i][j] = new DirtBlock(x, y);
				}
				else if(rand<.95) {
					board[i][j] = new DirtBlock(x, y);//change to toughdirtblock
				}
				else 
					board[i][j] = new DirtBlock(x, y);//change to treasureblock
	
				
				
				
		              
		    x += DirtBlock.w;
		    }
			x = 0;
			y += DirtBlock.h;
				
			}
			
		}
		
		
		
		
		
		
		
	}
	
	


