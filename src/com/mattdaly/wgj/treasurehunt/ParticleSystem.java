package com.mattdaly.wgj.treasurehunt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ParticleSystem {

	float x;
	float y;
	
	ArrayList<Particle> particles = new ArrayList<Particle>();
	
	public ParticleSystem(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void spawnParticles(int count, BufferedImage sourceImg) {
		for(int i = 0; i < count; i++) {
			int randX = ThreadLocalRandom.current().nextInt(0, sourceImg.getWidth());
			int randY = ThreadLocalRandom.current().nextInt(0, sourceImg.getHeight());
			
			Color col = new Color(sourceImg.getRGB(randX, randY));
			
			Particle p = new Particle(x, y, new Velocity(1, 1), 30, col);
			Main.entityManager.addEntity(p);
		}
	}
	
	public void update() {
		if(particles.size() < 1)
			return;
		
		for(Particle p : particles) {
			p.update();
		}
	}
	
	public void render(Graphics g) {
		for(Particle p : particles) {
			Main.renderSurface.drawRectangle(g, Main.renderSurface.cam.getRenderRect(new Rectangle((int)p.x, (int)p.y, 3, 3)), p.col);
		}
	}
	
}
