import java.util.Random;


public class RandomBot extends BotBaseClass {

	int remainingDynamite = 100;
	Random rng = new Random();
	
	@Override
	public Moves doMove(Moves opponentMove, int pointsOnLine) {
		
		int move = rng.nextInt(5);
		switch( move ){
		case 0:
			return Moves.Rock;
		case 1:
			return Moves.Scissors;
		case 2:
			return Moves.Paper;
		case 3:
			return Moves.WaterBalloon;
		case 4:
			if ( remainingDynamite > 0 ){
				remainingDynamite--;
				return Moves.Dynamite;
			}
			else{
				return Moves.Rock;
			}
			default:
				return Moves.None;
		}
	}

	public RandomBot(int dynamiteAllowed) {
		super(dynamiteAllowed);
		remainingDynamite = dynamiteAllowed;
		this.setName("RandomBot");
	}

}
