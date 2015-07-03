package combine;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;

public class CompPlayers extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int[] yd = new int[10];
	static Shape[] compshape = new Shape[10];
	static int mid;
	static int defend;
	static int total;
	static int strike;
	static int yc1;
    static int yc2;
    static int yc3;
       
    public CompPlayers()
    {
    	System.out.println("Constructor");
    	//assign();
    	compForm();
    }
    
    public static int getdefend()
    {
    	defend = (int)(Math.random() * 4 ) + 3;
    	System.out.println(defend);
    	return defend;
    }
    
    public static int getmid()
    {
    	mid=(int)(Math.random() * 4) + 3;
    	System.out.println("mid");
    	return mid;
    }
    
    public static int getstrike()
    {
    	strike = (int)(Math.random() * 4) + 1;
    	System.out.println("strike");
    	return strike;
    }
    
    public static int getTotal()
    {
    	total = getdefend() + getmid() + getstrike();
    	System.out.println("total");
    	return total;
    }
    
    public static boolean check()
    {
    	while(total!=10)
    	{
    		getTotal();
    	}
    	System.out.println("check");
    	return true;
    }
    
    public static void assign()
    {
    	if(check())
    	{
    		yc1 = BounceBall.BOX_HEIGHT/(defend+1);
    		yc2 = BounceBall.BOX_HEIGHT/(mid+1);
    		yc3 = BounceBall.BOX_HEIGHT/(strike+1);
    	}
    	System.out.println("assign");
    }
    
    public static int axis1()
    {
    	return yc1;
    }
    
    public static int axis2()
    {
    	return yc2;
    }
    
    public static int axis3()
    {
    	return yc3;
    }
    
	public static void compDefend()
	{
		System.out.println("defenderss");
		for(int i = 0; i<defend; i++)
		{
			 yd[i]=axis1()*(i+1);
	         compshape[i] = new Rectangle2D.Float((BounceBall.x1) * 6,yd[i], 20, 20);
		}
		System.out.println(axis1());
	}
	
	public static void compmid()
	{
		for(int i=0;i<mid;i++)
		{
			yd[i + defend] = axis2()*(i+1);
			compshape[i+ defend] = new Rectangle2D.Float((BounceBall.x1) * 4,yd[i + defend], 20, 20);
		}
		System.out.println(axis2());
	}
	
	public static void compstrike()
	{
		System.out.println("working");
		for(int i=0;i<strike;i++)
		{
			yd[i + defend + mid] = axis3()*(i+1);
			compshape[i+ defend + mid] = new Rectangle2D.Float((BounceBall.x1) * 2,yd[i + defend + mid], 20, 20);
		}
		System.out.println(axis3());
	}

	public static void compForm()
	{
		assign();
		System.out.println("checking");
		compDefend();
		System.out.println(":)");
		compmid();
		compstrike();
	}
}
