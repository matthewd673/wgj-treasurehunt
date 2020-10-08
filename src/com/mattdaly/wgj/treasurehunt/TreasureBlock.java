package com.mattdaly.wgj.treasurehunt;

public class TreasureBlock extends Block {
	
	

	public TreasureBlock(int x, int y) {
		super(x, y, Sprites.treasure, 1);
		
			if(y<100)
			sprite = Sprites.treasure;
			else if(y<200)
			sprite = Sprites.purpleTreasure;
			else if(y<300)
			sprite = Sprites.blueTreasure;
			else if(y<400)
			sprite = Sprites.orangeTreasure;
			else
			sprite = Sprites.redTreasure;
			//board[i][j] = new TreasureBlock(x, yInc);
	}

	public void breakBlock(Drill breakingDrill) {
		Main.treasureCt++;
		super.breakBlock(breakingDrill);
		spawnTreasureParticles();
	}
	
	public void spawnTreasureParticles() {
		ParticleSystem particles = new ParticleSystem(x, y);
		particles.spawnSpriteParticles(8, Sprites.treasureParticle, 12, 12);
	}
	
}
