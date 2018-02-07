
public class RockBot extends BotBaseClass{

	public RockBot(int dynamiteAllowed) {
		super(dynamiteAllowed);
		this.setName("RockBot");
	}

	@Override
	public Moves doMove(Moves opponentMove, int pointsOnLine) {
		return Moves.Dynamite;
	}

	
}