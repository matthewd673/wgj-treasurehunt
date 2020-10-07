package com.mattdaly.wgj.treasurehunt;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Drill extends Entity {

	/*
	 * Stub so we can reference the drill
	 * while the drill controller is being
	 * written.
	 * 
	 * SOME IDEAS:
	 *  - drill heats up for every 1 toughness unit you mine away
	 *  - hit water to fully cool your drill
	 */
	
	int speed = 5;
	
	public int blockX;
	public int blockY;
	
	int minTimeBetweenBreaks = 30;
	int timeBetweenBreaks = 0;
	
	public Drill(float x, float y)
	{
		super(Sprites.drill, x, y, 32, 32);
		a = new Acceleration(0, 4.9f);
	}
	
	public void update()
	{
		/*
		 * This code is confusing
		 * I wrote it at 1am
		 * Basically just don't touch any of it
		 * Or else it will probably break
		 * I'm sorry
		 * - Matt
		 */
		
		/*
		//find current drill block
		blockX = (int)x / 32;
		blockY = (int)y / 32;
		
		int boardHashX = blockX / 30;
		int boardHashY = blockY / 30;
		
		int innerBoardY = blockY - (boardHashY * 30);
		
		if(innerBoardY > 15 && !Main.boardManager.boardTable.containsKey("0," + (boardHashY + 1)))
			Main.boardManager.createBoard(0, boardHashY + 1);
		
		Board currentBoard = Main.boardManager.getCurrentBoard(boardHashX + "," + boardHashY);
		Block currentBlock = currentBoard.board[innerBoardY][blockX];
		
		if(!currentBlock.broken) {
			currentBlock.spawnBlockParticles();
			currentBlock.breakBlock();
			timeBetweenBreaks = 0;
		}
		
		//increment time between block breaks
		if(timeBetweenBreaks < minTimeBetweenBreaks)
			timeBetweenBreaks++;
			*/
		
		acceptInput();
		
		//System.out.println(a.accelY + " " + v.velY + " " + y);
		
		//make camera follow drill
		Main.renderSurface.cam.lockToEntity(this);
		
		v.velX += a.accelX;
		v.velY += a.accelY;
		
		if(v.velY > 4)
			v.velY = 4;
		
		//a.accelX = 0;
		//a.accelY = 0;
		
		moveDrill(x + v.velX, y + v.velY);
	}
	
	public void acceptInput()
	{
		
		int blockMineX = 0;
		int blockMineY = 1;
		
		if(Main.inputManager.isKeyPressed('w')) {
			v.velY = -10;
		}
		if(Main.inputManager.isKeyPressed('a')) {
			moveDrill(x - speed, y);
			blockMineX = -1;
			blockMineY = 0;
		}
		if(Main.inputManager.isKeyPressed('s')) {
			blockMineY = 1;
			blockMineX = 0;
		}
		if(Main.inputManager.isKeyPressed('d')) {
			moveDrill(x + speed, y);
			blockMineX = 1;
			blockMineY = 0;
		}
		
		if(Main.inputManager.isKeyPressed(' '))
			mineBlock(blockMineX, blockMineY);
	}
	
	public void moveDrill(float newX, float newY)
	{
		/*
		if(timeBetweenBreaks < minTimeBetweenBreaks)
			return; //can't move yet
		*/
		
		if(!willCollide(newX, y, w, h))
			x = newX;
		if(!willCollide(x, newY, w, h))
			y = newY;
	}
	
	public void mineBlock(int xDir, int yDir) {
		//find current drill block
		blockX = Math.round(x / 32);
		blockY = Math.round(y / 32);
		
		int boardHashX = Math.round(blockX / 30);
		int boardHashY = Math.round(blockY / 30);
		
		int innerBoardY = Math.round(blockY - (boardHashY * 30));
		
		if(innerBoardY > 15 && !Main.boardManager.boardTable.containsKey("0," + (boardHashY + 1)))
			Main.boardManager.createBoard(0, boardHashY + 1);
		
		Board currentBoard = Main.boardManager.getCurrentBoard(boardHashX + "," + boardHashY);
		Block currentBlock = new Block(0, 0, Sprites.pixel, 0);
		if(innerBoardY + yDir <= 29)
			currentBlock = currentBoard.board[innerBoardY + yDir][blockX + xDir];
		else
			currentBlock = Main.boardManager.getCurrentBoard(boardHashX + "," + (boardHashY + 1)).board[0][blockX + xDir];
		
		if(!currentBlock.broken) {
			currentBlock.spawnBlockParticles();
			currentBlock.breakBlock();
		}
		
	}
	
	public boolean willCollide(float x, float y, int w, int h) {
		
		Rectangle aRect = new Rectangle((int)(x + 2), (int)(y + 2), w - 4, h - 4);
		boolean hitWall = false;
		
		for(Entity e : Main.entityManager.entityList) {

			if(rectsCollide(aRect, new Rectangle((int)e.x, (int)e.y, e.w, e.h)) &&
					e.collider &&
					e.getClass().getName().contains("Block"))
				hitWall = true;
			
			if(hitWall)
				break;
				
		}
		
		return hitWall;
	}
	
	public boolean rectsCollide(Rectangle a, Rectangle b) {
		return (a.x < b.x + b.width &&
				a.x + a.width > b.x &&
				a.y < b.y + b.height &&
				a.y + a.height > b.y);
	}
	
	public void render(Graphics g) {
		Rectangle renderRect = Main.renderSurface.cam.getRenderRect(new Rectangle((int)x, (int)y, 32, 32));
		Main.renderSurface.drawSprite(g, Sprites.drill, renderRect);
	}
	
}
