
public class CounterHindsightBot extends BotBaseClass {
	
	Moves myLastMove = Moves.None;
	
	public CounterHindsightBot(int dynamiteAllowed) {
		super(dynamiteAllowed);
		// TODO Auto-generated constructor stub
		this.setName("CounterHindsightBot");
	}

	@Override
	public Moves doMove(Moves opponentMove, int pointsOnLine) {
		// TODO Auto-generated method stub
		if ( pointsOnLine >= Battlefield.POINTS_TO_WIN ){
			return Moves.Paper;
		}
		
		switch ( opponentMove ){
		case None:
			return Moves.WaterBalloon;
		case WaterBalloon:
			return Moves.Rock;
		case Dynamite:
			return Moves.WaterBalloon;
		case Rock:
			return Moves.Paper;
		case Scissors:
			return Moves.Rock;
		case Paper:
			return Moves.Scissors;
		default:
			return Moves.None;
		}
	}
	
	

}
