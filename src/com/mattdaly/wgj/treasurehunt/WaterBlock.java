package com.mattdaly.wgj.treasurehunt;

public class WaterBlock extends Block {

	public WaterBlock(int x, int y) {
		super(x, y, Sprites.water, 0);
	}

	public void breakBlock(Drill breakingDrill) {

		if(breakingDrill != null)
			breakingDrill.subtractHeat(5);

		super.breakBlock(breakingDrill);
	}

}
