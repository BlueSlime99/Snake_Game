package TP9;

import java.util.ArrayList;
import java.util.List;

import TP9.SnakeEvent.ChangeType;

public class NormalState extends SnakeState{
	private State state;

	protected NormalState(SnakeObservable snake) {
		super(snake);
		state = State.NORMAL;
		
	}

	@Override
	public void move() {
		Coordinate current = snake.getBody().get(snake.getBody().size() - 1);
		Coordinate next = new Coordinate(current.getX() + snake.getDirection().getX(), current.getY() + snake.getDirection().getY());
		if(snake.getBody().contains(next) || snake.getGame().isOut(next))
			snake.setIsAlive(false);
		snake.getBody().add(next);
		List<SnakeEvent> events = new ArrayList<>();
		events.add(new SnakeEvent(next, ChangeType.ENTER));
		events.add(new SnakeEvent(snake.getBody().get(0),ChangeType.LEAVE));
		snake.notifyObserver(events);		
		snake.getBody().remove(0);		
	}

	@Override
	protected State getState() {
		// TODO Auto-generated method stub
		return state;
	}
	

}
