package TP9;

import java.util.Random;

public class Fruit {
	private Game game;
	private Coordinate coordinate;
	private int timer = 0;
	private static final int TIMEOUT = 50;
	
	public Fruit(Game game) {
		this.game = game;
		reset();
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public boolean isAlive() {
		return timer > 0;
	}

	public void kill() {
		timer = 0;
	}

	public void reset() {
		Random r = new Random();
		coordinate = new Coordinate(r.nextInt(game.getHeight()), r.nextInt(game.getWidth()));
		timer = TIMEOUT;
	}
	
	public void action() {
		timer--;
		if(!isAlive()){ 
		game.setTimer();}
		game.chekFruit();
	}

}
