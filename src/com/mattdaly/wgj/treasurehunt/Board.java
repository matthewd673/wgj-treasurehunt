package com.mattdaly.wgj.treasurehunt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Board {
	
	public int x,y;
	public int w,h;
	

	Block[][] board;
	
	public Board(int h, int w, int y) {
		
		this.w = w;
		this.h = h;
		this.y = y;
		
		board = new Block[w][h];
			
	}
	
	public void generateBoard() {
		
		x = 0;
		int yInc = y;
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				
				//random tile generation (we can change later)
				double rand  = Math.random();
				
				if(rand<.55) { //DIRT BLOCK
					DirtBlock dirtBlock = new DirtBlock(x, yInc);
					if(rand < .1) {
						dirtBlock.breakBlock();
					}
					board[i][j] = dirtBlock;
				}
				else if(rand<.92) { //TOUGH DIRT BLOCK
					board[i][j] = new ToughDirtBlock(x, yInc);
				}
				else if(rand<.95) { //WATER & ICE
					if(rand < .94)
						board[i][j] = new WaterBlock(x, yInc);
					else
						board[i][j] = new IceBlock(x, yInc);
				}
				else //TREASURE BLOCK
					board[i][j] = new TreasureBlock(x, yInc);
				
				//randomly break some blocks (these will always be normal dirt, based on the above generator)
				if(rand < .08)
					board[i][j].MinusToughness();
				
				//set air and surface blocks at set y levels
				if(yInc == 32)
					board[i][j] = new SurfaceBlock(x, yInc);
		        if(yInc == 0)
		        {
		        	Block skyBlock = new Block(x, yInc, Sprites.sky, 0);
		        	skyBlock.broken = true;
		        	board[i][j] = skyBlock;
		        }
				
				x += DirtBlock.w;
		    }
			
			x = 0;
			yInc += DirtBlock.h;
			
		}
		
	}
		
	public void populateBoardEntities() {
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				Main.entityManager.addEntity(board[i][j]);
				
				/*
				ParticleSystem particleSystem = new ParticleSystem(board[i][j].x, board[i][j].y);
				particleSystem.spawnParticles(12, board[i][j].sprite);
				Main.entityManager.addEntity(particleSystem);
				*/
				
			}
		}
	}
	
	public void dePopulateBoardEntities() {
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				Main.entityManager.removeEntity(board[i][j]);
			}
		}
	}
		
}
	
	


