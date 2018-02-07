import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Battlefield {

	public final static int MAX_DYNAMITE = 100;
	public final static int POINTS_TO_WIN = 1000;
	public final static int MAX_ROUNDS = 1000;

	public static void main(String[] args) throws InterruptedException {

		ArrayList<BotBaseClass> bots = new ArrayList<BotBaseClass>();
		Map<BotBaseClass, Record> records = new TreeMap<BotBaseClass, Record>();

//		bots.add(new AbramBot(MAX_DYNAMITE));
		bots.add(new CarsonScissorBot(MAX_DYNAMITE));
//		bots.add(new RockBot(MAX_DYNAMITE));
		bots.add(new RandomBot(MAX_DYNAMITE));
//		bots.add(new CounterHindsightBot(MAX_DYNAMITE));
//		bots.add(new AttemptToOutsmart(MAX_DYNAMITE));

		for (BotBaseClass entry : bots) {
			Record r = new Record();
			r.botName = entry.getName();
			records.put(entry, r);
		}

		Scoreboard score = new Scoreboard();

		for (int bot1Index = 0; bot1Index < bots.size(); bot1Index++) {
			for (int bot2Index = bot1Index + 1; bot2Index < bots.size(); bot2Index++) {
				int bot1DynamiteThrown = 0;
				int bot2DynamiteThrown = 0;

				int bot1PointsEarned = 0;
				int bot2PointsEarned = 0;

				BotBaseClass bot1 = bots.get(bot1Index);
				BotBaseClass bot2 = bots.get(bot2Index);
				Moves bot1LastMove = Moves.None;
				Moves bot2LastMove = Moves.None;
				int pointsOnLine = 1;
				int round = 0;
    			score.resetScoreboard(bot1.toString(), bot2.toString());
				while ((bot1PointsEarned < POINTS_TO_WIN && bot2PointsEarned < POINTS_TO_WIN)
						&& MAX_ROUNDS > round++) {

					score.repaint();
					Thread.sleep(20);
					Moves bot1Move = bot1.doMove(bot2LastMove, pointsOnLine);
					Moves bot2Move = bot2.doMove(bot1LastMove, pointsOnLine);

					if (bot1Move == Moves.Dynamite) {
						if (bot1DynamiteThrown > MAX_DYNAMITE) {
							bot1Move = Moves.None;
						}
						bot1DynamiteThrown++;
					}

					if (bot2Move == Moves.Dynamite) {
						if (bot2DynamiteThrown >= MAX_DYNAMITE) {
							bot2Move = Moves.None;
						}
						bot2DynamiteThrown++;
					}

					System.out.println("Bot 1 threw " + bot1Move
							+ ", Bot 2 threw " + bot2Move + ", worth "
							+ pointsOnLine);

					if (bot1Move != bot2Move) {
						switch (bot1Move) {
						case None:
							bot2PointsEarned += pointsOnLine;
							break;
						case Rock:
							if (bot2Move == Moves.Paper
									|| bot2Move == Moves.Dynamite) {
								bot2PointsEarned += pointsOnLine;
							} else {
								bot1PointsEarned += pointsOnLine;
							}
							break;
						case Paper:
							if (bot2Move == Moves.Scissors
									|| bot2Move == Moves.Dynamite) {
								bot2PointsEarned += pointsOnLine;
							} else {
								bot1PointsEarned += pointsOnLine;
							}
							break;
						case Scissors:
							if (bot2Move == Moves.Rock
									|| bot2Move == Moves.Dynamite) {
								bot2PointsEarned += pointsOnLine;
							} else {
								bot1PointsEarned += pointsOnLine;
							}
							break;
						case WaterBalloon:
							if (bot2Move != Moves.Dynamite
									&& bot2Move != Moves.None) {
								bot2PointsEarned += pointsOnLine;
							} else {
								bot1PointsEarned += pointsOnLine;
							}
							break;
						case Dynamite:
							if (bot2Move == Moves.WaterBalloon) {
								bot2PointsEarned += pointsOnLine;
							} else {
								bot1PointsEarned += pointsOnLine;
							}
						}
						pointsOnLine = 1;
					} else {
						pointsOnLine++;
					}
					score.setScores(bot1PointsEarned, bot2PointsEarned);
					bot1LastMove = bot1Move;
					bot2LastMove = bot2Move;
					score.setMoves(bot1LastMove, bot2LastMove);
				}
				if (bot1PointsEarned > bot2PointsEarned) {
					System.out.println(bot1 + " wins; " + bot1PointsEarned
							+ " - " + bot2PointsEarned);
					records.get(bot1).wins += 1;
					records.get(bot2).losses += 1;
				} else if (bot1PointsEarned == bot2PointsEarned) {
					System.out.println("Tie; " + bot1PointsEarned + " - "
							+ bot2PointsEarned);
					records.get(bot2).ties += 1;
					records.get(bot1).ties += 1;
				} else {
					System.out.println(bot2 + " wins; " + bot2PointsEarned
							+ " - " + bot1PointsEarned);
					records.get(bot2).wins += 1;
					records.get(bot1).losses += 1;
				}
				score.showWinner = true;
				score.repaint();
				Thread.sleep(100);
			}
			
			
		}
		ArrayList<Record> allRecords = new ArrayList<Record>();
		allRecords.addAll(records.values());
		Collections.sort(allRecords);
		
		for( Record record : allRecords){
			System.out.println(record.botName + " " + record);
		}
	}

}
