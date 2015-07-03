package combine;

import org.testng.AssertJUnit;

///import static org.testng.AssertJUnit.assertThat;

public class Testcases {

	public void Toss() {
		String st = "Heads";
		AssertJUnit.assertEquals(st, PlayerDetails.toss());
	}

	public void TestDefend() {
		int i = 4;
		AssertJUnit.assertEquals(i, CompPlayers.getdefend());
	}

	public void TestMid() {
		int i = 4;
		AssertJUnit.assertEquals(i, CompPlayers.getmid());
	}

	public void TestStrike() {
		int i = 2;
		AssertJUnit.assertEquals(i, CompPlayers.getstrike());
	}

	public void TestTotal() {
		int i = 10;
		AssertJUnit.assertEquals(i, CompPlayers.getTotal());
	}

	public void TestCheck() {
		boolean i = true;
		AssertJUnit.assertEquals(i, CompPlayers.check());
	}

	 public void TestCoin() {
	 float i = 50;
	 AssertJUnit.assertEquals(i,Coin.coins(), i);
	 }
	public void TestAxis1() {
		int i = 4;
		AssertJUnit.assertEquals(i, CompPlayers.axis1());
	}

	public void TestAxis2() {
		int i = 4;
		AssertJUnit.assertEquals(i, CompPlayers.axis2());
	}

	public void TestAxis3() {
		int i = 2;
		AssertJUnit.assertEquals(i, CompPlayers.axis3());
	}
	public void Testpdefend() {
		int i = 4;
		AssertJUnit.assertEquals(i, PlayerFormation.noofDefenders());
	}
	public void Testpmid() {
		int i = 4;
		AssertJUnit.assertEquals(i, PlayerFormation.noofmid());
	}
	public void Testpstrike() {
		int i = 2;
		AssertJUnit.assertEquals(i, PlayerFormation.noofstrike());
	}
	
	public void Testboxheight() {
		int i = 1001;
		AssertJUnit.assertEquals(i, LoadingFrame.boxheight());
	}
	
	public void Testboxwidth() {
		int i = 600;
		AssertJUnit.assertEquals(i, LoadingFrame.boxwidth());
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