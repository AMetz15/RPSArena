/**
 * Created by Abram on 5/4/2014.
 */
public class AbramBot extends BotBaseClass {

    public AbramBot(int dynamiteAllowed) {
        super(dynamiteAllowed);
        this.setName("AbramBot");
    }

    private int remainingDynamite = 100;
    private int counter = 0;

    @Override
    public Moves doMove(Moves opponentMove, int pointsOnLine) {

        switch (opponentMove) {
            case Scissors:
                counter++;
                if (counter < 10) {
                    return Moves.Rock;
                }
                else if (counter == 10){
                    counter = 0;
                    remainingDynamite--;
                    return Moves.Dynamite;
                }
                else if (remainingDynamite == 0){
                    return Moves.Rock;
                }
            case Paper:
                counter++;
                if (counter < 10) {
                    return Moves.Scissors;
                }
                else if (counter == 10){
                    counter = 0;
                    remainingDynamite--;
                    return Moves.Dynamite;
                }
                else if (remainingDynamite == 0){
                    return Moves.Scissors;
                }
            case Rock:
                counter++;
                if (counter < 10) {
                    return Moves.Paper;
                }
                else if (counter == 10){
                    counter = 0;
                    remainingDynamite--;
                    return Moves.Dynamite;
                }
                else if (remainingDynamite == 0){
                    return Moves.Paper;
                }
            case Dynamite:
                counter++;
                if (counter < 10) {
                    return Moves.WaterBalloon;
                }
                else if (counter == 10){
                    counter = 0;
                    remainingDynamite--;
                    return Moves.Dynamite;
                }
                else if (remainingDynamite == 0){
                    return Moves.WaterBalloon;
                }
            case WaterBalloon:
                return Moves.Scissors;
            default:
                return Moves.Rock;
        }
    }
}