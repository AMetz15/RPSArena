
public class CarsonScissorBot extends BotBaseClass{

	public CarsonScissorBot(int dynamiteAllowed) {
		super(dynamiteAllowed);
		this.setName("CarsonScissorBot");
	}

	@Override
	public Moves doMove(Moves opponentMove, int pointsOnLine) {
		return Moves.Scissors;
	}

	
}
