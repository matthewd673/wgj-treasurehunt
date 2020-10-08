package com.mattdaly.wgj.treasurehunt;

import java.util.ArrayList;

public class EntityManager {

	ArrayList<Entity> entityList = new ArrayList<Entity>();
	
	private ArrayList<Entity> addQueue = new ArrayList<Entity>();
	private ArrayList<Entity> removeQueue = new ArrayList<Entity>();
	
	public void addEntity(Entity e) {
		addQueue.add(e);
	}
	
	public void removeEntity(Entity e) {
		removeQueue.add(e);
	}
	
	public void update() {
		for(Entity e : entityList) {
			e.update();
		}
		
		entityList.removeAll(removeQueue);
		removeQueue.clear();
		
		entityList.addAll(addQueue);
		addQueue.clear();
	}
	
}
