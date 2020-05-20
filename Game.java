package TP9;


public class Game {
	
	private int height;
	private int width;
	private SnakeObservable snake;
	private Fruit fruit;
	private static final int FRUIT_PERIOD = 20;
	private static final int INVINCIBLE_PERIOD = 40;
	private int invinciblePeriode ;

	private int timerFruit;

	public Game(int width, int height, Coordinate c) {
		this.height = height;
		this.width = width;
		snake = new SnakeObservable(this, c);
		fruit = new Fruit(this);
		timerFruit = FRUIT_PERIOD;
		invinciblePeriode = 0;
		
	}	
	
	public void chekCoo() {
		if(snake.getBody().get(snake.getBody().size()-1).equals(fruit.getCoordinate())){
			snake.setState(new InvincibleState(snake));
			invinciblePeriode = INVINCIBLE_PERIOD;
			fruit.kill();
		}
	}
	
	public void setTimer() {
		timerFruit--;
	}
	
	public void chekFruit() {
		if(timerFruit == 0) {
			fruit.reset();
			timerFruit = FRUIT_PERIOD;
		}
	}
	
	public void setInvincible() {
		invinciblePeriode--;
	}

	public SnakeObservable getSnake() {
		return snake;
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public Fruit getFruit() {
		return fruit;
	}
	
	
	
	 boolean isOut(Coordinate c) {
		if (c.getX() < 0 || c.getY() < 0)
			return true;
		if (c.getX() >= width || c.getY() >= height)
			return true;
		return false;
	}

	public void step() {
		snake.move();
		fruit.action();
		chekCoo();
		chekInv();
	}

	private void chekInv() {
		if(invinciblePeriode == 0) {
			snake.setState(new NormalState(snake));
		}
	}

	public Coordinate invincible(Coordinate next, Coordinate current) {
		if(next.getX() == width -1) {
			return new Coordinate(0, current.getY());
		}else if(next.getY() == height -1) {
			return new Coordinate(current.getX(), 0);
		}else if( next.getY() == 0) {
			return new Coordinate(current.getX(), height);
		}else if(next.getX() == 0) {
			return new Coordinate(width, current.getY());
		}
		return next;
		
	}


}
