package com.mattdaly.wgj.treasurehunt;

public class TreasureBlock extends Block {
	
	
	
	
	public TreasureBlock(int x, int y) {
		super(x, y, Sprites.treasure, 1);
		
			
			//board[i][j] = new TreasureBlock(x, yInc);
	}

	public void breakBlock(Drill breakingDrill) {
		if(type == "G" || type == "N")
			Main.treasureCt++;
		else if((type.equals("P")))
			Main.treasureCt+=2;
		else if((type.equals("O")))
			Main.treasureCt+=3;
		else if((type.equals("R")))
			Main.treasureCt+=4;
		super.breakBlock(breakingDrill);
		
		
		spawnTreasureParticles();
	}
	

	
	public void spawnTreasureParticles() {
		ParticleSystem particles = new ParticleSystem(x, y);
		//particles.spawnSpriteParticles(8, Sprites.treasureParticle, 12, 12);
		
		if(type == "G" || type == "N")
			particles.spawnSpriteParticles(8, Sprites.treasureParticle, 12, 12);
		else if((type.equals("O")))
			particles.spawnSpriteParticles(8, Sprites.treasureOrangeParticle, 12, 12);
		else if((type.equals("P")))
			particles.spawnSpriteParticles(8, Sprites.treasurePurpleParticle, 12, 12);
		else if((type.equals("R")))
			particles.spawnSpriteParticles(8, Sprites.treasureRedParticle, 12, 12);
			
	}
	
}
