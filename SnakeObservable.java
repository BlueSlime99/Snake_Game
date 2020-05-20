package TP9;

import java.util.ArrayList;
import java.util.List;

import TP9.SnakeEvent.ChangeType;
import TP9.SnakeState.State;
public class SnakeObservable {

	private final int INITSIZE = 3;
	private SnakeState state;
	private List<Coordinate> body;
	private Game game;
	private Direction direction;
	private boolean alive;
	private List<SnakeObserver> observers;
	
	public SnakeObservable(Game game, Coordinate start) {
		observers = new ArrayList<>();
		alive = true;
		state = new NormalState(this);
		this.game = game;
		direction = Direction.Right;
		body = new ArrayList<>();
		for (int i = 0; i < INITSIZE; i++) {
			body.add(new Coordinate(start.getX() + i, start.getY()));
		}
	}
	
	public State getState() {
		return state.getState();
	}
	public void setState(SnakeState state) {
		this.state = state;
	}


	public void register(SnakeObserver o) {
		observers.add(o);
	}

	public void unregister(SnakeObserver o) {
		observers.remove(o);
	}

	public void notifyObserver(List<SnakeEvent> events) {
		for (SnakeObserver snakeObserver : observers) {
			snakeObserver.notify(events);
		}
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public List<Coordinate> getbody() {
		return new ArrayList<>(body);
	}

	public List<Coordinate> getBody() {
		return body;
	}
	
	public void setIsAlive(Boolean alive) {
		this.alive = alive;
	}
	
	public Game getGame() {
		return game;
	}

	public void move() {
		/*Coordinate current = body.get(body.size() - 1);
		Coordinate next = new Coordinate(current.getX() + direction.getX(), current.getY() + direction.getY());
		if(body.contains(next) || game.isOut(next))
			alive = false;
		body.add(next);
		List<SnakeEvent> events = new ArrayList<>();
		events.add(new SnakeEvent(next, ChangeType.ENTER));
		events.add(new SnakeEvent(body.get(0),ChangeType.LEAVE));
		notifyObserver(events);		
		body.remove(0);*/
		state.move();
	}

	public boolean isAlive() {
		return alive;
	}

}
