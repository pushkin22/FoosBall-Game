package combine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Shape;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BounceBall extends JPanel implements ActionListener, KeyListener {

private static final long serialVersionUID = 1L;
JButton b1;
JLabel l1;
static final int BOX_WIDTH = 1001;
static final int BOX_HEIGHT = 600;
static float ballRadius = 10; // BounceBall's radius
private float ballX = 980; // BounceBall's center (x, y)
private float ballY = 300;// 300
private float ballSpeedX = 5; // BounceBall's speed for x and y
private float ballSpeedY = 5;
float a = 50;
float b = 960;
private static final int UPDATE_RATE = 30; // Number of refresh per second
Shape[] shape = new Shape[10];
Timer tm = new Timer(5, this);
float[] y = new float[10];
Image bgimage = null;
int valX = 0;
int valY = -1;
int velocityC = 0;
String cc;
String cc2;
int y11 = 310;
int y1 = BOX_HEIGHT / (Secondscreen.d + 1);
int y2 = BOX_HEIGHT / (Secondscreen.d1 + 1);
int y3 = BOX_HEIGHT / (Secondscreen.d2 + 1);
static int x1 = BOX_WIDTH / 7;
int velocityX = 0;
float velocityY = 0;
float d = 0.5f;
int y21 = 300;
float y10 = 300;
float y12 = 300;
float[] yd = new float[10];
Shape[] compshape = new Shape[10];
static int mid;
static int defend;
static int total;
static int strike;
static int yc1;
static int yc2;
static int yc3;
Shape shape12;
float defspeed = 1;
float midspeed = (Secondscreen.d + 1) / (Secondscreen.d1 + 1);
float strspeed = (Secondscreen.d + 1) / (Secondscreen.d2 + 1);
float velocityY1 = 0;
float velocityY2 = 0;
float velocityY3 = 0;
float velocityG = 0;

public BounceBall() {
tm.start();
addKeyListener(this);
setFocusable(true);
setFocusTraversalKeysEnabled(false);
this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
MediaTracker mt = new MediaTracker(this);
bgimage = Toolkit.getDefaultToolkit().getImage("n2.png");
mt.addImage(bgimage, 0);
try {
mt.waitForAll();
} catch (InterruptedException e) {
e.printStackTrace();
}
/*
JPanel panel = new JPanel();
      
      panel.setLayout(null);

      JButton quitButton = new JButton("Quit");
      quitButton.setBounds(50, 60, 80, 30);
      quitButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {
              System.exit(0);
         }
      });

      panel.add(quitButton);*/

       // setJMenuBar(menubar);

// Ballstart.check();
/*
* if(Secondscreen.flag == true){ ballX = 50; //
* System.out.println(BounceBall.ballX);
* System.out.println("Player wins toss"); // ballY = 300; } else
* if(!Secondscreen.flag) { // BounceBall.ballX = 980;
* //System.out.println(BounceBall.ballX);
* System.out.println("Computer wins toss"); } else {
* System.out.println("Oops, no choice"); }
*/
final TextField textfield = new TextField("");
add(textfield);
final TextField textfield3 = new TextField("       ");
add(textfield3);
final TextField textfield2 = new TextField("");
add(textfield2);
Thread gameThread = new Thread() {
public void run() {
while (true) { // Execute one update step
ballX += ballSpeedX;
ballY += ballSpeedY;
if (ballX - ballRadius < 0 && ballY - ballRadius > 200
&& ballY - ballRadius < 390) {
ballX = 50;
valX++;
cc = Integer.toString(valX);
textfield.setText(cc);
if (valX >= 5) {
textfield3.setText("Player wins");

break;

}
// System.out.println(valX);
// ballY =y11;
ballSpeedX = -ballSpeedX;
try {
Thread.sleep(1000); // milliseconds
} catch (InterruptedException ex) {
}
} else if (ballX - ballRadius >= x1 - 40
&& ballX - ballRadius <= x1 + 40) {
for (int i = 0; i < Secondscreen.d; i++) {

if (ballY - ballRadius >= y[i]
&& ballY - ballRadius < (y[i] + 20)) {

if (ballX <= x1) {
ballSpeedX = ballSpeedX;
ballSpeedY =  -ballSpeedY;
ballX = x1 + 10;
break;
} else if (ballX >= x1 + 20) {
ballSpeedX = -ballSpeedX;
ballSpeedY = -ballSpeedY;
break;
}
ballX = x1 - ballRadius;
// ballSpeedY = -ballSpeedY;
ballY = y[i] - ballRadius;
} 
}
}
else if (ballX - ballRadius >= 25
&& ballX - ballRadius <= 45) {
if (ballY - ballRadius >= 300
&& ballY - ballRadius <= 330) {
ballSpeedX = -ballSpeedX;
ballX = y[0];
ballY = x1;
}
}
if (ballX - ballRadius >= (3 * x1)-40
&& ballX - ballRadius <= (3 * x1) + 40) {
for (int j = 0; j < Secondscreen.d1; j++) {
if (ballY - ballRadius >= y[j + Secondscreen.d]
&& ballY - ballRadius <= y[j
+ Secondscreen.d] + 20) {
// System.out.println("5");
if (ballX <= 429) {
ballSpeedX = ballSpeedX;
ballSpeedY = -ballSpeedY;
ballX = 3 * x1 + 10;
break;
} else if (ballX >= 449) {
ballSpeedX = -ballSpeedX;
ballSpeedY = -ballSpeedY;
break;
}
ballX = x1 * 3 - ballRadius;
// ballSpeedY = -ballSpeedY;
ballY = y[j + Secondscreen.d] - ballRadius;
}

}
}

else if (ballX - ballRadius >= (5 * x1)-40
&& ballX - ballRadius <= (5 * x1) + 40) {

for (int k = 0; k < Secondscreen.d2; k++) {
if (ballY - ballRadius >= y[k + Secondscreen.d
+ Secondscreen.d1]
&& ballY - ballRadius <= y[k
+ Secondscreen.d + Secondscreen.d1] + 20) {
// System.out.println("5");
if (ballX <= 715) {
ballSpeedX = ballSpeedX;
ballSpeedY = -ballSpeedY;
ballX = 5 * x1 + 10;
// ballSpeedY = -ballSpeedY;
break;
} else if (ballX >= 735) {
ballSpeedX = -ballSpeedX;
ballSpeedY = -ballSpeedY;
break;
}
ballX = x1 * 5 - ballRadius;
// ballSpeedY = -ballSpeedY;
ballY = y[k + Secondscreen.d + Secondscreen.d1]
- ballRadius;
}

}

}

else if (ballX - ballRadius >= (6 * x1)-40
&& ballX - ballRadius <= (6 * x1) + 40) {

for (int i = 0; i < defend; i++) {
if (Secondscreen.d3 == 1) {
if (ballY - ballRadius >= yd[i]
&& ballY - ballRadius <= yd[i] + 10) {
// System.out.println("5");
if (ballX <= 858) {
ballSpeedX = -ballSpeedX;
ballSpeedY = -ballSpeedY;
ballX= x1*6 +30;
//ballY = 838;
// ballSpeedY = -ballSpeedY;
break;
} else if (ballX >= 878) {
ballSpeedX = ballSpeedX;
ballSpeedY = -ballSpeedY;
ballX= x1*6 +30;
//ballY = 838;
//ballX = 6 * x1 + 10;
break;
}
ballX = x1 * 6 - ballRadius;
// ballSpeedY = -ballSpeedY;
ballY = yd[i] - ballRadius;
}
}
if (Secondscreen.d3 == 2) {
if (ballY - ballRadius >= yd[i]
&& ballY - ballRadius <= yd[i] + 20) {
// System.out.println("5");
if (ballX <= 858) {
ballSpeedX = -ballSpeedX;
ballSpeedY = -ballSpeedY;
// ballSpeedY = -ballSpeedY;
ballX= x1*6 +30;
ballY = 838;
break;
} else if (ballX >= 878) {
ballSpeedX = ballSpeedX;
ballSpeedY = -ballSpeedY;
ballX= x1*6 +30;
ballY = 838;
//ballX = 6 * x1 + 10;
break;
}
ballX = x1 * 6 - ballRadius;
// ballSpeedY = -ballSpeedY;
ballY = yd[i] - ballRadius;
}
}
if (Secondscreen.d3 == 3) {
if (ballY - ballRadius >= yd[i]
&& ballY - ballRadius <= yd[i] + 30) {
// System.out.println("5");
if (ballX <= 858) {
ballSpeedX = -ballSpeedX;
ballSpeedY = -ballSpeedY;
ballX= x1*6 +30;
ballY = 838;
break;
} else if (ballX >= 878) {
ballSpeedX = ballSpeedX;
ballSpeedY = -ballSpeedY;
ballX= x1*6 +30;
ballY = 838;
//ballX = 6 * x1 + 10;
break;
}
ballX = x1 * 6 - ballRadius;
// ballSpeedY = -ballSpeedY;
ballY = yd[i] - ballRadius;
}
}
}

} else if (ballX - ballRadius >= (4 * x1)-40
&& ballX - ballRadius <= (4 * x1) + 40) {
for (int i = 0; i < mid; i++) {
if (Secondscreen.d3 == 1) {
if (ballY - ballRadius >= yd[i + defend]
&& ballY - ballRadius <= yd[i + defend] + 10) {
// System.out.println("5");
if (ballX <= 572) {
ballSpeedX = -ballSpeedX;
ballSpeedY = -ballSpeedY;
ballX= x1*4 +30;
//ballY = 552;
break;
} else if (ballX >= 592) {
ballSpeedX = +ballSpeedX;
ballSpeedY = -ballSpeedY;
//ballX = 4 * x1 + 10;
ballX= x1*4 +30;
//ballY = 552;
break;
}
ballX = x1 * 4 - ballRadius;
// ballSpeedY = -ballSpeedY;
ballY = yd[i + defend] - ballRadius;
}
}
if (Secondscreen.d3 == 2) {
if (ballY - ballRadius >= yd[i + defend]
&& ballY - ballRadius <= yd[i + defend] + 20) {
// System.out.println("5");
if (ballX <= 572) {
ballSpeedX = -ballSpeedX;
ballSpeedY = -ballSpeedY;
ballX= x1*4 +30;
ballY = 552;
break;
} else if (ballX >= 592) {
ballSpeedX = +ballSpeedX;
ballSpeedY = ballSpeedY;
ballX= x1*4 +30;
ballY = 552;
break;
}
ballX = x1 * 4 - ballRadius;
// ballSpeedY = -ballSpeedY;
ballY = yd[i + defend] - ballRadius;
}
}
if (Secondscreen.d3 == 3) {
if (ballY - ballRadius >= yd[i + defend]
&& ballY - ballRadius <= yd[i + defend] + 30) {
// System.out.println("5");
if (ballX <= 572) {
ballSpeedX = -ballSpeedX;
ballSpeedY = -ballSpeedY;
ballX= x1*4 +30;
ballY = 552;
break;
} else if (ballX >= 592) {
ballSpeedX = +ballSpeedX;
ballSpeedY=-ballSpeedY;
ballX= x1*4 +30;
ballY = 552;
//ballX = 4 * x1 + 10;
break;
}
ballX = x1 * 4 - ballRadius;
// ballSpeedY = -ballSpeedY;
ballY = yd[i + defend] - ballRadius;
}
}
}

} else if (ballX - ballRadius >= (2 * x1)-40
&& ballX - ballRadius <= (2 * x1) + 40) {
for (int i = 0; i < strike; i++) {
if (Secondscreen.d3 == 1) {
if (ballY - ballRadius >= yd[i + defend + mid]
&& ballY - ballRadius <= yd[i + defend
+ mid] + 10) {
// System.out.println("5");
if (ballX <= 286) {
ballSpeedX = -ballSpeedX;
ballSpeedY = -ballSpeedY;
ballX= x1*2 +30;
//ballY = 266;
break;
} else if (ballX >= 306) {
ballSpeedX = +ballSpeedX;
ballSpeedY = -ballSpeedY;
//ballX = x1 * 2 + 10;
ballX= x1*2 +30;
//ballY = 266;
break;
}
ballX = x1 * 2 - ballRadius;
// ballSpeedY = -ballSpeedY;
ballY = yd[i + defend + strike]
- ballRadius;
}
}
if (Secondscreen.d3 == 2) {
if (ballY - ballRadius >= yd[i + defend + mid]
&& ballY - ballRadius <= yd[i + defend
+ mid] + 20) {
// System.out.println("5");
if (ballX <= 286) {
ballSpeedX = -ballSpeedX;
ballSpeedY = -ballSpeedY;
ballX= x1*2 +30;
ballY = 266;
break;
} else if (ballX >= 306) {
ballSpeedX = +ballSpeedX;
ballSpeedY = -ballSpeedY;
ballX = x1 * 2 + 30;
ballY = 266;
break;
}
ballX = x1 * 2 - ballRadius;
// ballSpeedY = -ballSpeedY;
ballY = yd[i + defend + strike]
- ballRadius;
}
}
if (Secondscreen.d3 == 3) {
if (ballY - ballRadius >= yd[i + defend + mid]
&& ballY - ballRadius <= yd[i + defend
+ mid] + 30) {
// System.out.println("5");
if (ballX <= 286) {
ballSpeedX = -ballSpeedX;
ballSpeedY = -ballSpeedY;
ballX= x1*2 +30;
ballY = 266;
break;
} else if (ballX >= 306) {
ballSpeedX = +ballSpeedX;
ballSpeedY = -ballSpeedY;
ballX = x1 * 2 + 30;
ballY = 266;
break;
}
ballX = x1 * 2 - ballRadius;
// ballSpeedY = -ballSpeedY;
ballY = yd[i + defend + strike]
- ballRadius;
}
}

}

}

else if (ballX - ballRadius < 0) {
ballSpeedX = -ballSpeedX; // Reflect along normal
ballX = ballRadius; // Re-position the BounceBall at the
// edge
} else if (ballX + ballRadius > BOX_WIDTH
&& ballY - ballRadius > 200
&& ballY - ballRadius < 390) {
ballX = b;
ballY = 290;
ballSpeedX = -ballSpeedX;
valY++;
cc2 = Integer.toString(valY);
textfield2.setText(cc2);

if (valY >= 5) {
textfield3.setText("Player wins");


break;
}
} else if (ballX + ballRadius > BOX_WIDTH) {
ballSpeedX = -ballSpeedX;
ballX = BOX_WIDTH - ballRadius;
}
if (ballY - ballRadius < 0) {
ballSpeedY = -ballSpeedY;
ballY = ballRadius;
} else if (ballY + ballRadius > BOX_HEIGHT) {
ballSpeedY = -ballSpeedY;
ballY = BOX_HEIGHT - ballRadius;
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

PlayerOneFormation();
compForm();

gameThread.start(); // Callback run()
}

public static int getdefend() {
defend = (int) (Math.random() * 4) + 3;
System.out.println(defend);
return defend;
}

public static int getmid() {
mid = (int) (Math.random() * 4) + 3;
System.out.println("mid");
return mid;
}

public static int getstrike() {
strike = (int) (Math.random() * 4) + 1;
System.out.println("strike");
return strike;
}

public static int getTotal() {
total = getdefend() + getmid() + getstrike();
System.out.println("total");
return total;
}

public static boolean check() {
while (total != 10) {
getTotal();
}
System.out.println("check");
return true;
}

public void assign() {
if (check()) {
yc1 = BOX_HEIGHT / (defend + 1);
yc2 = BOX_HEIGHT / (mid + 1);
yc3 = BOX_HEIGHT / (strike + 1);
}
System.out.println("assign");
}

public static int axis1() {
return yc1;
}

public static int axis2() {
return yc2;
}

public static int axis3() {
return yc3;
}

public void compDefend() {
System.out.println("defenderss");
for (int i = 0; i < defend; i++) {
yd[i] = axis1() * (i + 1);
compshape[i] = new Rectangle2D.Float(6 * x1, yd[i], 20, 20);
}
System.out.println(axis1());
}

public void compmid() {
for (int i = 0; i < mid; i++) {
yd[i + defend] = axis2() * (i + 1);
compshape[i + defend] = new Rectangle2D.Float(4 * x1,
yd[i + defend], 20, 20);
}
System.out.println(axis2());
}

public void compstrike() {
for (int i = 0; i < strike; i++) {
yd[i + defend + mid] = axis3() * (i + 1);
compshape[i + defend + mid] = new Rectangle2D.Float(2 * x1, yd[i
+ defend + mid], 20, 20);
}
System.out.println(axis3());
}

public void compForm() {
assign();

compDefend();

compmid();
compstrike();
}

public void defenders() {
for (int i = 0; i < Secondscreen.d; i++) {
y[i] = y1 * (i + 1);
shape[i] = new Rectangle2D.Float(x1, y[i], 20, 20);
}

}

public void mid() {
for (int j = 0; j < Secondscreen.d1; j++) {

y[j + Secondscreen.d] = (j + 1) * y2;
shape[j + Secondscreen.d] = new Rectangle2D.Float(3 * x1, y[j
+ Secondscreen.d], 20, 20);
}
}

public void striker() {
for (int k = 0; k < Secondscreen.d2; k++) {
y[k + Secondscreen.d + Secondscreen.d1] = (k + 1) * y3;
shape[k + Secondscreen.d + Secondscreen.d1] = new Rectangle2D.Float(
5 * x1, y[k + Secondscreen.d + Secondscreen.d1], 20, 20);
}
}

public void PlayerOneFormation() {
defenders();
mid();
striker();
System.out.println("Once");
}

/** Custom rendering codes for drawing the JPanel */
// @Override
public void paintComponent(Graphics g) {
super.paintComponent(g); // Paint background
int imwidth = bgimage.getWidth(null);
int imheight = bgimage.getHeight(null);
g.drawImage(bgimage, 0, 0, null);
g.setFont(new Font("PLAYER 1", Font.BOLD, 16));
g.drawString("PLAYER 1", 5, 12);

g.setFont(new Font("COMPUTER", Font.BOLD, 16));
g.drawString("COMPUTER", 900, 12);
Graphics2D[] player = new Graphics2D[10];
Graphics2D g10 = (Graphics2D) g;
Graphics2D g12 = (Graphics2D) g;

for (int i = 0; i < 10; i++)
player[i] = (Graphics2D) g;
Shape shape10 = new Rectangle2D.Float(25, y10, 20, 20);// goalkeeper
shape12 = new Rectangle2D.Float(940, y12, 20, 20);
g12.fill(shape12);
Graphics2D[] playercomp = new Graphics2D[10];
for (int i = 0; i < 10; i++)
playercomp[i] = (Graphics2D) g;

for (int i = 0; i < 10; i++)
playercomp[i].fill(compshape[i]);

for (int i = 0; i < 10; i++)
player[i].fill(shape[i]);
g10.fill(shape10);
g.setColor(Color.BLACK);
// setBackground(Color.GREEN);
g.setColor(Color.BLACK);
g.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius),
(int) (2 * ballRadius), (int) (2 * ballRadius));
}

public void keyPressed(KeyEvent e) {
int c = e.getKeyCode();
if (c == KeyEvent.VK_UP) {
	if(y10>450)
        velocityG=(float)-0.3;
    else
        velocityG=(float) -0.3;
for (int i = 0; i < 10; i++) {
velocityX = 0;
velocityY1 = 0;
velocityY2 = 0;
velocityY = 0;

if (y[i] < 75) {
velocityX = 0;
velocityY1 = 0;
velocityY2 = 0;
velocityY = 0;
} else {
velocityX = 0;
velocityY1 = -defspeed;
velocityY2 = -midspeed;
velocityY = -strspeed;

}
}
}
if (c == KeyEvent.VK_DOWN) {
       if(y10<150)
        velocityG=(float) 0.3;
    else
        velocityG=(float) 0.3;
for (int i = 0; i < 10; i++) {
if (y[i] > 550) {
velocityX = 0;
velocityY1 = 0;
velocityY2 = 0;
velocityY = 0;

} else {
velocityX = 0;
velocityY1 = defspeed;
velocityY2 = midspeed;
velocityY = strspeed;
}
}
}
}

public void keyTyped(KeyEvent e) {
}

public static void ma() {
JFrame frame = new JFrame("A Bouncing BouncingBallSimple");
// frame.setContentPane(new JLabel(new ImageIcon("footballfield.jpg")));
frame.setContentPane(new BounceBall());

frame.pack();
setDefaultLocale(null);
frame.setVisible(true);
}

public void keyReleased(KeyEvent e) {
// TODO Auto-generated method stub
velocityX = 0;
velocityY1 = 0;
velocityY2 = 0;
velocityY = 0;
velocityG = 0;
}

public void actionPerformed(ActionEvent e) {

for (int i = 0; i < Secondscreen.d; i++) {
y[i] = y[i] + velocityY1;
y10 = velocityG + y10;
shape[i] = new Rectangle2D.Float(x1, y[i], 20, 20);
// System.out.println(y[i]);
}
for (int j = 0; j < Secondscreen.d1; j++) {
y[j + Secondscreen.d] = y[j + Secondscreen.d] + velocityY2;
shape[j + Secondscreen.d] = new Rectangle2D.Float(3 * x1, y[j
+ Secondscreen.d], 20, 20);
}
for (int k = 0; k < Secondscreen.d2; k++) {

y[k + Secondscreen.d + Secondscreen.d1] = y[k + Secondscreen.d
+ Secondscreen.d1]
+ velocityY;
shape[k + Secondscreen.d + Secondscreen.d1] = new Rectangle2D.Float(
5 * x1, y[k + Secondscreen.d + Secondscreen.d1], 20, 20);
}
for (int i = 0; i < defend; i++) {

if (ballY + ballRadius > 300 && yd[defend - 1] < BOX_HEIGHT - 20) {
if (Secondscreen.d3 == 1) {
yd[i] = yd[i] + 0.5f;
y12= y12 + 0.5f;

}
if (Secondscreen.d3 == 2) {
yd[i] = yd[i] + 1;
y12 = y12-1;
}
if (Secondscreen.d3 == 3) {
yd[i] = yd[i] + 1.5f;
y12 = y12+1.5f;
}
compshape[i] = new Rectangle2D.Float(6 * x1, yd[i], 20, 20);
} else if (ballY + ballRadius <= 300 && yd[0] > 0) {
if (Secondscreen.d3 == 1) {
yd[i] = yd[i] - 0.5f;
y12= y12-0.5f;
}
if (Secondscreen.d3 == 2) {
yd[i] = yd[i] - 1;
y12= y12-1;
}
if (Secondscreen.d3 == 3) {
yd[i] = yd[i] - 1.5f;
y12= y12-1.5f;
}
compshape[i] = new Rectangle2D.Float(6 * x1, yd[i], 20, 20);
}
}
for (int i = 0; i < mid; i++) {
if (ballY + ballRadius > 300
&& yd[defend + mid - 1] < BOX_HEIGHT - 20) {
if (Secondscreen.d3 == 1) {
yd[i + defend] = yd[i + defend] + 0.5f;
}
if (Secondscreen.d3 == 2) {
yd[i + defend] = yd[i + defend] + 1;
}
if (Secondscreen.d3 == 2) {
yd[i + defend] = yd[i + defend] + 1.5f;
}
compshape[i + defend] = new Rectangle2D.Float(4 * x1, yd[i
+ defend], 20, 20);
} else if (ballY + ballRadius <= 300 && yd[defend] > 0) {
if (Secondscreen.d3 == 1) {
yd[i + defend] = yd[i + defend] - 0.5f;
}
if (Secondscreen.d3 == 2) {
yd[i + defend] = yd[i + defend] - 1;
}
if (Secondscreen.d3 == 3) {
yd[i + defend] = yd[i + defend] - 1.5f;
}
compshape[i + defend] = new Rectangle2D.Float(4 * x1, yd[i
+ defend], 20, 20);
}
}
for (int i = 0; i < strike; i++) {
if (ballY + ballRadius > 300
&& yd[defend + mid + strike - 1] < BOX_HEIGHT - 20) {
if (Secondscreen.d3 == 1) {
yd[i + defend + mid] = yd[i + defend + mid] + 0.5f;
}
if (Secondscreen.d3 == 2) {
yd[i + defend + mid] = yd[i + defend + mid] + 1;
}
if (Secondscreen.d3 == 3) {
yd[i + defend + mid] = yd[i + defend + mid] + 1.5f;
}
compshape[i + defend + mid] = new Rectangle2D.Float(2 * x1,
yd[i + defend + mid], 20, 20);
} else if (ballY + ballRadius <= 300 && yd[defend + mid] > 0) {
if (Secondscreen.d3 == 1) {
yd[i + defend + mid] = yd[i + defend + mid] - 0.5f;
}
if (Secondscreen.d3 == 2) {
yd[i + defend + mid] = yd[i + defend + mid] - 1;
}
if (Secondscreen.d3 == 3) {
yd[i + defend + mid] = yd[i + defend + mid] - 1.5f;
}
compshape[i + defend + mid] = new Rectangle2D.Float(2 * x1,
yd[i + defend + mid], 20, 20);
}

}
}
}