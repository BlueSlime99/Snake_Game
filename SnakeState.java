package TP9;

public abstract class  SnakeState {
   public enum State{
	   INVINCIBLE, 
	   NORMAL;
   }
	
	protected SnakeObservable snake;
	
	protected SnakeState(SnakeObservable snake){
	this.snake = snake;
	}
	
	public abstract void move();

	protected abstract State getState();
}
