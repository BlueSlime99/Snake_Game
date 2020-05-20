package TP9;

import java.util.List;



public class App {

	static final int SPEED = 75;

	public static void main(String[] args) {
		Game game = new Game(50, 50, new Coordinate(20, 30));
		game.getSnake().register(new Gui(game));
		game.getSnake().register(new SnakeObserver() {
			@Override
			public void notify(List<SnakeEvent> events) {
				for (SnakeEvent event : events) {
					System.out.println(event);
				}
			}
		});
		while (game.getSnake().isAlive()) {
			game.step();
			try {
				Thread.sleep(SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}