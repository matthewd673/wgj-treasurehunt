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
	
	public int blockX;
	public int blockY;
	
	int minTimeBetweenBreaks = 30;
	int timeBetweenBreaks = 0;
	
	public Drill(float x, float y)
	{
		super(Sprites.drill, x, y, 32, 32);
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
		
		acceptInput();
		
		//make camera follow drill
		Main.renderSurface.cam.lockToEntity(this);
	}
	
	public void acceptInput()
	{
		if(Main.inputManager.isKeyPressed('w'))
			moveDrill(x, y - 32);
		if(Main.inputManager.isKeyPressed('a'))
			moveDrill(x - 32, y);
		if(Main.inputManager.isKeyPressed('s'))
			moveDrill(x, y + 32);
		if(Main.inputManager.isKeyPressed('d'))
			moveDrill(x + 32, y);
	}
	
	public void moveDrill(float newX, float newY)
	{
		if(timeBetweenBreaks < minTimeBetweenBreaks)
			return; //can't move yet
		
		x = newX;
		y = newY;
	}
	
	public void render(Graphics g) {
		Rectangle renderRect = Main.renderSurface.cam.getRenderRect(new Rectangle(blockX * 32, blockY * 32, 32, 32));
		Main.renderSurface.drawSprite(g, Sprites.drill, renderRect);
	}
	
}
