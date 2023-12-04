import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
public class SnakeGame extends JPanel{
 private ImageIcon titleImage;
 public SnakeGame() {
  
 }
 public void paint(Graphics g) {
  
  //Drawing title image border
  g.setColor(Color.GREEN);
  g.drawRect(24, 10, 851, 55);
  //Drawing the title image
  titleImage = new ImageIcon("snaketitle.jpg");
  titleImage.paintIcon(this, g, 25, 11);
  //Border for playing area
  g.setColor(Color.BLUE);
  g.drawRect(24, 74, 851, 577);
  //draw bg for the game
  g.setColor(Color.DARK_GRAY);
  g.fillRect(25, 75, 850, 575);
  
 }

}
