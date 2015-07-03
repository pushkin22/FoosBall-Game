package combine;

public class Coin {

	static int ballcoord;
	public static int coins(){
		
		if(Secondscreen.sins == 1){
			ballcoord = 50;
			System.out.println("ballcheck");
			//BounceBall.ballX = 50;
			//BounceBall.valX=-1;
			//BounceBall.ballY = 300;
				
			//	System.out.println(BounceBall.ballX);
				System.out.println("Player wins toss");
				//ballY = 300;
			}else if(Secondscreen.sins == 0)
			{
				//BounceBall.ballX = 960;
				//System.out.println(BounceBall.ballX);
			//	BounceBall.valY=-1;
				//BounceBall.ballY = 300;
				ballcoord = 960;
				System.out.println("Computer wins toss");
				
			}
			else{
				
				System.out.println("Oops, no choice");
		}
		return ballcoord;
	}

}
