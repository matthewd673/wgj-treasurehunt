package com.mattdaly.wgj.treasurehunt;

import java.util.ArrayList;

public class EntityManager {

	ArrayList<Entity> entityList = new ArrayList<Entity>();
	
	ArrayList<Entity> addQueue = new ArrayList<Entity>();
	
	public void addEntity(Entity e) {
		addQueue.add(e);
	}
	
	public void removeEntity(Entity e) {
		entityList.remove(e);
	}
	
	public void update() {
		for(Entity e : entityList) {
			e.update();
		}
		
		entityList.addAll(addQueue);
		addQueue.clear();
	}
	
}
