package com.mattdaly.wgj.treasurehunt;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Drill extends Entity {

	int speed = 5;

	public int drillHeat = 0;
	final int maxHeat = 40;
	
	public int blockX;
	public int blockY;
	public int boardHashX;
	public int boardHashY;
	public int innerBoardY;
	
	//feeds different drill images to sprite image
		public AnimationManager animationManager;

	
	public Drill(float x, float y)
	{
		super(Sprites.drill1, x, y, 32, 32);
		a = new Acceleration(0, 4.9f);
		
		animationManager = new AnimationManager();
	}
	
	public void update()
	{
			
		acceptInput();
		
		//System.out.println(a.accelY + " " + v.velY + " " + y);
		
		//make camera follow drill
		Main.renderSurface.cam.lockToEntity(this);
		
		v.velX += a.accelX;
		v.velY += a.accelY;
		
		if(v.velY > 4)
			v.velY = 4;
		
		//move drill according to velocity
		moveDrill(x + v.velX, y + v.velY);
		
		//find current drill block
		blockX = Math.round(x / 32);
		blockY = Math.round(y / 32);
		
		boardHashX = Math.round(blockX / 30);
		boardHashY = Math.round(blockY / 30);
		
		innerBoardY = Math.round(blockY - (boardHashY * 30));
		
		//create new board if too far through the current one 
		if(innerBoardY > 15 && !Main.boardManager.boardTable.containsKey("0," + (boardHashY + 1)))
			Main.boardManager.createBoard(0, boardHashY + 1);

		//check if dead
		if(drillHeat > maxHeat)
			Main.entityManager.removeEntity(this);

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
		
		if(!willCollide(newX, y, w, h))
			x = newX;
		if(!willCollide(x, newY, w, h))
			y = newY;
	}
	
	public void mineBlock(int xDir, int yDir) {
				
		Board currentBoard = Main.boardManager.getCurrentBoard(boardHashX + "," + boardHashY);
		Block currentBlock;
		
		if(innerBoardY + yDir <= 29)
			currentBlock = currentBoard.board[innerBoardY + yDir][blockX + xDir];
		else
			currentBlock = Main.boardManager.getCurrentBoard(boardHashX + "," + (boardHashY + 1)).board[0][blockX + xDir];

		if(!currentBlock.broken) {
			currentBlock.spawnBlockParticles();
			currentBlock.breakBlock(this);
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
		Main.renderSurface.drawSprite(g, animationManager.getCurrentDrill(), renderRect);
	}

	public void addHeat(int heatAmount) {
		drillHeat += heatAmount;
	}

	public void resetDrillHeat() {
		drillHeat = 0;
	}

	public void subtractHeat(int heatAmount) {
		drillHeat -= heatAmount;
		if(drillHeat < 0)
			drillHeat = 0;
	}
	
}
