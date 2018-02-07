import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class AttemptToOutsmart extends BotBaseClass {

	int myDynamite = 0;
	ArrayList<Moves> opponentMoves = new ArrayList<Moves>();
	Map<Moves,Integer> moveCounts = new TreeMap<Moves,Integer>();
	
	public AttemptToOutsmart(int dynamiteAllowed) {
		super(dynamiteAllowed);
		myDynamite = dynamiteAllowed;
		
		for( Moves move : Moves.values() ){
			moveCounts.put(move, 0);
		}
		this.setName("Attempt To Outsmart");
	}

	@Override
	public Moves doMove(Moves opponentMove, int pointsOnLine) {

		manageMostRecentMoves(opponentMove);

		return getTheMoveIThrow();
	}

	private void manageMostRecentMoves(Moves opponentMove) {
		opponentMoves.add(opponentMove);
		if ( opponentMoves.size() > 20 ){
			opponentMoves.remove(0);
		}
		// update the map
		moveCounts.clear();
		for( Moves move : opponentMoves ){
			moveCounts.put( move , moveCounts.get(move) == null ? 1 : moveCounts.get(move) + 1 ); 
		}
		
		
	}

	private Moves getTheMoveIThrow() {
		Moves lowestMove = Moves.None;
		int lowestCount = Integer.MAX_VALUE;
		for(Moves typeOfMove : Moves.values()){
			Integer moveCount = moveCounts.get(typeOfMove);
			if ( moveCount == null ){
				lowestMove = typeOfMove;
				lowestCount = 0;
			}
			else if ( moveCount < lowestCount ){
				lowestMove = typeOfMove;
				lowestCount = moveCount;
			}
		}
		switch( lowestMove ){
		case None:
			if ( myDynamite > 0 ){
				myDynamite--;				
				return Moves.Dynamite;
			}
			else{
				return Moves.Rock;
			}
		case Dynamite: 
			return Moves.WaterBalloon;
		case Paper:
			return Moves.Scissors;
		case Scissors:
			return Moves.Rock;
		case Rock:
			return Moves.Paper;
		case WaterBalloon:
			return Moves.Paper;
			default:
				return Moves.WaterBalloon;
		}
	}

	
}
