package TP9;

import java.awt.Color;


import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;


import TP9.Coordinate;
import TP9.Direction;
import TP9.Game;
import TP9.SnakeEvent;
import TP9.SnakeObservable;
import TP9.SnakeObserver;

public class Gui implements SnakeObserver {

	private Game game;
	private SnakeObservable snake;
	private static final int scale = 10;
	private JFrame frame = new JFrame("Snake");
	private JComponent component = new JComponent() {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			switch(snake.getState()) {
				case INVINCIBLE:
					g.setColor(Color.RED);
					break;
				case NORMAL:
					g.setColor(Color.blue);
					break;
			}
			
			for (Coordinate c : snake.getBody()) {
				g.fillOval(c.getX() * scale, c.getY() * scale, scale, scale);
			}
			if (game.getFruit().isAlive()) {
				Coordinate c = game.getFruit().getCoordinate();
				g.setColor(Color.red);
				g.fillOval(c.getX() * scale, c.getY() * scale, scale, scale);
				}
			Toolkit.getDefaultToolkit().sync();
		}
	};

	public Gui(Game game2) {
		this.game = game2;
		this.snake = game2.getSnake();
		frame.setContentPane(component);
		frame.setSize(game2.getWidth() * scale, game2.getHeight() * scale);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					snake.setDirection(Direction.Left);
					break;
				case KeyEvent.VK_RIGHT:
					snake.setDirection(Direction.Right);
					break;					
				case KeyEvent.VK_UP:
					snake.setDirection(Direction.Up);
					break;
				case KeyEvent.VK_DOWN:
					snake.setDirection(Direction.Down);
					break;					
				default:
					break;
				}

			}
		});
	}

	@Override
	public void notify(List<SnakeEvent> events) {
		component.repaint();
	}

}
