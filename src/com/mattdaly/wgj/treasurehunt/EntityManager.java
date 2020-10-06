package com.mattdaly.wgj.treasurehunt;

import java.util.ArrayList;

public class EntityManager {

	ArrayList<Entity> entityList = new ArrayList<Entity>();
	
	public void addEntity(Entity e) {
		entityList.add(e);
	}
	
	public void removeEntity(Entity e) {
		entityList.remove(e);
	}
	
	public void update() {
		for(Entity e : entityList) {
			e.update();
		}
		
	}
	
}
