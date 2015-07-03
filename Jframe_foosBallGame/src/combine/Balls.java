package combine;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Balls extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final int UPDATE_RATE = 0;
	/**
	 * @param args
	 */
	public static float ballRadius = 10; // BounceBall's radius
    public static float ballX = 500; // BounceBall's center (x, y)
    public static float ballY = 210;
    public static float ballSpeedX = 20; // BounceBall's speed for x and y
    public static float ballSpeedY = 20;
    float a = 50;
    float b = 960;
    
	public Balls(){
        Thread gameThread = new Thread() 
        {
            public void run()
            {
                while (true)
                { // Execute one update step
                    ballX += ballSpeedX;
                    ballY += ballSpeedY;
                    if (ballX - ballRadius < 0 && ballY - ballRadius > 200 && ballY - ballRadius < 390)
                    {
                        ballX = 50;
                        ballSpeedX = -ballSpeedX;
                        try {
                            Thread.sleep(1000); // milliseconds
                        } catch (InterruptedException ex)
                        {
                    }

                        // ballSpeedX = -ballSpeedX; // Reflect along normal
                        // edge
                    } else if (ballX - ballRadius < 0)
                    {
                        ballSpeedX = -ballSpeedX; // Reflect along normal
                        ballX = ballRadius; // Re-position the BounceBall at the
                                            // edge
                    } 
                    else if (ballX + ballRadius > BounceBall.BOX_WIDTH    && ballY - ballRadius > 200    && ballY - ballRadius < 390) 
                    {
                        ballX = b;
                        ballY = 290;
                        ballSpeedX = -ballSpeedX;
                        try
                        {
                            Thread.sleep(1000); // milliseconds
                        } catch (InterruptedException ex)
                        {
                        }
                    }
                    else if (ballX + ballRadius > BounceBall.BOX_WIDTH)
                    {
                        ballSpeedX = -ballSpeedX;
                        ballX = BounceBall.BOX_WIDTH - ballRadius;
                    }
                    if (ballY - ballRadius < 0)
                    {
                        ballSpeedY = -ballSpeedY;
                        ballY = ballRadius;
                    } 
                    else if (ballY + ballRadius > BounceBall.BOX_HEIGHT) 
                    {
                        ballSpeedY = -ballSpeedY;
                        ballY = BounceBall.BOX_HEIGHT - ballRadius;
                    }
                    repaint(); // Callback paintComponent()
                    // Delay for timing control and give other threads a chance
                    try {
                        Thread.sleep(1000 / UPDATE_RATE); // milliseconds
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        
        
        gameThread.start(); // Callback run()
    }
	 public void paintComponent(Graphics g) {
	        super.paintComponents(g); // Paint background
	        g.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius),
	                (int)(2 * ballRadius), (int)(2 * ballRadius));
	      
	   	       }
	


}
