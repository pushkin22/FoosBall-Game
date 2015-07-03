package combine;

public class Reflection {

	/**
	 * @param args
	 * @return 
	 */
	public static int ball_Ref_Play(){
		
		float ballX = 252;
		int x1 =125;
		if (40 <= ballX - BounceBall.ballRadius
				&& ballX - BounceBall.ballRadius <=  40) {
			for (int i = 0; i < Secondscreen.d; i++) {

				float ballY = 152;
				if (ballY - BounceBall.ballRadius >= 100
						&& ballY -BounceBall.ballRadius < (120)) {

					
					ballX = x1 - BounceBall.ballRadius;
					// ballSpeedY = -ballSpeedY;
					ballY = 100 - BounceBall.ballRadius;
				} 
			}
		

	}
		return x1;
		
			}
	
	public static int  ball_Ref_Comp(){
		
		float ballX = 252;
		int y1 =325;
		if (40 <= ballX - BounceBall.ballRadius
				&& ballX - BounceBall.ballRadius <=  40) {
			for (int i = 0; i < Secondscreen.d; i++) {

				float ballY = 152;
				if (ballY - BounceBall.ballRadius >= 100
						&& ballY -BounceBall.ballRadius < (120)) {

					
					ballX = y1 - BounceBall.ballRadius;
					// ballSpeedY = -ballSpeedY;
					ballY = 100 - BounceBall.ballRadius;
				} 
			}
		

	}
		return y1;
		
			}
		
	

}
