
public class Record implements Comparable<Record> {
	int wins;
	int losses;
	int ties;
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public int getTies() {
		return ties;
	}
	public void setTies(int ties) {
		this.ties = ties;
	}
	
	public String toString(){
		return this.wins + "-" + this.losses + "-" + this.ties;
	}
	
	public String botName;
	
	@Override
	public int compareTo(Record other) {
		// wins first, then ties, then losses
		int result = Integer.compare(other.getWins(), this.wins);
		if ( result == 0 )
		{
			result = Integer.compare(other.getTies(),this.ties);
			if ( result == 0){
				result = Integer.compare(other.getLosses(),this.losses);
			}
		}
		return result;
	}
	
	
}
