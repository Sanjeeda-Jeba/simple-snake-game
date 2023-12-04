		package snake;
		
		import java.awt.Dimension;
		
		import java.awt.Point;
		
		import java.awt.Toolkit;
		
		import java.awt.event.ActionEvent;
		
		import java.awt.event.ActionListener;
   
		import java.awt.event.KeyEvent;

		import java.awt.event.KeyListener;

		import java.util.ArrayList;
        
		import java.util.Random;

        import javax.swing.Timer;
		
		import javax.swing.JFrame;
		
		        public class Snake implements ActionListener ,KeyListener{
			
		        	public RenderPanel renderPanel;
			
		        	public JFrame jFrame;
			
		        	public Toolkit toolkit;
			
		        	public static Snake snake;
			
		        	public Timer timer = new Timer(20,this);
			
		        	public ArrayList<Point> snakeParts = new ArrayList<Point>();
			
		        	public static final int UP=0, DOWN=1, LEFT=2, RIGHT=3, SCALE=10;
			
		        	public int ticks = 0, direction =DOWN,score=0,tailLength=10,time;
			
			
		        	public Point head,cherry;
		        	public Dimension dim;
			
		        	public Random random;
		        	public boolean over = false, paused;
			
			
			
			
			
			        public Snake() {
				
			        	 dim = Toolkit.getDefaultToolkit().getScreenSize();
			 
			        	jFrame = new JFrame("Snake");
			
			        	jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        	
			        	jFrame.setResizable(false);
			        	
			        	jFrame.addKeyListener(this);
			 
			        	jFrame.setVisible(true);
			 
			        	jFrame.setSize(800, 700);
			 
			        	jFrame.setLocation(dim.width/2 - jFrame.getWidth()/2, dim.height/2-jFrame.getHeight()/2);
			 
			        	jFrame.add(renderPanel=new RenderPanel());
			            
			        	startGame();
		
			 
			            }
			        public void startGame() {
			        	
			        	over = false;
			        	paused= false;
			        	score=0;
			        	time=0;
			        	tailLength=3;
			        	direction = DOWN;
			        	
						
			        	random = new Random();
			        	snakeParts.clear();
			
			        	head = new Point(0,0);
			 
			        	cherry = new Point(random.nextInt(79),random.nextInt(66));
			        	
			        	for(int i =0;i<tailLength;i++) {
			        		
			        		snakeParts.add(new Point(head.x,head.y));
			        	}

			        	timer.start();
			        	
			        }
			
			
			
			
			
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				renderPanel.repaint();
				
				         ++ticks;
				
				         if(ticks%7==0 && head!=null && !over && !paused) {
				        	 
				        	 snakeParts.add(new Point(head.x,head.y));
					
				        	 if(direction == UP) {
				        		 
				        		 if(head.y-1>=0 && noTailAt(head.x,head.y-1))
						            
				        			 head=new Point(head.x,head.y-1);
				        		 else
				        			 over = true;
					          }
		           
				        	 if(direction == DOWN) {
				        		
				        		 if(head.y+1<67 &&  noTailAt(head.x,head.y+1))
						
						        head=new Point(head.x,head.y+1);
				        		 else
				        			 over = true;
				        			 
					           }
		           
				        	 if(direction == LEFT) {
			                      if(head.x-1>=0 &&  noTailAt(head.x-1,head.y))
			                   head=new Point(head.x-1,head.y);
			                      else
			                    	  over=true;
		                       }
		           
				        	 if(direction == RIGHT) 
			                   if(head.x+1<80 && noTailAt(head.x+1,head.y))
			                   head=new Point(head.x+1,head.y);
			                   else
			                	   over=true;
			                 
				        	 if(snakeParts.size()>tailLength) {
				        		 
				        		 snakeParts.remove(0);
				        	 }
				        	  
		                       
		          
				        	 if(cherry!=null) {
		            	
				        		 if(head.equals(cherry)) {
		            		            score+=10;
		            		            tailLength++;
		            		          cherry.setLocation(random.nextInt(79),random.nextInt(66));
		            	       }
		            	
		                    }
				        }
			}

			          public boolean  noTailAt(int x, int y) {
				            
			        	  for(Point point : snakeParts) {
			        		  if(point.equals(new Point(x,y)))
			        			  return false;
			        	  }
			        	  
				                 return true;
			}
					public static void main(String[] args) {
				         snake = new Snake();
				
		
			           }







					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}







					@Override
					public void keyPressed(KeyEvent e) {
						int i =e.getKeyCode();
						if(i== KeyEvent.VK_A&& direction !=RIGHT)
							direction = LEFT;
						if(i== KeyEvent.VK_D&& direction !=LEFT)
							direction = RIGHT;
						if(i== KeyEvent.VK_W&& direction !=DOWN)
							direction = UP;
						if(i== KeyEvent.VK_S && direction !=UP)
							direction = DOWN;
						if(i== KeyEvent.VK_SPACE)
							if(over)
							startGame();
							else
								paused = !paused;
						
					}







					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
		}
