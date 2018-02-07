
public abstract class BotBaseClass implements Comparable<BotBaseClass> {
	
	@Override
	public int compareTo(BotBaseClass o) {
		return this.name.compareTo(o.getName());
	}

	private String name = "";
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public BotBaseClass(int dynamiteAllowed){
		
	}
	
	public Moves doMove(Moves opponentMove, int pointsOnLine){
		return Moves.None;
	}

	public String toString(){
		return this.name;
	}
}
