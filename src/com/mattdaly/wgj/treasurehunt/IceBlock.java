package com.mattdaly.wgj.treasurehunt;

public class IceBlock extends Block {

	public IceBlock(int x, int y) {
		super(x, y, Sprites.ice, 1);
	}

	public void breakBlock(Drill breakingDrill) {

		if(breakingDrill != null) {
			breakingDrill.resetDrillHeat();
			breakingDrill.maxHeat += 1;
		}

		super.breakBlock(breakingDrill);
	}

}
