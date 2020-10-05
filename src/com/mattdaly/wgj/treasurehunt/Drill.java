package com.mattdaly.wgj.treasurehunt;

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
	
	public Drill(float x, float y)
	{
		super(Sprites.drill, x, y, 32, 32);
	}
	
	public void update()
	{
		//make camera follow drill
		Main.renderSurface.cam.lockToEntity(this);
	}
	
}
