package combine;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
///import static org.testng.AssertJUnit.assertThat;

public class TestClass {
    
	public void Toss() {
	   String st = "Heads";
	   AssertJUnit.assertEquals(st,PlayerDetails.toss());
   }
    
   public void TestDefend() {
	   int i = 4;
	   AssertJUnit.assertEquals(i,BounceBall.getdefend());
   }
   public void TestMid() {
	   int i =4;
	   AssertJUnit.assertEquals(i,BounceBall.getmid());
   }
   public void TestStrike() {
	   int i = 2;
	   AssertJUnit.assertEquals(i,BounceBall.getstrike());
   }
   public void TestTotal() {
	   int i = 10;
	   AssertJUnit.assertEquals(i,BounceBall.getTotal());
   }
   public void TestCheck() {
	   boolean i = true;
	   AssertJUnit.assertEquals(i,BounceBall.check());
   }
    public void TestCoin() {
    	float i = 50;
    	  AssertJUnit.assertEquals(i,Coin.coins(), i);
    } 
   public void TestAxis1() {
	   int i = 4;
	   AssertJUnit.assertEquals(i,BounceBall.axis1());
   }
public void TestAxis2() {
	int i =4;
	  AssertJUnit.assertEquals(i,BounceBall.axis2());
}
public void TestAxis3() {
	int i= 2;
	  AssertJUnit.assertEquals(i,BounceBall.axis3());
}
public void TestBall_Ref() {
	int i = 145;
	  AssertJUnit.assertEquals(i,Reflection.ball_Ref_Play());
}
public void TestBall_Comp() {
	int i =148 ;
	
	 AssertJUnit.assertEquals(i,Reflection.ball_Ref_Comp());
}
}

