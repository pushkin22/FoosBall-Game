package combine;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class PlayerFormation {
	
	Shape[] shape = new Shape[10];
	float[] y = new float[10];
	int y1 = BounceBall.BOX_HEIGHT / (Secondscreen.d + 1);
	int y2 = BounceBall.BOX_HEIGHT / (Secondscreen.d1 + 1);
	int y3 = BounceBall.BOX_HEIGHT / (Secondscreen.d2 + 1);
	static int x1 = BounceBall.BOX_WIDTH / 7;

	
	public static int noofDefenders()
	{
		return Secondscreen.d;
	}
	
	public static int noofmid()
	{
		return Secondscreen.d1;
	}
	
	public static int noofstrike()
	{
		return Secondscreen.d2;
	}
	
	public void defenders() {
		for (int i = 0; i < noofDefenders(); i++) {
			y[i] = y1 * (i + 1);
			shape[i] = new Rectangle2D.Float(x1, y[i], 20, 20);
		}

	}

	public void mid() {
		for (int j = 0; j < noofmid(); j++) {

			y[j + noofDefenders()] = (j + 1) * y2;
			shape[j + noofDefenders()] = new Rectangle2D.Float(3 * x1, y[j
					+ noofDefenders()], 20, 20);
		}
	}

	public void striker() {
		for (int k = 0; k < noofstrike(); k++) {
			y[k + noofDefenders() + noofmid()] = (k + 1) * y3;
			shape[k + noofDefenders() + noofmid()] = new Rectangle2D.Float(
					5 * x1, y[k + noofDefenders() + noofmid()], 20, 20);
		}
	}

	public void PlayerOneFormation() {
		defenders();
		mid();
		striker();
		System.out.println("Once");
	}
}
