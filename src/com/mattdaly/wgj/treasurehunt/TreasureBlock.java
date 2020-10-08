package com.mattdaly.wgj.treasurehunt;

public class TreasureBlock extends Block {

	public TreasureBlock(int x, int y) {
		super(x, y, Sprites.treasure, 1);
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
