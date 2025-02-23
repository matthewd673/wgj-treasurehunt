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
			
			float velX = 10 * (ThreadLocalRandom.current().nextFloat() - 0.5f);
			float velY = 10 * (ThreadLocalRandom.current().nextFloat() - 0.5f);
			
			Particle p = new Particle(x, y, new Velocity(velX, velY), 12, col);
			Main.entityManager.addEntity(p);
		}
	}

	public void spawnSpriteParticles(int count, BufferedImage pSprite, int w, int h) {
		for(int i = 0; i < count; i++) {
			float velX = 10 * (ThreadLocalRandom.current().nextFloat() - 0.5f);
			float velY = 10 * (ThreadLocalRandom.current().nextFloat() - 0.5f);
			
			SpriteParticle p = new SpriteParticle(x, y, w, h, new Velocity(velX, velY), 12, pSprite);
			Main.entityManager.addEntity(p);
		}
	}


	
}
