import java.awt.Color;

import javax.swing.JFrame;
public class Game1 {
 public static void main(String[] args) {
  JFrame obj = new JFrame();
  SnakeGame snake = new SnakeGame();
  obj.setBounds(10, 10, 905, 700);
  obj.setBackground(Color.CYAN);
  obj.setResizable(false);
  obj.setVisible(true);
  obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  obj.add(snake);
 }

}
