
public class HindsightBot extends BotBaseClass {
	
	public HindsightBot(int dynamiteAllowed) {
		super(dynamiteAllowed);
		// TODO Auto-generated constructor stub
		this.setName("HindsightBot");
	}

	@Override
	public Moves doMove(Moves opponentMove, int pointsOnLine) {
		// TODO Auto-generated method stub
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
