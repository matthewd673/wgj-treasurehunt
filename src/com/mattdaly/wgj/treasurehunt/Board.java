package com.mattdaly.wgj.treasurehunt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Board {
	
	public int x,y;
	public int w,h;
	

	Block[][] board;
	boolean[][] map;
	public Board(int h, int w, int y) {
		
		this.w = w;
		this.h = h;
		this.y = y;
		
		board = new Block[w][h];
			
	}
	
	public void generateBoard() {
		
		x = 0;
		int yInc = y;

		
		/*
		//generates random noise
		for(int i = 0; i<w; i++){
	        for(int j=0; j<h; j++){
	            if(Math.random() < chanceToStartAlive){
	                board[i][j].broken = false;
	            }
	        }
	    }
		
		*/

		 map = new boolean[w][h];
	
		double chanceToStartAlive = 0.50;
		int steps = 20;
		//initialiseMap
		 for(int i=0; i<w; i++){
		        for(int j=0; j<h; j++){
		        	map[i][j] = false;   
		        	//board[i][j] = new BrokenBlock(x, yInc);
		            if(Math.random() < chanceToStartAlive){
		            	//board[i][j] = new DirtBlock(x, yInc);
		            	map[i][j] = true;   
		            }
		        	
		        }
		      
		 }
		 

		
		    //And now run the simulation for a set number of steps
		    for(int  i=0; i<steps; i++){
		        map = doSimulationStep(map);
		    }
		    
		    
		     
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				
				
			//	if(!board[i][j].broken) {
				
				//random tile generation (we can change later)
				double rand  = Math.random();
				
				if(map[i][j]) {
				
				if(rand<.55) { //DIRT BLOCK
					board[i][j] = new DirtBlock(x, yInc);
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
				else { //TREASURE BLOCK
					
					
					board[i][j] = new TreasureBlock(x, yInc);
					
				double tRand = Math.random();
				if(tRand<.75) {
					board[i][j].sprite = Sprites.treasure;
					board[i][j].type = "G";
				}
				else if(tRand<.9 && y>1200) {
					board[i][j].sprite = Sprites.purpleTreasure;
					board[i][j].type = "P";
				}
				else if(tRand<.95 && y>3000) {
					board[i][j].sprite = Sprites.orangeTreasure;
					board[i][j].type = "O";
				}
				else if(tRand<.95 && y>5000) {
					board[i][j].sprite = Sprites.redTreasure;
					board[i][j].type = "R";
				}
					
				
		
				}

				//randomly break some blocks (these will always be normal dirt, based on the above generator)
				
		
				
				if(j+3<w && i+1<h && map[i][j] && !map[i][j+1] && !map[i][j+2] && map[i][j+3]  && map[i+1][j+1] && map[i+1][j+2]) {
					x+=32;
					j++;
					board[i][j] = new LavaBlock(x, yInc);
					x+=32;
					j++;
					board[i][j] = new LavaBlock(x, yInc);
					
					
				}
				
				if(rand>.85 && j+2 <w && i+1<h && map[i][j] && !map[i][j+1] && map[i][j+2] && map[i+1][j+1]) {
					x+=32;
					j++;
					board[i][j] = new LavaBlock(x, yInc);
				}
			}
		
			
				else {
					board[i][j] = new BrokenBlock(x, yInc);
					board[i][j].broken = true;
				}
			
				

				
				//set air and surface blocks at set y levels
				if(yInc == 32)
					board[i][j] = new SurfaceBlock(x, yInc);
		        if(yInc == 0)
		        {
		        	Block skyBlock = new Block(x, yInc, Sprites.sky, 0);
		        	skyBlock.breakBlock(null);
		        	board[i][j] = skyBlock;
		        }
				x += 32;

		    }
			
			x = 0;
			yInc += 32;
	}
	
		}

	
	

	public int countAliveNeighbours(boolean[][] map, int x, int y){
		
	    int count = 0;
	    for(int i=-1; i<2; i++){
	        for(int j=-1; j<2; j++){
	            int neighbourx = x+i;
	            int neighboury = y+j;
	            
	            if(i == 0 && j == 0){
	            	//Do nothing for center point
	            }
	            //If index is on border
	            else if(neighbourx < 0 || neighboury < 0 || neighbourx >= map.length || neighboury >= map[0].length){
	                count = count + 1;
	            }
	            //Otherwise, a normal check of the neighbour
	            else if(map[neighbourx][neighboury]){
	                count = count + 1;
	            }
	        }
	    }
	    return count;
	}
	
	
	public boolean[][] doSimulationStep(boolean[][] oldMap){
	    boolean[][] newMap = new boolean[w][h];
	    
	    //Change these to change caves
	    int deathLimit = 5;
	    int birthLimit = 3;
	    //Loop over each row and column of the map
	    for(int x=0; x<oldMap.length; x++){
	        for(int y=0; y<oldMap[0].length; y++){
	            int nbs = countAliveNeighbours(oldMap, x, y);
	            //The new value is based on our simulation rules
	            //First, if a cell is alive but has too few neighbours, kill it.
	            if(oldMap[x][y]){
	                if(nbs < deathLimit){
	                    newMap[x][y] = false;
	                }
	                else{
	                    newMap[x][y] = true;
	                }
	            } //Otherwise, if the cell is dead now, check if it has the right number of neighbours to be 'born'
	            else{
	                if(nbs > birthLimit){
	                    newMap[x][y] = true;
	                }
	                else{
	                    newMap[x][y] = false;
	                }
	            }
	        }
	    }
	    return newMap;
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

