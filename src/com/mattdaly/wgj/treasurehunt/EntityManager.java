package com.mattdaly.wgj.treasurehunt;

import java.util.ArrayList;
import java.util.Hashtable;

public class EntityManager {

	ArrayList<Entity> addQueue = new ArrayList<Entity>();
	ArrayList<Entity> removeQueue = new ArrayList<Entity>();
	
	Hashtable<String, ArrayList<Entity>> entityTable = new Hashtable<String, ArrayList<Entity>>();
	
	public void addEntity(Entity e) {
		
		if(entityTable.containsKey(e.hash))
			entityTable.get(e.hash).add(e);
		else {
			ArrayList<Entity> newCell = new ArrayList<Entity>();
			newCell.add(e);
			entityTable.put(e.hash, newCell);
		}
	}
	
	public void removeEntity(Entity e) {
		removeQueue.add(e);
	}
	
	public void update() {
		/*
		for(Entity e : entityList) {
			e.update();
		}
		
		for(Entity e : addQueue) {
			entityList.add(e);
			System.out.println(e.x + " " + e.y);
		}
		addQueue.clear();
		
		for(Entity e : removeQueue) {
			entityList.remove(e);
		}
		removeQueue.clear();
		*/
	
		ArrayList<Entity> updateEntities = getEntitiesInRange((int)Main.renderSurface.cam.x, (int)Main.renderSurface.cam.y, Main.renderSurface.cam.screenW, Main.renderSurface.cam.screenH);
		for(Entity e : updateEntities) {
			
			String oldHash = e.hash;
			e.update();
			
			if(!e.hash.equals(oldHash)) { //entity has moved in hash table
				if(entityTable.containsKey(oldHash))
					entityTable.get(oldHash).remove(e);
				addEntity(e);
			}
		}
		
		
	}
	
	public ArrayList<Entity> getEntitiesInRange(int x, int y, int w, int h)
	{
		int cellX = x / 256;
		int cellY = y / 256;
		int cellW = w / 256;
		int cellH = h / 256;
		
		ArrayList<Entity> entities = new ArrayList<Entity>();
		
		for(int i = cellX - 1; i < cellX + cellW + 1; i++)
		{
			for(int j = cellY - 1; j < cellY + cellH + 1; j++)
			{				
				if(entityTable.containsKey(i + "," + j))
					entities.addAll(entityTable.get(i + "," + j));
			}
		}
		
		return entities;
		
	}
	
}
